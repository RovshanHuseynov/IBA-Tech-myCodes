package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOPizzaHashMap implements DAO<Pizza> {

    private Map<Integer, Pizza> storage = new HashMap<>();

    @Override
    public void put(Pizza object) {
        storage.put(object.getId(), object);
    }

    @Override
    public Pizza get(int id) {
        return storage.get(id);
    }

    @Override
    public void delete(int id) {
        storage.remove(storage.get(id));
    }

    @Override
    public List<Pizza> getAll() {
        return (List) storage.values();
    }
}
