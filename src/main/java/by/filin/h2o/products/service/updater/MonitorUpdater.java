package by.filin.h2o.products.service.updater;

import by.filin.h2o.monitor.model.entity.Monitor;
import by.filin.h2o.products.model.dto.update.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MonitorUpdater implements ProductUpdater<Monitor> {

    private final BaseProductUpdater base;

    @Override
    public Class<Monitor> supportedType() {
        return Monitor.class;
    }

    @Override
    public void update(Monitor monitor, ProductUpdateRequest request) {

        base.updateBase(request, monitor);

        if (request.getDiagonal() != null) {
            monitor.setDiagonal(request.getDiagonal());
        }
    }
}
