package by.filin.h2o.products.model.dto.create.CreateProductNewManufacturer;

import by.filin.h2o.common.enums.ManufacturerRequestType;
import by.filin.h2o.products.model.dto.create.CreateProductRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CreateProductNewManufacturerRequest extends CreateProductRequest {
    @Schema(
            example = "NEW",
            allowableValues = {"NEW"}
    )
    private ManufacturerRequestType manufacturerType;
    @NotBlank
    private String manufacturer;
}
