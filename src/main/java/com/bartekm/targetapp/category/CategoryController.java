package com.bartekm.targetapp.category;

import com.bartekm.targetapp.product.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@CrossOrigin
@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id")int id) {
        return ResponseEntity.ok(categoryService.findCategoryById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable("name")String name) {
        return ResponseEntity.ok(categoryService.findCategoryByName(name));
    }

    @PostMapping()
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
//        category.setId(categoryService.getAllCategories().size() + 1);
        return ResponseEntity.created(getLocation(category.getId())).body(categoryService.addCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id")int id) {
        return ResponseEntity.ok(categoryService.deleteById(id));
    }

    @PutMapping()
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }

    private URI getLocation(int id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }


}
