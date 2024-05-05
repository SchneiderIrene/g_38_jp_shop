package de.ait_tr.g_38_jp_shop.service.interfaces;

import de.ait_tr.g_38_jp_shop.domain.dto.CustomerDto;
import de.ait_tr.g_38_jp_shop.domain.entity.Customer;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerDto dto);
    CustomerDto getById(Long id);
    List<CustomerDto> findAll();
    List<CustomerDto> findAllActive();
    void update(CustomerDto customer);
    void deleteById(Long id);
    void deleteByName(String name);
    void restoreById(Long id);

}
