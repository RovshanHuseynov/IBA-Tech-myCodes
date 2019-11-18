package dao;

import java.util.ArrayList;
import java.util.List;

public class DAOPersonSQL implements DAO<Person> {

    ArrayList<Person> al = new ArrayList<Person>();

    @Override
    public void put(Person object) {
        al.add(object);
    }

    @Override
    public Person get(int id) {
        return al.get(id);
    }

    @Override
    public void delete(int id) {
        al.remove(id);
    }

    @Override
    public List<Person> getAll() {
        return (List) al;
    }
}
