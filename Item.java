public class Item {
    private String name;
    private String description;
    private boolean canTake;

    public Item(String name, String description, boolean canTake) {
        this.name = name;
        this.description = description;
        this.canTake = canTake;
    }

    //get item name
    public String getName() {
        return name;
    }

    // describe item
    public String getDescription() {
        return description;
    }

    //can take item
    public boolean canTake() {
        return canTake;
    }
    
    
}
