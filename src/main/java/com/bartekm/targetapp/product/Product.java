package com.bartekm.targetapp.product;

import com.bartekm.targetapp.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String optionalInfo;

    @Column(
            columnDefinition = "DATE"
    )
    private String expirationDate;

    @Column(
            columnDefinition = "DATE"
    )
    private String deliveryDate;

    private int authorId;

    // private int postAuthorId; it will be used in a separate table to keep track of the products and corresponding users

    // private Image image;
    // have to look into it a bit more, maybe try []bytes (array) or sth to store just the url to the image in the db




}
