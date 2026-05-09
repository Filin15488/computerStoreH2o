package by.filin.h2o.products.model.dto.response;

import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.manufacturers.model.dto.ManufacturerResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Schema(
        hidden = true
)
public abstract class ProductResponse {
    private Integer id;
    private String serialNumber;
    private BigDecimal price;
    private Integer stock;
    private ProductType productType;
    private ManufacturerResponse manufacturer;
}
