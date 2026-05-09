package by.filin.h2o.products.model.dto.create.CreateProductNewManufacturer;

import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.common.validation.ValueOfInts;
import by.filin.h2o.products.model.dto.common.manufacturer.NewManufacturerRequest;
import by.filin.h2o.products.model.dto.common.products.LaptopRequestSpecific;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class CreateLaptopNewManufacturerRequest extends CreateProductNewManufacturerRequest implements LaptopRequestSpecific, NewManufacturerRequest {
    @Schema(
            example = "LAPTOPS",
            allowableValues = {"LAPTOPS"}
    )
    private ProductType productType;

    @ValueOfInts(values = {13, 14, 15, 17}, message = "Invalid screen size")
    private Integer screenSize;
}
