package de.ait_tr.g_38_jp_shop.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import de.ait_tr.g_38_jp_shop.service.interfaces.FileService;
import de.ait_tr.g_38_jp_shop.service.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private AmazonS3 client;
    private ProductService productService;

    public FileServiceImpl(AmazonS3 client, ProductService productService) {
        this.client = client;
        this.productService = productService;
    }

    @Override
    public String upload(MultipartFile file, String productTitle) {

        try {
            String uniqFileName = generateUniqueFileName(file);

            // сохранение загруженных файлов в локальную папку
//            Files.copy(file.getInputStream(),
//                    Path.of("C:\\Users\\zzzir\\IdeaProjects\\g_38_jp_shop\\files\\"
//                    + uniqFileName));

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());

            PutObjectRequest request = new PutObjectRequest(
                    "cohort-37-bucket", uniqFileName, file.getInputStream(), metadata
            ).withCannedAcl(CannedAccessControlList.PublicRead);

            client.putObject(request);

            String url = client.getUrl("cohort-37-bucket", uniqFileName).toString();

            productService.attachImage(url, productTitle);

            return uniqFileName;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateUniqueFileName(MultipartFile file) {
        String sourceFileName = file.getOriginalFilename();
        int dotIndex   = sourceFileName.lastIndexOf(".");
        String fileName = sourceFileName.substring(0, dotIndex);
        String extension = sourceFileName.substring(dotIndex);

        return String.format("%s-%s%s", fileName, UUID.randomUUID(), extension);
    }
}
