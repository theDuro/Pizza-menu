package com.javatechie.redis.contlorel;

import com.javatechie.redis.entity.Product;
import com.javatechie.redis.model.Bill;
import com.javatechie.redis.respository.ProductDao;
import com.javatechie.redis.services.PizzaMenuImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/product")
public class Contlorel {
    private final PizzaMenuImp pizzaMenuImp;
    @Autowired
    public Contlorel(PizzaMenuImp pizzaMenuImp) {
        this.pizzaMenuImp = pizzaMenuImp;
    }

    @Autowired
    private ProductDao dao;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return pizzaMenuImp.addProduck(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return pizzaMenuImp.getMenu();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id) {
        return pizzaMenuImp.getProductByID(id);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable int id)   {
         pizzaMenuImp.delteProductById(id);

    }
    @GetMapping("/getBill")
    public Bill getBill(List<Integer> inxedList,int id){
        return pizzaMenuImp.getBillFronIndexList(inxedList,id);
    }
    @GetMapping("/bill")
    public Bill bill(){
        return pizzaMenuImp.getBillFronIndexList(Arrays.asList(1, 2, 3),1);
    }


}
