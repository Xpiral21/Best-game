package run;

public abstract class Room {

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

    public abstract boolean roomIsClear(Monster m);
    public abstract Monster getMonster();

}
