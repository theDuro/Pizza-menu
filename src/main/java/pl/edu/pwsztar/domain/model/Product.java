package pl.edu.pwsztar.domain.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Product")
public class Product implements Serializable {
    @Id
    int id;
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
