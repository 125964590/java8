package stream.api;

/**
 * @Author jbzm
 * @Date Create on 2018/3/12 1:06
 */
public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

