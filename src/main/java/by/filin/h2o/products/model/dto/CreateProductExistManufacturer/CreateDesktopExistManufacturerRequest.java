package by.filin.h2o.products.model.dto.CreateProductExistManufacturer;

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
public class CreateDesktopExistManufacturerRequest extends CreateProductExistManufacturerRequest {
    @NotBlank
    private FormFactor formFactor;
}
