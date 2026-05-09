package by.filin.h2o.products.service;

import by.filin.h2o.advice.GeneralException;
import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.desktopComputer.model.entity.DesktopComputer;
import by.filin.h2o.hardDrive.model.entity.HardDrive;
import by.filin.h2o.laptop.model.entity.Laptop;
import by.filin.h2o.manufacturers.model.entity.Manufacturer;
import by.filin.h2o.manufacturers.repository.ManufacturerRepository;
import by.filin.h2o.monitor.model.entity.Monitor;
import by.filin.h2o.products.model.dto.common.manufacturer.ExistingManufacturerRequest;
import by.filin.h2o.products.model.dto.common.manufacturer.NewManufacturerRequest;
import by.filin.h2o.products.model.dto.common.products.DesktopRequestSpecific;
import by.filin.h2o.products.model.dto.common.products.HardDriveRequestSpecific;
import by.filin.h2o.products.model.dto.common.products.LaptopRequestSpecific;
import by.filin.h2o.products.model.dto.common.products.MonitorRequestSpecific;
import by.filin.h2o.products.model.dto.create.CreateProductRequest;
import by.filin.h2o.products.model.dto.response.ProductResponse;
import by.filin.h2o.products.model.dto.update.ProductUpdateRequest;
import by.filin.h2o.products.model.entity.Product;
import by.filin.h2o.products.repository.ProductRepository;
import by.filin.h2o.products.service.updater.ProductUpdater;
import by.filin.h2o.products.service.updater.ProductUpdaterRegistry;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private ManufacturerRepository manufacturerRepository;
    private ProductUpdaterRegistry registry;

    public ProductResponse createProduct(CreateProductRequest request) {
        Manufacturer manufacturer = resolveManufacturer(request);
        Product existedSerialKey = productRepository.findBySerialNumber(request.getSerialNumber());
        if (existedSerialKey != null) {
            throw new GeneralException("Product with serial number already exists", HttpStatus.CONFLICT);
        }
        Product product = createProduct(request, manufacturer);
        productRepository.save(product);
        return product.toResponse();
    }

    private Product createProduct(
            CreateProductRequest request,
            Manufacturer manufacturer
    ) {

        return switch (request) {

            case DesktopRequestSpecific dto -> {
                DesktopComputer pc = new DesktopComputer();
                fillBaseAttributes(request, pc, manufacturer);
                pc.setFormFactor(dto.getFormFactor());
                yield pc;
            }

            case HardDriveRequestSpecific dto -> {
                HardDrive hd = new HardDrive();
                fillBaseAttributes(request, hd, manufacturer);
                hd.setCapacity(dto.getCapacity());
                yield hd;
            }

            case LaptopRequestSpecific dto -> {
                Laptop laptop = new Laptop();
                fillBaseAttributes(request, laptop, manufacturer);
                laptop.setScreenSize(dto.getScreenSize());
                yield laptop;
            }

            case MonitorRequestSpecific dto -> {
                Monitor monitor = new Monitor();
                fillBaseAttributes(request, monitor, manufacturer);
                monitor.setDiagonal(dto.getDiagonal());
                yield monitor;
            }

            default -> throw new GeneralException("Invalid request", HttpStatus.BAD_REQUEST);
        };
    }

    private Manufacturer resolveManufacturer(
            CreateProductRequest request
    ) {

        return switch (request) {
            case NewManufacturerRequest dto -> manufacturerRepository.save(
                    Manufacturer.builder()
                            .name(dto.getManufacturer())
                            .build()
            );
            case ExistingManufacturerRequest dto -> manufacturerRepository.findById(
                    dto.getManufacturerId()
            ).orElseThrow(
                    () -> new GeneralException("Manufacturer with id " + dto.getManufacturerId() + " not found", HttpStatus.NOT_FOUND)
            );
            default -> throw new GeneralException("Invalid request", HttpStatus.BAD_REQUEST);
        };
    }

    private void fillBaseAttributes(CreateProductRequest request, Product product, Manufacturer manufacturer) {
        product.setSerialNumber(request.getSerialNumber());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());
        product.setManufacturer(manufacturer);
    }

    public List<ProductResponse> getProductsByType(ProductType productType) {
        return productRepository.findByType(productType.getEntityClass()).stream().map(Product::toResponse).toList();
    }

    public ProductResponse getProductById(Long id) {
        return getProductOrThrow(id)
                .toResponse();
    }

    private Product getProductOrThrow(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new GeneralException(
                                "Product with id " + id + " not found",
                                HttpStatus.NOT_FOUND
                        )
                );
    }

    public ProductResponse updateProduct(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new GeneralException("Not found", HttpStatus.NOT_FOUND));

        ProductUpdater updater = registry.get(product.getClass());

        updater.update(product, request);

        return productRepository.save(product).toResponse();
    }

}
