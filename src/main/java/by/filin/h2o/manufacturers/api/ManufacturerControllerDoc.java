package by.filin.h2o.manufacturers.api;

import by.filin.h2o.manufacturers.model.dto.ManufacturerRequest;
import by.filin.h2o.manufacturers.model.dto.ManufacturerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(
        name = "ManufacturerApi",
        description = "Апи для работы с поставщиками"
)
public interface ManufacturerControllerDoc {

    @Operation(
            summary = "Получение списка производителей"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Список производителей",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(
                            schema = @Schema(
                                    implementation = ManufacturerResponse.class
                            )
                    )
            )
    )
    ResponseEntity<List<ManufacturerResponse>> getManufacturers();


    @Operation(
            summary = "Создание производителя"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Производитель создан",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(
                            implementation = ManufacturerResponse.class
                    )
            )
    )
    ResponseEntity<ManufacturerResponse> createManufacturer(

            @RequestBody(
                    required = true,
                    content = @Content(
                            schema = @Schema(
                                    implementation = ManufacturerRequest.class
                            )
                    )
            )
            ManufacturerRequest request
    );
}