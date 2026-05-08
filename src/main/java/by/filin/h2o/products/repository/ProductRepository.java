package by.filin.h2o.products.repository;

import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.products.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
        select p
        from Product p
        where type(p) = :type
    """)
    List<Product> findByType(
            @Param("type")
            Class<? extends Product> type
    );

    Product findBySerialNumber(String serialNumber);
}
