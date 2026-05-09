package by.filin.h2o.products.model.dto.response;

import by.filin.h2o.common.enums.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonitorResponse extends ProductResponse {
    @Schema(
            example = "MONITORS",
            allowableValues = {"MONITORS"}
    )
    private ProductType productType;

    @Schema(
            description = "В дюймах"
    )
    private Float diagonal;
}
