package Items;

import Heroes.HeroAttribute;

public class Armor extends Item{

    private final ArmorType armorType;    //type of armor
    private final HeroAttribute armorAttribute; //armor attributes

    public Armor(ArmorType armorType, String name, int requiredLevel, Slot slot, HeroAttribute armorAttribute) {  //constructor of armor items
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    public ArmorType getArmorType() {
        return armorType;
    }
}
