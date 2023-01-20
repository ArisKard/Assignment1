import Items.Armor;
import Items.Item;
import Items.Slot;
import Items.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    public void testWeaponName(){

        String name = "Black Cleaver";
        Item item = new Weapon(name, 0, null, 0);

        Assertions.assertEquals(name, item.getName());
    }

    @Test
    public void testArmorName(){

        String name = "Thornmail";
        Item item = new Armor(null, name, 0, null, null);

        Assertions.assertEquals(name, item.getName());
    }

    @Test
    public void testWeaponRequiredLevel(){

        Item item = new Weapon(null, 5, null, 0);

        Assertions.assertEquals(5, item.getRequiredLevel());
    }

    @Test
    public void testArmorRequiredLevel(){

        Item item = new Armor(null,null, 5, null, null);

        Assertions.assertEquals(5, item.getRequiredLevel());
    }

    @Test
    public void testWeaponSlot(){

        Item item = new Weapon(null, 0, null, 0);

        Assertions.assertEquals(Slot.WEAPON, item.getSlot());
    }

    @Test
    public void testArmorSlot(){

        Item item = new Armor(null,null, 0, Slot.HEAD, null);

        Assertions.assertEquals(Slot.HEAD, item.getSlot());
    }

}