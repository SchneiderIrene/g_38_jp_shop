package de.ait_tr.g_38_jp_shop.service;

import de.ait_tr.g_38_jp_shop.domain.dto.ProductDto;
import de.ait_tr.g_38_jp_shop.domain.entity.Product;
import de.ait_tr.g_38_jp_shop.repository.ProductRepository;
import de.ait_tr.g_38_jp_shop.service.interfaces.ProductService;
import de.ait_tr.g_38_jp_shop.service.mapping.ProductMappingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
    public void update(ProductDto product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByTitle(String title) {

    }

    @Override
    public void restoreById(Long id) {

    }

    @Override
    public int getTotalQuantity() {
        return 0;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return null;
    }

    @Override
    public BigDecimal getAveragePrice() {
        return null;
    }
}