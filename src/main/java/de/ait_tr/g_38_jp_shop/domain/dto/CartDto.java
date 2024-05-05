package de.ait_tr.g_38_jp_shop.domain.dto;

import java.util.List;
import java.util.Objects;

public class CartDto {

    private Long cartId;
    private List<ProductDto> products;

    public CartDto() {
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto cartDto = (CartDto) o;
        return Objects.equals(cartId, cartDto.cartId) && Objects.equals(products, cartDto.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, products);
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cartId=" + cartId +
                ", products=" + products +
                '}';
    }
}
