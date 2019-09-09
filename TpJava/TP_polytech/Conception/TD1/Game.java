
public class Game {

    public static void main(String[] args) throws Exception
    {
        King robert = new King(new SwordBehavior());
        robert.fight();
    }
}