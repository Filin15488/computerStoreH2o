package by.filin.h2o.products.service.updater;

import by.filin.h2o.products.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProductUpdaterRegistry {

    private final Map<Class<? extends Product>, ProductUpdater<?>> registry;

    public ProductUpdaterRegistry(List<ProductUpdater<?>> updaters) {

        this.registry = updaters.stream()
                .collect(Collectors.toMap(
                        ProductUpdater::supportedType,
                        u -> u
                ));
    }

    @SuppressWarnings("unchecked")
    public <T extends Product> ProductUpdater<T> get(Class<T> type) {
        return (ProductUpdater<T>) registry.get(type);
    }
}
