package pl.edu.pwsztar.domain.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Products")
public class Product implements Serializable {
    private String name;
    private String ingredients;
    private BigDecimal cost;
    private boolean isProduckOnlyForAdults;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", cost=" + cost +
                ", isProductOnlyForAdults=" + isProduckOnlyForAdults +
                '}';
    }
}
