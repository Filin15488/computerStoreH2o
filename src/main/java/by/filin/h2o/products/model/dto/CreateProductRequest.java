package by.filin.h2o.products.model.dto;

import by.filin.h2o.common.enums.ManufacturerRequestType;
import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.products.model.ProductDeserializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;

@Getter
@Setter
@JsonDeserialize(using = ProductDeserializer.class)
public abstract class CreateProductRequest {
    @NotBlank
    private ManufacturerRequestType manufacturerType;

    @NotBlank
    @Size(max = 256)
    private String serialNumber;
    @PositiveOrZero
    private BigDecimal price;
    @PositiveOrZero
    private Integer stock = 0;
    @NotBlank
    private ProductType productType;
}

