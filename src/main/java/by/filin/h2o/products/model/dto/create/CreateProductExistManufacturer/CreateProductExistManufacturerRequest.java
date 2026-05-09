package by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer;

import by.filin.h2o.common.enums.ManufacturerRequestType;
import by.filin.h2o.products.model.dto.create.CreateProductRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CreateProductExistManufacturerRequest extends CreateProductRequest {
    @Schema(
            example = "EXISTING",
            allowableValues = {"EXISTING"}
    )
    private ManufacturerRequestType manufacturerType;
    @NotNull
    private Integer manufacturerId;
}
