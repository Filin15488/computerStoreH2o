package by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer;

import by.filin.h2o.products.model.dto.common.manufacturer.ExistingManufacturerRequest;
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
public class CreateHardDriveExistManufacturerRequest extends CreateProductExistManufacturerRequest implements HardDriveRequestSpecific, ExistingManufacturerRequest {
    @Positive
    private Long capacity;
}
