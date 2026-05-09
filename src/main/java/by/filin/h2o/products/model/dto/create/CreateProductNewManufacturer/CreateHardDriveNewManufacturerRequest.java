package by.filin.h2o.products.model.dto.create.CreateProductNewManufacturer;

import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.products.model.dto.common.manufacturer.NewManufacturerRequest;
import by.filin.h2o.products.model.dto.common.products.HardDriveRequestSpecific;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateHardDriveNewManufacturerRequest extends CreateProductNewManufacturerRequest implements HardDriveRequestSpecific, NewManufacturerRequest {

    @Schema(
            example = "HARD_DRIVES",
            allowableValues = {"HARD_DRIVES"}
    )
    private ProductType productType;
    @Schema(
            description = "В байтах"
    )
    @Positive
    private Long capacity;
}
