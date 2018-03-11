package stream.api;

/**
 * @Author jbzm
 * @Date Create on 2018/3/12 1:06
 */
public class Persion {
    private String username;

    public static Persion build(String username) {
        Persion p = new Persion();
        p.username = username;
        return p;
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

