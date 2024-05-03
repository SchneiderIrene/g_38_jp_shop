package de.ait_tr.g_38_jp_shop.controller;

import de.ait_tr.g_38_jp_shop.domain.dto.ProductDto;
import de.ait_tr.g_38_jp_shop.domain.entity.Product;
import de.ait_tr.g_38_jp_shop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // Способ 1:
    // Передача значений как часть строки запроса
    // http://localhost:8080/products/5

//    @GetMapping("/{id}")
//    public ProductDto getById(@PathVariable Long id) {
//        return service.getById(id);
//    }


// Способ 2:
    // Передача значений как параметр запроса
    // http://localhost:8080/products?id=5

    @GetMapping
    public ProductDto getById(@RequestParam Long id) {
        return service.getById(id);
    }

    // Способ 3:
// Передача значений в JSON объекте в теле запроса
// http://localhost:8080/products

    @PostMapping
    public ProductDto save(@RequestBody ProductDto product) {
        return service.save(product);
    }

    @GetMapping("/all") public List<ProductDto> getAll(){
        return  service.getAll();
    }



}