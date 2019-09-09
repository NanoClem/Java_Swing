
public abstract class Character
{
    /**
     * 
     */
    protected WeaponBehavior weapon;

    /**
     * 
     */
    public Character(WeaponBehavior w) {
        this.weapon = w;
    }

    /**
     * 
     */
    public abstract void fight();

    /**
     * 
     */
    public void setWeapon(WeaponBehavior w) {
        this.weapon = w;
    }
}