public class CafeJava {
    public static void main(String[] args) {
        String generalGreetings = "Welcome to Cafe Java, ";
        String pendingMessage = ", Your order will be ready shortly";
        String readyMessage = ", Your order is ready";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.5;
        double dripCoffee = 2.5;
        int lattePrice = 4;
        double cappucinoPrice = 4.5;

        double LargeMochaPrice = 4.5;
        double LargeDripCoffee = 3.5;
        int LargeLattePrice = 5;
        double LargeCappucinoPrice = 5.5;



        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";



        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;

        // Cinddhuri 
        System.out.println(generalGreetings + customer1 + pendingMessage  + ". " + displayTotalMessage + dripCoffee);
        isReadyOrder1 = true;
        System.out.println(customer1 + readyMessage);

        // Noah
        System.out.println(generalGreetings + customer4 + pendingMessage  + ". " + displayTotalMessage + cappucinoPrice);
        isReadyOrder4 = true;

        if (isReadyOrder4 == false){
            System.out.println(customer4 + pendingMessage);
        }
        else {
            System.out.println(customer4 + readyMessage);
        }

        // Sam
        System.out.println(generalGreetings + customer2 + pendingMessage  + ". " + displayTotalMessage + (lattePrice * 2));
        isReadyOrder2 = true;

        if (isReadyOrder2 == false){
            System.out.println(generalGreetings + customer2 + pendingMessage);
        }
        else {
            System.out.println(customer2 + readyMessage);
        }

        //Jimmy
        System.out.println(generalGreetings + customer3 + pendingMessage  + ". " + displayTotalMessage + lattePrice);
        isReadyOrder3 = true;
        System.out.println(customer3 + readyMessage);
        System.out.println("It says on the recipt I paid for a coffee instead of a latte. I owe you $" + (lattePrice - dripCoffee));
        System.out.println("Thanks, See you again soon " + customer3);
    }
}