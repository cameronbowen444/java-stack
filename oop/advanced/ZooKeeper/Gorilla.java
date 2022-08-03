public class Gorilla extends Mammal {

    public Gorilla(int energyLevel) {
        super(energyLevel);
    }

    public void throwSomething() {
        this.energyLevel -= 5;
        System.out.println("toss! toss! toss! Energy Decresed: " + this.energyLevel);
    }
    public void eatBannana() {
        this.energyLevel += 10;
        System.out.println("toss! toss! toss! Energy Decresed: " + this.energyLevel);
    }

    public void climb() {
        this.energyLevel -= 10;
        System.out.println("toss! toss! toss! Energy Decresed: " + this.energyLevel);
    }
}