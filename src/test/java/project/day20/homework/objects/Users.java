package project.day20.homework.objects;

public class Users {

    int id;
    public String username;
    public String realname;
    public String password;
    public String email;

    public Users(int id, String username, String realname, String password, String email) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "[{" +
                "id=" + id +
                ", username=" + username +
                ", realname=" + realname +
                ", password=" + password +
                ", email=" + email  +
                "}]";
    }
}