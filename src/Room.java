import java.util.ArrayList;
import java.util.HashMap;

public class Room {
	private HashMap<String, Room> exit;
	private String name;
	private String description;
	private String hiddenDetails;
	private boolean hasLamp;
	private ArrayList<Item> items = new ArrayList<Item>();

	Room(String name, String description, String hiddenDetails) {
		this.name = name;
		this.description=description;
		this.hiddenDetails=hiddenDetails;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item){
		items.add(item);
	}

	public void setExit(HashMap<String, Room> exit) {
		this.exit = exit;
	}

	public HashMap<String, Room> getExit() {
		return exit;
	}

	public void setExists(HashMap<String, Room> exits) {
		this.exit = exits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHiddenDetails() {
		return hiddenDetails;
	}

	public void setHiddenDetails(String hiddenDetails) {
		this.hiddenDetails = hiddenDetails;
	}

	public boolean isHasLamp() {
		return hasLamp;
	}

	public void setHasLamp(boolean hasLamp) {
		this.hasLamp = hasLamp;
	}

}
