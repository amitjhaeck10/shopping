package com.onlineshopping.shopping.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "name",length = 255,nullable = false)
    @Basic(optional = false)
    @Getter
    @Setter
    private String name;

    @Column(name = "price",nullable = false)
    @Getter
    @Setter
    private Double price;

    public Product(Long id,String name,Double price){
       this.id=id;
       this.name=name;
       this.price=price;
    }

    public Product(){
    }
}
