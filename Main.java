// IN LANGA 42264634
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        //prompt user about game
        System.out.println("Welcome to Text Adventure!");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter your name");
        name = scanner.nextLine();
        //instructions on how to use the game
        System.out.println("\nwelcome adventurer "+ name + ", this is a text based adventure game, ");
        System.out.println("you have to navigate in the different rooms, and find items to store in your back pack.");
        System.out.println("you can move around and perform actions by typing commands in the terminal.");
        System.out.println("The objective of the game is to go into all the rooms and collect all the items in the entire game");
        System.out.println("remember, if you do not know the commands, you may type in the command 'help' at anytime during the game to help guide you in your adventure");
        
        System.out.println("Good Luck " + name);
        // start game
        
        System.out.println("You can start entering a command");
        TextAdventure game = new TextAdventure(name);
        game.run();
    }
}
