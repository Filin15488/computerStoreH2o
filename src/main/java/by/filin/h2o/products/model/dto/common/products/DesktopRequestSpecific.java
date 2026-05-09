package by.filin.h2o.products.model.dto.common.products;

import by.filin.h2o.common.enums.FormFactor;

public non-sealed interface DesktopRequestSpecific
        extends ProductSpecific {

    FormFactor getFormFactor();
}