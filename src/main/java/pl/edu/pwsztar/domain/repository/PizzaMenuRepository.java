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
    public static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate template;

    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id){
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }

    public  List<Product> getProductListByListOfIndex(List<Integer> indexList){
        return template.opsForHash().multiGet(HASH_KEY,indexList);

       //  return indexList.stream()
       //          .map(this::findProductById)
        //         .collect(Collectors.toList());
    }


    public String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }
}
