package pl.edu.pwsztar.domain.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import pl.edu.pwsztar.domain.model.Product;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Repository
public class PizzaMenuRepository implements Serializable {
    public static final String MENU_KEY = "Products";
    private  final RedisTemplate template;
    @Autowired
    PizzaMenuRepository(RedisTemplate template){
        this.template = template;
    }
    public void save(Product product){
        template.opsForList().rightPush(MENU_KEY,product);
    }
    public List<Product> getAll(){
        return template.opsForList().range(MENU_KEY,1,-1);
    }
    public Product getByIndex(Long index)  {


        Object test = template.opsForList().index(MENU_KEY,index);

        Object obj = template.opsForList().index(MENU_KEY, index);
        if (obj instanceof Product) {
            return (Product) obj;
        }
        return null;
    }
    public void delete(long index){
       Object obj = template.opsForHash().keys(MENU_KEY);
       template.opsForList().remove(MENU_KEY,1,getByIndex(index));
    }
    public List<Product> getListOfProducktsByIndexList(List<Long> indexList){
        return indexList.stream()
                .map(this::getByIndex)
                .collect(Collectors.toList());
    }
}
