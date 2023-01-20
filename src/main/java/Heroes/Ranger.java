package Heroes;

import Items.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ranger extends Hero{

    public Ranger(String name) {                //constructor of rangers
        super(name);
        heroAttribute = new HeroAttribute(1, 7, 1);
        initializeValidItemLists();
    }

    @Override
    protected void initializeValidItemLists() {         //initialization of validWeaponTypes and validArmorTypes lists

        validWeaponTypes = new ArrayList<>(
                List.of(WeaponType.BOW));

        validArmorTypes = new ArrayList<>(
                Arrays.asList(ArmorType.MAIL,
                        ArmorType.LEATHER));
    }

    @Override
    public double heroDamage() {                //calculates ranger's damage, according to the formula

        int weaponDamage = (equipment.get(Slot.WEAPON)==null) ? 1 : ((Weapon)equipment.get(Slot.WEAPON)).getWeaponDamage();

        return weaponDamage*(1 + (double)totalAttributes().getDexterity() / 100);
    }


    @Override
    public void levelUp() {                     //ranger level up

        heroLevel++;
        heroAttribute.levelUp(1, 5, 1);
    }

}
