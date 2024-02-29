package me.project.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(unique = true)
    private String productName;

    private Double price;

    private String colour;

    private String dimension;

    private String manufacturer;
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    @ManyToOne
    private Order myOrder;



}
