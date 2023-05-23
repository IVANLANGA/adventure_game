import java.util.HashMap; // import the HashMap its like a dictionary in python
import java.util.ArrayList;

public class Room {
    //variables about Rooms
    private String name;
    private String description;
    private HashMap<String, Room> exits; //will be used to locate exits
    private ArrayList<Item> items;

    //initialize variabels
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    // get room name
    public String getName() {
        return name;
    }

    //describes room
    public String getDescription() {
        return description;
    }
    
    //sets exits
    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }
    
    //get exits
    public Room getExit(String direction) {
        return exits.get(direction);
    }
    
    // returns hashmap exits
    public HashMap<String, Room> getExits() {
        return exits;
    }

    //adds item to room
    public void addItem(Item item) {
        items.add(item);
    }

    //remove item from room
    public void removeItem(Item item) {
        items.remove(item);
    }

    //for when looking
    public ArrayList<Item> getItems() {
        return items;
    }
}
