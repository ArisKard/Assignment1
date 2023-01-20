package Items;

public abstract class Item {

    private final String name;
    private final int requiredLevel;
    private final Slot slot;
    public Item(String name, int requiredLevel, Slot slot) { //constructor of parent class

        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public Slot getSlot() {
        return slot;
    }
}
