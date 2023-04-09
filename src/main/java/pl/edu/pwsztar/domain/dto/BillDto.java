package pl.edu.pwsztar.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {
    private long userId;
    private String customerName;
    private String produckts;
    private double cost;

}
