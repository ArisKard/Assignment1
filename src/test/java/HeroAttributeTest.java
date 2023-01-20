import Heroes.HeroAttribute;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeroAttributeTest {

    @Test
    public void levelUp() { //tests if hero's base attributes are properly leveled up when he levels up

        HeroAttribute heroAttribute = new HeroAttribute(1,2,3);
        heroAttribute.levelUp(5,10,15);

        Assertions.assertEquals(6, heroAttribute.getStrength());
        Assertions.assertEquals(12, heroAttribute.getDexterity());
        Assertions.assertEquals(18, heroAttribute.getIntelligence());
    }
}