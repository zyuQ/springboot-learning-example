package springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import springboot.pojo.User;

import java.util.List;

/**
 * @Description:
 * @Author: zyu
 */
@Component
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param user
     */
    public User saveUser(User user) {
        User save = mongoTemplate.save(user);
        return save;
    }


    /**
     * 更新对象
     * @param user
     */
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName", user.getUserName()).set("age", user.getAge()).set("desc", user.getDesc());
        mongoTemplate.updateFirst(query, update, User.class);
    }


    /**
     * 根据用户名查询对象
     * @param name
     * @return
     */
    public User findUserByName(String name) {
        Query query = new Query(Criteria.where("userName").is(name));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }


    /**
     * 查询所有对象
     * @return
     */
    public List<User> findUserList() {
        List<User> all = mongoTemplate.findAll(User.class);
        return all;
    }


    /**
     * 删除对象
     * @param id
     */
    public void deleteUserById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }

}
