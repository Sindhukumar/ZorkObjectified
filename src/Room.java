import java.util.HashMap;
import java.util.Map;

public class Room {
 private HashMap<String,Room> Exist;
 private String name;
 private String description;
 private String hiddenDetails;
 private boolean hasLamp;
 
 Room(String name){
	 this.name=name;
 }

public HashMap<String, Room> getExist() {
	return Exist;
}

public void setExists(HashMap<String, Room> exists) {
	Exist = exists;
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
