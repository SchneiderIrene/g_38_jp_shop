package de.ait_tr.g_38_jp_shop.controller;

import de.ait_tr.g_38_jp_shop.domain.dto.CustomerDto;
import de.ait_tr.g_38_jp_shop.service.interfaces.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public CustomerDto getById(@RequestParam Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public CustomerDto save(@RequestBody CustomerDto customer) {
        return service.save(customer);
    }

    @GetMapping("/all") public List<CustomerDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/all/active")
    public List<CustomerDto> getAllActive (){
        return service.findAllActive();
    }

    @PostMapping("/update")
    public void update(@RequestBody CustomerDto dto) {
        service.update(dto);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam Long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/delete/name")
    public void deleteByName(@RequestParam String name) {
        service.deleteByName(name);
    }

    @PutMapping("/restore") public void restoreById(@RequestParam Long id) {
        service.restoreById(id);
    }
}
