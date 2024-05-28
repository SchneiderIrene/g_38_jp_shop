package de.ait_tr.g_38_jp_shop.service;

import de.ait_tr.g_38_jp_shop.domain.dto.ProductDto;
import de.ait_tr.g_38_jp_shop.domain.entity.Product;
import de.ait_tr.g_38_jp_shop.exception_handling.exceptions.*;
import de.ait_tr.g_38_jp_shop.repository.ProductRepository;
import de.ait_tr.g_38_jp_shop.service.interfaces.ProductService;
import de.ait_tr.g_38_jp_shop.service.mapping.ProductMappingService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private ProductRepository repository;
    private ProductMappingService mappingService;

    public ProductServiceImpl(ProductRepository repository, ProductMappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }

    @Override
    @Transactional
    public ProductDto save(ProductDto dto) {

        Product product = mappingService.mapDtoToEntity(dto);

        try {
            repository.save(product);
        } catch (Exception e){
            throw new FourthTestException("Error saving product", e);
        }


        return mappingService.mapEntityToDto(product);
    }

    @Override
    public List<ProductDto> getAll() {

        return repository.findAll()
                .stream()
                .filter(Product::isActive)
                .map(x -> mappingService.mapEntityToDto(x))
                .toList();
    }

    @Override
    public ProductDto getById(Long id) {

//        logger.info("Database request: get product by id {}", id);
//        logger.warn("Product with id {} not found", id);
//        logger.error("Error");

        if (id == null || id < 1) {
            throw new ThirdTestException("Product ID is incorrect");
        }

        Product product = repository.findById(id).orElse(null);

        if (product == null) {
            throw new ProductNotFoundException("ProductNotFoundException: Product not found");
        }


        return mappingService.mapEntityToDto(product);
    }


    @Override
    @Transactional
    public void update(ProductDto dto) {
        Product existedProduct = repository.findById(dto.getProductId()).orElse(null);
        if (existedProduct != null) {
            existedProduct.setTitle(dto.getTitle());
            existedProduct.setPrice(dto.getPrice());
        } else {
            throw new ProductNotFoundByUpdateException("Product not found");
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Product product = repository.findById(id).orElse(null);
        if (product == null) {
            throw new ProductNotFoundByDeleteException("ProductNotFoundByDeleteException: Product not found");
        }
        product.setActive(false);
    }

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        Product product = repository.findByTitle(title);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        product.setActive(false);
    }

    @Override
    @Transactional
    public void restoreById(Long id) {
        Product product = repository.findById(id).orElse(null);
        if (product == null) {
            throw new ProductNotFoundByRestoreException("ProductNotFoundByRestoreException: Product not found");
        }
        product.setActive(true);
    }

    @Override
    public int getTotalQuantity() {
        return (int) repository.findAll()
                .stream()
                .filter(Product::isActive)
                .count();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return repository.findAll()
                .stream()
                .filter(Product::isActive)
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal getAveragePrice() {
        return getTotalPrice()
                .divide(BigDecimal.valueOf(getTotalQuantity()), 2, RoundingMode.HALF_UP);


//                repository.findAll()
//                .stream()
//                .filter(Product::isActive)
//                .map(Product::getPrice)
//                .reduce(BigDecimal.ZERO, BigDecimal::add)
//                .divide(BigDecimal.valueOf(getTotalQuantity()), 2, RoundingMode.HALF_UP);


//        List<Product> products = repository.findAll();
//        BigDecimal totalPrice = BigDecimal.ZERO;
//        for (Product product : products) {
//            totalPrice = totalPrice.add(product.getPrice());
//        }
//        if (!products.isEmpty()) {
//            return totalPrice.divide(BigDecimal.valueOf(products.size()), 2, RoundingMode.HALF_UP);
//        }
//        return BigDecimal.ZERO;
    }

    @Override
    @Transactional
    public void attachImage(String imgUrl, String productTitle) {
        Product product = repository.findByTitle(productTitle);

        if (product == null) {
            throw new ProductNotFoundException(productTitle);
        }
        product.setImage(imgUrl);

    }
}