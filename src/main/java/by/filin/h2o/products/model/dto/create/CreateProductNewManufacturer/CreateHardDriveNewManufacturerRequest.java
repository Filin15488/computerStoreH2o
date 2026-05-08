package by.filin.h2o.products.model.dto.create.CreateProductNewManufacturer;

import by.filin.h2o.products.model.dto.common.manufacturer.NewManufacturerRequest;
import by.filin.h2o.products.model.dto.common.products.HardDriveRequestSpecific;
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
    @Positive
    private Long capacity;
}
