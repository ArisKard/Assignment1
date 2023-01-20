import Exceptions.InvalidArmorException;
import Exceptions.InvalidWeaponException;
import Heroes.*;
import Items.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    public void testWarriorName(){  //tests if the warrior's name is properly assigned

        String name = "Shen";
        Hero hero = new Warrior(name);

        Assertions.assertEquals(name, hero.getName());
    }

    @Test
    public void testMageName(){ //tests if the mage's name is properly assigned

        String name = "Veigar";
        Hero hero = new Mage(name);

        Assertions.assertEquals(name, hero.getName());
    }

    @Test
    public void testRangerName(){  //tests if the ranger's name is properly assigned

        String name = "Ashe";
        Hero hero = new Ranger(name);

        Assertions.assertEquals(name, hero.getName());
    }

    @Test
    public void testRogueName(){  //tests if the rogue's name is properly assigned

        String name = "Talon";
        Hero hero = new Rogue(name);

        Assertions.assertEquals(name, hero.getName());
    }

    @Test
    public void testWarriorHeroLevel(){  //tests if the warrior's level is properly initialized to 1

        Hero hero = new Warrior("Shen");

        Assertions.assertEquals(1, hero.getHeroLevel());
    }

    @Test
    public void testMageHeroLevel(){  //tests if the mage's level is properly initialized to 1

        Hero hero = new Mage("Veigar");

        Assertions.assertEquals(1, hero.getHeroLevel());
    }

    @Test
    public void testRangerHeroLevel(){  //tests if the ranger's level is properly initialized to 1

        Hero hero = new Ranger("Ashe");

        Assertions.assertEquals(1, hero.getHeroLevel());
    }

    @Test
    public void testRogueHeroLevel(){  //tests if the rogue's level is properly initialized to 1

        Hero hero = new Rogue("Talon");

        Assertions.assertEquals(1, hero.getHeroLevel());
    }

    @Test
    public void testWarriorHeroAttributes(){  //tests if the warrior's attributes are properly initialized

        Hero hero = new Warrior("Shen");

        Assertions.assertEquals(5, hero.getHeroAttribute().getStrength());
        Assertions.assertEquals(2, hero.getHeroAttribute().getDexterity());
        Assertions.assertEquals(1, hero.getHeroAttribute().getIntelligence());
    }

    @Test
    public void testMageHeroAttributes(){  //tests if the mage's attributes are properly initialized

        Hero hero = new Mage("Veigar");

        Assertions.assertEquals(1, hero.getHeroAttribute().getStrength());
        Assertions.assertEquals(1, hero.getHeroAttribute().getDexterity());
        Assertions.assertEquals(8, hero.getHeroAttribute().getIntelligence());
    }

    @Test
    public void testRangerHeroAttributes(){  //tests if the ranger's attributes are properly initialized

        Hero hero = new Ranger("Ashe");

        Assertions.assertEquals(1, hero.getHeroAttribute().getStrength());
        Assertions.assertEquals(7, hero.getHeroAttribute().getDexterity());
        Assertions.assertEquals(1, hero.getHeroAttribute().getIntelligence());
    }

    @Test
    public void testRogueHeroAttributes(){  //tests if the rogue's attributes are properly initialized

        Hero hero = new Rogue("Talon");

        Assertions.assertEquals(2, hero.getHeroAttribute().getStrength());
        Assertions.assertEquals(6, hero.getHeroAttribute().getDexterity());
        Assertions.assertEquals(1, hero.getHeroAttribute().getIntelligence());
    }

    @Test
    public void testWarriorLevelUp(){ //tests if the warriors level up properly

        Hero hero = new Warrior("Shen");
        hero.levelUp();

        Assertions.assertEquals(8, hero.getHeroAttribute().getStrength());
        Assertions.assertEquals(4, hero.getHeroAttribute().getDexterity());
        Assertions.assertEquals(2, hero.getHeroAttribute().getIntelligence());
    }

    @Test
    public void testMageLevelUp(){  //tests if the mages level up properly

        Hero hero = new Mage("Veigar");
        hero.levelUp();

        Assertions.assertEquals(2, hero.getHeroAttribute().getStrength());
        Assertions.assertEquals(2, hero.getHeroAttribute().getDexterity());
        Assertions.assertEquals(13, hero.getHeroAttribute().getIntelligence());
    }

    @Test
    public void testRangerLevelUp(){  //tests if the rangers level up properly

        Hero hero = new Ranger("Ashe");
        hero.levelUp();

        Assertions.assertEquals(2, hero.getHeroAttribute().getStrength());
        Assertions.assertEquals(12, hero.getHeroAttribute().getDexterity());
        Assertions.assertEquals(2, hero.getHeroAttribute().getIntelligence());
    }

    @Test
    public void testRogueLevelUp(){  //tests if the rogues level up properly

        Hero hero = new Rogue("Talon");
        hero.levelUp();

        Assertions.assertEquals(3, hero.getHeroAttribute().getStrength());
        Assertions.assertEquals(10, hero.getHeroAttribute().getDexterity());
        Assertions.assertEquals(2, hero.getHeroAttribute().getIntelligence());
    }

    @Test
    void testWeaponEquipUnderleveled() {  //tests if the InvalidWeaponException is thrown properly when hero is underleveled

        Hero hero = new Warrior("Shen");
        Weapon weapon = new Weapon(null, 2, null, 0);

        Assertions.assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void testWeaponEquipWrongType() {  //tests if the InvalidWeaponException is thrown properly when hero tries to equip an invalid type of weapon

        Hero hero = new Warrior("Shen");
        Weapon weapon = new Weapon(null, 1, WeaponType.STAFF, 0);

        Assertions.assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void testWeaponEquip() {  //tests if the weapon is equipped properly

        Hero hero = new Warrior("Shen");
        Weapon weapon = new Weapon("Black Cleaver", 1, WeaponType.AXE, 10);

        try {
            hero.equip(weapon);
        }catch(InvalidWeaponException e){}

        Assertions.assertEquals("Black Cleaver", hero.getEquipment().get(Slot.WEAPON).getName());
        Assertions.assertEquals(1, hero.getEquipment().get(Slot.WEAPON).getRequiredLevel());
        Assertions.assertEquals(WeaponType.AXE, ((Weapon)hero.getEquipment().get(Slot.WEAPON)).getWeaponType());
        Assertions.assertEquals(10, ((Weapon) hero.getEquipment().get(Slot.WEAPON)).getWeaponDamage());
    }

    @Test
    void testArmorEquip() {  //tests if the armor is equipped properly

        Hero hero = new Warrior("Shen");
        Armor armor = new Armor(ArmorType.MAIL,"Thornmail", 1, Slot.HEAD, new HeroAttribute(1,2,3));

        try {
            hero.equip(armor);
        }catch(InvalidArmorException e){}

        Assertions.assertEquals("Thornmail", hero.getEquipment().get(Slot.HEAD).getName());
        Assertions.assertEquals(1, hero.getEquipment().get(Slot.HEAD).getRequiredLevel());
        Assertions.assertEquals(ArmorType.MAIL, ((Armor)hero.getEquipment().get(Slot.HEAD)).getArmorType());
        Assertions.assertEquals(1, ((Armor) hero.getEquipment().get(Slot.HEAD)).getArmorAttribute().getStrength());
        Assertions.assertEquals(2, ((Armor) hero.getEquipment().get(Slot.HEAD)).getArmorAttribute().getDexterity());
        Assertions.assertEquals(3, ((Armor) hero.getEquipment().get(Slot.HEAD)).getArmorAttribute().getIntelligence());
    }

    @Test
    void testArmorEquipUnderleveled() {  //tests if the InvalidArmorException is thrown properly when hero is underleveled

        Hero hero = new Warrior("Shen");
        Armor armor = new Armor(null, null, 2, null, null);

        Assertions.assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
    }

    @Test
    void testArmorEquipWrongType() { //tests if the InvalidArmorException is thrown properly when hero tries to equip an invalid type of armor

        Hero hero = new Warrior("Shen");
        Armor armor = new Armor(ArmorType.CLOTH, null, 1, null, null);

        Assertions.assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
    }


    @Test
    void testIfWeaponEquipable() { //tests if the weapon is equippable according to hero's weapon valid list

        Hero hero = new Warrior("Shen");
        Weapon weapon = new Weapon(null, 0, WeaponType.AXE, 0);

        assertTrue(hero.getValidWeaponTypes().contains(weapon.getWeaponType()));

    }

    @Test
    void testIfWeaponNotEquipable() {  //tests if the weapon is not equippable according to hero's weapon valid list

        Hero hero = new Warrior("Shen");
        Weapon weapon = new Weapon(null, 0, WeaponType.DAGGER, 0);

        assertFalse(hero.getValidWeaponTypes().contains(weapon.getWeaponType()));

    }

    @Test
    void testIfArmorEquipable() { //tests if the armor is equippable according to hero's weapon valid list

        Hero hero = new Mage("Veigar");
        Armor armor = new Armor(ArmorType.CLOTH, null, 0, null, null);

        assertTrue(hero.getValidArmorTypes().contains(armor.getArmorType()));

    }

    @Test
    void testIfArmorNotEquipable() {  //tests if the armor is not equippable according to hero's weapon valid list

        Hero hero = new Mage("Veigar");
        Armor armor = new Armor(ArmorType.PLATE, null, 0, null, null);

        assertFalse(hero.getValidArmorTypes().contains(armor.getArmorType()));

    }

    @Test
    void testTotalAttributesCalculationNoEquipment() {  //tests if hero's attributes are calculated properly, when he has no equipment

        Hero hero = new Warrior("Shen");

        Assertions.assertEquals(5, hero.totalAttributes().getStrength());
        Assertions.assertEquals(2, hero.totalAttributes().getDexterity());
        Assertions.assertEquals(1, hero.totalAttributes().getIntelligence());
    }

    @Test
    void testTotalAttributesCalculationOnePieceOfArmor() {  //tests if hero's attributes are calculated properly, when he has one piece of armor equipped

        Hero hero = new Warrior("Shen");
        Armor armor = new Armor(ArmorType.PLATE, null, 1, Slot.BODY, new HeroAttribute(1,2,3));

        try {
            hero.equip(armor);
        }catch(InvalidArmorException e){}

        HeroAttribute totalAttributes = hero.totalAttributes();

        Assertions.assertEquals(6, totalAttributes.getStrength());
        Assertions.assertEquals(4, totalAttributes.getDexterity());
        Assertions.assertEquals(4, totalAttributes.getIntelligence());
    }

    @Test
    void testTotalAttributesCalculationTwoPiecesOfArmor() {  //tests if hero's attributes are calculated properly, when he has two pieces of armor equipped

        Hero hero = new Warrior("Shen");
        Armor armor = new Armor(ArmorType.PLATE, null, 1, Slot.BODY, new HeroAttribute(1,2,3));
        Armor armor2 = new Armor(ArmorType.MAIL, null, 1, Slot.HEAD, new HeroAttribute(3,2,1));

        try {
            hero.equip(armor);
            hero.equip(armor2);
        }catch(InvalidArmorException e){}

        HeroAttribute totalAttributes = hero.totalAttributes();

        Assertions.assertEquals(9, totalAttributes.getStrength());
        Assertions.assertEquals(6, totalAttributes.getDexterity());
        Assertions.assertEquals(5, totalAttributes.getIntelligence());
    }

    @Test
    void testTotalAttributesCalculationReplaceArmor() {  //tests if hero's attributes are calculated properly, when he has one piece of armor equipped and then
                                                        //his armor is replaced by another item
        Hero hero = new Warrior("Shen");
        Armor armor = new Armor(ArmorType.PLATE, null, 1, Slot.BODY, new HeroAttribute(1,2,3));
        Armor armor2 = new Armor(ArmorType.MAIL, null, 1, Slot.BODY, new HeroAttribute(3,2,1));

        try {
            hero.equip(armor);
        }catch(InvalidArmorException e){}

        try {
            hero.equip(armor2);
        }catch(InvalidArmorException e){}

        HeroAttribute totalAttributes = hero.totalAttributes();

        Assertions.assertEquals(8, totalAttributes.getStrength());
        Assertions.assertEquals(4, totalAttributes.getDexterity());
        Assertions.assertEquals(2, totalAttributes.getIntelligence());
    }

    @Test
    void testCalculateDamageNoWeapon() {  //tests if hero's damage is calculated properly, when he has no weapon equipped

        Hero hero = new Warrior("Shen");


        Assertions.assertEquals(1.05, hero.heroDamage());
    }

    @Test
    void testCalculateDamageWithWeapon() {  //tests if hero's damage is calculated properly, when he has a weapon equipped

        Hero hero = new Warrior("Shen");
        Weapon weapon = new Weapon(null, 1, WeaponType.AXE, 10);

        try {
            hero.equip(weapon);
        }catch(InvalidWeaponException e){}

        Assertions.assertEquals(10.5, hero.heroDamage());
    }

    @Test
    void testCalculateDamageReplaceWeapon() { //tests if hero's damage is calculated properly, when he has a weapon equipped and then it's replaced by another weapon

        Hero hero = new Warrior("Shen");
        Weapon weapon = new Weapon(null, 1, WeaponType.AXE, 5);
        Weapon weapon2 = new Weapon(null, 1, WeaponType.SWORD, 10);

        try {
            hero.equip(weapon);
        }catch(InvalidWeaponException e){}

        try {
            hero.equip(weapon2);
        }catch(InvalidWeaponException e){}

        Assertions.assertEquals(10.5, hero.heroDamage());
    }

    @Test
    void testCalculateDamageWeaponAndArmor() { //tests if hero's damage is calculated properly, when he has both weapon and a piece of armor equipped

        Hero hero = new Warrior("Shen");
        Weapon weapon = new Weapon(null, 1, WeaponType.AXE, 10);
        Armor armor = new Armor(ArmorType.MAIL, null, 1, Slot.BODY, new HeroAttribute(3,2,1));

        try {
            hero.equip(weapon);
        }catch(InvalidWeaponException e){}

        try {
            hero.equip(armor);
        }catch(InvalidArmorException e){}

        Assertions.assertEquals(10.8, hero.heroDamage());
    }

    @Test
    void testHeroDisplay() {  //test if the hero's state is displayed properly

        Hero hero = new Warrior("Shen");

        StringBuilder s = new StringBuilder("Name: Shen\nClass: Heroes.Warrior\nLevel: 1\nTotal Strength: 5\nTotal Dexterity: 2\nTotal Intelligence: 1\nDamage: 1,05");

        String st = s.toString();
        String st2 = hero.display().toString();

        Assertions.assertEquals(st, st2);
    }

}