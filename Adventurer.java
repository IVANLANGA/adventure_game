import java.util.ArrayList;

public class Adventurer {
    // adventurer variables
    private String name;
    private Room currentRoom = new Room("name", "description");
    private ArrayList<Item> items;
    private ArrayList<Item> inventory;

    public Adventurer(String name, Room startingRoom) {
        //initialize thier name and starting room
        this.name = name;
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    // return inventory array
    public ArrayList<Item> getInventory() {
        return this.inventory;
    }
    
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
    

    public void addItemToInventory(Item item){
        this.inventory.add(item);
        System.out.println("Added " + item.getName() + " to inventory.");
    }
    
    public void removeItemFromInventory(Item item){
        if (this.inventory.contains(item)) {
            this.inventory.remove(item);
            System.out.println("Removed " + item.getName() + " from inventory.");
        } else {
            System.out.println("Cannot remove " + item.getName() + " - not in inventory.");
        }
    }
    
    //use item
    public void useItem(Item item){
        System.out.println("Good job " + name + " You used the " + item.getName());
        System.out.println("try to find more items in other rooms to use");
    }
    
    
    //view inventory
    public String viewInventory() {
        if (inventory.size() == 0) {
            return "Your inventory is empty.";
        } else {
            String inventoryList = "Inventory: ";
            for (Item item : inventory) {
                inventoryList += item.getName() + ", ";
            }
            // Remove the trailing comma and space
            inventoryList = inventoryList.substring(0, inventoryList.length() - 2);
            return inventoryList;
        }
    }
}
