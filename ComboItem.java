import java.util.ArrayList;

/**
 * This class is a child of the "Item" class. It represents a special item that can
 *  only be purchased in the special vending machine. It has an array of Item attribute
 *  which stores the add-on items which will become part of this ComboItem
 */
public class ComboItem extends Item{

    private ArrayList<Item> addOns; // ArrayList of included add-ons

    /**
     * Constructor of ComboItem that takes in the same parameters as a regular Item
     *
     * @param name - The String representing the name of the ComboItem
     * @param price - The double price of the ComboItem based on the sub-items inside it
     * @param calories - The integer calories of the ComboItem, also based on sub-items in it.
     */
    public ComboItem(String name, double price, int calories) {

        super(name, price, calories); // Invokes the constructor of the parent class Item
        this.addOns = new ArrayList<>(); // An additional attribute exclusive to the ComboItem class which represents
                                         // the additional items added onto this special item.
    }

    /**
     * Method to get the Add-ons (list of additional items) selected by the user for the ComboItem.
     *
     * @return addOns - The ArrayList of Items containing the items inside the ComboItem.
     */
    public ArrayList<Item> getAddOns (){

        return addOns;
    }

    /**
     * Method to get one item in the addOns ArrayList of items.
     *
     * @param index - The index of the item we wish to get.
     * @return - The item relative to the index passed as a parameter.
     */
    public Item getSpecificAddOn (int index) {

        return addOns.get(index);
    }

    /**
     * Method to set an add-On to the ArrayList of items.
     *
     * @param item - The specific item the user wishes to add into the ComboItem.
     */
    public void setAddOns (Item item) {

        this.addOns.add(item);
    }

    /**
     * Method to update the price and calories of the ComboItem.
     * It does this by using a for each loop to iterate over every item currently in the ArrayList,
     * and incrementing the price and calories accordingly.
     */
    public void updateCombo() {

        for (Item item : addOns) { // Iterate over every Item in the ArrayList

            setPrice(getPrice() + item.getPrice()); // set the price to the current price + the price of the item per iteration
            setCalories(getCalories() + item.getCalories()); // same logic for calories
        }
    }
}
