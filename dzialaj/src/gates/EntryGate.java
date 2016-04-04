package gates;

import data.Customer;
import exceptions.RoomIsFullException;
import rooms.Room;
import rooms.WaitingRoom;

public class EntryGate extends Gate {

    Thread thread;

    public EntryGate(Room room, WaitingRoom waitingRoom) {
        super(room, waitingRoom);
    }

    @Override
    public void run() {
        while (true) {
            stopThreadFor(1 * 1000);
            Customer customer = waitingRoom.getRandomCustomer();
            try {
                room.tryToAddCustomer(customer);
            } catch (RoomIsFullException e) {
                waitingRoom.addCustomer(customer);
            }
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, "EntryGate");
            thread.start();
            System.out.println("EntryGate started.");
        }
    }
}
