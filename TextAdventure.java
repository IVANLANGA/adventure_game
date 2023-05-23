import java.util.Scanner;

public class TextAdventure {
    private AdventureModel model;
    private Adventurer adventurer;

    public TextAdventure(String name) {
        this.model = new AdventureModel();
        this.adventurer = new Adventurer(name ,model.getStartingRoom());
    }

    public void run() {
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if(adventurer.getInventory().size() == 8)
            {
                System.out.println("Congradulations " + adventurer.getName() + "! You have won the game by finding all the items on the map");
                System.out.println("You have won the game!!");
                System.out.println("Goodbye!");
                break;
            }
            
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();
            
            //display list of commands when enters help
            if (input.equals("help")) {
                System.out.println("Commands:");
                System.out.println("go [direction]: move in a direction (north, south, east, or west)");
                System.out.println("look: look around the room");
                System.out.println("view inventory: view what you have stored in your backpack");
                System.out.println("take [item]: take an item in the room");
                System.out.println("drop [item]: drop an item from your inventory");
                System.out.println("use [item]: use an item in your inventory");
                System.out.println("exit: quit the game");
            } 
            //move to next room if possible when entered go
            else if (input.startsWith("go ")) {
                String direction = input.substring(3);
                Room nextRoom = adventurer.getCurrentRoom().getExit(direction);
                if (nextRoom == null) {
                    System.out.println("You can't go that way.");
                } else {
                    adventurer.setCurrentRoom(nextRoom);
                    System.out.println(adventurer.getCurrentRoom().getDescription());
                }
            } 
            //displays items when enters looks
            else if (input.equals("look")) {
                System.out.println(adventurer.getCurrentRoom().getDescription());
                System.out.print("Exits: ");
                for (String direction : adventurer.getCurrentRoom().getExits().keySet()) {
                    System.out.print(direction + " ");
                }
                System.out.println();
                if (!adventurer.getCurrentRoom().getItems().isEmpty()) {
                    System.out.println("Items:");
                    for (Item item : adventurer.getCurrentRoom().getItems()) {
                        System.out.println("- " + item.getName() + ": " + item.getDescription());
                    }
                }
            } 
            // takes item if item take is pressed
            else if (input.startsWith("take ")) {
                String itemName = input.substring(5);
                boolean itemTaken = false;
                for (Item item : adventurer.getCurrentRoom().getItems()) {
                    if (item.getName().equals(itemName) && item.canTake()) {
                        adventurer.getCurrentRoom().removeItem(item);
                        adventurer.addItemToInventory(item);
                        itemTaken = true;
                        System.out.println("You took the " + itemName + ".");
                        break;
                    }
                }
                if (!itemTaken) {
                    System.out.println("You can't take that.");
                }
            } 
            //drops item if presed drop
            else if (input.startsWith("drop ")) {
                String itemName = input.substring(5);
                boolean itemDropped = false;
                for (Item item : adventurer.getInventory()) {
                    if (item.getName().equals(itemName)) {
                        adventurer.removeItemFromInventory(item);
                        adventurer.getCurrentRoom().addItem(item);
                        itemDropped = true;
                        System.out.println("You drop the " + itemName + ".");
                        break;
                    }
                }
                if (!itemDropped) {
                    System.out.println("You don't have that.");
                }
            } 
            
            else if (input.startsWith("use ")) {
                String itemName = input.substring(4);
                boolean itemUsed = false;
                //loop and find item to be used
                for (Item item : adventurer.getInventory()) {
                    if (item.getName().equals(itemName)) {
                        adventurer.useItem(item);
                        itemUsed = true;
                        break;
                    }
                }
                if (!itemUsed) {
                    System.out.println("You don't have that.");
                }
            } 
            //exit game 
            else if (input.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            } 
            else if(input.startsWith("view inventory")){
                System.out.println(adventurer.viewInventory());
            }
            else {
            System.out.println("Invalid command.");
            }
        }
    }
}