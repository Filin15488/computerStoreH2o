package by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer;

import by.filin.h2o.common.validation.ValueOfInts;
import by.filin.h2o.products.model.dto.common.manufacturer.ExistingManufacturerRequest;
import by.filin.h2o.products.model.dto.common.products.LaptopRequestSpecific;
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
public class CreateLaptopExistManufacturerRequest extends CreateProductExistManufacturerRequest implements LaptopRequestSpecific, ExistingManufacturerRequest {
    @ValueOfInts(values = {13, 14, 15, 17})
    private Integer screenSize;
}
