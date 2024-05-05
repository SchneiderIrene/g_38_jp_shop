package de.ait_tr.g_38_jp_shop.repository;

import de.ait_tr.g_38_jp_shop.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customer...", nativeQuery = true)
    Customer findByName(String name);

    @Query(value = "SELECT * FROM customer...", nativeQuery = true)
    Customer findById(long id);
}
