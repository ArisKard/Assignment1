package Heroes;

import Exceptions.InvalidArmorException;
import Exceptions.InvalidWeaponException;
import Items.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {

    private final String name;
    protected int heroLevel = 1; //hero is level 1 on creation by default

    protected HeroAttribute heroAttribute; //holds the levels of his attributes (strength, dexterity, intelligence)

    protected List<WeaponType> validWeaponTypes; //holds the weapon types the character is able to equip
    protected List<ArmorType> validArmorTypes; //holds the armor types the character is able to equip

    protected Map<Slot, Item> equipment = new HashMap<>(); //a map of <Slot, Item> to hold hero's equipment

    public Hero(String name) {      //parent class constructor
        this.name = name;
        initializeEquipment();      //calls this method so that the equipment map is initialized
    }

    private void initializeEquipment() {        //initializes hero's equipment with null values

        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.WEAPON, null);
        equipment.put(Slot.BODY, null);
        equipment.put(Slot.LEGS, null);
    }

    public abstract void levelUp();     //abstract method, to be implemented at child classes

    protected abstract void initializeValidItemLists(); //abstract method, to be implemented at child classes

    public abstract double heroDamage(); //abstract method, to be implemented at child classes


    public void equip(Weapon weapon) throws InvalidWeaponException {  //overloaded method to equip weapons, throws InvalidWeaponExceptions

        if(notEquipableByLevel(weapon))
            throw new InvalidWeaponException("Your level is too low for this weapon");

        if(!equipableByWeaponType(weapon))
            throw new InvalidWeaponException("Cannot equip this type of weapon to this type of character");

        equipment.put(weapon.getSlot(), weapon);
    }
    public void equip(Armor armor) throws InvalidArmorException {  //overloaded method to equip armor, throws InvalidArmorExceptions

        if(notEquipableByLevel(armor))
            throw new InvalidArmorException("Your level is too low for this armor");

        if(!equipableByArmorType(armor))
            throw new InvalidArmorException("Cannot equip this type of armor to this type of character");

        equipment.put(armor.getSlot(), armor);

    }



    public boolean equipableByWeaponType(Weapon weapon){                    //returns if the weapon can be equipped by this character, according to the validWeaponTypes list
        return validWeaponTypes.contains(weapon.getWeaponType());
    }
    public boolean equipableByArmorType(Armor armor){                       //returns if this armor can be equipped by this character, according to the validArmorTypes list
        return validArmorTypes.contains(armor.getArmorType());
    }

    public boolean notEquipableByLevel(Item item){                         //returns if the character can equip this item, according to his level

        return item.getRequiredLevel() > heroLevel;
    }

    public HeroAttribute totalAttributes(){                                //returns a HeroAttribute with hero's total strength, dexterity and intelligence, by adding his armor items' attributes to his base stats

        int totalStrength = heroAttribute.getStrength();
        int totalDexterity = heroAttribute.getDexterity();
        int totalIntelligence = heroAttribute.getIntelligence();

        for (Map.Entry<Slot, Item> entry : equipment.entrySet())            //loops through the armor items, to return hero's total attributes. Slot.WEAPON and null values are omitted.
            if(entry.getKey()!= Slot.WEAPON && entry.getValue()!=null){
                totalStrength+=((Armor)entry.getValue()).getArmorAttribute().getStrength();
                totalDexterity+=((Armor)entry.getValue()).getArmorAttribute().getDexterity();
                totalIntelligence+=((Armor)entry.getValue()).getArmorAttribute().getIntelligence();

            }

        return new HeroAttribute(totalStrength, totalDexterity, totalIntelligence);
    }

    public StringBuilder display(){                                       //returns a StringBuilder in order to display hero's name, class, total attributes, and damage

        HeroAttribute totalAttributes = totalAttributes();
        StringBuilder s = new StringBuilder("Name: " + name);

        s.append("\nClass: ").append(getClass().getName()).append("\nLevel: ").append(heroLevel).append("\nTotal Strength: ").append(totalAttributes.getStrength());
        s.append("\nTotal Dexterity: ").append(totalAttributes.getDexterity()).append("\nTotal Intelligence: ").append(totalAttributes.getIntelligence()).append("\nDamage: ").append(String.format("%.2f", heroDamage()));

        return s;
    }

    public String getName() {                                                                //getters in order to achieve encapsulation
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

