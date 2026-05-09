package by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer;

import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.products.model.dto.common.manufacturer.ExistingManufacturerRequest;
import by.filin.h2o.products.model.dto.common.products.MonitorRequestSpecific;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
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
public class CreateMonitorsExistManufacturerRequest extends CreateProductExistManufacturerRequest implements MonitorRequestSpecific, ExistingManufacturerRequest {
    @Schema(
            example = "MONITORS",
            allowableValues = {"MONITORS"}
    )
    private ProductType productType;
    @Schema(
            description = "В дюймах"
    )
    @Positive
    private Float diagonal;
}
