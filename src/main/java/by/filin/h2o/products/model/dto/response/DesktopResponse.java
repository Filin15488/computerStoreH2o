package by.filin.h2o.products.model.dto.response;

import by.filin.h2o.common.enums.FormFactor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesktopResponse extends ProductResponse {
    private FormFactor formFactor;
}
