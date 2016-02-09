package run;

public class Room {
	private String roomDescription;



	Room (String desc){
		roomDescription=desc;
	}

	Room() {
		roomDescription = "DankRoom";
		
	}
	

	public String getRoomDescription() {
		return roomDescription;
	}


	
}
