package by.filin.h2o.products.model.dto.common;

import by.filin.h2o.common.enums.ManufacturerRequestType;
import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer.CreateDesktopExistManufacturerRequest;
import by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer.CreateHardDriveExistManufacturerRequest;
import by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer.CreateLaptopExistManufacturerRequest;
import by.filin.h2o.products.model.dto.create.CreateProductExistManufacturer.CreateMonitorsExistManufacturerRequest;
import by.filin.h2o.products.model.dto.create.CreateProductNewManufacturer.CreateDesktopNewManufacturerRequest;
import by.filin.h2o.products.model.dto.create.CreateProductNewManufacturer.CreateHardDriveNewManufacturerRequest;
import by.filin.h2o.products.model.dto.create.CreateProductNewManufacturer.CreateLaptopNewManufacturerRequest;
import by.filin.h2o.products.model.dto.create.CreateProductNewManufacturer.CreateMonitorsNewManufacturerRequest;
import by.filin.h2o.products.model.dto.create.CreateProductRequest;
import by.filin.h2o.products.model.entity.Product;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.deser.std.StdDeserializer;

public class ProductCreateDeserializer extends StdDeserializer<CreateProductRequest> {

    public ProductCreateDeserializer() {
        this(null);
    }

    public ProductCreateDeserializer(Class<?> vc) {
        super(Product.class);
    }

    @Override
    public CreateProductRequest deserialize(
            JsonParser p,
            DeserializationContext ctxt
    ) throws JacksonException {

        JsonNode node =
                p.readValueAsTree();

        ManufacturerRequestType manufacturerType =
                ManufacturerRequestType.valueOf(
                        node.get("manufacturerType")
                                .asString()
                );

        ProductType productType =
                ProductType.valueOf(
                        node.get("productType")
                                .asString()
                );

        Class<? extends CreateProductRequest> dtoClass =
                resolveClass(
                        manufacturerType,
                        productType
                );

        return ctxt.readTreeAsValue(
                node,
                dtoClass
        );
    }

    private Class<? extends CreateProductRequest> resolveClass(
            ManufacturerRequestType manufacturerType,
            ProductType productType
    ) {

        return switch (manufacturerType) {

            case NEW -> switch (productType) {

                case DESKTOP -> CreateDesktopNewManufacturerRequest.class;

                case LAPTOPS -> CreateLaptopNewManufacturerRequest.class;

                case MONITORS -> CreateMonitorsNewManufacturerRequest.class;

                case HARD_DRIVES -> CreateHardDriveNewManufacturerRequest.class;
            };

            case EXISTING -> switch (productType) {

                case DESKTOP -> CreateDesktopExistManufacturerRequest.class;

                case LAPTOPS -> CreateLaptopExistManufacturerRequest.class;

                case MONITORS -> CreateMonitorsExistManufacturerRequest.class;

                case HARD_DRIVES -> CreateHardDriveExistManufacturerRequest.class;
            };
        };
    }
}
