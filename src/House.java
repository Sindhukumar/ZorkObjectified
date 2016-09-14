import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class House {
	static Room foyer = new Room("foyer", "You are in the Foyer, There is a dead Scorpio.", "you see Sheet Music",
			calcMoney());
	static Room frontRoom = new Room("frontRoom", "You are in the Front Room, You see a Piano.", "", calcMoney());
	static Room library = new Room("library", "You are in the Library, You see Spiders.",
			"You can see a scroll with match", calcMoney());
	static Room kitchen = new Room("kitchen", "You are in the Kitchen,You see bats.",
			"A refrigerator full of your favorite food/drink", calcMoney());
	static Room diningRoom = new Room("diningRoom", "You are in the Dining Room,You see an empty box.",
			"The box is not actually empty, it contains an Amazon gift card", calcMoney());
	static Room vault = new Room("vault", "You are in the Vault, You see 3 walking Skeltons", "", calcMoney());
	static Room parlor = new Room("parlor", "You are in Parlor, You see treasure Chest",
			"There is a portrait of your favorite movie star and tickets to their latest movie", calcMoney());
	static Room secretRoom = new Room("secretRoom", "You found a Secret Room", "You see a pile of gold", calcMoney());
	static Room current;
	static boolean isSecretRoomFound = false;
	static HashMap<String, Room> directions;
	static TreasureChest treasureChest = new TreasureChest();

	public static void main(String[] args) {

		// Create room foyer
		directions = new HashMap<String, Room>();
		directions.put("east", null);
		directions.put("south", null);
		directions.put("west", null);
		directions.put("north", frontRoom);
		foyer.setExists(directions);

		// create room frontroom
		directions = new HashMap<String, Room>();
		directions.put("east", kitchen);
		directions.put("south", foyer);
		directions.put("west", library);
		directions.put("north", null);
		frontRoom.setExists(directions);
		//frontRoom.addItem(new Item("Piano", "plays music", frontRoom, false));
		frontRoom.addItem(new Item("Sheet Music", "It plays your fav song", frontRoom, true));

		// create room Library
		directions = new HashMap<String, Room>();
		directions.put("east", frontRoom);
		directions.put("south", null);
		directions.put("west", null);
		directions.put("north", diningRoom);
		library.setExists(directions);
		//library.addItem(new Item("Spider", "it bites", library, false));
		library.addItem(new Item("Scroll", "Reads a secret message", library, true));

		// Create room kitchen
		directions = new HashMap<String, Room>();
		directions.put("east", null);
		directions.put("south", null);
		directions.put("west", frontRoom);
		directions.put("north", parlor);
		kitchen.setExists(directions);
		library.addItem(new Item("Fridge", "keeps yours stuff cool", kitchen, false));
		library.addItem(new Item("Food", "You can eat them", kitchen, true));

		// Create room dining
		directions = new HashMap<String, Room>();
		directions.put("north", null);
		directions.put("south", library);
		directions.put("west", null);
		directions.put("east", null);
		diningRoom.setExists(directions);
		//diningRoom.addItem(new Item("Box", "its an empty box", diningRoom, false));
		diningRoom.addItem(new Item("Gift Card", "You can take the amazon gift card", diningRoom, true));

		// Create vault
		directions = new HashMap<String, Room>();
		directions.put("north", null);
		directions.put("south", null);
		directions.put("west", null);
		directions.put("east", findRoom());// parlor and secretRoom(25%)
		vault.setExists(directions);

		// create parlor
		directions = new HashMap<String, Room>();
		directions.put("north", null);
		directions.put("south", kitchen);
		directions.put("west", vault);
		directions.put("east", null);
		parlor.setExists(directions);
		//parlor.addItem(new Item("A big box", "Have a look", parlor, false));
		parlor.addItem(new Item("Movie Tickets", "Your fav movie ticket", parlor, true));
		parlor.addItem(new Item("Potrait", "Your fav movie star", parlor, true));

		// create secret room
		directions = new HashMap<String, Room>();
		directions.put("north", null);
		directions.put("south", null);
		directions.put("west", vault);
		directions.put("east", null);
		secretRoom.setExists(directions);
		secretRoom.addItem(new Item("Pile of Gold", "Take as much as you can", secretRoom, true));
		secretRoom.addItem(new Item("House Map", "Navigate faster", secretRoom, true));

		System.out.println("Welcome! You are entering a house with lots of mystires ");

		setLamp();
		current = foyer;
		Room tmp;
		String option, o;

		while (true) {
			System.out.println(current.getDescription());
			if (hasLamp()) {
				System.out.println(current.getHiddenDetails());
			}
			if(current.getName().equalsIgnoreCase("vault")){
				directions.put("east", findRoom());
			}
			System.out.println("Action words are Go, Use, Quit ");
			o = getInput();
			if (o.equalsIgnoreCase("Go")) {
				System.out.println("Where do you want to go?(East/West/North/South) ");
				option = getInput();
				tmp = current.getExit().get(option.toLowerCase());
				while (tmp == null) {
					System.out.println("You cannot go that way Please enter another direction");
					option = getInput();
					tmp = current.getExit().get(option.toLowerCase());
				}
				current = tmp;
			}
			if (o.equalsIgnoreCase("Use")) {
				System.out.println("What do you want to use or take:");
				showItems();
				option = getInput();
				while(!use(option))
					System.out.println("you cannot use that");

			}
			if (o.equalsIgnoreCase("quit") && current.equals(foyer)) {
				treasureChest.createScroll();
				System.out.println(treasureChest.getScroll());
				break;
			} else if (o.equalsIgnoreCase("quit")) {
				System.out.println("Sorry to see you go empty handed");
				break;
			}

		}
		System.out.println("Bye");
	}

	public static void setLamp() {
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

	public static String getInput() {
		Scanner sc = new Scanner(System.in);
		String tmp = "";
		tmp = sc.next();
		return tmp;
	}

	public static Room findRoom() {
		if (!isSecretRoomFound) {
			System.out.println("find room");
			if (new Random().nextInt(4) == 3)
				return secretRoom;
			return parlor;
		}
		System.out.println("Would you want to go Secret Room or Parlor");
		if (getInput().equalsIgnoreCase("SecretRoom"))
			return secretRoom;
		return parlor;

	}

	public static double calcMoney() {
		return new Random().nextInt(1001);
	}

	public static boolean hasLamp() {
		if (treasureChest.getItems() != null) {
			for (Item item : treasureChest.getItems()) {
				if (item.getName().equalsIgnoreCase("Lamp"))
					return true;
			}
		}
		return false;
	}

	public static void showItems() {
		if(current.getItems().isEmpty()){
			System.out.println("Nothing to use/pick here");
			return;
		}
			
		if (hasLamp()){
			System.out.println(current.getItems());
		}
		else {
			if (current.getItems() != null) {
				System.out.print("[");
				for (Item item : current.getItems()) {
					if (!item.isHidden())
						System.out.print(item.getName()+",");
				}
				System.out.print("]");
			}
		}
		if(current.getMoney()>0)
		System.out.println("The room has $"+ current.getMoney() +" lying around."+"Type \"money\" to pick it up");
	}
	
	public static boolean use(String thing){
		
		if(thing.equalsIgnoreCase("money")){
			treasureChest.setMoney(treasureChest.getMoney()+current.getMoney());
			current.setMoney(0);
			return true;
		}
		if (current.getItems() != null) {
			for (Item item : current.getItems()) {
				if (item.getName().equalsIgnoreCase(thing)){
					System.out.print("You used/took "+item.getName());
					current.getItems().remove(item);
					treasureChest.addItem(item);
				}
			}
			System.out.print("]");
			return true;
		}
		return false;
	}
}
