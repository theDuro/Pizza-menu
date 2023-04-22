package com.javatechie.redis;

import com.google.gson.Gson;
import com.javatechie.redis.entity.Product;
import com.javatechie.redis.model.Bill;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class BillCreator {
   private Gson gson = new Gson();
    public Bill listOfProtuctsToBill(List<Product> productList, long customerId){
        Bill bill = new Bill();
        bill.setCost(getSumCostOfProducts(productList));
        bill.setProduckts(listOfProductToJson(productList));
        bill.setCustomerId(customerId);
        return  bill;
    }

    private BigDecimal getSumCostOfProducts(List<Product> productList){
        return productList
                .stream()
                .map(Product::getCost)
                .reduce(BigDecimal.ZERO,BigDecimal::add);

    }
    private String listOfProductToJson(List<Product> productList){
        return gson.toJson(productList);
    }
}
