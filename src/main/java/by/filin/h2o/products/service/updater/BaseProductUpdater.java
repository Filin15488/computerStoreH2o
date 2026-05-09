package by.filin.h2o.products.service.updater;

import by.filin.h2o.advice.GeneralException;
import by.filin.h2o.manufacturers.model.entity.Manufacturer;
import by.filin.h2o.manufacturers.repository.ManufacturerRepository;
import by.filin.h2o.products.model.dto.update.ProductUpdateRequest;
import by.filin.h2o.products.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BaseProductUpdater {

    private final ManufacturerRepository manufacturerRepository;


    public void updateBase(ProductUpdateRequest request, Product product) {

        if (request.getManufacturerId() != null) {
            Manufacturer manufacturer = manufacturerRepository.findById(request.getManufacturerId()).orElseThrow(
                    () -> new GeneralException("Not found manufacturer by id " + request.getManufacturerId(), HttpStatus.NOT_FOUND)
            );
            product.setManufacturer(manufacturer);
        }

        if (request.getSerialNumber() != null) {
            product.setSerialNumber(request.getSerialNumber());
        }

        if (request.getPrice() != null) {
            product.setPrice(request.getPrice());
        }

        if (request.getStock() != null) {
            product.setStock(request.getStock());
        }
    }
}
