import java.util.ArrayList;

public class TreasureChest {
	private ArrayList<Item> items = new ArrayList<Item>();
	private double money;
	private String scroll;

	public void addItem(Item item) {
		items.add(item);
	}
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getScroll() {
		return scroll;
	}

	public void setScroll(String scroll) {
		this.scroll = scroll;
	}
	
	public void createScroll(){
		scroll="------------------------------------\n";
		scroll= scroll+"		Your Collection\n";
		scroll= scroll+"------------------------------------\n";
		scroll= scroll+"\nMoney: "+ money+"\n";
		if(items!=null)
		for(Item item: items)
		scroll=scroll+item.getName()+"\n";
	}
}
