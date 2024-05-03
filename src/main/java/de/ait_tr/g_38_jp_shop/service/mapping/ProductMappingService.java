package de.ait_tr.g_38_jp_shop.service.mapping;

import de.ait_tr.g_38_jp_shop.domain.dto.ProductDto;
import de.ait_tr.g_38_jp_shop.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductMappingService {

//    public ProductDto mapEntityToDto (Product entity);
//    {
//        ProductDto dto = new ProductDto();
//        dto.setProductId(entity.getId());
//        dto.setTitle(entity.getTitle());
//        dto.setPrice(entity.getPrice());
//        return dto;
//    }
//     public Product mapDtoEntity (ProductDto dto) {
//
 @Mapping(target = "productId", source = "id")
 ProductDto mapEntityToDto (Product entity);

 @Mapping(target = "id", ignore = true)
 @Mapping(target = "active", constant = "true")
 Product mapDtoToEntity (ProductDto dto);

}
