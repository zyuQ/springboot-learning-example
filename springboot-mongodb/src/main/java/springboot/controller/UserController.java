package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.dao.UserDao;
import springboot.pojo.User;

import java.util.List;

/**
 * @Description:
 * @Author: zyu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/findList")
    public List<User> findUserList() {
        List<User> userList = userDao.findUserList();
        return userList;
    }


    @GetMapping("/findByName")
    public User findUserByName(@RequestParam String name) {
        User userByName = userDao.findUserByName(name);
        return userByName;
    }


    @GetMapping("/save")
    public User saveUser(@RequestParam long id,@RequestParam String name, @RequestParam Integer age, @RequestParam String desc) {
        User user = new User();
        user.setUserName(name);
        user.setAge(age);
        user.setDesc(desc);
        user.setId(id);
        return userDao.saveUser(user);
    }


    @GetMapping("/update")
    public String updateUser(@RequestParam long id, @RequestParam String name, @RequestParam Integer age, @RequestParam String desc) {
        User user = new User();
        user.setUserName(name);
        user.setDesc(desc);
        user.setAge(age);
        user.setId(id);
        userDao.updateUser(user);
        return "Success";
    }

}
