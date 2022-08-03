public class TestGorilla {

    public static void main(String[] args) {

        Gorilla perfomAction = new Gorilla(100);

        perfomAction.displayEnergy();
        perfomAction.throwSomething();
        perfomAction.throwSomething();
        perfomAction.throwSomething();
        perfomAction.throwSomething();
        perfomAction.displayEnergy();

        perfomAction.climb();
        perfomAction.climb();
        perfomAction.displayEnergy();

        perfomAction.eatBannana();
        perfomAction.eatBannana();
        perfomAction.eatBannana();
        perfomAction.eatBannana();
        perfomAction.displayEnergy();

        // Bat batAction = new Bat(300);


        // batAction.displayEnergy();
        // batAction.fly();
        // batAction.eatHumans();
        // batAction.attackTown();

    }
}