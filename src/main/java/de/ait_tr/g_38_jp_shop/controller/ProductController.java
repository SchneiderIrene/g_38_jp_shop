package de.ait_tr.g_38_jp_shop.controller;

import de.ait_tr.g_38_jp_shop.domain.entity.Product;
import de.ait_tr.g_38_jp_shop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // Способ 1:
    // Передача значений как часть строки запроса
    // http://localhost:8080/products/example/5

//    @GetMapping("/example/{id}")
//    public Product getById(@PathVariable Long id) {
//        return service.getById(id);
//    }


// Способ 2:
    // Передача значений как параметр запроса
    // http://localhost:8080/products/example?id=5

    @GetMapping("/example")
    public Product getById(@RequestParam Long id) {
        return service.getById(id);
    }

    // Способ 3:
// Передача значений в JSON объекте в теле запроса
// http://localhost:8080/products/example
    @PostMapping("/example")
    public Product save(@RequestBody Product product) {
        return service.save(product);


}



}