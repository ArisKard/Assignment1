import Items.Weapon;
import Items.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeaponTest {

    @Test
    public void testWeaponType(){

        Weapon weapon = new Weapon(null, 0, WeaponType.SWORD, 0);

        Assertions.assertEquals(WeaponType.SWORD, weapon.getWeaponType());
    }

    @Test
    public void testWeaponDamage(){

        Weapon weapon = new Weapon(null, 0, WeaponType.SWORD, 10);

        Assertions.assertEquals(10, weapon.getWeaponDamage());
    }
}