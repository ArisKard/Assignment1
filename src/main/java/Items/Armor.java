package Items;

import Heroes.HeroAttribute;

public class Armor extends Item{

    private final ArmorType armorType;
    private final HeroAttribute armorAttribute;

    public Armor(ArmorType armorType, String name, int requiredLevel, Slot slot, HeroAttribute armorAttribute) {
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
