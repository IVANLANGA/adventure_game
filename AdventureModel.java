import java.util.ArrayList;

public class AdventureModel {
    private ArrayList<Room> rooms;
    
    Room startingRoom ;
    Room secondRoom ;
    Room thirdRoom ;

    public AdventureModel() {
        rooms = new ArrayList<>();

        // create rooms and add them to the rooms list
        startingRoom = new Room("Starting Room", "You are in a small, dimly lit room.");
        secondRoom = new Room("Second Room", "You are in a large, empty room.");
        thirdRoom = new Room("Third Room", "You are in a room with a table and chairs.");

        startingRoom.setExit("north", secondRoom);
        secondRoom.setExit("south", startingRoom);
        secondRoom.setExit("east", thirdRoom);
        thirdRoom.setExit("west", secondRoom);

        rooms.add(startingRoom);
        rooms.add(secondRoom);
        rooms.add(thirdRoom);

        // add items to the rooms
        Item key = new Item("key", "A small, rusty key.", true);
        Item book = new Item("book", "An old, leather-bound book.", true);
        Item sword = new Item("sword", "A Sharp weapon used for combat.", true);
        Item potion = new Item("potion", "A magical elixir that restores health.", true);
        Item shield = new Item("shield", "A defensive item used to protect against attacks.", true);
        Item hammer = new Item("hammer", "A heavy hammer that can be used to break down walls.", true);
        Item map = new Item("map", "A map to useful for treasure hunting.", true);
        Item diamond = new Item("diamond", "A precious gem worth a fortune.", true);
        

        startingRoom.addItem(key);
        startingRoom.addItem(sword);
        startingRoom.addItem(map);
        secondRoom.addItem(shield);
        secondRoom.addItem(diamond);
        thirdRoom.addItem(book);
        thirdRoom.addItem(potion);
        thirdRoom.addItem(hammer);
    }
    
    public Room getStartingRoom()
    {
        return startingRoom;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
