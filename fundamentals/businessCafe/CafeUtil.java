import java.util.ArrayList;
import java.util.Arrays;
public class CafeUtil {

    public Integer getStreakGoal(){
        return 55;
    }

    public Double getOrderTotal(double[] prices) {
        Double total = 0.0;
        for(double price: prices){
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for(int i = 0; i < menuItems.size(); i++){
            String name = menuItems.get(i);
            System.out.printf("%s \n", name, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello " + userName + "!");
        System.out.printf("There are %s ahead of you! \n", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }
}

