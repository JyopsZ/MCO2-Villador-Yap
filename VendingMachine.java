import java.util.ArrayList;

/**
 * The VendingMachine class, parent class of the RegularVendingMachine and SpecialVendingMachine.
 * Has an abstract keyword so that it cannot be instantiated.
 * All methods have protected access modifiers so that they may be accessed by the child classes.
 */
public abstract class VendingMachine {

    private double totalSales;
    protected ArrayList<ArrayList<Item>> items;
    protected ArrayList<ArrayList<Denomination>> denominations;

    /**
     * Constructor for VendingMachine
     *
     * @param items - The ArrayList of ArrayLists containing each itemList (siomaiList, hakaoList...) which in turn has
     *                  initially 10 instances of their respective items (siomai x10, hakao x10...).
     * @param denominations - The ArrayLsit of ArrayLists containing each denominationList (hundredList, fiftyList...) which in turn has
     *                             initially 10 instances of their respective items (hundred x10, fifty x10...).
     */
    public VendingMachine (ArrayList<ArrayList<Item>> items, ArrayList<ArrayList<Denomination>> denominations) {

        this.denominations = denominations; // Array of Denomination Objects
        this.items = items; // ArrayList to store the available items
        this.totalSales = 0.0; //set to 0 since it's the start of the program, also tracks the total sales
    }


    /**
     * A method to view the current amount of denominations inside the vending machine, regardless of being regular or special.
     *
     * @param hundredList - The ArrayList of hundreds used to determine the number of hundreds currently in the machine.
     * @param fiftyList - The ArrayList of fifties.
     * @param twentyList - The ArrayList of twenties.
     * @param tenList - The ArrayList of tens.
     * @param fiveList - The ArrayList of fives.
     * @param oneList - The ArrayList of ones.
     * @param fiveCentsList - The ArrayList of five cents.
     * @param twFiveCentsList - The ArrayList of twenty-five cents.
     * @return stock - The integer ArrayList that holds the stock of denominations in a specific order. Index 0 is for hundreds, index 1 is for fifties and so on.
     */
    protected ArrayList<Integer> viewCurrentDenom(ArrayList<Denomination> hundredList, ArrayList<Denomination> fiftyList, ArrayList<Denomination> twentyList, ArrayList<Denomination> tenList,
                                               ArrayList<Denomination> fiveList, ArrayList<Denomination> oneList, ArrayList<Denomination> fiveCentsList, ArrayList<Denomination> twFiveCentsList) {

        ArrayList<Integer> stock = new ArrayList<>(); // Locally instantiating an integer ArrayList to hold the stock.

        stock.add(hundredList.size()); // adds the integer stock of hundreds determined by the size of the hundreds ArrayList (hundredList)
        stock.add(fiftyList.size());   // The same goes for the rest of the denominations as the hudnreds.
        stock.add(twentyList.size());
        stock.add(tenList.size());
        stock.add(fiveList.size());
        stock.add(oneList.size());
        stock.add(fiveCentsList.size());
        stock.add(twFiveCentsList.size());

        return stock; // Returns the integer ArrayList
    }

    /**
     *  Restocks the amount of denominations in the vending machine, regardless of type.
     *
     * @param hundred - an instance of the denomination class representing 100 pesos.
     * @param hundredList - an arrayList of hundreds.
     * @param fifty - an instance of the denomination class representing 50 pesos.
     * @param fiftyList - an arrayList of fifties.
     * @param twenty - an instance of the denomination class representing 20 pesos.
     * @param twentyList - an arrayList of twenties.
     * @param ten - an instance of the denomination class representing 10 pesos.
     * @param tenList - an arrayList of tens.
     * @param five - an instance of the denomination class representing 5 pesos.
     * @param fiveList - an arrayList of fives.
     * @param one - an instance of the denomination class representing 1 peso.
     * @param oneList - an arrayList of ones.
     * @param fiveCents - an instance of the denomination class representing 5 cents (0.5 pesos).
     * @param fiveCentsList - an arrayList of five cents.
     * @param twFiveCents - an instance of the denomination class representing 25 cents (0.25 pesos).
     * @param twFiveCentsList - an arrayList of twenty-five cents.
     */
    protected void restockDenoms(Denomination hundred, ArrayList<Denomination> hundredList, Denomination fifty, ArrayList<Denomination> fiftyList, Denomination twenty, ArrayList<Denomination>
                                twentyList, Denomination ten, ArrayList<Denomination> tenList, Denomination five, ArrayList<Denomination> fiveList, Denomination one, ArrayList<Denomination>
                                    oneList, Denomination fiveCents, ArrayList<Denomination> fiveCentsList, Denomination twFiveCents, ArrayList<Denomination> twFiveCentsList) {

        while (hundredList.size() != 10) { // While there are not 10 instances of hundred Denomination in the hundredList...

            hundredList.add(hundred);           // increment the hundredList by 1 instance of hundred.
        }

        while (fiftyList.size() != 10) { // Same logic applies to the rest of the denominations and their respective ArrayLists as the hundreds.

            fiftyList.add(fifty);
        }

        while (twentyList.size() != 10) {

            twentyList.add(twenty);
        }

        while (tenList.size() != 10) {

            tenList.add(ten);
        }

        while (fiveList.size() != 10) {

            fiveList.add(five);
        }

        while (oneList.size() != 10) {

            oneList.add(one);
        }

        while (fiveCentsList.size() != 10) {

            fiveCentsList.add(fiveCents);
        }

        while (twFiveCentsList.size() != 10) {

            twFiveCentsList.add(twFiveCents);
        }
    }

    /**
     * A simple method to calculate the change needed.
     *
     * @param itemPrice - specific price of the item (double).
     * @param amountPaid - the amount paid by the user (input).
     * @return the change needed.
     */
    protected double calculateChange(double itemPrice, double amountPaid) {

        return amountPaid - itemPrice;
    }

    /**
     * Increment the total sales based on the price of the item the user selects
     *
     * @param itemPrice - The double price of the item the user selected
     */
    protected void incrementSales(double itemPrice) {

        totalSales += itemPrice; // Increments the totalSales by each price of the item each user selects.
    }

    /**
     * Getter for the total sales the current vending machine has made.
     *
     * @return totalSales
     */
    protected double getTotalSales() {

        return totalSales;
    }


    /**
     * A method to update the price of every item (ex. siomai) in an itemList (ex. siomaiList).
     *
     * @param item - The specific item that has received a price change.
     * @param itemList - The itemList that holds the instantiations of the specific item price changed.
     */
    protected void updatePrice(Item item, ArrayList<Item> itemList) {

        int itemCount = itemList.size(); // Gets the current amount of Items in the list
        itemList.clear(); // Clears the old items with outdated prices

        for (int i = 0; i < itemCount; i++) { // Adds back the same amount of items as before the price change,

            itemList.add(item);               // and adds the new items with new prices
        }

    }

    /**
     * A method to flush the totalSales, setting it back to 0 after it is called.
     *
     * @return initialSales - the totalSales before being reset to 0.0 again.
     */
    protected double collectSales() {

        double initialSales = totalSales;
        totalSales = 0.0;

        return initialSales;
    }
}


