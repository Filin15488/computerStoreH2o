package by.filin.h2o.products.model.dto.response;

import by.filin.h2o.common.enums.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HardDriveResponse extends ProductResponse {
    @Schema(
            example = "HARD_DRIVES",
            allowableValues = {"HARD_DRIVES"}
    )
    private ProductType productType;

    @Schema(
            description = "В байтах"
    )
    private Long capacity;

}
