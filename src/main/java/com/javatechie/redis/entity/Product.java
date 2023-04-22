package com.javatechie.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("ProductMenu")
public class Product implements Serializable {
    @Id
    private int id;
    private String name;
    private String ingredients;
    private BigDecimal cost;
    private boolean isProduckOnlyForAdults;

    @Override
    public String toString() {
        return "Product{" +
                ", id=" + id +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", cost=" + cost +
                ", isProductOnlyForAdults=" + isProduckOnlyForAdults +
                '}';
    }

}
