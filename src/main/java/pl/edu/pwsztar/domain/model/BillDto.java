package pl.edu.pwsztar.domain.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto implements Serializable {
    private long customerId;
    private String produckts;
    private BigDecimal cost;
}
