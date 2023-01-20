import Exceptions.InvalidArmorException;
import Exceptions.InvalidWeaponException;
import Heroes.*;
import Items.*;

public class Main {

    public static void main(String[] args){

       Warrior warrior = new Warrior("Shen");
       Mage mage = new Mage("Veigar");
       Rogue rogue = new Rogue("Talon");
       Ranger ranger = new Ranger("Ashe");

       Weapon axe = new Weapon("Black Cleaver", 2, WeaponType.AXE, 6);
       Weapon sword = new Weapon("Wit's End", 1, WeaponType.SWORD, 4);
       Weapon hammer = new Weapon("Divine Sunderer", 3, WeaponType.HAMMER, 8);
       Weapon bow = new Weapon("Kraken Slayer", 1, WeaponType.BOW, 7);
       Weapon dagger = new Weapon("Duskblade of Draktharr", 1, WeaponType.DAGGER, 10);
       Weapon staff = new Weapon("Void Staff", 1, WeaponType.STAFF, 5);
       Weapon wand = new Weapon("Wand of Ages", 2, WeaponType.WAND, 9);

       Armor bodyMail = new Armor(ArmorType.MAIL, "Thornmail", 2, Slot.BODY, new HeroAttribute(4,2,1));
       Armor legsPlate = new Armor(ArmorType.PLATE, "Plated Steelcaps", 1, Slot.LEGS, new HeroAttribute(2,2,1));
       Armor headPlate = new Armor(ArmorType.PLATE, "Demonic Embrace", 3, Slot.HEAD, new HeroAttribute(4,1,2));

       Armor bodyCloth = new Armor(ArmorType.CLOTH, "Negatron Cloak", 2, Slot.BODY, new HeroAttribute(1,1,4));
       Armor legsCloth = new Armor(ArmorType.CLOTH, "Sorcerer's Shoes", 1, Slot.LEGS, new HeroAttribute(1,2,3));
       Armor headCloth = new Armor(ArmorType.CLOTH, "Rabadon's Deathcap", 3, Slot.HEAD, new HeroAttribute(1,2,7));

       Armor legsLeather = new Armor(ArmorType.LEATHER, "Ionian Boots of Lucidity", 1, Slot.LEGS, new HeroAttribute(1,3,1));
       Armor bodyLeather = new Armor(ArmorType.LEATHER, "Edge of Night", 2, Slot.BODY, new HeroAttribute(1,4,2));
       Armor headLeather = new Armor(ArmorType.LEATHER, "Abyssal Mask", 3, Slot.HEAD, new HeroAttribute(2,5,2));
       Armor headLeather2 = new Armor(ArmorType.LEATHER, "Liandry's Anguish", 3, Slot.HEAD, new HeroAttribute(3,4,3));

       System.out.println("No weapons: "); System.out.println(warrior.display().append(mage.display()).append(rogue.display()).append(ranger.display())); //display

       try{warrior.equip(sword); mage.equip(staff); rogue.equip(dagger); ranger.equip(bow);}catch(
               InvalidWeaponException e){System.out.println(e.getMessage());}; //equipment of weapons

       System.out.println("With weapons: "); System.out.println(warrior.display().append(mage.display()).append(rogue.display()).append(ranger.display())); //display

       try{warrior.equip(legsPlate); mage.equip(legsCloth); rogue.equip(legsLeather); ranger.equip(legsLeather);}catch(
               InvalidArmorException e){System.out.println(e.getMessage());}; //equipment of armor level 1

       System.out.println("With weapons and armor: "); System.out.println(warrior.display().append(mage.display()).append(rogue.display()).append(ranger.display())); //display

       warrior.levelUp(); mage.levelUp(); rogue.levelUp(); ranger.levelUp();  //level up

       try{warrior.equip(axe); mage.equip(wand);}catch(InvalidWeaponException e){System.out.println(e.getMessage());} //equipment of weapons level 2

       try{warrior.equip(bodyMail); mage.equip(bodyCloth); rogue.equip(bodyLeather); ranger.equip(bodyLeather);}catch(InvalidArmorException e){System.out.println(e.getMessage());} //equipment of armor level 2

       System.out.println("With weapons and armor level 2: "); System.out.println(warrior.display().append(mage.display()).append(rogue.display()).append(ranger.display())); //display

       warrior.levelUp(); mage.levelUp(); rogue.levelUp(); ranger.levelUp(); // level up

       try{warrior.equip(hammer);}catch(InvalidWeaponException e){System.out.println(e.getMessage());} //equipment of weapons level 3

       try{warrior.equip(headPlate); mage.equip(headCloth); rogue.equip(headLeather); ranger.equip(headLeather2);}catch(InvalidArmorException e){System.out.println(e.getMessage());}; //equipment of armor level 3

       System.out.println("With weapons and armor level 3: "); System.out.println(warrior.display().append(mage.display()).append(rogue.display()).append(ranger.display())); //display

    }
}
