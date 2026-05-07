package by.filin.h2o.products.repository;

import by.filin.h2o.products.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
