package web.calc_authorisation;

public class User {
    int id;
    String name;
    String password;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(!(o instanceof User)) return false;
        if (this == o) return true;


        User that = (User) o;
        return this.id == that.id &&
                this.password.equals(that.password) &&
                this.name.equals(that.name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
