import java.util.Arrays;
import java.util.ArrayList;

public class TestBankAccount {

    public static void main(String[] args) {

        BankAccount bank1 = new BankAccount();
        bank1.depositMoney(100.00, "checking");
        bank1.depositMoney(4554.00, "savings");
        bank1.withdrawMoney(30.00, "checking");
        bank1.withdrawMoney(30.00, "checking");
        bank1.showStatements();
        BankAccount bank2 = new BankAccount();


        BankAccount bank3 = new BankAccount();


        System.out.println(BankAccount.numberOfAccounts);
    }
}