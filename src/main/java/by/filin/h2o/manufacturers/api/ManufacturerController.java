package by.filin.h2o.manufacturers.api;

import by.filin.h2o.manufacturers.model.dto.ManufacturerRequest;
import by.filin.h2o.manufacturers.model.dto.ManufacturerResponse;
import by.filin.h2o.manufacturers.service.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manufacturers")
@AllArgsConstructor
public class ManufacturerController {

    private ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<List<ManufacturerResponse>> getManufacturers() {
        return ResponseEntity.ok(manufacturerService.getManufacturers());
    }

    @PostMapping
    public ResponseEntity<ManufacturerResponse> createManufacturer(
            @RequestBody ManufacturerRequest request
    ) {
        return ResponseEntity.ok(manufacturerService.createManufacturer(request));
    }

}
