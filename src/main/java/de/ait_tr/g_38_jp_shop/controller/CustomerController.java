package de.ait_tr.g_38_jp_shop.controller;

import de.ait_tr.g_38_jp_shop.domain.entity.Customer;
import de.ait_tr.g_38_jp_shop.service.interfaces.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    private CustomerService service;

    public CustomerController() {}

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public Customer getById(@RequestParam Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return service.save(customer);
    }
}
