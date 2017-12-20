package cn.com.entity;

/**
 * ${DESCRIPTION}
 *
 * @author lightTrace
 * @create 2017-10-28 11:15
 **/
public class User {
    private Integer id;
    private String userName;
    private String password;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
