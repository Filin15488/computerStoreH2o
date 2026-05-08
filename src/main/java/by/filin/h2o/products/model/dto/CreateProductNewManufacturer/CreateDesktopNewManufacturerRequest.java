package by.filin.h2o.products.model.dto.CreateProductNewManufacturer;

import by.filin.h2o.common.enums.FormFactor;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDesktopNewManufacturerRequest extends CreateProductNewManufacturerRequest {
    @NotBlank
    private FormFactor formFactor;
}
