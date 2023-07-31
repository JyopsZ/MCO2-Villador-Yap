import java.util.ArrayList;

/**
 * RegularVendingMachine is a child class of the VendingMachine. It is only able to sell regular items.
 * UnsellableItems and ComboItems are not included in it.
 */
public class RegularVendingMachine extends VendingMachine {


    /**
     * Constructor for RegularVendingMachine.
     * Invokes the super keyword to invoke the constructor of the VendingMachine parent class.
     *
     * @param items - The ArrayList of ArrayLists containing each itemList (siomaiList, hakaoList...) which in turn has
     *                  initially 10 instances of their respective items (siomai x10, hakao x10...).
     * @param denominations - The ArrayLsit of ArrayLists containing each denominationList (hundredList, fiftyList...) which in turn has
     *                             initially 10 instances of their respective items (hundred x10, fifty x10...).
     */
    public RegularVendingMachine(ArrayList<ArrayList<Item>> items, ArrayList<ArrayList<Denomination>> denominations) {
        super(items, denominations);
    }

    /**
     * The method viewCurrentStock takes in the itemList parameters and gets each ArrayList's size to determine the amount of stock each item has.
     * Then adds each number of stock to an ArrayList in a specific order.
     *
     * @param siomaiList - itemList containing all instances of siomai.
     * @param hakaoList - itemList containing all instances of hakao.
     * @param wantonList - itemList containing all instances of wanton.
     * @param fishCakeList - itemList containing all instances of fish cake.
     * @param asadoList - itemList containing all instances of pork asado.
     * @param eggList - itemList containing all instances of scrambled egg.
     * @param riceList - itemList containing all instances of plain rice.
     * @param noodlesList - itemList containing all instances of plain noodles.
     * @return stock - The ArrayList containing the integer stock of each itemList.
     */
    public ArrayList<Integer> viewCurrentStock(ArrayList<Item> siomaiList, ArrayList<Item> hakaoList, ArrayList<Item> wantonList, ArrayList<Item> fishCakeList,
                                                  ArrayList<Item> asadoList, ArrayList<Item> eggList, ArrayList<Item> riceList, ArrayList<Item> noodlesList) {

        ArrayList<Integer> stock = new ArrayList<>(); // Instantiates a new ArrayList to save the integers representing the stock of each item in the machine

        stock.add(siomaiList.size()); // Adds the quantity of siomai items currently in the siomaiList to index 0 of the stock ArrayList.
        stock.add(hakaoList.size()); // Does the same for each itemList.
        stock.add(wantonList.size());
        stock.add(fishCakeList.size());
        stock.add(asadoList.size());
        stock.add(eggList.size());
        stock.add(riceList.size());
        stock.add(noodlesList.size());

        return stock;
    }

    /**
     * A method that restocks the current amount of items into exactly 10 instances of each.
     * It does this by accepting an item as a parameter (ex. siomai), and "cloning" this item to the ArrayList of that specific
     * item which is also passed as a parameter (ex. siomaiList).
     *
     * @param siomai - Item parameter representing the siomai Item.
     * @param siomaiList - ArrayList of siomai Items.
     * @param hakao - Item parameter representing the hakao Item.
     * @param hakaoList - ArrayList of hakao Items.
     * @param wanton - Item parameter representing the wanton Item.
     * @param wantonList - ArrayList of wanton Items.
     * @param fishcake - Item parameter representing the fish cake Item.
     * @param fishCakeList - ArrayList of fishcake Items.
     * @param asado - Item parameter representing the pork asado Item.
     * @param asadoList - ArrayList of asado Items.
     * @param egg - Item parameter representing the scrambled egg Item.
     * @param eggList - ArrayList of egg Items.
     * @param rice - Item parameter representing the plain rice Item.
     * @param riceList - ArrayList of rice Items.
     * @param noodles - Item parameter representing the plain noodles Item.
     * @param noodlesList- ArrayList of noodles Items.
     */
    public void restockItems(Item siomai, ArrayList<Item> siomaiList, Item hakao, ArrayList<Item> hakaoList, Item wanton, ArrayList<Item> wantonList, Item fishcake, ArrayList<Item> fishCakeList,
                             Item asado, ArrayList<Item> asadoList, Item egg, ArrayList<Item> eggList, Item rice, ArrayList<Item> riceList, Item noodles, ArrayList<Item> noodlesList) {

        while (siomaiList.size() != 10) { // Iterates as long as there are not 10 instances of siomai in the siomaiList ArrayList.

            siomaiList.add(siomai); // Adds 1 instance of siomai while there are not 10 instances of siomai in the list.
        }

        while (hakaoList.size() != 10) { // The same logic applied to the siomai and siomaiList are applied to the rest of the items.

            hakaoList.add(hakao);
        }

        while (wantonList.size() != 10) {

            wantonList.add(wanton);
        }

        while (fishCakeList.size() != 10) {

            fishCakeList.add(fishcake);
        }

        while (asadoList.size() != 10) {

            asadoList.add(asado);
        }

        while (eggList.size() != 10) {

            eggList.add(egg);
        }

        while (riceList.size() != 10) {

            riceList.add(rice);
        }

        while (noodlesList.size() != 10) {

            noodlesList.add(noodles);
        }
    }
}
