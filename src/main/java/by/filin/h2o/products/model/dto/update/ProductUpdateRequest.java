package by.filin.h2o.products.model.dto.update;

import by.filin.h2o.common.enums.FormFactor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductUpdateRequest {
    private String serialNumber;
    private BigDecimal price;
    private Integer stock;
    private Integer manufacturerId;

    // optional fields
    private FormFactor formFactor;
    private Integer screenSize;
    private Float diagonal;
    private Long capacity;
}
