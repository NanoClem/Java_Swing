
public class King extends Character
{
    public King(WeaponBehavior w) {
        super(w);
    }

    public void fight() {
        System.out.println("The king is fighting !");
        this.weapon.useWeapon();
    }
}