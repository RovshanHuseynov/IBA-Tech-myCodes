package dao;

public class Pizza {
  private final int id;
  private final int size;
  private final int price;

  public Pizza(int id, int size, int price) {
    this.id = id;
    this.size = size;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public int getSize() {
    return size;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pizza)) return false;

    Pizza pizza = (Pizza) o;

    if (id != pizza.id) return false;
    if (size != pizza.size) return false;
    return price == pizza.price;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + size;
    result = 31 * result + price;
    return result;
  }

  @Override
  public String toString() {
    return "Pizza{" +
        "id=" + id +
        ", size=" + size +
        ", price=" + price +
        '}';
  }
}
