package de.ait_tr.g_38_jp_shop.controller;

import de.ait_tr.g_38_jp_shop.domain.dto.ProductDto;
import de.ait_tr.g_38_jp_shop.exception_handling.Response;
import de.ait_tr.g_38_jp_shop.exception_handling.exceptions.FirstTestException;
import de.ait_tr.g_38_jp_shop.exception_handling.exceptions.ProductNotFoundException;
import de.ait_tr.g_38_jp_shop.service.interfaces.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
        product.setProductId(null);
        return service.save(product);
    }

    @GetMapping("/all")
    public List<ProductDto> getAll(){
        return  service.getAll();
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductDto dto) {
        service.update(dto);
    }

    @GetMapping("/totalQuantity")
    public int getTotalQuantity () {
        return service.getTotalQuantity();
    }

    @GetMapping("/totalPrice")
    public BigDecimal getTotalPrice () {
        return service.getTotalPrice();
    }

    @GetMapping("/averagePrice")
    public BigDecimal getAveragePrice () {
        return service.getAveragePrice();
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam Long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/delete/title")
    public void deleteByTitle(@RequestParam String title) {
        service.deleteByTitle(title);
    }

    @PutMapping("/restore") public  void restoreById(@RequestParam Long id) {
        service.restoreById(id);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Response handleException (ProductNotFoundException e){
        return  new Response(e.getMessage());
    }


}