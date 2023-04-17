package pl.edu.pwsztar.service;

import pl.edu.pwsztar.domain.model.BillDto;
import pl.edu.pwsztar.domain.model.Product;

import java.util.List;
import java.util.Map;

public interface PizzaMenu {
    public List<Product> getMenu();
    public BillDto getBillFronIndexList(List<Long> listOfIndexes,long id);
    public void addProduck(Product product);
    public void delteProductById(long id);


}
