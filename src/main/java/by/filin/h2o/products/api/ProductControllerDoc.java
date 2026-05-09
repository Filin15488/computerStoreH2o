package by.filin.h2o.products.api;

import by.filin.h2o.advice.ExceptionResponse;
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
import by.filin.h2o.products.model.dto.response.DesktopResponse;
import by.filin.h2o.products.model.dto.response.HardDriveResponse;
import by.filin.h2o.products.model.dto.response.LaptopResponse;
import by.filin.h2o.products.model.dto.response.MonitorResponse;
import by.filin.h2o.products.model.dto.response.ProductResponse;
import by.filin.h2o.products.model.dto.update.ProductUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(
        name = "ProductApi",
        description = "апи для работы с товарами"
)
public interface ProductControllerDoc {

    @Operation(
            summary = "Создание товара",
            description = "Создаёт товар с новым или уже существующим поставщиком"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Товар создан",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            oneOf = {
                                    DesktopResponse.class,
                                    LaptopResponse.class,
                                    MonitorResponse.class,
                                    HardDriveResponse.class
                            }
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Поставщик не найден (при создании товара с manufacturerType=EXISTING)",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            implementation = ExceptionResponse.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "409",
            description = "Серийный номер уже существует",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            implementation = ExceptionResponse.class
                    )
            )
    )
    ResponseEntity<ProductResponse> create(

            @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType =  MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    oneOf = {
                                            CreateDesktopNewManufacturerRequest.class,
                                            CreateLaptopNewManufacturerRequest.class,
                                            CreateMonitorsNewManufacturerRequest.class,
                                            CreateHardDriveNewManufacturerRequest.class,

                                            CreateDesktopExistManufacturerRequest.class,
                                            CreateLaptopExistManufacturerRequest.class,
                                            CreateMonitorsExistManufacturerRequest.class,
                                            CreateHardDriveExistManufacturerRequest.class
                                    }
                            )
                    )
            )
            @Valid
            CreateProductRequest request
    );


    @Operation(summary = "Получение списка товаров по их типу")
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(
                            schema = @Schema(
                                    oneOf = {
                                            DesktopResponse.class,
                                            LaptopResponse.class,
                                            MonitorResponse.class,
                                            HardDriveResponse.class
                                    }
                            )
                    )
            )
    )
    ResponseEntity<List<ProductResponse>> getProductsByType(

            @Parameter(
                    description = "Тип товара"
            )
            ProductType productType
    );


    @Operation(summary = "Получить товар по id")
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            oneOf = {
                                    DesktopResponse.class,
                                    LaptopResponse.class,
                                    MonitorResponse.class,
                                    HardDriveResponse.class
                            }
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Товар не найдер",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            implementation = ExceptionResponse.class
                    )
            )
    )
    ResponseEntity<ProductResponse> getProductById(

            @Parameter(
                    description = "Product id"
            )
            Long id
    );


    @Operation(summary = "Редактирование товара")
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            oneOf = {
                                    DesktopResponse.class,
                                    LaptopResponse.class,
                                    MonitorResponse.class,
                                    HardDriveResponse.class
                            }
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Товар не найдер",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            implementation = ExceptionResponse.class
                    )
            )
    )
    ResponseEntity<ProductResponse> updateProduct(

            Long id,

            @RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    implementation = ProductUpdateRequest.class
                            )
                    )
            )
            ProductUpdateRequest request
    );
}