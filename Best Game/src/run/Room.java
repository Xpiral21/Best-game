package run;

public class Room {

    private String roomDescription;

    Room(String desc) {
        roomDescription = desc;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public boolean roomIsClear(Monster m) {
        if (m.isAlive()) {
            return true;
        }
        return false;
    }

    public Monster getMonster() {
        return null;
    }

}
