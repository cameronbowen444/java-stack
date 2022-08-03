import java.util.Arrays;
import java.util.ArrayList;

public class OrderTest {

    //main file used for testing our applicaiton and making it more user friendly
    public static void main(String[] args) {
        // THIS current Item will hold these values, which is passed in the constructor and understands that we are talking about the CURENT new item unless it has defaults
        Item item1 = new Item("Mocha", 3.5);
        Item item2 = new Item("Latte", 4.5);
        Item item3 = new Item("Drip Coffee", 2.5);
        Item item4 = new Item("Capuccino", 5.5);

        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Cameron \n");
        Order order4 = new Order("James \n");
        Order order5 = new Order("Jacob \n");

        order3.addItem(item1);
        order3.addItem(item3);
        order3.addItem(item4);

        // When GETTING, we are returning in the previous file so we can access here to print in our terminal (GETTERs)
        System.out.println(order3.getStatusMessage());

        // When SETTING, we are defining in the previous file so we can define something to change/ alter/ create functionality
        // YOu can see we SET this order from being false to true (SETTERs)
        System.out.println(order3.getStatusMessage());

        System.out.println(order3.getOrderTotal());

        order4.addItem(item1);
        order4.addItem(item4);
        order5.addItem(item2);
        order3.display();
        order3.setReady(true);
        order4.display();
        order4.setReady(true);
        order5.display();
        order5.setReady(true);




        // Item item2 = new Item();
        // Item item3 = new Item();
        // Item item4 = new Item();



        // Item item1 = new Item();
        // item1.name = "Mocha";
        // item1.price = 3.5;
        
        // Item item2 = new Item();
        // item2.name = "Latte";
        // item2.price = 4.5;

        // Item item3 = new Item();
        // item3.name = "Drip Coffee";
        // item3.price = 2.5;

        // Item item4 = new Item();
        // item4.name = "Capuccino";
        // item4.price = 5.5;



        // Order order1 = new Order();
        // order1.name = "Cindhuri";
        // order1.total = 0.0;
        // order1.ready = false;

        // Order order2 = new Order();
        // order2.name = "Jimmy";
        // order2.total = 0.0;
        // order2.ready = false;

        // Order order3 = new Order();
        // order3.name = "Noah";
        // order3.total = 0.0;
        // order3.ready = false;

        // Order order4 = new Order();
        // order4.name = "Sam";
        // order4.total = 0.0;
        // order4.ready = false;


        // System.out.println("\n------Menu Items------");
        // System.out.printf("%s --- $%.2f \n", item1.name, item1.price);
        // System.out.printf("%s --- $%.2f \n", item2.name, item2.price);
        // System.out.printf("%s --- $%.2f \n", item3.name, item3.price);
        // System.out.printf("%s --- $%.2f \n\n", item4.name, item4.price);
        
        // order1.total += item3.price;
        // System.out.printf("Hey %s, you ordered a %s, that'll be $%.2f \n", order1.name, item3.name, order1.total);
        // order1.ready = true;
        // System.out.printf("Hey %s, your order is ready! \n", order1.name);

        // order2.total += item1.price;
        // System.out.printf("Hey %s, you ordered a %s, that'll be $%.2f \n", order2.name, item1.name, order2.total); 

        // order3.total += item4.price;
        // System.out.printf("Hey %s, you ordered a %s, that'll be $%.2f \n", order3.name, item4.name, order3.total);

        // order4.total += item2.price;
        // System.out.printf("Hey %s, you ordered a %s, that'll be $%.2f \n", order4.name, item2.name, order4.total);
        // order4.total += item2.price * 2;
        // System.out.printf("Hey %s, you ordered 2 more %s, that'll be $%.2f \n", order4.name, item2.name, order4.total);
        // order4.ready = true;
        // System.out.printf("Hey %s, your order is ready! \n", order4.name);

        // order2.ready = true;
        // System.out.printf("Hey %s, your order is ready! \n", order2.name);


        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n\n", order1.ready);

        // System.out.printf("Name: %s\n", order2.name);
        // System.out.printf("Total: %s\n", order2.total);
        // System.out.printf("Ready: %s\n\n", order2.ready);

        // System.out.printf("Name: %s\n", order3.name);
        // System.out.printf("Total: %s\n", order3.total);
        // System.out.printf("Ready: %s\n\n", order3.ready);

        // System.out.printf("Name: %s\n", order4.name);
        // System.out.printf("Total: %s\n", order4.total);
        // System.out.printf("Ready: %s\n\n", order4.ready);


    }
}