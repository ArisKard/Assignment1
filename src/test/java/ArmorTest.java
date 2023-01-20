import Heroes.HeroAttribute;
import Items.Armor;
import Items.ArmorType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArmorTest {

    @Test
    public void testArmorType(){

        Armor armor = new Armor(ArmorType.LEATHER,null, 0, null, null);

        Assertions.assertEquals(ArmorType.LEATHER, armor.getArmorType());
    }

    @Test
    public void testArmorAttributes(){

        HeroAttribute armorAttribute = new HeroAttribute(1,2,3);
        Armor armor = new Armor(null,null, 0, null, armorAttribute);

        Assertions.assertEquals(1, armorAttribute.getStrength());
        Assertions.assertEquals(2, armorAttribute.getDexterity());
        Assertions.assertEquals(3, armorAttribute.getIntelligence());
    }

}