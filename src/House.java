import java.util.HashMap;

public class House {

	public static void main(String[] args) {
		Room foyer = new Room("foyer");
		Room frontRoom = new Room("frontRoom");
		Room library = new Room("library");
		Room kitchen = new Room("kitchen");
		Room diningRoom = new Room("diningRoom");
		Room vault = new Room("vault");
		Room parlor = new Room("parlor");
		HashMap <String,Room> directions= new HashMap<String,Room>();
		
		//Create room foyer
		directions.put("east", null);
		directions.put("south", foyer);
		directions.put("west", library);
		directions.put("North",frontRoom);
		foyer.setDescription("");
		foyer.setExists(directions);
		foyer.setHiddenDetails("");
		
		//create room frontroom
		directions.put("east", null);
		directions.put("south", foyer);
		directions.put("west", library);
		directions.put("east", kitchen);
		frontRoom.setExists(directions);
		frontRoom.setDescription("");
		frontRoom.setHiddenDetails("");
		
		//create room Library
		directions.put("east", null);
		directions.put("south", foyer);
		directions.put("west", library);
		directions.put("east", kitchen);
		library.setExists(directions);
		library.setDescription("");
		library.setHiddenDetails("");
		
		//Create room kitchen
		directions.put("east", null);
		directions.put("south", foyer);
		directions.put("west", library);
		directions.put("east", kitchen);
		kitchen.setExists(directions);
		kitchen.setDescription("");
		kitchen.setHiddenDetails("");
		
		//Create room dining
		
		directions.put("north", null);
		directions.put("south", foyer);
		directions.put("west", library);
		directions.put("east", kitchen);
		diningRoom.setExists(directions);
		diningRoom.setDescription("");
		diningRoom.setHiddenDetails("");
		
		//Create vault
		
		directions.put("north", null);
		directions.put("south", foyer);
		directions.put("west", library);
		directions.put("east", kitchen);
		vault.setExists(directions);
		vault.setDescription("");
		vault.setHiddenDetails("");
		
		//create parlor
		
		directions.put("north", null);
		directions.put("south", foyer);
		directions.put("west", library);
		directions.put("east", kitchen);
		parlor.setExists(directions);
		parlor.setDescription("");
		parlor.setHiddenDetails("");
		
		
		
	}

}
