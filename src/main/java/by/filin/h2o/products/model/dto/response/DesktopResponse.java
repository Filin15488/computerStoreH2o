package by.filin.h2o.products.model.dto.response;

import by.filin.h2o.common.enums.FormFactor;
import by.filin.h2o.common.enums.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesktopResponse extends ProductResponse {
    @Schema(
            example = "DESKTOP",
            allowableValues = {"DESKTOP"}
    )
    private ProductType productType;

    private FormFactor formFactor;
}
