// Importing the utilites we will need to do this properly
import java.util.Arrays;
import java.util.ArrayList;

// public method class file used for public or private member variables and methods for features to our application
// Private and Public are known as (ACCESS MODIFIERS so our computer understands how we are using variables, methods, etc...)
public class Item {
    // private variables for preventing access from other parts for application, and are accessed through getters and setters
    private String name; // MEMBER VARIABLE, ATTRIBUTE, FIELD VALUE OR INSTANCE VARIABLE (NAME)
    private double price;

    // This is Our CONSTRUCTOR, we used it so that we excute a block of code in one line for our test file
    public Item(String name, Double price) { // Parmeter doesn't have to be same name as member variable and if its same then we have to use this below
        this.name = name; // With (THIS) keyword specified , it means were talking about member variable, not parameter
        this.price = price;
    }

    // GETTER: retrives feild value AKA private member variable
    public String getNameItem() {
        return this.name;
    }
    // SETTER: sets feild value AKA private member variable
    public void setName(String name) {
        this.name = name;
    }
    public Double getPriceItem() {
        return this.price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }


// Note: Remember that field, attribute, and member variable all refer to the same thing.
}
