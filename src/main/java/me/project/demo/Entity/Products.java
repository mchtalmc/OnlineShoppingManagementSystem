package me.project.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
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
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "adress_id")
    private Adress adress;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
