package by.filin.h2o.products.service.updater;

import by.filin.h2o.laptop.model.entity.Laptop;
import by.filin.h2o.products.model.dto.update.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LaptopUpdater implements ProductUpdater<Laptop> {

    private final BaseProductUpdater base;

    @Override
    public Class<Laptop> supportedType() {
        return Laptop.class;
    }

    @Override
    public void update(Laptop laptop, ProductUpdateRequest request) {

        base.updateBase(request, laptop);

        if (request.getScreenSize() != null) {
            laptop.setScreenSize(request.getScreenSize());
        }
    }
}
