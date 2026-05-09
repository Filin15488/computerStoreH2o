package by.filin.h2o.manufacturers.service;

import by.filin.h2o.manufacturers.model.dto.ManufacturerRequest;
import by.filin.h2o.manufacturers.model.dto.ManufacturerResponse;
import by.filin.h2o.manufacturers.model.entity.Manufacturer;
import by.filin.h2o.manufacturers.repository.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public List<ManufacturerResponse> getManufacturers() {
        return manufacturerRepository.findAll().stream()
                .map(Manufacturer::toResponse)
                .toList();
    }

    public ManufacturerResponse createManufacturer(ManufacturerRequest request) {
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName(request.name());
        return manufacturerRepository.save(newManufacturer).toResponse();
    }
}
