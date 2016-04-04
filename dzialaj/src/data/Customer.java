package data;

public class Customer {
    private final int id;

    public Customer(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Customer with id: %s", id);
    }
}
