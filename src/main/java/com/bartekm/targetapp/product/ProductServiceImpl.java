package com.bartekm.targetapp.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // POST ==========================================================================
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // GET ==========================================================================
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findProductsByExpirationDate(String expirationDate) {
        return productRepository.findByExpirationDate(expirationDate);
    }

    @Override
    public List<Product> findProductsByDeliveryDate(String deliveryDate) {
        return productRepository.findByDeliveryDate(deliveryDate);
    }

//    @Override
//    public List<Product> findProductsByAuthorId(int authorId) {
//        return productRepository.findByAuthorId(authorId);
//    }

    // PUT =============================================================================
    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // DELETE ========================================================================
    @Override
    public Boolean deleteById(int id) {
        productRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
