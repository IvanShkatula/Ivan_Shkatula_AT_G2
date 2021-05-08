package project.day20.homework.objects;

public class UsersList {

    public String code;
    public Users[] data;

    public UsersList(String code, Users[] usersList) {
        this.code = code;
        this.data = usersList;
    }
}
