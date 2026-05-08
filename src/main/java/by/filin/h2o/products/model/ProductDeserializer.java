package by.filin.h2o.products.model;

import by.filin.h2o.advice.GeneralException;
import by.filin.h2o.common.enums.FormFactor;
import by.filin.h2o.common.enums.ManufacturerRequestType;
import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.products.model.dto.CreateProductExistManufacturer.CreateDesktopExistManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductExistManufacturer.CreateHardDriveExistManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductExistManufacturer.CreateLaptopExistManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductExistManufacturer.CreateMonitorsExistManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductExistManufacturer.CreateProductExistManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductNewManufacturer.CreateDesktopNewManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductNewManufacturer.CreateHardDriveNewManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductNewManufacturer.CreateLaptopNewManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductNewManufacturer.CreateMonitorsNewManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductNewManufacturer.CreateProductNewManufacturerRequest;
import by.filin.h2o.products.model.dto.CreateProductRequest;
import by.filin.h2o.products.model.entity.Product;
import org.springframework.http.HttpStatus;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.deser.std.StdDeserializer;

import java.math.BigDecimal;

public class ProductDeserializer extends StdDeserializer<CreateProductRequest> {

    public ProductDeserializer() {
        this(null);
    }

    public ProductDeserializer(Class<?> vc) {
        super(Product.class);
    }

    @Override
    public CreateProductRequest deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        JsonNode node = p.readValueAsTree();
        try {
            ManufacturerRequestType manufacturerRequestType = ManufacturerRequestType.valueOf(
                    node.get("manufacturerType").asString()
            );
            try {
                ProductType productType = ProductType.valueOf(
                        node.get("productType").asString()
                );
                String serialNumber = node.get("serialNumber").asString();
                BigDecimal price = new BigDecimal(node.get("price").asString());
                Integer stock = node.get("stock").asInt();

                CreateProductRequest request = switch (manufacturerRequestType) {
                    case NEW -> {
                        String manufacturerName = node.get("manufacturer").asText();
                        CreateProductNewManufacturerRequest product = switch (productType) {
                            case DESKTOP -> {
                                FormFactor formFactor = FormFactor.valueOf(node.get("formFactor").asString());
                                CreateDesktopNewManufacturerRequest desk = new CreateDesktopNewManufacturerRequest();
                                desk.setFormFactor(formFactor);
                                yield desk;
                            }
                            case LAPTOPS -> {
                                Integer screenSize = node.get("screenSize").asInt();
                                CreateLaptopNewManufacturerRequest laptop = new CreateLaptopNewManufacturerRequest();
                                laptop.setScreenSize(screenSize);
                                yield laptop;
                            }
                            case MONITORS -> {
                                Float diagonal = node.get("diagonal").asFloat();
                                CreateMonitorsNewManufacturerRequest monitors = new CreateMonitorsNewManufacturerRequest();
                                monitors.setDiagonal(diagonal);
                                yield monitors;
                            }
                            case HARD_DRIVES -> {
                                Long capacity = node.get("capacity").asLong();
                                CreateHardDriveNewManufacturerRequest hardDrive = new CreateHardDriveNewManufacturerRequest();
                                hardDrive.setCapacity(capacity);
                                yield hardDrive;
                            }
                        };
                        product.setManufacturer(manufacturerName);
                        yield product;
                    }
                    case EXISTING -> {
                        Integer manufacturerId = node.get("manufacturerId").asInt();
                        CreateProductExistManufacturerRequest product = switch (productType) {
                            case DESKTOP -> {
                                FormFactor formFactor = FormFactor.valueOf(node.get("formFactor").asString());
                                CreateDesktopExistManufacturerRequest desk = new CreateDesktopExistManufacturerRequest();
                                desk.setFormFactor(formFactor);
                                yield desk;
                            }
                            case LAPTOPS -> {
                                Integer screenSize = node.get("screenSize").asInt();
                                CreateLaptopExistManufacturerRequest laptop = new CreateLaptopExistManufacturerRequest();
                                laptop.setScreenSize(screenSize);
                                yield laptop;
                            }
                            case MONITORS -> {
                                Float diagonal = node.get("diagonal").asFloat();
                                CreateMonitorsExistManufacturerRequest monitors = new CreateMonitorsExistManufacturerRequest();
                                monitors.setDiagonal(diagonal);
                                yield monitors;
                            }

                            case HARD_DRIVES -> {
                                Long capacity = node.get("capacity").asLong();
                                CreateHardDriveExistManufacturerRequest hardDrive = new CreateHardDriveExistManufacturerRequest();
                                hardDrive.setCapacity(capacity);
                                yield hardDrive;
                            }
                        };
                        product.setManufacturerId(manufacturerId);
                        yield product;
                    }
                };
                request.setStock(stock);
                request.setPrice(price);
                request.setSerialNumber(serialNumber);
                request.setProductType(productType);
                request.setManufacturerType(manufacturerRequestType);
                return request;

            } catch (IllegalArgumentException e) {
                throw new GeneralException("Not support productType", HttpStatus.BAD_REQUEST);
            }

        } catch (IllegalArgumentException e) {
            throw new GeneralException("Not support manufacturerType", HttpStatus.BAD_REQUEST);
        }
    }
}
