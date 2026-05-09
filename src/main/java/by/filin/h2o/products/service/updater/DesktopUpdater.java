package by.filin.h2o.products.service.updater;

import by.filin.h2o.desktopComputer.model.entity.DesktopComputer;
import by.filin.h2o.products.model.dto.update.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DesktopUpdater implements ProductUpdater<DesktopComputer> {

    private final BaseProductUpdater base;

    @Override
    public Class<DesktopComputer> supportedType() {
        return DesktopComputer.class;
    }

    @Override
    public void update(DesktopComputer desktop, ProductUpdateRequest request) {

        base.updateBase(request, desktop);

        if (request.getFormFactor() != null) {
            desktop.setFormFactor(request.getFormFactor());
        }
    }
}