package com.bartekm.targetapp.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findByExpirationDate(String expirationDate);

    public List<Product> findByDeliveryDate(String deliveryDate);

    public List<Product> findByAuthorId(int authorId);


}
