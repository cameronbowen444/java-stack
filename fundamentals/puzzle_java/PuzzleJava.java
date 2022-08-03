import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {

        ArrayList<Integer> random10 = new ArrayList<Integer>();
        Random numMachine = new Random();
        for(int i = 1; i <= 10; i++) {
            random10.add(numMachine.nextInt(20) + 1);
        }
        return random10;
    }



    public String getRandomLetter() {
        Random letterMachine = new Random();

        String alphaString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = String.valueOf(alphaString.charAt(i));
        }
        return alphabet[letterMachine.nextInt(26)];
    }
}

