package by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer;

import by.filin.h2o.products.model.dto.common.manufacturer.ExistingManufacturerRequest;
import by.filin.h2o.products.model.dto.common.products.MonitorRequestSpecific;
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
    @Positive
    private Float diagonal;
}
