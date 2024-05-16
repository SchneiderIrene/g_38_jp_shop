package de.ait_tr.g_38_jp_shop.service;

import de.ait_tr.g_38_jp_shop.service.interfaces.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile file, String productTitle) {

        try {
            String uniqFileName = generateUniqueFileName(file);
            Files.copy(file.getInputStream(),
                    Path.of("C:\\Users\\zzzir\\IdeaProjects\\g_38_jp_shop\\files\\"
                    + uniqFileName));

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
