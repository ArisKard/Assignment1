import Heroes.HeroAttribute;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeroAttributeTest {

    @Test
    public void levelUp() {

        HeroAttribute heroAttribute = new HeroAttribute(1,2,3);
        heroAttribute.levelUp(5,10,15);

        Assertions.assertEquals(6, heroAttribute.getStrength());
        Assertions.assertEquals(12, heroAttribute.getDexterity());
        Assertions.assertEquals(18, heroAttribute.getIntelligence());
    }
}