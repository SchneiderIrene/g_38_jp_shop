package de.ait_tr.g_38_jp_shop.service.interfaces;

import de.ait_tr.g_38_jp_shop.domain.entity.Customer;

import de.ait_tr.g_38_jp_shop.repository.CustomerRepository;


import java.util.List;

public class CustomerServiceImpl implements CustomerService{


    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer findById(Long id) {
//        if (id == null || id < 1) {
//            throw new RuntimeException("Customer not found");
//        }
//
//        Customer customer = repository.findById(id).orElse(null);
//
//        if (customer == null) {
//            throw new RuntimeException("Product not found");
//        }
//
//        return customer;
        return null;
    }


    @Override
    public List<Customer> findAll() {
        return List.of();
    }

    @Override
    public List<Customer> findAllActive() {
        return List.of();
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void restoreById(Long id) {

    }
}
