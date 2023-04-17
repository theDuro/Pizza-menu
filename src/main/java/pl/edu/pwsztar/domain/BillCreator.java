package pl.edu.pwsztar.domain;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.model.BillDto;
import pl.edu.pwsztar.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;
@Component
public class BillCreator {
   private Gson gson = new Gson();
    public BillDto listOfProtuctsToBill(List<Product> productList,long customerId){
        BillDto billDto = new BillDto();
        billDto.setCost(getSumCostOfProducts(productList));
        billDto.setProduckts(listOfProductToJson(productList));
        billDto.setCustomerId(customerId);
        return  billDto;
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
