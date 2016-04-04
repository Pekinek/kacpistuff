package loggers;

import data.Customer;

public class Logger {
    public static void accepted(Customer c, int size) {
        String message = String.format("%-20s - ACCEPTED. Customers in the room: %d", c, size);
        System.out.println(message);
    }

    public static void denied(Customer c, int size) {
        String message = String.format("%-20s - DENIED. Customers in the room: %d", c, size);
        System.out.println(message);
    }

    public static void left(Customer c, int size) {
        String message = String.format("%-20s - LEFT. Customers in the room: %d", c, size);
        System.out.println(message);
    }
}
