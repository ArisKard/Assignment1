package Heroes;

import Exceptions.InvalidArmorException;
import Exceptions.InvalidWeaponException;
import Items.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {

    private final String name;
    protected int heroLevel = 1;

    protected HeroAttribute heroAttribute;

    protected List<WeaponType> validWeaponTypes;
    protected List<ArmorType> validArmorTypes;

    protected Map<Slot, Item> equipment = new HashMap<>();

    public Hero(String name) {
        this.name = name;
        initializeEquipment();
    }

    private void initializeEquipment() {

        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.WEAPON, null);
        equipment.put(Slot.BODY, null);
        equipment.put(Slot.LEGS, null);
    }

    public abstract void levelUp();

    protected abstract void initializeValidItemLists();

    public abstract double heroDamage();


    public void equip(Weapon weapon) throws InvalidWeaponException {

        if(notEquipableByLevel(weapon))
            throw new InvalidWeaponException("Your level is too low for this weapon");

        if(!equipableByWeaponType(weapon))
            throw new InvalidWeaponException("Cannot equip this type of weapon to this type of character");

        equipment.put(weapon.getSlot(), weapon);
    }
    public void equip(Armor armor) throws InvalidArmorException {

        if(notEquipableByLevel(armor))
            throw new InvalidArmorException("Your level is too low for this armor");

        if(!equipableByArmorType(armor))
            throw new InvalidArmorException("Cannot equip this type of armor to this type of character");

        equipment.put(armor.getSlot(), armor);

        //heroAttribute.levelUp(armor.getArmorAttribute().getStrength(), armor.getArmorAttribute().getDexterity(), armor.getArmorAttribute().getIntelligence());
    }



    public boolean equipableByWeaponType(Weapon weapon){
        return validWeaponTypes.contains(weapon.getWeaponType());
    }
    public boolean equipableByArmorType(Armor armor){
        return validArmorTypes.contains(armor.getArmorType());
    }

    public boolean notEquipableByLevel(Item item){

        return item.getRequiredLevel() > heroLevel;
    }

    public HeroAttribute totalAttributes(){

        int totalStrength = heroAttribute.getStrength();
        int totalDexterity = heroAttribute.getDexterity();
        int totalIntelligence = heroAttribute.getIntelligence();

        for (Map.Entry<Slot, Item> entry : equipment.entrySet())
            if(entry.getKey()!= Slot.WEAPON && entry.getValue()!=null){
                totalStrength+=((Armor)entry.getValue()).getArmorAttribute().getStrength();
                totalDexterity+=((Armor)entry.getValue()).getArmorAttribute().getDexterity();
                totalIntelligence+=((Armor)entry.getValue()).getArmorAttribute().getIntelligence();

            }

        return new HeroAttribute(totalStrength, totalDexterity, totalIntelligence);
    }

    public StringBuilder display(){

        HeroAttribute totalAttributes = totalAttributes();
        StringBuilder s = new StringBuilder("Name: " + name);

        s.append("\nClass: ").append(getClass().getName()).append("\nLevel: ").append(heroLevel).append("\nTotal Strength: ").append(totalAttributes.getStrength());
        s.append("\nTotal Dexterity: ").append(totalAttributes.getDexterity()).append("\nTotal Intelligence: ").append(totalAttributes.getIntelligence()).append("\nDamage: ").append(String.format("%.2f", heroDamage()));

        return s;
    }

    public String getName() {
        return name;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public HeroAttribute getHeroAttribute() {
        return heroAttribute;
    }

    public Map<Slot, Item> getEquipment() {
        return equipment;
    }

    public List<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }

    public List<ArmorType> getValidArmorTypes() {
        return validArmorTypes;
    }
}

