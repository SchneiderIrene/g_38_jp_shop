package de.ait_tr.g_38_jp_shop.service;

import de.ait_tr.g_38_jp_shop.domain.dto.ProductDto;
import de.ait_tr.g_38_jp_shop.domain.entity.Product;
import de.ait_tr.g_38_jp_shop.repository.ProductRepository;
import de.ait_tr.g_38_jp_shop.service.interfaces.ProductService;
import de.ait_tr.g_38_jp_shop.service.mapping.ProductMappingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;
    private ProductMappingService mappingService;

    public ProductServiceImpl(ProductRepository repository, ProductMappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }

    @Override
    public ProductDto save(ProductDto dto) {
        Product product = mappingService.mapDtoToEntity(dto);
        repository.save(product);
        return mappingService.mapEntityToDto(product);
    }

    @Override
    public List<ProductDto> getAll() {

        return repository.findAll()
                .stream()
                .filter(x->x.isActive())
                .map(x->mappingService.mapEntityToDto(x))
                .toList();
    }

    @Override
    public ProductDto getById(Long id) {

        if (id == null || id < 1) {
            throw new RuntimeException("Product ID is incorrect");
        }

        Product product = repository.findById(id).orElse(null);

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        return mappingService.mapEntityToDto(product);
    }

    @Override
    public void update(ProductDto dto) {
        Product existedProduct = repository.findById(dto.getProductId()).orElse(null);
        if (existedProduct != null) {
            existedProduct.setTitle(dto.getTitle());
            existedProduct.setPrice(dto.getPrice());
            repository.save(existedProduct);
        }else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public void deleteById(Long id) {
        Product product = repository.findById(id).orElse(null);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        repository.delete(product);
    }

    @Override
    public void deleteByTitle(String title) {
    Product product = repository.findByTitle(title);
    if (product == null) {
        throw new RuntimeException("Product not found");
    }
    repository.delete(product);
    }

    @Override
    public void restoreById(Long id) {
    Product product = repository.findById(id).orElse(null);
    if (product == null) {
        throw new RuntimeException("Product not found");
    }
    product.setActive(true);
    repository.save(product);
    }

    @Override
    public int getTotalQuantity() {
        List<Product> products = repository.findAll();
        return products.size();
    }

    @Override
    public BigDecimal getTotalPrice() {
        List <Product> products = repository.findAll();
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : products) {
            totalPrice = totalPrice.add(product.getPrice());
        }
        return totalPrice;
    }

    @Override
    public BigDecimal getAveragePrice() {
        List <Product> products = repository.findAll();
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : products) {
            totalPrice = totalPrice.add(product.getPrice());
        }
        if(!products.isEmpty()) {
            return totalPrice.divide(BigDecimal.valueOf(products.size()), 2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO;
    }
}