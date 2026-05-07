package by.filin.h2o.products.model.dto;

import jakarta.validation.constraints.NotBlank;
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
public final class CreateProductNewManufacturerRequest extends CreateProductRequest {
    @NotBlank
    private String manufacturer;
}
