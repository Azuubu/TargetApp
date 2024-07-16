package com.bartekm.targetapp.product;

import com.bartekm.targetapp.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id")int id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name")String name) {
        return ResponseEntity.ok(productService.findProductByName(name));
    }

//    @PostMapping()
//    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
//        product.setId(productService.getAllProducts().size() + 1);
//        return ResponseEntity.created(getLocation(product.getId())).body(productService.addProduct(product));
//    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
        //product.setId(productService.getAllProducts().size() + 1);
        // calkiem wywalic to ^
        System.out.println("===========");
        System.out.println(product.toString());
        System.out.println("===========");
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
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
