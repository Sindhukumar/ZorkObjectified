import java.util.HashMap;
import java.util.Scanner;

public class House {
	static Room foyer = new Room("foyer");
	static Room frontRoom = new Room("frontRoom");
	static Room library = new Room("library");
	static Room kitchen = new Room("kitchen");
	static Room diningRoom = new Room("diningRoom");
	static Room vault = new Room("vault");
	static Room parlor = new Room("parlor");
	static Room secretRoom = new Room("secretRoom");
	static Room current;
	static HashMap<String, Room> directions = new HashMap<String, Room>();

	public static void main(String[] args) {

		// Create room foyer
		directions.put("east", null);
		directions.put("south", null);
		directions.put("west", null);
		directions.put("North", frontRoom);
		foyer.setDescription(
				"You are in the Foyer, There is dead Scorpio. \n exit to the FrontRoom in the North by typing \'N\' or  to quit type \"Quit\" or \'Q\' \n ");
		foyer.setExists(directions);
		foyer.setHiddenDetails("");
		foyer.setThings("");
		foyer.setHasThings(false);

		// create room frontroom
		directions.put("east", kitchen);
		directions.put("south", foyer);
		directions.put("west", library);
		directions.put("north", null);
		frontRoom.setExists(directions);
		frontRoom.setDescription("You are in the Front Room, You see a Piano.");
		frontRoom.setHiddenDetails("There is Piano, Play your fav Song.");
		frontRoom.setThings("");
		frontRoom.setHasThings(false);

		// create room Library
		directions.put("east", frontRoom);
		directions.put("south", null);
		directions.put("west", null);
		directions.put("north", diningRoom);
		library.setExists(directions);
		library.setDescription("You are in the Library, You see Spiders.");
		library.setHiddenDetails(
				"You can Scroll on the wall with a secret message to get $10,000 more, type your message");
		library.setThings("");
		library.setHasThings(false);

		// Create room kitchen
		directions.put("east", null);
		directions.put("south", null);
		directions.put("west", frontRoom);
		directions.put("north", parlor);
		kitchen.setExists(directions);
		kitchen.setDescription("You are in the Kitchen,You see bats.");
		kitchen.setHiddenDetails(
				"A refrigerator full of your favorite food/drink, you can have some if they type drink \"coke\" or \"cake\" or whatever.");
		kitchen.setThings("");
		kitchen.setHasThings(false);

		// Create room dining

		directions.put("north", null);
		directions.put("south", library);
		directions.put("west", null);
		directions.put("east", null);
		diningRoom.setExists(directions);
		diningRoom.setDescription("You are in the Dining Room,You see an empty box.");
		diningRoom.setHiddenDetails(
				"The box is not actually empty, it contains an Amazon gift card which you can take if you type \"Get Gift Card\"");
		diningRoom.setThings("");
		diningRoom.setHasThings(false);

		// Create vault

		directions.put("north", null);
		directions.put("south", null);
		directions.put("west", null);
		directions.put("east", parlor);// parlor and secretRoom(25%)
		vault.setExists(directions);
		vault.setDescription("You are in the Vault, You see 3 walking Skeltons");
		vault.setHiddenDetails(
				"You can choose to:\n Type \"Parlor\" or 'N' to enter Parlor in the North \n Type \"SecretRoom\" or 'E' to enter Secret Room in the East");
		vault.setThings("");
		vault.setHasThings(false);

		// create parlor

		directions.put("north", null);
		directions.put("south", kitchen);
		directions.put("west", vault);
		directions.put("east", null);
		parlor.setExists(directions);
		parlor.setDescription("You are in Parlor, You see treasure Chest");
		parlor.setHiddenDetails(
				"There is a portrait of your favorite movie star and tickets to their latest movie which you can take in case you ever get out of the house, type \"Movie\" to get them");
		parlor.setThings("");
		parlor.setHasThings(false);

		// create secret room

		directions.put("north", null);
		directions.put("south", null);
		directions.put("west", vault);
		directions.put("east", null);
		secretRoom.setExists(directions);
		secretRoom.setDescription("You are in Secret Room");
		secretRoom.setHiddenDetails(
				"You see a map of the house along with the piles of gold. you may can take the map or gold or both.Type \"Map\"");
		secretRoom.setThings("");
		secretRoom.setHasThings(false);

		System.out.println("Welcome ");
		System.out.println("Action words are Go, Use, Quit ");
		current = foyer;
		Scanner sc = new Scanner(System.in);
		String option;
		do {

			current.getDescription();
			// money();
			// if (lamp) current.getHiddenDetails();
			// System.out.println("Action words are Go, Use, Quit ");
			String o = sc.next();
			if (o.equalsIgnoreCase("Go")) {
				System.out.println("Where do you want to go ");
				option = sc.next();
				current = current.getExit().get(option);
				while (current == null) {
					System.out.println("You cannot go that way Please enter another direction");
					option = sc.next();
				}
				current = current.getExit().get(option);
			}
			if (o.equalsIgnoreCase("Use")) {
				System.out.println("What do you want to use ");
				option = sc.next();

			}

			System.out.println("Bye");

		} while (true);
	}
}
