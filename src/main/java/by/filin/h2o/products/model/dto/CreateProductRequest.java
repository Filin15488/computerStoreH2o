package by.filin.h2o.products.model.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateProductNewManufacturerRequest.class, name = "NEW"),
        @JsonSubTypes.Type(value = CreateProductExistManufacturerRequest.class, name = "EXISTING")
})
@Getter
@Setter
public sealed abstract class CreateProductRequest
        permits CreateProductNewManufacturerRequest,
        CreateProductExistManufacturerRequest {

    @NotBlank
    @Size(max = 256)
    private String serialNumber;
    @PositiveOrZero
    private BigDecimal price;
    @PositiveOrZero
    private Integer stock = 0;
}

