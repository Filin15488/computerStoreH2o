package by.filin.h2o.products.model.entity;

import by.filin.h2o.desktopComputer.model.entity.DesktopComputer;
import by.filin.h2o.hardDrive.model.entity.HardDrive;
import by.filin.h2o.laptop.model.entity.Laptop;
import by.filin.h2o.manufacturers.model.entity.Manufacturer;
import by.filin.h2o.monitor.model.entity.Monitor;
import by.filin.h2o.products.model.dto.response.ProductResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 256)
    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @PositiveOrZero
    private BigDecimal price;

    @PositiveOrZero
    private Integer stock;

    public ProductResponse toResponse() {
        return switch (this) {

            case DesktopComputer pc ->
                    pc.toResponse();

            case Laptop laptop ->
                    laptop.toResponse();

            case Monitor monitor ->
                    monitor.toResponse();

            case HardDrive hardDrive ->
                    hardDrive.toResponse();
            default -> throw new IllegalStateException("Unexpected value: " + this);
        };
    }

    protected void fillBaseResponse(ProductResponse response) {
        response.setId(id);
        response.setSerialNumber(serialNumber);
        response.setPrice(price);
        response.setStock(stock);
        response.setManufacturer(manufacturer.toResponse());
    }
}