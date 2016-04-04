package rooms;

import data.Customer;
import exceptions.RoomIsEmptyException;
import exceptions.RoomIsFullException;
import loggers.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {

    private final int capacity;
    private final List<Customer> customers;
    private final Random random;

    public Room(int capacity) {
        this.capacity = capacity;
        customers = new ArrayList<>();
        random = new Random();
    }

    public synchronized Customer getRandomCustomer() {
        if (customers.isEmpty())
            throw new RoomIsEmptyException();
        Customer c = customers.get((random).nextInt(customers.size()));
        customers.remove(c);
        Logger.left(c, customers.size());
        return c;
    }

    public synchronized void tryToAddCustomer(Customer customer) {
        if (isEnoughRoom()) {
            letCustomerIn(customer);
        } else {
            doNotLetCustomerIn(customer);
        }
    }

    private boolean isEnoughRoom() {
        return customers.size() < capacity;
    }

    private void letCustomerIn(Customer customer) {
        customers.add(customer);
        Logger.accepted(customer, customers.size());
    }

    private void doNotLetCustomerIn(Customer customer) {
        Logger.denied(customer, customers.size());
        throw new RoomIsFullException();
    }
}
