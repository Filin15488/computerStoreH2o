package by.filin.h2o.products.service.updater;

import by.filin.h2o.products.model.dto.update.ProductUpdateRequest;
import by.filin.h2o.products.model.entity.Product;

public interface ProductUpdater<T extends Product> {
    Class<T> supportedType();
    void update(T product, ProductUpdateRequest request);
}
