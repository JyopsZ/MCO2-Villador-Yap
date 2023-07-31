import java.util.ArrayList;

/**
 * SpecialVendingMachine child class of the VendingMachine. Makes use of the UnsellableItem and ComboItem.
 */
public class SpecialVendingMachine extends VendingMachine {

    /**
     * Constructor for VendingMachine
     *
     * @param items - The ArrayList of ArrayLists containing each itemList (siomaiList, hakaoList...) which in turn has
     *                   initially 10 instances of their respective items (siomai x10, hakao x10...).
     * @param denominations - The ArrayLsit of ArrayLists containing each denominationList (hundredList, fiftyList...) which in turn has
     *                             initially 10 instances of their respective items (hundred x10, fifty x10...).
     */
    public SpecialVendingMachine(ArrayList<ArrayList<Item>> items, ArrayList<ArrayList<Denomination>> denominations) {

        super(items, denominations);
    }

    /**
     * A method that stores the stock of each item in a locally declared ArrayList by order, to be returned in the same method.
     *
     * @param siomaiList - ArrayList of siomai items to determine the stock of siomai (size of ArrayList)
     * @param hakaoList - ArrayList of hakao items to determine the stock of hakao (size of ArrayList)
     * @param wantonList - ArrayList of wanton items to determine the stock of wanton (size of ArrayList)
     * @param fishCakeList - ArrayList of fishcake items to determine the stock of fishcake (size of ArrayList)
     * @param asadoList - ArrayList of asado items to determine the stock of asado (size of ArrayList)
     * @param eggList - ArrayList of egg items to determine the stock of egg (size of ArrayList)
     * @param riceList - ArrayList of rice items to determine the stock of rice (size of ArrayList)
     * @param noodlesList - ArrayList of noodles items to determine the stock of noodles (size of ArrayList)
     * @param unsellableList - ArrayList of unsellable items (ex. garlic, shallots) to determine the stock of each (size of ArrayList relative to specific unsellable item instance)
     * @return
     */
    public ArrayList<Integer> viewCurrentStock(ArrayList<Item> siomaiList, ArrayList<Item> hakaoList, ArrayList<Item> wantonList, ArrayList<Item> fishCakeList, ArrayList<Item> asadoList,
                                               ArrayList<Item> eggList, ArrayList<Item> riceList, ArrayList<Item> noodlesList, ArrayList<UnsellableItem> unsellableList) {

        ArrayList<Integer> stock = new ArrayList<>(); // Instantiates a local ArrayList to store the stock of items in order before returning it.

        int garlicCount = 0; // Will store the count of each unsellable item instance inside the unsellableList.
        int shallotsCount = 0;
        int vegOilCount = 0;
        int carrotCount = 0;
        int cabbageCount = 0;
        int chickenCount = 0;

        for (UnsellableItem item : unsellableList) { // Getting the count of each Unsellable Item. Does this via the amount of calories.

            if (item.getCalories() == 5) { // If the calories of the unsellableItem is 5, then it is an instance of garlic.

                garlicCount++; // Increments the garlicCount to represent the stock of garlic.
            }

            else if (item.getCalories() == 7) { // Same logic applies to other unsellableItems as the garlic above.

                shallotsCount++;
            }

            else if (item.getCalories() == 50) {

                vegOilCount++;
            }

            else if (item.getCalories() == 3) {

                carrotCount++;
            }

            else if (item.getCalories() == 2) {

                cabbageCount++;
            }

            else if (item.getCalories() == 27) {

                chickenCount++;
            }
        }

        stock.add(siomaiList.size()); // Adds the integer stock of each regular "Item" in a specific order.
        stock.add(hakaoList.size());        // So that we know that index 0 is the stock of siomai, index 1 is the stock of hakao and so on.
        stock.add(wantonList.size());
        stock.add(fishCakeList.size());
        stock.add(asadoList.size());
        stock.add(eggList.size());
        stock.add(riceList.size());
        stock.add(noodlesList.size());

        stock.add(garlicCount); // For the "UnsellableItem(s)", the count of each was taken above, these values are also added to the stock ArrayList.
        stock.add(shallotsCount);
        stock.add(vegOilCount);
        stock.add(carrotCount);
        stock.add(cabbageCount);
        stock.add(chickenCount);

        return stock; // Return the ArrayList of stock
    }

    /**
     *  A method to restock the amount of regular Items and UnsellableItems. Regulars are stocked back to 10 each and
     *   unsellables are stocked to 20 each.
     *
     * @param siomai - a siomai regular item.
     * @param siomaiList - The ArrayList of siomai items to be restocked.
     * @param hakao - a hakao regular item.
     * @param hakaoList
     * @param wanton - a wanton regular item.
     * @param wantonList
     * @param fishcake - a fishcake regular item.
     * @param fishCakeList
     * @param asado - an asado regular item.
     * @param asadoList
     * @param egg - an egg regular item.
     * @param eggList
     * @param rice - a rice regular item.
     * @param riceList
     * @param noodles - a noodles regular item.
     * @param noodlesList
     * @param garlic - a garlic unsellable item.
     * @param shallots - a shallots unsellable item.
     * @param vegOil - a vegOil unsellable item.
     * @param carrot - a carrot unsellable item.
     * @param cabbage - a cabbage unsellable item.
     * @param chicken - a chicken unsellable item.
     * @param unsellableList - an ArrayList of unsellable items, all unsellable item instances are restocked here regardless of type.
     */
    public void restockItems(Item siomai, ArrayList<Item> siomaiList, Item hakao, ArrayList<Item> hakaoList, Item wanton, ArrayList<Item> wantonList, Item fishcake, ArrayList<Item> fishCakeList,
                             Item asado, ArrayList<Item> asadoList, Item egg, ArrayList<Item> eggList, Item rice, ArrayList<Item> riceList, Item noodles, ArrayList<Item> noodlesList,
                             UnsellableItem garlic, UnsellableItem shallots, UnsellableItem vegOil, UnsellableItem carrot, UnsellableItem cabbage, UnsellableItem chicken,
                             ArrayList<UnsellableItem> unsellableList) {

        int garlicCount = 0; // Counters for the stock of each unsellable item to be used later on.
        int shallotsCount = 0;
        int vegOilCount = 0;
        int carrotCount = 0;
        int cabbageCount = 0;
        int chickenCount = 0;

        while (siomaiList.size() != 10) { // While the siomaiList does not have 10 instances of siomai, add 1 siomai

            siomaiList.add(siomai); // Increment the list by 1 siomai item.
        }

        while (hakaoList.size() != 10) { // All regular items apply the same logic as siomaiList above to restock items.

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

        for (UnsellableItem item : unsellableList) { // For each loop to iterate over each UnsellableItem in the unsellableList.

            if (item == garlic) { // If the item is garlic, increment the garlicCount.

                garlicCount++; // Increments the garlicCount.
            }

            else if (item == shallots) { // Same logic applies to the rest of the unsellable items as the garlic above.

                shallotsCount++;
            }

            else if (item == vegOil) {

                vegOilCount++;
            }

            else if (item == carrot) {

                carrotCount++;
            }

            else if (item == cabbage) {

                cabbageCount++;
            }

            else if (item == chicken) {

                chickenCount++;
            }
        }

        if (garlicCount < 20) { // If the garlicCount is less than 20...

            for (int i = garlicCount; i < 20; i++) { // loop by the current amount of garlic until it is less than 20...

                unsellableList.add(garlic); // so that that amount of garlic can be added to the unsellableList.
            }
        }

        if (shallotsCount < 20) { // Same logic as garlic applies to the rest of the UnsellableItems.

            for (int i = shallotsCount; i < 20; i++) {

                unsellableList.add(shallots);
            }
        }

        if (vegOilCount < 20) {

            for (int i = vegOilCount; i < 20; i++) {

                unsellableList.add(vegOil);
            }
        }

        if (carrotCount < 20) {

            for (int i = carrotCount; i < 20; i++) {

                unsellableList.add(carrot);
            }
        }

        if (cabbageCount < 20) {

            for (int i = cabbageCount; i < 20; i++) {

                unsellableList.add(cabbage);
            }
        }

        if (chickenCount < 20) {

            for (int i = chickenCount; i < 20; i++) {

                unsellableList.add(chicken);
            }
        }
    }
}
