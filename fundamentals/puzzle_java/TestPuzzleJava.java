import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class TestPuzzleJava {
    
    public static void main(String[] args) {

        PuzzleJava generator = new PuzzleJava();


        System.out.println(generator.getTenRolls());

        System.out.println(generator.stringArray());
        

        System.out.println(generator.getRandomLetter());
    }
}
