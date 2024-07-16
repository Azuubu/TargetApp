package com.bartekm.targetapp.category;

import com.bartekm.targetapp.product.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Category {

    @Id
    @GeneratedValue()
    private int id;

    @Column(
            columnDefinition = "TEXT",
            unique = true
    )
    private String name;


//    @OneToMany(mappedBy = "category")
//    @JsonManagedReference
//    private List<Product> products;


    // add a @updatable = false to scannedDate -> this makes it so that if we have a date in this specific column, it only changes once, at creation time, and
    // then when we update the data in the row, this exact scannedDate wont change

    // ! also can add insertable = false to some other columns (it works so that it is null at the beginning, unless changed at least once)

    // Cascade.sth is good when we want to dynamically create an entity which is related to another entity, ex: a person has an address
    // but when we want to have a static list of entities, it doesnt rly work well, ex: a product has a strictly set list of available categories
    // 1h 30 minutes into the tutorial

//    @JsonCreator
//    public Category(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("products") List<Product> products) {
//        this.id = id;
//        this.name = name;
//        this.products = products;
//    }



}
