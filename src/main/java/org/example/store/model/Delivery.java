package org.example.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Provider provider;
    //    объем
    @Column(name = "volume")
    private double volume;
    @Column(name = "price")
    private double price;
    @Column(name = "date")
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Store store;
    @Column(name = "number")
    private String number;
    @PrePersist
    private void init(){
        date = LocalDateTime.now();
    }
}
