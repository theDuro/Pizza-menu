package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.BillCreator;
import pl.edu.pwsztar.domain.model.BillDto;
import pl.edu.pwsztar.domain.model.Product;
import pl.edu.pwsztar.domain.repository.PizzaMenuRepository;
import pl.edu.pwsztar.service.PizzaMenu;

import java.util.List;

@Service
public class PizzaMenuImp implements PizzaMenu {
    private final PizzaMenuRepository pizzaMenuRepository;
    private final BillCreator billCreator;
    @Autowired
    public PizzaMenuImp(PizzaMenuRepository pizzaMenuRepository, BillCreator billCreator) {
        this.pizzaMenuRepository = pizzaMenuRepository;
        this.billCreator = billCreator;
    }
    @Override
    public List<Product> getMenu() {
        return pizzaMenuRepository.getAll();
    }
    @Override
    public BillDto getBillFronIndexList(List<Long> listOfIndexes, long id) {
        return billCreator.listOfProtuctsToBill(
                pizzaMenuRepository.getListOfProducktsByIndexList(listOfIndexes),id
        );
    }
    @Override
    public void addProduck(Product product) {
        pizzaMenuRepository.save(product);
    }
    @Override
    public void delteProductById(long id) {
        pizzaMenuRepository.delete(id);
    }


}
