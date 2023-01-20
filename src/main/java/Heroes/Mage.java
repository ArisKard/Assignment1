package Heroes;

import Items.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mage extends Hero{

    public Mage(String name){
        super(name);
        heroAttribute = new HeroAttribute(1, 1, 8);
        initializeValidItemLists();
    }

    @Override
    protected void initializeValidItemLists() {

        validWeaponTypes = new ArrayList<>(
                Arrays.asList(WeaponType.STAFF,
                        WeaponType.WAND));

        validArmorTypes = new ArrayList<>(
                List.of(ArmorType.CLOTH));
    }

    @Override
    public double heroDamage() {

        int weaponDamage = (equipment.get(Slot.WEAPON)==null) ? 1 : ((Weapon)equipment.get(Slot.WEAPON)).getWeaponDamage();

        return weaponDamage*(1 + (double)totalAttributes().getIntelligence() / 100);
    }

    @Override
    public void levelUp() {

        heroLevel++;
        heroAttribute.levelUp(1, 1, 5);
    }

}
