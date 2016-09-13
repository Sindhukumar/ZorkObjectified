import java.util.HashMap;
import java.util.Map;

public class Room {
 private HashMap<String,Room> Exit;
 private String name;
 private String description;
 private String hiddenDetails;
 private boolean hasLamp;
 private String things;
 private boolean hasThings;
 
 public boolean isHasThings() {
	return hasThings;
}

public void setHasThings(boolean hasThings) {
	this.hasThings = hasThings;
}

public String getThings() {
	return things;
}

public void setThings(String things) {
	this.things = things;
}

Room(String name){
	 this.name=name;
 }

public HashMap<String, Room> getExit() {
	return Exit;
}

public void setExists(HashMap<String, Room> exits) {
	Exit = exits;
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
