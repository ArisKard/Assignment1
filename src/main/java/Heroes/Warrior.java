package Heroes;

import Items.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Warrior extends Hero{              //constructor of warriors

    public Warrior(String name) {
        super(name);
        heroAttribute = new HeroAttribute(5, 2, 1);
        initializeValidItemLists();
    }

    protected void initializeValidItemLists() {                  //initialization of validWeaponTypes and validArmorTypes lists

        validWeaponTypes = new ArrayList<>(
                Arrays.asList(WeaponType.AXE,
                        WeaponType.SWORD,
                        WeaponType.HAMMER));

        validArmorTypes = new ArrayList<>(
                Arrays.asList(ArmorType.MAIL,
                        ArmorType.PLATE));
    }

    @Override
    public double heroDamage() {                //calculates warrior's damage, according to the formula

        int weaponDamage = (equipment.get(Slot.WEAPON)==null) ? 1 : ((Weapon)equipment.get(Slot.WEAPON)).getWeaponDamage();

        return weaponDamage*(1 + (double)totalAttributes().getStrength() / 100);
    }

    @Override
    public void levelUp() {             //warrior level up

        heroLevel++;
        heroAttribute.levelUp(3, 2, 1);
    }

}
