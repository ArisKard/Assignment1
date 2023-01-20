package Heroes;

import Items.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Warrior extends Hero{

    public Warrior(String name) {
        super(name);
        heroAttribute = new HeroAttribute(5, 2, 1);
        initializeValidItemLists();
    }

    protected void initializeValidItemLists() {

        validWeaponTypes = new ArrayList<>(
                Arrays.asList(WeaponType.AXE,
                        WeaponType.SWORD,
                        WeaponType.HAMMER));

        validArmorTypes = new ArrayList<>(
                Arrays.asList(ArmorType.MAIL,
                        ArmorType.PLATE));
    }

    @Override
    public double heroDamage() {

        int weaponDamage = (equipment.get(Slot.WEAPON)==null) ? 1 : ((Weapon)equipment.get(Slot.WEAPON)).getWeaponDamage();

        return weaponDamage*(1 + (double)totalAttributes().getStrength() / 100);
    }

    @Override
    public void levelUp() {

        heroLevel++;
        heroAttribute.levelUp(3, 2, 1);
    }

}
