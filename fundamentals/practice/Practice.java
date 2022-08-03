import java.util.ArrayList;
import java.util.Arrays;

public class Practice {
    // basic features/ data structure of java
    public void chaiLatte() {
        System.out.println("enjoy your chai latte!");
    }

    public void americano(String name) {
        System.out.printf("Here you go " + name);
    }

    // fixed array stucture
    public void buildArray() {
        int[] numbers = new int[10];
        //basic for loop after declaration for getting all numbers
        for (int i = 0;i < numbers.length; i++) {
            numbers[i] = i+1;
        }
        // Printing one
        System.out.println(numbers[0]);
        // FOR EACH LOOP (important)
        for(int i : numbers) {
            System.out.println(i);
        }
        // Getting array structure format
        System.out.println(Arrays.toString(numbers));

        String[] things = {"ball", "dog", "computer", "jar", "button", "jeans"};
        System.out.println(Arrays.toString(things));
    }

    public void sayHello() {
        System.out.println("Hello everyone!");
    }

    public void greetOne(String name) {
        System.out.printf("Hello, " + name);
    }

    public void allParties() {
        int[] people = new int[20];

        for (int i = 0; i < people.length; i++){
            people[i] = i + 1;
        }
        System.out.println(Arrays.toString(people));
        for(int i : people) {
            System.out.println(i);
        }

    }

    // ArrayLists
    public int buildCustomerArrayList() {
        ArrayList<String> customers = new ArrayList<>();
        customers.add("Carlos");
        customers.add("Cameron");
        customers.add("Nicolle");
        customers.add("James");
        customers.add("Nick");
        customers.add("Jimmy");
        System.out.println(customers);
        return customers.size();
    }

    public Object randomItems() {
        ArrayList<String> myThings = new ArrayList<>();
        myThings.add("ball");
        myThings.add("cup");
        myThings.add("mac");
        myThings.add("jar");
        myThings.add("car");
        myThings.add("coffee");
        System.out.println(myThings);
        return myThings;
    }

    //HashMaps (next topic , get other assignment done first)!!!!!!

}
