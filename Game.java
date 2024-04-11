import java.util.ArrayList;
import java.util.Scanner;

/**
 * the game class represents a game with various actions and options
 * it implements the contract interface
 * 
 * this class allows the player to interact with the game world by performing actions such as:
 * grabbing items, dropping items, examining items, using items, walking, flying, shrinking, growing, resting, and undoing actions
 * the game starts with a grassy cliff face and provides options for the player to explore and interact with the environment
 * the player can also manage their inventory by adding and removing items
 */
public class Game implements Contract {
    
    // variables

    /*
     * private array list to store the player's inventory
     */
    private ArrayList<String> inventory = new ArrayList<>();

    /*
     * private int to store the size of the player
     */
    private int size = 10;
    
    // methods

    /**
     * gameLaunch method
     * prints the initial game launch message
     */
    public void gameLaunch() {
        System.out.println("You look around a grassy cliff face. There is a path to the west. Rocks and flowers are scattered around the terrain. You see a small campfire to the south, maybe you can rest there.");
    }

    /**
     * showOptions method
     * prints the available options for the player to interact with the game world
     */
    public void showOptions() {
        System.out.println("Available options:\n + showInventory() \n + grab() \n + drop() \n + examine() \n + use()\n + walk()\n + fly()\n + shrink()\n + grow()\n + rest()\n + undo()");
    }

    /**
     * showInventory method
     * prints the player's inventory
     */
    public void showInventory() {
        System.out.println("Inventory:");
        for (String item : inventory) {
            System.out.println("* " + item);
        }
    }
    
    /**
     * grab method
     * adds an item to the player's inventory
     * @param item the item to add to the inventory
     */
    public void grab (String item) {
        System.out.println("You pick up a " + item);
        inventory.add(item);
    }

    /**
     * drop method
     * removes an item from the player's inventory
     * @param item the item to remove from the inventory
     * @return a message indicating that the item was dropped
     */
    public String drop (String item) {
        // check if the item is in the inventory
        if (!inventory.contains(item)) {
            System.out.println("You don't have a " + item);
            return "You don't have a " + item;
        }
        else {
            inventory.remove(item);
            System.out.println("You drop a " + item);
            return "You drop a " + item;
        }
    }

    /**
     * examine method
     * prints a message indicating that the player is examining an item
     * @param item the item to examine
     */
    public void examine (String item) {
        System.out.println("You look closer at a " + item + ". It's fascinating!");
    }

    /**
     * use method
     * prints a message indicating that the player is using an item
     * @param item the item to use
     */
    public void use (String item) {
        System.out.println("You use a " + item);
        System.out.println("That didn't seem to do much");
    }
    
    /**
     * walk method
     * returns a boolean indicating whether the player can walk in a certain direction
     * @param direction the direction to walk
     * @return a boolean indicating whether the player can walk in that direction
     */
    public boolean walk (String direction) {
        if (direction.contains("east")) {
            System.out.println("You cannot walk east");
            return false;
        } 
        else if (direction.contains("west")) {
            System.out.println("You walk west");
            System.out.println("The path continues on, the view is delightful");
            return true;
        }
        else if (direction.contains("north")) {
            System.out.println("You cannot walk north");
            return false;
        }
        else if (direction.contains("south")) {
            System.out.println("You walk south");
            System.out.println("You near the campfire. It seems to be cared for. The fire is still warm. You can rest here");
            return true;
        }
        return false; // default return statement
    }

    /**
     * fly method
     * returns a boolean indicating whether the player can fly in a certain direction
     * @param x the x coordinate to fly to
     * @param y the y coordinate to fly to
     * @return a boolean indicating whether the player can fly in that direction
     */
    public boolean fly (int x, int y) {
        // check if the y coordinate is greater than 0, implying that the player is actually going upward (i.e., flying)
        if (y > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * shrink method
     * increases the size of the player and
     * prints a message indicating that the player has shrunk
     * @return the new size of the player
     */
    public Number shrink() {
        size -= 1;
        System.out.println("You shrink. The world seems bigger now");
        return size;
    }

    /**
     * grow method
     * decreases the size of the player and
     * prints a message indicating that the player has grown
     * @return the new size of the player
     */
    public Number grow() {
        size -= 1;
        System.out.println("You grow. The world seems smaller now");
        return size;
    }

    /**
     * rest method
     * prints a message indicating that the player is resting
     */
    public void rest() {
        System.out.println("You rest, for a moment");
    }
    
    /**
     * undo method
     * "clears" the console by printing a series of escape characters
     */
    public void undo() {
        System.out.print("Are you sure you want to undo? (yes/no): ");
        Scanner check = new Scanner(System.in);
        String confirmation = check.nextLine();
        if (confirmation.equals("yes")) {
            System.out.print("\033[H\033[2J");
            System.out.println("Very well, let us go back to the beginning");
            System.out.flush();
        } else {
            System.out.println("You decide not to undo, life is too short after all");
        }
    }

    /**
     * main method
     * the main method of the game class
     * allows the player to interact with the game world by performing actions
     * @param args the command line arguments
     */

     public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
    
        game.gameLaunch();
        game.showOptions();
    
        while (true) {
            System.out.print("Enter your action: ");
            String action = scanner.nextLine();
    
            switch (action) {
                case "showInventory":
                    game.showInventory();
                    break;
                case "grab":
                    System.out.print("Enter item to grab: ");
                    String itemToGrab = scanner.nextLine();
                    game.grab(itemToGrab);
                    break;
                case "drop":
                    System.out.print("Enter item to drop: ");
                    String itemToDrop = scanner.nextLine();
                    game.drop(itemToDrop);
                    break;
                case "examine":
                    System.out.print("Enter item to examine: ");
                    String itemToExamine = scanner.nextLine();
                    game.examine(itemToExamine);
                    break;
                case "use":
                    System.out.print("Enter item to use: ");
                    String itemToUse = scanner.nextLine();
                    game.use(itemToUse);
                    break;
                case "walk":
                    System.out.print("Enter direction to walk: ");
                    String direction = scanner.nextLine();
                    game.walk(direction);
                    break;
                case "fly":
                    System.out.print("Enter x coordinate: ");
                    int x = scanner.nextInt();
                    System.out.print("Enter y coordinate: ");
                    int y = scanner.nextInt();
                    scanner.nextLine(); // consume newline character
                    boolean canFly = game.fly(x, y);
                    System.out.println("Can fly: " + canFly);
                    break;
                case "shrink":
                    game.shrink();
                    break;
                case "grow":
                    game.grow();
                    break;
                case "rest":
                    game.rest();
                    break;
                case "undo":
                    game.undo();
                    game.showOptions();
                    break;
                default:
                    System.out.println("Invalid action!");
                    break;
            }
            System.out.print("Continue? (yes/no): ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
        System.out.println("Game over!");
    }
}