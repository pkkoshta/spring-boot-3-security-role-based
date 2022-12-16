package com.prashant.entity;

import com.prashant.enums.Categorys;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;




@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pid;
    private String name;
    private String desc;
    private String imageUrl;
    private Categorys categorys;

    public Products(){}
}
