package ssfassessment.cryptocompare.services;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import jakarta.json.JsonObject;
import ssfassessment.cryptocompare.models.artObj;

//https://docs.spring.io/spring-data/redis/docs/current/api/org/springframework/data/redis/core/RedisTemplate.html

@Service
public class redisService implements bgRepo {
    
    ArrayList<Integer> keys;

    //To save and retrieve normal HashMap, String etc form Redis
    // @Autowired
    // RedisTemplate<String, Object> redisTemplate;

    //To save and retrieve POJO from Redis
    @Autowired
    RedisTemplate<String, artObj> redisTemplate;

    //POST
    @Override
    public void save(String cameraData) {
        int max = 0;
        this.keys = getKeys();
        for (Integer key : keys) {
            if (key > max)
                max = key;
        }
        max += 1; //When saving a new entry, the latest entry is max key + 1. Eg latest is 5, next is 5 + 1 = 6
        String id = max + ""; //Change from int to String
        // redisTemplate.opsForValue().set(id, cameraData);

    }

    @Override
    public void deleteAll() {
        this.keys = getKeys();
        for (Integer key : keys) {
            redisTemplate.delete(key + ""); //Deleting key. Casting from integer to String (Since Redis keys are String)
        }
    }

    //Helper class to get all keys from database
    public ArrayList<Integer> getKeys() {
        Set<String> redisKeys = redisTemplate.keys("*"); //Pattern is * for ALL keys. Getting all keys.
        ArrayList<Integer> keys = new ArrayList<>();
        for (String item : redisKeys) {
            keys.add(Integer.parseInt(item));
        }
        return keys;
    }

    @Override
    public void saveCurrObj(artObj currconverter, int value) {
        redisTemplate.opsForValue().set(value + "", currconverter);
        
    }

    @Override
    public artObj getCurrObj(String id) {
        artObj obj = (artObj)redisTemplate.opsForValue().get(id);
        return obj;
    }


}