public class TestBat {
    public static void main(String[] args){
        Bat batCity = new Bat(300);

        batCity.displayEnergy();
        batCity.attackTown();
        batCity.attackTown();
        batCity.attackTown();
        batCity.eatHumans();
        batCity.eatHumans();
        batCity.fly();
        batCity.fly();
    }
}