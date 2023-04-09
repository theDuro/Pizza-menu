package pl.edu.pwsztar.domain.mapper;

import com.google.gson.Gson;
import pl.edu.pwsztar.domain.model.BillDto;
import pl.edu.pwsztar.domain.model.Product;

import java.util.List;

public class BillCreator {
   private Gson gson = new Gson();
    public BillDto listOfProtuctsToBill(List<Product> productList,long customerId){
        BillDto billDto = new BillDto();
        billDto.setCost(getSumCostOfProducts(productList));
        billDto.setProduckts(listOfProductToJson(productList));
        billDto.setCustomerId(customerId);
        return  billDto;
    }

    private Double getSumCostOfProducts(List<Product> productList){
        return productList
                .stream()
                .mapToDouble(Product::getCost)
                .reduce(0.0,Double::sum);

    }
    private String listOfProductToJson(List<Product> productList){
        return gson.toJson(productList);
    }
}
