import Items.Weapon;
import Items.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeaponTest {

    @Test
    public void testWeaponType(){ //tests if the weapon type is properly assigned

        Weapon weapon = new Weapon(null, 0, WeaponType.SWORD, 0);

        Assertions.assertEquals(WeaponType.SWORD, weapon.getWeaponType());
    }

    @Test
    public void testWeaponDamage(){ //tests if the weapon's damage is properly assigned

        Weapon weapon = new Weapon(null, 0, WeaponType.SWORD, 10);

        Assertions.assertEquals(10, weapon.getWeaponDamage());
    }
}