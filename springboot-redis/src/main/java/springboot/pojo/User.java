package springboot.pojo;

import java.io.Serializable;

/**
 * 用户实体类
 * 注意：要缓存的Java对象必须实现 Serializable 接口,因为Spring会将对象先序列化再存入Redis
 */
public class User implements Serializable {

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户年龄
     */
    private int age;

    /**
     * 用户描述
     */
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
