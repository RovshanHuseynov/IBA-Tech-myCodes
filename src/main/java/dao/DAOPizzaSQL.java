package dao;

import java.util.ArrayList;
import java.util.List;

public class DAOPizzaSQL implements DAO<Pizza> {

    ArrayList<Pizza> al = new ArrayList<Pizza>();

    @Override
    public void put(Pizza object) {
        al.add(object);
    }

    @Override
    public Pizza get(int id) {
        return al.get(id);
    }

    @Override
    public void delete(int id) {
        al.remove(id);
    }

    @Override
    public List<Pizza> getAll() {
        return (List) al;
    }
}
