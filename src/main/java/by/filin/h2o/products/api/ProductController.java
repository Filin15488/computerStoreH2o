package by.filin.h2o.products.api;

import by.filin.h2o.common.enums.ProductType;
import by.filin.h2o.products.model.dto.create.CreateProductRequest;
import by.filin.h2o.products.model.dto.response.ProductResponse;
import by.filin.h2o.products.model.dto.update.ProductUpdateRequest;
import by.filin.h2o.products.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
@Validated
public class ProductController implements ProductControllerDoc{

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @RequestBody @Valid CreateProductRequest createProductRequest
    ) {
        return ResponseEntity.ok(productService.createProduct(createProductRequest));
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getProductsByType(
            @RequestParam ProductType productType
    ) {
        return ResponseEntity.ok(productService.getProductsByType(productType));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductUpdateRequest request
            ) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }
}
