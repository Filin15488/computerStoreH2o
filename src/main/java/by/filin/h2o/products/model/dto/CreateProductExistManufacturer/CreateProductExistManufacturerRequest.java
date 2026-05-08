package by.filin.h2o.products.model.dto.CreateProductExistManufacturer;

import by.filin.h2o.products.model.dto.CreateProductRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CreateProductExistManufacturerRequest extends CreateProductRequest {
    @NotNull
    private Integer manufacturerId;
}
