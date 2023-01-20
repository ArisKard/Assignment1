package Heroes;

import Items.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Rogue extends Hero{

    public Rogue(String name){              //constructor of rogues
        super(name);
        heroAttribute = new HeroAttribute(2, 6, 1);
        initializeValidItemLists();
    }

    @Override
    protected void initializeValidItemLists() {            //initialization of validWeaponTypes and validArmorTypes lists

        validWeaponTypes = new ArrayList<>(
                Arrays.asList(WeaponType.DAGGER,
                        WeaponType.SWORD));

        validArmorTypes = new ArrayList<>(
                Arrays.asList(ArmorType.MAIL,
                        ArmorType.LEATHER));

    }

    @Override
    public double heroDamage() {            //calculates rogue's damage, according to the formula

        int weaponDamage = (equipment.get(Slot.WEAPON)==null) ? 1 : ((Weapon)equipment.get(Slot.WEAPON)).getWeaponDamage();

        return weaponDamage*(1 + (double)totalAttributes().getDexterity() / 100);

    }

    @Override
    public void levelUp() {         //rogue level up

        heroLevel++;
        heroAttribute.levelUp(1, 4, 1);
    }

}
