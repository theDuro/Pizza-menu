package com.javatechie.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {
    private long customerId;
    private String produckts;
    private BigDecimal cost;
}
