import Items.Armor;
import Items.Item;
import Items.Slot;
import Items.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    public void testWeaponName(){  //tests if the weapon's name is properly assigned

        String name = "Black Cleaver";
        Item item = new Weapon(name, 0, null, 0);

        Assertions.assertEquals(name, item.getName());
    }

    @Test
    public void testArmorName(){ //tests if the armor's name is properly assigned

        String name = "Thornmail";
        Item item = new Armor(null, name, 0, null, null);

        Assertions.assertEquals(name, item.getName());
    }

    @Test
    public void testWeaponRequiredLevel(){ //tests if the weapon's required level is properly assigned

        Item item = new Weapon(null, 5, null, 0);

        Assertions.assertEquals(5, item.getRequiredLevel());
    }

    @Test
    public void testArmorRequiredLevel(){  //tests if the armor's required level is properly assigned

        Item item = new Armor(null,null, 5, null, null);

        Assertions.assertEquals(5, item.getRequiredLevel());
    }

    @Test
    public void testWeaponSlot(){  //tests if the weapon's slot is properly assigned

        Item item = new Weapon(null, 0, null, 0);

        Assertions.assertEquals(Slot.WEAPON, item.getSlot());
    }

    @Test
    public void testArmorSlot(){  //tests if the armor's slot is properly assigned

        Item item = new Armor(null,null, 0, Slot.HEAD, null);

        Assertions.assertEquals(Slot.HEAD, item.getSlot());
    }

}