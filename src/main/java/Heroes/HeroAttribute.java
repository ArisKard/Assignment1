package Heroes;

public class HeroAttribute {

    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {     //constructor of a HeroAttribute instance
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void levelUp(int str, int dext, int intel){                      //level up of hero's base attributes, when the hero is leveled up

        strength+=str;
        dexterity+=dext;
        intelligence+=intel;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }
}
