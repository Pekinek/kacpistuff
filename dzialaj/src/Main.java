import gates.EntryGate;
import gates.ExitGate;
import rooms.Room;
import rooms.WaitingRoom;

public class Main {

    public static void main(String[] args) {
        Room room = new Room(15);
        WaitingRoom waitingRoom = new WaitingRoom(20);
        for (int i = 0; i < 2; i++) {
            new EntryGate(room, waitingRoom).start();
            new ExitGate(room, waitingRoom).start();

        }
    }
}
