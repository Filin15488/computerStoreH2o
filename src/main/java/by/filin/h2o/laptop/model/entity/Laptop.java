package by.filin.h2o.laptop.model.entity;

import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.common.validation.ValueOfInts;
import by.filin.h2o.products.model.dto.response.LaptopResponse;
import by.filin.h2o.products.model.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "laptops")
@PrimaryKeyJoinColumn(name = "product_id")
@Getter
@Setter
public class Laptop extends Product {
    @NotNull
    @Column(name = "screen_size", nullable = false)
    @ValueOfInts(values = {13, 14, 15, 17})
    private Integer screenSize;

    public LaptopResponse toResponse(){
        LaptopResponse lr = new LaptopResponse();
        fillBaseResponse(lr);
        lr.setProductType(ProductType.LAPTOPS);
        lr.setScreenSize(screenSize);
        return lr;
    }
}
