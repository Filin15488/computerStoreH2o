package by.filin.h2o.common;

import by.filin.h2o.products.model.ProductDeserializer;
import by.filin.h2o.products.model.dto.create.CreateProductRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.module.SimpleModule;

@Configuration
public class JacksonConfig {

    @Bean
    SimpleModule productModule() {

        SimpleModule module = new SimpleModule();

        module.addDeserializer(
                CreateProductRequest.class,
                new ProductDeserializer()
        );

        return module;
    }
}