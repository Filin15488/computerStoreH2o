package by.filin.h2o.products.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class CreateProductExistManufacturerRequest extends CreateProductRequest {
    @NotNull
    private Integer manufacturerId;
}
