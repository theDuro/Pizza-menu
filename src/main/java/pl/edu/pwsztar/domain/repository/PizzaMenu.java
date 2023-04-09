package pl.edu.pwsztar.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import pl.edu.pwsztar.domain.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class PizzaMenu {
    public static final String MENU_KEY = "menu";
    private  final RedisTemplate template;
    @Autowired
    PizzaMenu(RedisTemplate template){
        this.template = template;
    }
    public void save(Product product){
        template.opsForList().rightPush(MENU_KEY,product);
    }
    public List<Product> getAll(){
        return template.opsForList().range(MENU_KEY,1,-1);
    }
    public Product getByIndex(Long index){
        return (Product) template.opsForList().index(MENU_KEY,index);
    }

    public void delete(long index){
        //todo delte by index
    }

    public List<Product> getListOfProducktsByIndexList(List<Long> indexList){
        return indexList.stream()
                .map(this::getByIndex)
                .collect(Collectors.toList());
    }



}
