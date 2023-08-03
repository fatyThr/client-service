package com.lij.clientservice.application.feign;

import com.lij.clientservice.application.model.ProductRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "${application.feign.product.name}", url = "${application.feign.product.url}",fallbackFactory = ProductClient.ProductFallbackFactory.class)
public interface ProductClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/products")
   List<ProductRepresentation>getProducts() ;


    @Component
    class ProductFallbackFactory implements FallbackFactory<ProductClient> {
        @Override
        public ProductClient create(Throwable cause) {
            return new ProductClient.ProductFallback(cause);
        }
    }
    @RequiredArgsConstructor
    class ProductFallback implements ProductClient {
        private final Throwable cause;

        @Override
        public List<ProductRepresentation> getProducts() {
            Exception ex = new Exception(cause);
            return null;
        }
    }
}
