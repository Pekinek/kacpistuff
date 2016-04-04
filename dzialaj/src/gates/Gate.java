package gates;

import rooms.Room;
import rooms.WaitingRoom;

public abstract class Gate implements Runnable {

    protected Room room;
    protected WaitingRoom waitingRoom;

    Gate(Room room, WaitingRoom waitingRoom) {
        this.room = room;
        this.waitingRoom = waitingRoom;
    }

    protected void stopThreadFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
