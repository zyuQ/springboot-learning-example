package springboot.pojo;

/**
 * 用户实体类
 */
public class User {

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
