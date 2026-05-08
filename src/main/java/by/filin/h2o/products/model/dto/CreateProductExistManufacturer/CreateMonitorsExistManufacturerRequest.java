package by.filin.h2o.products.model.dto.CreateProductExistManufacturer;

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
public class CreateMonitorsExistManufacturerRequest extends CreateProductExistManufacturerRequest {
    @Positive
    private Float diagonal;
}
