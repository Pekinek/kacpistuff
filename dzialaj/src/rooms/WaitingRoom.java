package rooms;

import data.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaitingRoom {
    private final List<Customer> customers;
    private final Random random;

    public WaitingRoom(int customersAmount) {
        customers = new ArrayList<>();
        createCustomers(customersAmount);
        random = new Random();
    }

    private void createCustomers(int customersAmount) {
        for (int i = 0; i <= customersAmount; i++) {
            addCustomer(new Customer(i));
        }
    }

    public synchronized Customer getRandomCustomer() {
        Customer c = customers.get(random.nextInt(customers.size()));
        customers.remove(c);
        return c;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
