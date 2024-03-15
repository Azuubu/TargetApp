package com.bartekm.targetapp.product;

import com.bartekm.targetapp.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(path = "/pr")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id")int id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        product.setId(productService.getAllProducts().size() + 1);
        return ResponseEntity.created(getLocation(product.getId())).body(productService.addProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id")int id) {
        return ResponseEntity.ok(productService.deleteById(id));
    }

    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    private URI getLocation(int id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

}
