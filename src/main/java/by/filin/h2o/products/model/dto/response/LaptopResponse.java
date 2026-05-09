package by.filin.h2o.products.model.dto.response;

import by.filin.h2o.common.enums.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LaptopResponse extends ProductResponse {
    @Schema(
            example = "LAPTOPS",
            allowableValues = {"LAPTOPS"}
    )
    private ProductType productType;

    private Integer screenSize;
}
