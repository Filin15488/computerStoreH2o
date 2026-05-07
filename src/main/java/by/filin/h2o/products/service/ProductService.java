package by.filin.h2o.products.service;

import by.filin.h2o.manufacturers.model.entity.Manufacturer;
import by.filin.h2o.manufacturers.repository.ManufacturerRepository;
import by.filin.h2o.products.model.dto.CreateProductExistManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductNewManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductRequest;
import by.filin.h2o.products.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private ManufacturerRepository manufacturerRepository;

    public void createProduct(CreateProductRequest request) {
        Manufacturer manufacturer = switch (request) {
            case CreateProductNewManufacturerRequest dto ->
                    manufacturerRepository.save(
                            new Manufacturer().builder()
                                    .name(dto.getManufacturer())
                                    .build()
                    );
            case CreateProductExistManufacturerRequest dto ->
                manufacturerRepository.findById(dto.getManufacturerId()).orElseThrow();
        };


    }
}
