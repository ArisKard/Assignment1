package Heroes;

import Items.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Rogue extends Hero{

    public Rogue(String name){
        super(name);
        heroAttribute = new HeroAttribute(2, 6, 1);
        initializeValidItemLists();
    }

    @Override
    protected void initializeValidItemLists() {

        validWeaponTypes = new ArrayList<>(
                Arrays.asList(WeaponType.DAGGER,
                        WeaponType.SWORD));

        validArmorTypes = new ArrayList<>(
                Arrays.asList(ArmorType.MAIL,
                        ArmorType.LEATHER));

    }

    @Override
    public double heroDamage() {

        int weaponDamage = (equipment.get(Slot.WEAPON)==null) ? 1 : ((Weapon)equipment.get(Slot.WEAPON)).getWeaponDamage();

        return weaponDamage*(1 + (double)totalAttributes().getDexterity() / 100);

    }

    @Override
    public void levelUp() {

        heroLevel++;
        heroAttribute.levelUp(1, 4, 1);
    }

}
