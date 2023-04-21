package pl.edu.pwsztar.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class CartRepository {
    public static final String HASH_KEY = "Cart";
    @Autowired
    private RedisTemplate template;

}
