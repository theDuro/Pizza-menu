package com.javatechie.redis.services;



import com.javatechie.redis.entity.Product;
import com.javatechie.redis.model.Bill;

import java.util.List;

public interface PizzaMenu {

    public List<Product> getMenu();
    public Bill getBillFronIndexList(List<Integer> listOfIndexes, long id);
    public Product addProduck(Product product);
    public void delteProductById(int id);
    public Product getProductByID(int id);


}
