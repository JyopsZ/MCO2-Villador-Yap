/**
 * This class represents an item in a Vending Machine
 * It contains information about an item such as name, price and calories.
 * The class provides getter and setter methods for accessing and modifying these properties.
 */

public class Item {

    private String name;
    private double price;
    private int calories;

    /**
     * Constructor to initialize the item with its properties.
     *
     * @param name - String name of Item
     * @param price - double value referring to price of Item
     * @param calories - int value referring to amount of calories in Item
     */
    public Item(String name, double price, int calories) {

        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    /**
     * Getter for the Name of the Item
     *
     * @return name - name of item
     */
    public String getName() {

        return name;
    }

    /**
     * Getter for the Price of the Item
     *
     * @return price - decimal price of Item
     */
    public double getPrice() {

        return price;
    }

    /**
     * Setter for the Price of the Item
     *
     * @param price - Price of item to be set
     */
    public void setPrice(double price) {

        this.price = price;
    }


    /**
     * Getter for the Calories the Item contains
     *
     * @return calories - amount of calories in Item
     */
    public int getCalories() {

        return calories;
    }

    /**
     * Setter for the Calories the Item contains
     *
     * @param calories - the integer amount of calories the user wishes to set for the Item.
     */
    public void setCalories(int calories) {

        this.calories = calories;
    }

}
