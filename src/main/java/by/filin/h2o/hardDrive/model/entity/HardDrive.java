package by.filin.h2o.hardDrive.model.entity;


import by.filin.h2o.products.model.dto.response.HardDriveResponse;
import by.filin.h2o.products.model.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hard_drives")
@PrimaryKeyJoinColumn(name = "product_id")
@Getter
@Setter
public class HardDrive extends Product {
    @Column(name = "capacity")
    @Positive
    private Long capacity;

    public HardDriveResponse toResponse() {
        HardDriveResponse hd = new HardDriveResponse();
        fillBaseResponse(hd);
        hd.setCapacity(capacity);
        return hd;
    }
}
