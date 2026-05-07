package by.filin.h2o.monitor.model.entity;

import by.filin.h2o.products.model.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "monitors")
@PrimaryKeyJoinColumn(name = "product_id")
@Getter
@Setter
public class Monitor extends Product {
    @Column(name = "diagonal")
    @Positive
    private Float diagonal;
}
