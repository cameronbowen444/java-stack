import java.util.ArrayList;
import java.util.Arrays;
public class TestPractice {

    public static void main(String[] args) {
        
        Practice testRun = new Practice();

        testRun.chaiLatte();

        testRun.americano("Robert \n");
        testRun.americano("Cameron \n");

        testRun.buildArray();

        testRun.sayHello();
        testRun.greetOne("Cameron \n");
        testRun.allParties();


        System.out.println(testRun.buildCustomerArrayList());
        System.out.println(testRun.randomItems());
    }
}