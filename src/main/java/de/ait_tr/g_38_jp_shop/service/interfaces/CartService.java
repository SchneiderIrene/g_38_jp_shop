package de.ait_tr.g_38_jp_shop.service.interfaces;

import de.ait_tr.g_38_jp_shop.domain.dto.CartDto;
import de.ait_tr.g_38_jp_shop.domain.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
     CartDto addCart(ProductDto product);
     List<ProductDto> getAllProducts();
     void deleteProductById(Long id);
     void deleteAllProducts();
     BigDecimal getCartPriceTotal();
     BigDecimal getCartPriceAvg();

}
