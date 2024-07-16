package com.bartekm.targetapp.product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product findProductById(int id);

    Product findProductByName(String name);

    List<Product> findProductsByExpirationDate(String expirationDate);

    List<Product> findProductsByDeliveryDate(String deliveryDate);

    Product updateProduct(Product product);

    Boolean deleteById(int id);


}
