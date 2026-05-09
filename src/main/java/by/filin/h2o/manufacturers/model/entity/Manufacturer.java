package by.filin.h2o.manufacturers.model.entity;

import by.filin.h2o.manufacturers.model.dto.ManufacturerResponse;
import by.filin.h2o.products.model.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "manufacturers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Builder.Default
    private Integer id = 0;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "manufacturer")
    @Builder.Default
    private Set<Product> products = new LinkedHashSet<>();

    public ManufacturerResponse toResponse() {
        return new  ManufacturerResponse(this.id, this.name);
    }
}