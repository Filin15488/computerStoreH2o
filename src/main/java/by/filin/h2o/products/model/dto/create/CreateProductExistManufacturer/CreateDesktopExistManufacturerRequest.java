package by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer;

import by.filin.h2o.common.enums.FormFactor;
import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.products.model.dto.common.manufacturer.ExistingManufacturerRequest;
import by.filin.h2o.products.model.dto.common.products.DesktopRequestSpecific;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(
            example = "DESKTOP",
            allowableValues = {"DESKTOP"}
    )
    private ProductType productType;
    @NotBlank
    private FormFactor formFactor;
}
