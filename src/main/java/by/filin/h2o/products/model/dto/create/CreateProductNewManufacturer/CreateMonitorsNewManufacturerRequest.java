package by.filin.h2o.products.model.dto.create.CreateProductNewManufacturer;

import by.filin.h2o.products.model.dto.common.manufacturer.NewManufacturerRequest;
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
public class CreateMonitorsNewManufacturerRequest extends CreateProductNewManufacturerRequest implements MonitorRequestSpecific, NewManufacturerRequest {
    @Positive
    private Float diagonal;
}
