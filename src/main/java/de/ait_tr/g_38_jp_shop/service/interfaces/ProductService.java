package de.ait_tr.g_38_jp_shop.service.interfaces;
import de.ait_tr.g_38_jp_shop.domain.dto.ProductDto;
import de.ait_tr.g_38_jp_shop.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto dto);

    List<ProductDto> getAll();

    ProductDto getById(Long id);

    void update(ProductDto dto);

    void deleteById(Long id);

    void deleteByTitle(String title);

    void restoreById(Long id);

    int getTotalQuantity();

    BigDecimal getTotalPrice();

    BigDecimal getAveragePrice();

    void attachImage(String imgUrl, String prductTitle);
}