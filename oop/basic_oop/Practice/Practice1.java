public class Practice1 {
    private int age;
    private String name;
    private static int numberOfPeople = 0;

    public Practice1 (int ageOfPerson, String nameOfPerson) {
        age = ageOfPerson;
        name = nameOfPerson;
        numberOfPeople++;
    }

    public static int peopleCount() {
        return numberOfPeople;
    }
}