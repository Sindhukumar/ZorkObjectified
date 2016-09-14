
public class Item {
	private String name;
	private String Description;
	private Room inRoom;
	private boolean isHidden=false;

	Item(String name, String Description, Room inRoom, Boolean isHidden) {
		this.name = name;
		this.Description = Description;
		this.inRoom = inRoom;
		this.isHidden = isHidden;

	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Room getInRoom() {
		return inRoom;
	}

	public void setInRoom(Room inRoom) {
		this.inRoom = inRoom;
	}
	
	@Override
	public String toString (){
		return name;
	}
}
