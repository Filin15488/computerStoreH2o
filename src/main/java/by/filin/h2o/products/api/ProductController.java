package by.filin.h2o.products.api;

import by.filin.h2o.products.model.dto.create.CreateProductRequest;
import by.filin.h2o.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> create(
            @RequestBody CreateProductRequest createProductRequest
    ){
        productService.createProduct(createProductRequest);
        return ResponseEntity.ok().build();
    }
}
