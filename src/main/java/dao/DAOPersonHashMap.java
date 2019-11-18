package dao;

import java.util.*;

public class DAOPersonHashMap implements DAO<Person> {

    // for HashMap implementation
    private Map<Integer, Person> storage = new HashMap<>();
    // for ArrayList implementation
//  private List<Person> storage2 = new ArrayList<>();

    @Override
    public void put(Person object) {
        storage.put(object.getId(), object);
    }

    @Override
    public Person get(int id) {
        return storage.get(id);
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    @Override
    public List<Person> getAll() {
        return (ArrayList)storage.values();
    }
}
