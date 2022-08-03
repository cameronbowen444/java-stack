import java.util.Arrays;
import java.util.ArrayList;
public class BankAccount {
    private double checking;
    private double savings;
    public static int numberOfAccounts;
    public static double amountOfMoney;


    public BankAccount() {
        this.checking = 0.0;
        this.savings = 0.0;
        BankAccount.numberOfAccounts += 1;
    }


    public Double getchecking() {
        return this.checking;
    }
    public Double getsavings() {
        return this.savings;
    }

    public void depositMoney(Double amount, String account) {
        if(account.equals("savings")) {
            this.savings += amount;
        }
        else if(account.equals("checking")) {
            this.checking += amount;
        }
        BankAccount.amountOfMoney += amount;
    }

    public void withdrawMoney(Double amount, String account) {
        if(account.equals("savings")) {
            this.savings -= amount;
        }
        else if(account.equals("checking")) {
            this.checking -= amount;
        }
        BankAccount.amountOfMoney -= amount;
    }

    public void showStatements() {
        System.out.printf("Your Checking Balance: $%.2f, Your Savings Balance: $%.2f", this.checking, this.savings);
    }
}