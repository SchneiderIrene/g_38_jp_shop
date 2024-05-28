package de.ait_tr.g_38_jp_shop.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Objects;

@Schema(description = "Product DTO")
public class ProductDto {

    @Schema(description = "Product ID",
    example = "777",
    accessMode = Schema.AccessMode.READ_ONLY)
    private Long productId;

    @Schema(description = "Title of Product",
            example = "Banana")
    public String title;

    @Schema(description = "Product price",
            example = "129.99")
    public BigDecimal price;

    public ProductDto() {}

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(productId, that.productId) && Objects.equals(title, that.title) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, title, price);
    }

    @Override
    public String toString() {
        return String.format("Product: ID - %d, title - %s, price - %.2f",
                productId, title, price);
    }


}
