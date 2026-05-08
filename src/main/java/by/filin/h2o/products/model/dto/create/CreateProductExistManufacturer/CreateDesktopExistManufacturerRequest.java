package by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer;

import by.filin.h2o.common.enums.FormFactor;
import by.filin.h2o.products.model.dto.common.manufacturer.ExistingManufacturerRequest;
import by.filin.h2o.products.model.dto.common.products.DesktopRequestSpecific;
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
public class CreateDesktopExistManufacturerRequest extends CreateProductExistManufacturerRequest implements DesktopRequestSpecific, ExistingManufacturerRequest {
    @NotBlank
    private FormFactor formFactor;
}
