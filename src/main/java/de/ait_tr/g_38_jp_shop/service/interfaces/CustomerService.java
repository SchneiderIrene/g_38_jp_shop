package de.ait_tr.g_38_jp_shop.service.interfaces;

import de.ait_tr.g_38_jp_shop.domain.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);
    Customer findById(Long id);
    List<Customer> findAll();
    List<Customer> findAllActive();
    void update(Customer customer);
    void deleteById(Long id);
    void deleteByName(String name);
    void restoreById(Long id);

}
