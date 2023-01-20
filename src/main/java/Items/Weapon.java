package Items;

public class Weapon extends Item{

    private final WeaponType weaponType; //type of weapon
    private final int weaponDamage; //weapon damage

    public Weapon(String name, int requiredLevel, WeaponType weaponType, int weaponDamage) { //constructor of weapons
        super(name, requiredLevel, Slot.WEAPON);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }
}
