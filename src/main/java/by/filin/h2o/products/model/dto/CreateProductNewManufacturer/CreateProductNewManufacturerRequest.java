package by.filin.h2o.products.model.dto.CreateProductNewManufacturer;

import by.filin.h2o.products.model.dto.CreateProductRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CreateProductNewManufacturerRequest extends CreateProductRequest {
    @NotBlank
    private String manufacturer;
}
