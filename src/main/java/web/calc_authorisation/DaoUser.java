package web.calc_authorisation;

import java.util.ArrayList;
import java.util.List;

public class DaoUser {
    private List<User> users = new ArrayList<>();

    public DaoUser() {
        User user1 = new User(1, "user", "123");
        User user2 = new User(2, "admin", "123");
        User user3 = new User(3, "manager", "123");
        User user4 = new User(4, "local", "123");
        this.users.add(user1);
        this.users.add(user2);
        this.users.add(user3);
        this.users.add(user4);
    }

    public List<User> getAll() {
        return users;
    }

    public User get(int index) {
        return users.get(index);
    }

    public void remove(int index) {
        users.remove(index);
    }

    public void add(User user) {
        users.add(user);
    }

    public boolean contains(User user) {
        for (User item : users) {
            if (item.equals(user)) return true;
        }
        return false;
    }
}
