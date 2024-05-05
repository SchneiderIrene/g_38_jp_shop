package de.ait_tr.g_38_jp_shop.service.mapping;

import de.ait_tr.g_38_jp_shop.domain.dto.CustomerDto;
import de.ait_tr.g_38_jp_shop.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CustomerMappingService {

 @Mapping(target = "customerId", source = "id")
 @Mapping(target = "customerName", source = "name")
 CustomerDto mapEntityToDto (Customer entity);


 @Mapping(target = "id", ignore = true)
 @Mapping(target = "name", ignore = true)
 @Mapping(target = "active", constant = "true")
 Customer mapDtoToEntity (CustomerDto dto);

}
