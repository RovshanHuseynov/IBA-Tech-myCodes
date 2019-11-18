package dao;

import java.util.List;

public interface DAO<T> {
  void put(T object);
  T get(int id);
  void delete(int id);
  List<T> getAll();
}
