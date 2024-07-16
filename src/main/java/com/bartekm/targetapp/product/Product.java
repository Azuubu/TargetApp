package com.bartekm.targetapp.product;

import com.bartekm.targetapp.category.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String optionalInfo;

//    @Column(
//        columnDefinition = "TEXT"
//    )
    @ManyToOne
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_name")
    )
//    @Cascade(CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(
            columnDefinition = "DATE"
    )
    private String expirationDate;

    @Column(
            columnDefinition = "DATE"
    )
    private String deliveryDate;


    @JsonProperty("category")
    public void deserializeCategory(String category) {
        Category categoryObj = new Category();
        categoryObj.setName(category);
        this.category = categoryObj;
    }


//    @Column(
//            unique = true
//    )
//     private String imagePath;
    // have to look into it a bit more, maybe try []bytes (array) or sth to store just the url to the image in the db




}
