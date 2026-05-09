package by.filin.h2o.products.service.updater;

import by.filin.h2o.hardDrive.model.entity.HardDrive;
import by.filin.h2o.products.model.dto.update.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HardDriveUpdater implements ProductUpdater<HardDrive> {

    private final BaseProductUpdater base;

    @Override
    public Class<HardDrive> supportedType() {
        return HardDrive.class;
    }

    @Override
    public void update(HardDrive hardDrive, ProductUpdateRequest request) {
        base.updateBase(request, hardDrive);
        if (request.getCapacity() != null) {
            hardDrive.setCapacity(request.getCapacity());
        }
    }
}
