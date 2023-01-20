import Heroes.HeroAttribute;
import Items.Armor;
import Items.ArmorType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArmorTest {

    @Test
    public void testArmorType(){  //tests if the armor type is properly assigned

        Armor armor = new Armor(ArmorType.LEATHER,null, 0, null, null);

        Assertions.assertEquals(ArmorType.LEATHER, armor.getArmorType());
    }

    @Test
    public void testArmorAttributes(){  //tests if the armor's attributes are properly assigned

        HeroAttribute armorAttribute = new HeroAttribute(1,2,3);
        Armor armor = new Armor(null,null, 0, null, armorAttribute);

        Assertions.assertEquals(1, armor.getArmorAttribute().getStrength());
        Assertions.assertEquals(2, armor.getArmorAttribute().getDexterity());
        Assertions.assertEquals(3, armor.getArmorAttribute().getIntelligence());
    }

}