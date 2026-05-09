package by.filin.h2o.products.model.dto.create;

import by.filin.h2o.common.enums.ManufacturerRequestType;
import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer.CreateProductExistManufacturerRequest;
import by.filin.h2o.products.model.dto.create.CreateProductNewManufacturer.CreateProductNewManufacturerRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Schema(
        oneOf = {
                CreateProductNewManufacturerRequest.class,
                CreateProductExistManufacturerRequest.class,
        }
)
public abstract class CreateProductRequest {
    @NotNull
    private ManufacturerRequestType manufacturerType;

    @NotBlank
    @Size(max = 256)
    private String serialNumber;
    @PositiveOrZero
    private BigDecimal price;
    @PositiveOrZero
    private Integer stock = 0;
    @NotNull
    private ProductType productType;
}

