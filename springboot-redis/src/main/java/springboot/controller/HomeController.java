package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.pojo.User;

/**
 * @Description:
 * @Author: zyu
 */
@RestController
@RequestMapping("/user")
public class HomeController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/save")
    public String saveUser(User user) {
        String key = "User_" + user.getId();
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set(key, user);
        return "Success";
    }

    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        String key = "User_" + id;
        ValueOperations operations = redisTemplate.opsForValue();
        User user = (User) operations.get(key);
        return user;
    }


}
