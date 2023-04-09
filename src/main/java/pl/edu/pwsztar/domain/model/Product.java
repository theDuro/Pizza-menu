package pl.edu.pwsztar.domain.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private String name;
    private String ingredients;
    private double cost;
    private boolean produckOnlyForAdults;
}
