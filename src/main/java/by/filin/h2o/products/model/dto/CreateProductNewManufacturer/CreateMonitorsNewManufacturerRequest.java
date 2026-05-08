package by.filin.h2o.products.model.dto.CreateProductNewManufacturer;

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
public class CreateMonitorsNewManufacturerRequest extends CreateProductNewManufacturerRequest {
    @Positive
    private Float diagonal;
}
