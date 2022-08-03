public class Bat extends Mammal {
    public Bat(int energyLevel) {
        super(energyLevel);
    }
    public int displayEnergy() {
        System.out.println("The Bats Energy Level Is: " + this.energyLevel);
        return this.energyLevel;
    }

    public void fly() {
        this.energyLevel -= 50;
        System.out.println("You're flying, Energy decreased: " + this.energyLevel);
    }

    public void eatHumans() {
        this.energyLevel += 25;
        System.out.println("Munch! Munch! Munch! Delicious Humans, Energy increased: " + this.energyLevel);
    }

    public void attackTown() {
        this.energyLevel -= 100;
        System.out.println("ahhhh! Help! Help! We're Being attacked my Bats!!! Energy Decreased: " + this.energyLevel);
        
    }
}