package by.filin.h2o.manufacturers.repository;

import by.filin.h2o.manufacturers.model.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
