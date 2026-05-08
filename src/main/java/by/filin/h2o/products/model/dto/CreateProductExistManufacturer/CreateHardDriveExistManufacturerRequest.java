package by.filin.h2o.products.model.dto.CreateProductExistManufacturer;

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
public class CreateHardDriveExistManufacturerRequest extends CreateProductExistManufacturerRequest {
    @Positive
    private Long capacity;
}
