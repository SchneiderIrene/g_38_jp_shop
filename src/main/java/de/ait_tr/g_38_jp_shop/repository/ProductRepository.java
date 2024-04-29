package de.ait_tr.g_38_jp_shop.repository;

import de.ait_tr.g_38_jp_shop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // В данном случае тело метода будет сгенерировано Спрингом,
    // при этом SQL запрос он тоже сгенерирует сам.
//    Product findByTitle(String title);

    // В данном случае тело метода будет сгенерировано Спрингом,
    // но он воспользуется тем SQL запросом, который мы ему предоставили.
    @Query(value = "SELECT * FROM product...", nativeQuery = true)
    Product findByTitle(String title);
}
