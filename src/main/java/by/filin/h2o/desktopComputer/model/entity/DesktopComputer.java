package by.filin.h2o.desktopComputer.model.entity;

import by.filin.h2o.common.enums.FormFactor;
import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.products.model.dto.response.DesktopResponse;
import by.filin.h2o.products.model.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "desktop_computers")
@PrimaryKeyJoinColumn(name = "product_id")
@Getter
@Setter
public class DesktopComputer extends Product {

    @Enumerated(EnumType.STRING)
    @Column(name = "form_factor")
    private FormFactor formFactor;

    public DesktopResponse toResponse() {
        DesktopResponse dr = new DesktopResponse();
        fillBaseResponse(dr);
        dr.setFormFactor(this.formFactor);
        dr.setProductType(ProductType.DESKTOP);
        return dr;
    }
}
