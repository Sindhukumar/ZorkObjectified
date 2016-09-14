import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class House {
	static Room foyer = new Room("foyer","You are in the Foyer, There is dead Scorpio.","");
	static Room frontRoom = new Room("frontRoom","","");
	static Room library = new Room("library","","");
	static Room kitchen = new Room("kitchen","","");
	static Room diningRoom = new Room("diningRoom","","");
	static Room vault = new Room("vault","","");
	static Room parlor = new Room("parlor","","");
	static Room secretRoom = new Room("secretRoom","","");
	static Room current;
	static HashMap<String, Room> directions = new HashMap<String, Room>();

	public static void main(String[] args) {

		// Create room foyer
		directions.put("east", null);
		directions.put("south", null);
		directions.put("west", null);
		directions.put("North", frontRoom);
		foyer.setExists(directions);
		
		// create room frontroom
		directions.put("east", kitchen);
		directions.put("south", foyer);
		directions.put("west", library);
		directions.put("north", null);
		frontRoom.setExists(directions);
		frontRoom.addItem(new Item("Piano","plays music",frontRoom,false ));
		frontRoom.addItem(new Item("Sheet Music","It plays your fav song",frontRoom,true ));
		
		// create room Library
		directions.put("east", frontRoom);
		directions.put("south", null);
		directions.put("west", null);
		directions.put("north", diningRoom);
		library.setExists(directions);
		library.addItem(new Item("Spider","it bites",library,false ));
		library.addItem(new Item("Scroll","Reads a secret message",library,true ));
		
		// Create room kitchen
		directions.put("east", null);
		directions.put("south", null);
		directions.put("west", frontRoom);
		directions.put("north", parlor);
		kitchen.setExists(directions);
		library.addItem(new Item("Fridge","keeps yours stuff cool",kitchen,false ));
		library.addItem(new Item("Food","You can eat them",kitchen,true ));
		// Create room dining

		directions.put("north", null);
		directions.put("south", library);
		directions.put("west", null);
		directions.put("east", null);
		diningRoom.setExists(directions);
		diningRoom.addItem(new Item("Box","its an empty box",diningRoom,false ));
		diningRoom.addItem(new Item("Gift Card","You can take the amazon gift card",diningRoom,true ));
		// Create vault

		directions.put("north", null);
		directions.put("south", null);
		directions.put("west", null);
		directions.put("east", parlor);// parlor and secretRoom(25%)
		vault.setExists(directions);

		// create parlor

		directions.put("north", null);
		directions.put("south", kitchen);
		directions.put("west", vault);
		directions.put("east", null);
		parlor.setExists(directions);
		parlor.addItem(new Item("A big box","Have a look",parlor,false ));
		parlor.addItem(new Item("Movie Tickets","Your fav movie ticket",parlor,true ));
		parlor.addItem(new Item("Potrait","Your fav movie star",parlor,true ));
		// create secret room

		directions.put("north", null);
		directions.put("south", null);
		directions.put("west", vault);
		directions.put("east", null);
		secretRoom.setExists(directions);
		secretRoom.addItem(new Item("Pile of Gold","Take as much as you can",secretRoom,true ));
		secretRoom.addItem(new Item("House Map","Navigate faster",secretRoom,true ));
		
		
		
		System.out.println("Welcome ");
		setLamp();
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
	
	public static void setLamp(){
		switch (new Random().nextInt(8)) {
		case 1:
			foyer.addItem(new Item("Lamp", "It glows", foyer, false));
			break;
		case 2:
			frontRoom.addItem(new Item("Lamp", "It glows", frontRoom, false));
			break;

		case 3:
			kitchen.addItem(new Item("Lamp", "It glows", kitchen, false));
			break;

		case 4:
			diningRoom.addItem(new Item("Lamp", "It glows", diningRoom, false));
			break;

		case 5:
			library.addItem(new Item("Lamp", "It glows", library, false));
			break;

		case 6:
			vault.addItem(new Item("Lamp", "It glows", vault, false));
			break;

		case 7:
			parlor.addItem(new Item("Lamp", "It glows", parlor, false));
			break;

		default:
			secretRoom.addItem(new Item("Lamp", "It glows", secretRoom, false));
			break;

		}

	}
}
