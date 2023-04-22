package com.javatechie.redis.services;

import com.javatechie.redis.BillCreator;
import com.javatechie.redis.entity.Product;
import com.javatechie.redis.model.Bill;
import com.javatechie.redis.respository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaMenuImp implements  PizzaMenu {
    private final BillCreator billCreator;
    private final ProductDao productDao;
    @Autowired
    public PizzaMenuImp(BillCreator billCreator, ProductDao productDao) {
        this.billCreator = billCreator;
        this.productDao = productDao;
    }

    @Override
    public List<Product> getMenu() {
        return productDao.findAll();
    }

    @Override
    public Bill getBillFronIndexList(List<Integer> listOfIndexes, long id) {
        return billCreator.listOfProtuctsToBill(productDao.getProductsById(listOfIndexes),id);
    }

    @Override
    public Product addProduck(Product product) {
        productDao.save(product);
        return product;
    }


    @Override
    public Product getProductByID(int id) {
        return productDao.findProductById(id);
    }

    @Override
    public void delteProductById(int id) {
        productDao.deleteProduct( id);

    }
}
