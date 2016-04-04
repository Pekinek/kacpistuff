package gates;

import exceptions.RoomIsEmptyException;
import rooms.Room;
import rooms.WaitingRoom;

public class ExitGate extends Gate {

    Thread thread;

    public ExitGate(Room room, WaitingRoom waitingRoom) {
        super(room, waitingRoom);
    }

    @Override
    public void run() {
        while (true) {
            stopThreadFor(5 * 1000);
            try {
                waitingRoom.addCustomer(room.getRandomCustomer());
            } catch (RoomIsEmptyException e) {
                //nothing to do
            }
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, "ExitGate");
            thread.start();
            System.out.println("ExitGate started.");
        }
    }


}
