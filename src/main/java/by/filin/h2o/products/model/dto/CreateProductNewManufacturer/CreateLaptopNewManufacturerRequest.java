package by.filin.h2o.products.model.dto.CreateProductNewManufacturer;

import by.filin.h2o.common.validation.ValueOfInts;
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
public class CreateLaptopNewManufacturerRequest extends CreateProductNewManufacturerRequest {
    @ValueOfInts(values = {13, 14, 15, 17})
    private Integer screenSize;
}
