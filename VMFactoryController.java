import javax.swing.*;
import java.util.ArrayList;

/**
 * The class that represents the controller of the Vending Machine Factory simulation program, conforming
 * to the MVC architecture standards. The view and various models are declared here so that they could interact.
 */
public class VMFactoryController {

    private VMFactoryView view;

    private RegularVendingMachine regularVendingMachine = null; // Sets attribute as null before a Regular Vending Machine is created
    private SpecialVendingMachine specialVendingMachine = null;

    private ArrayList<ArrayList<Item>> itemSlots; // ArrayList of ArrayLists
    private ArrayList<Item> siomaiList;
    private ArrayList<Item> hakaoList;
    private ArrayList<Item> wantonList;
    private ArrayList<Item> fishCakeList;
    private ArrayList<Item> asadoList;
    private ArrayList<Item> eggList;
    private ArrayList<Item> riceList;
    private ArrayList<Item> noodlesList;

    // Individual Sellable Items
    private Item siomai;
    private Item hakao;
    private Item wanton;
    private Item fishcake;
    private Item asado;
    private Item egg;
    private Item rice;
    private Item noodles;

    // Individual Unsellable Items
    private UnsellableItem garlic;
    private UnsellableItem shallots;
    private UnsellableItem vegOil;
    private UnsellableItem carrot;
    private UnsellableItem cabbage;
    private UnsellableItem chicken;
    private ArrayList<UnsellableItem> unsellableList;

    // Combo Items
    private ComboItem friedRice = null;
    private ComboItem friedNoodles = null;
    private ArrayList<Item> comboItem; // Arraylist to store the list of items selected for the comboItem

    private ArrayList<ArrayList<Denomination>> denominationSlots;
    private ArrayList<Denomination> changeDenominations;

    // ArrayList of Similar Denomination Declarations
    private ArrayList<Denomination> hundredList;
    private ArrayList<Denomination> fiftyList;
    private ArrayList<Denomination> twentyList;
    private ArrayList<Denomination> tenList;
    private ArrayList<Denomination> fiveList;
    private ArrayList<Denomination> oneList;
    private ArrayList<Denomination> fiveCentsList;
    private ArrayList<Denomination> twFiveCentsList;

    // Individual Denomination Declarations
    private Denomination hundred;
    private Denomination fifty;
    private Denomination twenty;
    private Denomination ten;
    private Denomination five;
    private Denomination one;
    private Denomination fiveCents;
    private Denomination twFiveCents;

    private boolean switcher; // If false (0) RegularVendingMachine, else true (1) SpecialVendingMachine

    /**
     * Constructor of the controller class that takes the view as a parameter
     *
     * @param view - The view in the MVC architecture that contains all the GUI elements to interact with the user.
     */
    public VMFactoryController (VMFactoryView view) {

        this.view = view;

        // Main Menu Buttons
        this.view.addCreateMachineListener(e -> createMachine()); // Listener for the "createMachine" button in the view, the createMachine() method
                                                                        // in this controller is executed when the button is pressed.
        this.view.addTestMachineListener(e -> testMachine());     // Same goes for the rest of the buttons.
        this.view.addExitMenuListener(e -> exitFactory());

        // Create Sub-Menu Buttons
        this.view.addCreateRvmButton(e -> createRvm());
        this.view.addCreateSvmButton(e -> createSvm());

        // Test Sub-Menu Buttons
        this.view.addTestVendingListener(e -> testVendingRvm());
        this.view.addMaintainVendingListener(e -> maintainVending());
        this.view.addExitTestMenuListener(e -> exitTestMenu());

        // Test Vending Features Sub-Menu Buttons
        this.view.addViewItemsListener(e -> viewItems());
        this.view.addBuyItemListener(e -> buyItem());
        this.view.addExitVendingFeatureListener(e -> exitVendingFeatures());

        // Buy Item Buttons
        this.view.addBuySiomaiListener(e -> buySiomai());
        this.view.addBuyHakaoListener(e -> buyHakao());
        this.view.addBuyWantonListener(e -> buyWanton());
        this.view.addBuyFishcakeListener(e -> buyFishcake());
        this.view.addBuyAsadoListener(e -> buyAsado());
        this.view.addBuyEggListener(e -> buyEgg());
        this.view.addBuyRiceListener(e -> buyRice());
        this.view.addBuyNoodlesListener(e -> buyNoodles());
        this.view.addExitBuyMenuListener(e -> exitBuyMenu());

        // Maintain Machine Buttons
        this.view.addExitMaintainButton(e -> exitMaintenanceMenu());

        // Combo Meal Listeners
        this.view.addBuyFrRiceListener(e -> buyFriedRice());
        this.view.addBuyFrNoodlesListener(e -> buyFriedNoodles());

        // AddOn Listeners
        this.view.addSellableListener(e -> addSellable());
        this.view.addUnsellableOneListener(e -> addUnsellableOne());
        this.view.addUnsellableTwoListener(e -> addUnsellableTwo());
        this.view.addUnsellableThreeListener(e -> addUnsellableThree());
        this.view.addConfirmAddOnsListener(e -> confirmAddOns());
    }

    /**
     * A method that calls the createMenuView() method from the view class.
     */
    public void createMachine () {

        view.createMenuView();
    }

    /**
     * A method that leads the user to the testing menu as long as a vending machine has already been created.
     * You cannot test a machine that has not yet been created.
     */
    public void testMachine () {

        if(regularVendingMachine == null && specialVendingMachine == null) { // If a regularVendingMachine and a specialVendingMachine have not yet been
                                                                             // created (instantiated), then display a warning.
            view.warningNoMachine();
        }

        else { // If one of them has been instantiated, proceed to the testing menu.

            view.testMenuView(); // The GUI elements for the test menu in the view.
        }

    }

    /**
     * A simple method that exits the main menu and the program when the specific button is pressed to do so.
     */
    public void exitFactory () {

        view.exitMainFrame();
    }

    /**
     * A method that sets the items inside the different ArrayLists, and later on the ArrayList of ArrayLists of items (itemSlots).
     */
    public void setRvmItem() {

        itemSlots = new ArrayList<>();
        // Individual Item Declarations
        siomai = new Item("Siomai | 4 pcs.", 30.0, 127);
        hakao = new Item("Hakao | 4 pcs.", 35.0, 187);
        wanton = new Item("Fried Wanton | 4 pcs.", 43.0, 280);
        fishcake = new Item("Fishcake | 2 pcs.", 53, 482);

        asado = new Item("Pork Asado | 2 pcs.", 62.0, 340);
        egg = new Item("Scrambled Egg", 20.5, 148);
        rice = new Item("Plain Rice | 1 cup", 20.0, 221);
        noodles = new Item("Plain Noodles | 1 bowl", 25.0, 221);

        // Instantiate new arrayLists for each item type
        siomaiList = new ArrayList<>();
        hakaoList = new ArrayList<>();
        wantonList = new ArrayList<>();
        fishCakeList = new ArrayList<>();
        asadoList = new ArrayList<>();
        eggList = new ArrayList<>();
        riceList = new ArrayList<>();
        noodlesList = new ArrayList<>();

        for (int i = 0; i < 10; i++) { // Adding 10 Items of the same type to their respective arrayLists.

            siomaiList.add(siomai);
            hakaoList.add(hakao);
            wantonList.add(wanton);
            fishCakeList.add(fishcake);
            asadoList.add(asado);
            eggList.add(egg);
            riceList.add(rice);
            noodlesList.add(noodles);
        }
    }

    /**
     * A method that sets the denominations inside the different ArrayLists, and later on the ArrayList of ArrayLists for denominations (denominationList).
     * Works more or less the same as the setRvmItems method.
     */
    public void setDenomination() {

        denominationSlots = new ArrayList<>();

        // Adding the arrayList of items into the rvmItemSLots arrayList. An arrayList of arrayLists
        itemSlots.add(siomaiList);
        itemSlots.add(hakaoList);
        itemSlots.add(wantonList);
        itemSlots.add(fishCakeList);
        itemSlots.add(asadoList);
        itemSlots.add(eggList);
        itemSlots.add(riceList);
        itemSlots.add(noodlesList);

        // Individual Denomination Declaration
        hundred = new Denomination(100.0);
        fifty = new Denomination(50.0);
        twenty = new Denomination(20.0);
        ten = new Denomination(10.0);
        five = new Denomination(5.0);
        one = new Denomination(1.0);
        fiveCents = new Denomination(0.5);
        twFiveCents = new Denomination(0.25);

        hundredList = new ArrayList<>();
        fiftyList = new ArrayList<>();
        twentyList = new ArrayList<>();
        tenList = new ArrayList<>();
        fiveList = new ArrayList<>();
        oneList = new ArrayList<>();
        fiveCentsList = new ArrayList<>();
        twFiveCentsList = new ArrayList<>();


        for (int i = 0; i < 10; i++) { // Adding 10 denominations of the same type to their respective arrayLists.

            hundredList.add(hundred);
            fiftyList.add(fifty);
            twentyList.add(twenty);
            tenList.add(ten);
            fiveList.add(five);
            oneList.add(one);
            fiveCentsList.add(fiveCents);
            twFiveCentsList.add(twFiveCents);
        }

        // Adding the arrayList of items into the denominationSlots arrayList. An arrayList of arrayLists
        denominationSlots.add(hundredList);
        denominationSlots.add(fiftyList);
        denominationSlots.add(twentyList);
        denominationSlots.add(tenList);
        denominationSlots.add(fiveList);
        denominationSlots.add(oneList);
        denominationSlots.add(fiveCentsList);
        denominationSlots.add(twFiveCentsList);
    }

    /**
     * The method that creates a Regular Vending Machine.
     */
    public void createRvm () {

        setRvmItem(); // Calls the method to set the itemSlots ArrayList of ArrayLists with items.
        setDenomination(); // The same happens for denominations on this method call.

        regularVendingMachine = new RegularVendingMachine(itemSlots, denominationSlots); // Instantiating a Regular Vending Machine (RVM)

        view.showSuccessMachine(); // Displays a message onscreen that a machine has successfully been created
        view.exitCreateMenu(); // Exits the create menu after a machine has been created

        switcher = false; // Tells the rest of the controller that it is a regularVendingMachine that was created
    }

    /**
     * A method that calls the GUI elements associated with the testing of vending features when the right button is pressed.
     */
    public void testVendingRvm() {

        view.testVendingFeaturesView();
    }

    /**
     *  Exits the testing menu when the specific button is pressed to do so.
     */
    private void exitTestMenu() {

        view.exitTestMenu();
    }

    /**
     *  Exits the vending features sub-menu when the button for it is pressed.
     */
    private void exitVendingFeatures() {

        view.exitVendingFeatures();
    }

    /**
     *  A method that locally stores the stock of each item. Has two versions depending on the boolean switcher. If false, the regularVendingMachine portion
     *  of the method will execute, otherwise the specialVendingMachine one will.
     */
    public void viewItems() {

        if (!switcher) {
            // Locally declaring an integer ArrayList to hold the stock of each item in a specific order based on the inputs given by the viewcurrentStock method.
            ArrayList<Integer> stock = regularVendingMachine.viewCurrentStock(siomaiList, hakaoList, wantonList, fishCakeList, asadoList, eggList, riceList, noodlesList);

            int siomaiStock = stock.get(0); // The 0 index in the stock ArrayList indicates the quantity of siomai.
            int hakaoStock = stock.get(1); // The 1 index represents hakao, 2 for wanton and so on.
            int wantonStock = stock.get(2);
            int fishcakeStock = stock.get(3);
            int asadoStock = stock.get(4);
            int eggStock = stock.get(5);
            int riceStock = stock.get(6);
            int noodleStock = stock.get(7);

            // Gives the view an instance of an item (ex. siomai) and its respective stock (ex. siomaiStock) so that they may be displayed by the view.
            view.displayRvmItems(siomai, siomaiStock, hakao, hakaoStock, wanton, wantonStock, fishcake, fishcakeStock, asado, asadoStock, egg, eggStock, rice, riceStock, noodles, noodleStock);
        }

        else { // If for the specialVendingMachine, do exactly the same except for the addition of unsellable items.

            // Notice the unsellableList at the end of the arguments.
            ArrayList<Integer> stock = specialVendingMachine.viewCurrentStock(siomaiList, hakaoList, wantonList, fishCakeList, asadoList, eggList, riceList, noodlesList, unsellableList);

            int siomaiStock = stock.get(0);
            int hakaoStock = stock.get(1);
            int wantonStock = stock.get(2);
            int fishcakeStock = stock.get(3);
            int asadoStock = stock.get(4);
            int eggStock = stock.get(5);
            int riceStock = stock.get(6);
            int noodleStock = stock.get(7);

            int garlicStock = stock.get(8); // Count of Unsellable Items
            int shallotsStock = stock.get(9);
            int vegOilStock = stock.get(10);
            int carrotStock = stock.get(11);
            int cabbageStock = stock.get(12);
            int chickenStock = stock.get(13);

            // Notice the added unsellable items such as garlic, shallots, and their respective stocks. Works the same as regular items anyway.
            view.displaySvmItems(siomai, siomaiStock, hakao, hakaoStock, wanton, wantonStock, fishcake, fishcakeStock, asado, asadoStock, egg, eggStock, rice, riceStock, noodles, noodleStock,
                                 garlic, garlicStock, shallots, shallotsStock, vegOil, vegOilStock, carrot, carrotStock, cabbage, cabbageStock, chicken, chickenStock);
        }

    }

    /**
     * The method that allows the user to enter the buy item menu with a click of a button.
     * The GUI elements are not here, just the prerequisite information the view needs from the controller.
     */
    public void buyItem() {

        if (!switcher) { // Same logic applies that if false, the regularVendingMachine lines are executed

            // Does the same as the viewItems() method but this information will be added to buttons as opposed to a simple list in the above method.
            ArrayList<Integer> stock = regularVendingMachine.viewCurrentStock(siomaiList, hakaoList, wantonList, fishCakeList, asadoList, eggList, riceList, noodlesList);

            int siomaiStock = stock.get(0);
            int hakaoStock = stock.get(1);
            int wantonStock = stock.get(2);
            int fishcakeStock = stock.get(3);
            int asadoStock = stock.get(4);
            int eggStock = stock.get(5);
            int riceStock = stock.get(6);
            int noodleStock = stock.get(7);

            view.buyRvmItem(siomai, siomaiStock, hakao, hakaoStock, wanton, wantonStock, fishcake, fishcakeStock, asado, asadoStock, egg, eggStock, rice, riceStock, noodles, noodleStock);
        }

        else { // special vending machine code segments for this method

            ArrayList<Integer> stock = specialVendingMachine.viewCurrentStock(siomaiList, hakaoList, wantonList, fishCakeList, asadoList, eggList, riceList, noodlesList, unsellableList);

            int siomaiStock = stock.get(0);
            int hakaoStock = stock.get(1);
            int wantonStock = stock.get(2);
            int fishcakeStock = stock.get(3);
            int asadoStock = stock.get(4);
            int eggStock = stock.get(5);
            int riceStock = stock.get(6);
            int noodleStock = stock.get(7);

            int garlicStock = stock.get(8); // Count of Unsellable Items
            int shallotsStock = stock.get(9);
            int vegOilStock = stock.get(10);
            int carrotStock = stock.get(11);
            int cabbageStock = stock.get(12);
            int chickenStock = stock.get(13);

            view.buySvmItems(siomai, siomaiStock, hakao, hakaoStock, wanton, wantonStock, fishcake, fishcakeStock, asado, asadoStock, egg, eggStock, rice, riceStock, noodles, noodleStock,
                    garlic, garlicStock, shallots, shallotsStock, vegOil, vegOilStock, carrot, carrotStock, cabbage, cabbageStock, chicken, chickenStock);

        }
    }

    /**
     *  A method to exit the buy menu once the button is pressed
     */
    private void exitBuyMenu() {

        view.exitBuyMenu();
    }

    /**
     *  Update the Denominations through this method
     *
     * @param change - the total change that needs to be deducted since it
     *                  was given out to a customer
     */
    public void updateDenominations(double change) {

        changeDenominations = new ArrayList<Denomination>(); // instantiates a new ArrayList of denominations to store the change denominations.

        while(change >= 100.0 && !denominationSlots.get(0).isEmpty()) { // While the change is greater or equal to 100 and there are still hundred denominations in the denominationSlots
                                                                            // ArrayList of ArrayLists, proceed.
            changeDenominations.add(hundred); // Adds 100 pesos to the changeDenominations array before...
            denominationSlots.get(0).remove(0); // Subtracting or removing it from the initial denominationSlots arraylist
            change -= 100.0; // Decrement the change needed by 100
        }

        while(change >= 50.0 && !denominationSlots.get(1).isEmpty()) {

            changeDenominations.add(fifty); // Adds 100 pesos to the changeDenominations array before...
            denominationSlots.get(1).remove(0); // Subtracting / removing it from the initial denominationSlots arraylist
            change -= 50.0; // Decrement the change needed
        }

        while(change >= 20.0 && !denominationSlots.get(2).isEmpty()) {

            changeDenominations.add(twenty); // Adds 100 pesos to the changeDenominations array before...
            denominationSlots.get(2).remove(0); // Subtracting / removing it from the initial denominationSlots arraylist
            change -= 20.0; // Decrement the change needed
        }

        while(change >= 10.0 && !denominationSlots.get(3).isEmpty()) {

            changeDenominations.add(ten); // Adds 100 pesos to the changeDenominations array before...
            denominationSlots.get(3).remove(0); // Subtracting / removing it from the initial denominationSlots arraylist
            change -= 10.0; // Decrement the change needed
        }

        while(change >= 5.0 && !denominationSlots.get(4).isEmpty()) {

            changeDenominations.add(five); // Adds 100 pesos to the changeDenominations array before...
            denominationSlots.get(4).remove(0); // Subtracting / removing it from the initial denominationSlots arraylist
            change -= 5.0; // Decrement the change needed
        }

        while(change >= 1.0 && !denominationSlots.get(5).isEmpty()) {

            changeDenominations.add(one); // Adds 100 pesos to the changeDenominations array before...
            denominationSlots.get(5).remove(0); // Subtracting / removing it from the initial denominationSlots arraylist
            change -= 1.0; // Decrement the change needed
        }

        while(change >= 0.5 && !denominationSlots.get(6).isEmpty()) {

            changeDenominations.add(fiveCents); // Adds 100 pesos to the changeDenominations array before...
            denominationSlots.get(7).remove(0); // Subtracting / removing it from the initial denominationSlots arraylist
            change -= 0.5; // Decrement the change needed
        }

        while(change >= 0.25 && !denominationSlots.get(7).isEmpty()) {

            changeDenominations.add(twFiveCents); // Adds 100 pesos to the changeDenominations array before...
            denominationSlots.get(6).remove(0); // Subtracting / removing it from the initial denominationSlots arraylist
            change -= 0.25; // Decrement the change needed
        }
    }

    /**
     *  Get the count of each Denomination of change to be given to the customer, to be passed to the view for displaying purposes.
     *
     * @param change - The change for the transaction made when buying an item also to be displayed in the view.
     */
    public void getDenominationCount (double change) {

        int hundredCount = 0; // local integers to store the count of each denomination.
        int fiftyCount = 0;
        int twentyCount = 0;
        int tenCount = 0;
        int fiveCount = 0;
        int oneCount = 0;
        int fiveCentCount = 0;
        int tfCentCount = 0;

        for(Denomination denomination : changeDenominations) { // A for each loop to iterate over each denomination in the changeDenominations list

            if(denomination.equals(hundred)) { // If the denomination is a hundred...

                hundredCount++; // Add 100 to the total denominations of change count.
            }

            else if(denomination.equals(fifty)) { // Do the same as hundreds for the following denominations.

                fiftyCount++;
            }

            else if(denomination.equals(twenty)) {

                twentyCount++;
            }

            else if(denomination.equals(ten)) {

                tenCount++;
            }

            else if(denomination.equals(five)) {

                fiveCount++;
            }

            else if(denomination.equals(one)) {

                oneCount++;
            }

            else if(denomination.equals(fiveCents)) {

                fiveCentCount++;
            }

            else if(denomination.equals(twFiveCents)) {

                tfCentCount++;
            }
        }

        // passes the counts calculated to the displayChange method in the view.
        view.displayChange(hundredCount, fiftyCount, twentyCount, tenCount, fiveCount, oneCount, fiveCentCount, tfCentCount, change);
    }

    /**
     * A method that handles the money after a transaction, also if the transaction lacks funds and does not push through.
     *
     * @param item - The item the customer purchased
     * @return - true or false depending on if the item was successfully purchased or not.
     */
    public boolean moneyHandler(Item item) {

        double requiredAmount = item.getPrice(); // The required amount to pay is simply the price of the item selected
        double remainingAmount = requiredAmount; // The initial remainingAmount the customer has to pay is the required amount.
        double amountPaid = 0.0; // The amountPaid is set to 0.0 as the customer has yet to provide payment.
        double change = 0.0; // The same goes for the change that has yet to be calculated.

        while (remainingAmount > 0) { // While the remainingAmount of money that needs to be paid is greater than 0, loop
                                        // In other words, insufficient payment.
            double additionalFunds = view.amountInput(remainingAmount); // the view.amountInput asks the customer to input more money, and it is saved as additionalFunds.
            amountPaid += additionalFunds; // The amountPaid is incremented based on the additionalFunds the customer provided.
            remainingAmount = requiredAmount - amountPaid; // The remainingAmount that needs to be paid is subtracted by the amountRequired and the amountPaid.

            if (remainingAmount > 0) { // If the is still greater than zero...
                view.insufficientFunds(remainingAmount); // display the insufficient funds message from the view.
            }
        }

        if (regularVendingMachine != null) { // If a regularVendingMachine is not null, then the change is calculated on the regularVendingMachine side.

            change = regularVendingMachine.calculateChange(requiredAmount, amountPaid);
        }

        else { // else, it is calculated from the specialVendingMachine. Although the values will be the same regardless of vending machine type.

            change = specialVendingMachine.calculateChange(requiredAmount, amountPaid);
        }


        if (change >= 0) { // If the change is greater than or equal to 0, execute the following.

            updateDenominations(change); // call the updateDenominations method
            getDenominationCount(change); // get the cont of denominations
            view.confirmPayment(); // Message that the payment was successful

            return true; // Purchase was successful
        }

        else {

            view.insufficientFundsTwo(item.getName()); // displays a message that the transaction was unsuccessful.
            return false; // Purchase failed due to insufficient funds
        }

    }

    /**
     * The method executed when the buySiomai button is pressed.
     */
    public void buySiomai() {

        if (moneyHandler(siomai)) { // If the money returns true with siomai as parameter...

            if (regularVendingMachine != null) { // and if the regularVendingMachine is instantiated...

                regularVendingMachine.incrementSales(siomai.getPrice()); // increment the totalSales by the price of 1 siomai.
            }

            else { // else,

                specialVendingMachine.incrementSales(siomai.getPrice()); // increment sales in the specialVendingMachine with the same principles.
            }

            siomaiList.remove(0); // remove a siomai item from the siomaiList
        }
        view.exitBuyMenu(); // exit the buy menu after the purchase was made.
    } // The rest of the buy[insert regular item] follow the same logic.

    /**
     * The method executed when the buyHakao button is pressed.
     */
    public void buyHakao() {

        if (moneyHandler(hakao)) {

            if (regularVendingMachine != null) {

                regularVendingMachine.incrementSales(hakao.getPrice());
            }

            else {

                specialVendingMachine.incrementSales(hakao.getPrice());
            }

            hakaoList.remove(0);
        }
        view.exitBuyMenu();
    }

    /**
     * The method executed when the buyWanton button is pressed.
     */
    public void buyWanton() {

        if (moneyHandler(wanton)) {

            if (regularVendingMachine != null) {

                regularVendingMachine.incrementSales(wanton.getPrice());
            }

            else {

                specialVendingMachine.incrementSales(wanton.getPrice());
            }

            wantonList.remove(0);
        }
        view.exitBuyMenu();
    }

    /**
     * The method executed when the buyFishcake button is pressed.
     */
    public void buyFishcake() {

        if (moneyHandler(fishcake)) {

            if (regularVendingMachine != null) {

                regularVendingMachine.incrementSales(fishcake.getPrice());
            }

            else {

                specialVendingMachine.incrementSales(fishcake.getPrice());
            }

            fishCakeList.remove(0);
        }
        view.exitBuyMenu();
    }

    /**
     * The method executed when the buyAsado button is pressed.
     */
    public void buyAsado() {

        if (moneyHandler(asado)) {

            if (regularVendingMachine != null) {

                regularVendingMachine.incrementSales(asado.getPrice());
            }

            else {

                specialVendingMachine.incrementSales(asado.getPrice());
            }

            asadoList.remove(0);
        }
        view.exitBuyMenu();
    }

    /**
     * The method executed when the buyEgg button is pressed.
     */
    public void buyEgg() {

        if (moneyHandler(egg)) {

            if (regularVendingMachine != null) {

                regularVendingMachine.incrementSales(egg.getPrice());
            }

            else {

                specialVendingMachine.incrementSales(egg.getPrice());
            }

            eggList.remove(0);
        }
        view.exitBuyMenu();
    }

    /**
     * The method executed when the buyRice button is pressed.
     */
    public void buyRice() {

        if (moneyHandler(rice)) {

            if (regularVendingMachine != null) {

                regularVendingMachine.incrementSales(rice.getPrice());
            }

            else {

                specialVendingMachine.incrementSales(rice.getPrice());
            }

            riceList.remove(0);
        }
        view.exitBuyMenu();
    }

    /**
     * The method executed when the buyNoodles button is pressed.
     */
    public void buyNoodles() {

        if (moneyHandler(noodles)) {

            if (regularVendingMachine != null) {

                regularVendingMachine.incrementSales(noodles.getPrice());
            }

            else {

                specialVendingMachine.incrementSales(noodles.getPrice());
            }

            noodlesList.remove(0);
        }
        view.exitBuyMenu();
    }

    /**
     *  A method that prepares the information needed for the view to display the current denominations.
     */
    public void viewDenoms() {

        ArrayList<Integer> stock;

        if (regularVendingMachine != null) { // If a regularVendingMachine was instantiated, the integer ArrayList is filled with the denominations from the RVM.

            stock = regularVendingMachine.viewCurrentDenom(hundredList, fiftyList, twentyList, tenList, fiveList, oneList, fiveCentsList, twFiveCentsList);
        }

        else { // else, from the SVM. same principles.

            stock = specialVendingMachine.viewCurrentDenom(hundredList, fiftyList, twentyList, tenList, fiveList, oneList, fiveCentsList, twFiveCentsList);
        }


        int hundredStock = stock.get(0); // gets the stock of hundreds as index 0.
        int fiftyStock = stock.get(1);   // the stock of fifties as index 1 and so on.
        int twentyStock = stock.get(2);
        int tenStock = stock.get(3);
        int fiveStock = stock.get(4);
        int oneStock = stock.get(5);
        int twFiveCentStock = stock.get(6);
        int fiveCentStock = stock.get(7);

        // Passes the prepared information to the view for displaying purposes.
        view.displayDenoms(hundred, hundredStock, fifty, fiftyStock, twenty, twentyStock, ten, tenStock, five, fiveStock, one, oneStock, fiveCents, twFiveCentStock, twFiveCents, fiveCentStock);

    }

    /**
     *  This method serves as the maintain a vending machine sub-menu.
     */
    public void maintainVending() {

        int input = view.maintainMachineMenu(); // Stores the input of the admin on which feature they would like to test.
        VendingMachine vendingMachine; // Declaring a vendingMachine object

        if (regularVendingMachine != null) { // If the current object is a regular vending machine,

            vendingMachine = regularVendingMachine; // the vendingMachine becomes a regular vending machine
        }

        else {

            vendingMachine = specialVendingMachine; // else, it becomes a specialVendingMachine.
        }


        switch(input) { // switch case taken in the input of the user given by the view as seen at the start of this method

            case 1: // View Current Item Stock
                viewItems(); // calls the method that views the current item stock and...
                exitMaintenanceMenu(); // exits the maintenance menu when done.
                break;

            case 2: // View Current Denominations
                viewDenoms(); // does the same as viewing the items but for denominations and..
                exitMaintenanceMenu(); // also exits the maintenance menu when done.
                break;

            case 3: // View Sales
                view.displaySales(vendingMachine.getTotalSales()); // displays the sales generated on the current vending machine.
                exitMaintenanceMenu(); // exits the sub-menu afterward.
                break;

            case 4: // Restock Current Items

                if (regularVendingMachine != null) { // restocks the items if it is for a regularVendingMachine or a specialVendingMachine (only added items are the difference).

                    regularVendingMachine.restockItems(siomai, siomaiList, hakao, hakaoList, wanton, wantonList, fishcake, fishCakeList, asado, asadoList, egg, eggList, rice, riceList, noodles, noodlesList);
                }

                else {

                    specialVendingMachine.restockItems(siomai, siomaiList, hakao, hakaoList, wanton, wantonList, fishcake, fishCakeList, asado, asadoList, egg, eggList, rice, riceList, noodles, noodlesList,
                                                        garlic, shallots, vegOil, carrot, cabbage, chicken, unsellableList);
                }

                view.confirmItemRestock(); // message confirming that the stocking was successful.
                exitMaintenanceMenu(); // exits the maintenance menu after.
                break;

            case 5: // Restock Change Denominations
                // same drill as the restock of items but the same exact process is used for both since they use the same denomination systems.
                vendingMachine.restockDenoms(hundred, hundredList, fifty, fiftyList, twenty, twentyList, ten, tenList, five, fiveList, one, oneList, fiveCents, fiveCentsList, twFiveCents, twFiveCentsList);
                view.confirmDenomRestock(); // message confirming a successful denomination restock.
                exitMaintenanceMenu(); // exit the maintenance menu.
                break;

            case 6: // Set Item Price
                itemPriceHelper(); // Asks for new item price and sets it depending on the item
                view.exitDisplayCurrent(); // Disposes the frame showing the list of current prices
                viewItems(); // Displays the updated list of items
                view.confirmPriceChange(); // Shows that the change has been made successfully
                exitMaintenanceMenu();
                break;

            case 7: // Collect Sales and Reset Balance

                double sales = 0.0; // resets the sales to 0.0 to show that it was collected.

                if (regularVendingMachine != null) {

                    sales = regularVendingMachine.collectSales();
                }

                else {

                    sales = specialVendingMachine.collectSales();
                }

                view.confirmSalesCollection(sales); // displays the total amount of sales before it is zeroed.
                exitMaintenanceMenu(); // exit to main menu
                break;
            default:
                exitMaintenanceMenu(); // exit the maintenance menu when input is not on the switch case.
        }
    }

    /**
     *  A method to aid in changing the price of items.
     */
    public void itemPriceHelper() {

        VendingMachine  vendingMachine;

        if (regularVendingMachine != null) {

            vendingMachine = regularVendingMachine; // sets vendingMachine as a regularVendingMachine it is not null
        }

        else {

            vendingMachine = specialVendingMachine; // sets vendingMachine as a specialVendingMachine otherwise
        }

        double newPrice = 0.0; // a double variable to store the newPrice the admin wishes to give the item.

        // the GUI components to display the list of items to show an admin their options of price change.
        view.displayCurPrices(siomai.getName(), hakao.getName(), wanton.getName(), fishcake.getName(), asado.getName(), egg.getName(), rice.getName(), noodles.getName());

        int choice = view.askItemType(); // asks for the type of item the admin wishes to change the price of.

        switch(choice) { // If choice is 1, admin wishes to change siomai price and so on.

            case 1:
                newPrice = view.askItemPrice(siomai.getPrice()); // sets the newPrice as the value the admin wished to set.
                siomai.setPrice(newPrice); // sets the price to the siomai item.
                vendingMachine.updatePrice(siomai, siomaiList); // updates each instance of the new siomai item in the siomaiList.
                break;

            case 2:
                newPrice = view.askItemPrice(hakao.getPrice()); // same logic as the siomai applies for hakao and other items below.
                hakao.setPrice(newPrice);
                vendingMachine.updatePrice(hakao, hakaoList);
                break;

            case 3:
                newPrice = view.askItemPrice(wanton.getPrice());
                wanton.setPrice(newPrice);
                vendingMachine.updatePrice(wanton, wantonList);
                break;

            case 4:
                newPrice = view.askItemPrice(fishcake.getPrice());
                fishcake.setPrice(newPrice);
                vendingMachine.updatePrice(fishcake, fishCakeList);
                break;

            case 5:
                newPrice = view.askItemPrice(asado.getPrice());
                asado.setPrice(newPrice);
                vendingMachine.updatePrice(asado, asadoList);
                break;

            case 6:
                newPrice = view.askItemPrice(egg.getPrice());
                egg.setPrice(newPrice);
                vendingMachine.updatePrice(egg, eggList);
                break;

            case 7:
                newPrice = view.askItemPrice(rice.getPrice());
                rice.setPrice(newPrice);
                vendingMachine.updatePrice(rice, riceList);
                break;

            case 8:
                newPrice = view.askItemPrice(noodles.getPrice());
                noodles.setPrice(newPrice);
                vendingMachine.updatePrice(noodles, noodlesList);
                break;
        }
    }

    /**
     * A method that exits the maintenance menu when the button for it is pressed in the view
     */
    public void exitMaintenanceMenu() {

        view.exitMaintain();
    }

    /**
     * A method that initializes the different items to be included in the specialVendingMachine.
     */
    public void setSvmItems() {

        setRvmItem(); // Sets the Regular Items also since they will also be sold in the Special Vending Machine
        setDenomination(); // It uses the exact same denomination system as the Regula Vending Machine

        // Instantiating items that cannot be sold on their own
        garlic = new UnsellableItem("Garlic | 1 tsp", 4.0, 5);
        shallots = new UnsellableItem("Shallots | 1 tbsp", 7.25, 7);
        vegOil = new UnsellableItem("Vegetable Oil | 1 tbsp", 9.5, 50);
        carrot = new UnsellableItem("Carrot | 1 tbsp", 3.25, 3);
        cabbage = new UnsellableItem("Cabbage | 1 tbsp", 2.5, 2);
        chicken = new UnsellableItem("Chicken | 1 slice", 23.5, 27);

        unsellableList = new ArrayList<>(); // ArrayList to store all instances of the unsellable items
        comboItem = new ArrayList<>(); // ArrayList to store the items to be added to the combo

        for (int i = 0; i < 20; i++) { // Adds 20 of each Unsellable item to the ArrayList, the order does not matter

            unsellableList.add(garlic);
            unsellableList.add(shallots);
            unsellableList.add(vegOil);
            unsellableList.add(carrot);
            unsellableList.add(cabbage);
            unsellableList.add(chicken);
        }
    }

    /**
     * Creates a SpecialVendingMachine when the button is pressed to do so.
     */
    public void createSvm() {

        setSvmItems(); // calls the method that initializes the variety of items to be put in the SpecialVendingMachine.
        setDenomination(); // calls the method that initializes the denominations to be used as change.

        specialVendingMachine = new SpecialVendingMachine(itemSlots, denominationSlots); // Instantiating a Special Vending Machine (SVM)

        view.svmSuccess(); // A message saying that a special vending machine was successfully created.
        view.exitCreateMenu();

        switcher = true; // sets the switcher to "SVM mode"
    }

    /**
     *  A method that goes through the process of buying ComboItem fried rice when the necessary button is pressed.
     */
    public void buyFriedRice() {

        view.selectAddOns(); // GUI elements that ask for the user's preferred add-ons for the combo item.

        friedRice = new ComboItem("Fried Rice", 0, 0); // Starts Without any price since there are no items inside yet

        friedRice.setAddOns(rice); // Adds rice, egg, and vegetable oil as base items included in the fried rice
        friedRice.setAddOns(egg);
        friedRice.setAddOns(vegOil);

        riceList.remove(0); // removes these base items from their respective stock lists
        eggList.remove(0);
        unsellableList.remove(vegOil);
    }

    /**
     *  A method that goes through the process of buying ComboItem fried noodles when the necessary button is pressed.
     */
    public void buyFriedNoodles() {

        view.selectAddOns();

        friedNoodles = new ComboItem("Fried Noodles", 0, 0); // Starts Without any price since there are no items inside yet

        friedNoodles.setAddOns(noodles); // Adds noodles, egg, and vegetable oil as base items included in the fried rice
        friedNoodles.setAddOns(egg);
        friedNoodles.setAddOns(vegOil);

        noodlesList.remove(0); // removes these base items from their respective stock lists
        eggList.remove(0);
        unsellableList.remove(vegOil);
    }

    /**
     *  A helper method to aid in the purchase of ComboItems, generalizes the method so that it is no unnecessary
     *  redundancy for the two ComboItems.
     *
     * @param item - The ComboItem that is selected by the user.
     */
    public void buyFriedHelper(ComboItem item) {

        int sellableIndex = addSellable(); // Indexes of the selected add-ons
        int unsellableIndexOne = addUnsellableOne();
        int unsellableIndexTwo = addUnsellableTwo();
        int unsellableIndexThree = addUnsellableThree();

        if (sellableIndex != 0) { // Screens the inputted index. If index is 0, it means that user selected "none"

            item.setAddOns(itemSlots.get(sellableIndex - 1).get(0)); // From the arraylist of arraylists itemSlots, get the index of the arraylist of the specific item, then get the first item
            // Need to subtract 1 because index 0 means no item but 0 means siomai in the sellableItems array
            itemSlots.get(sellableIndex - 1).remove(0);              // After adding that item, remove it from the arraylist

        }

        if (unsellableIndexOne != 0) {

            item.setAddOns(findUnsellableItem(unsellableIndexOne));  // Since in the function, 1 is garlic, no need to subtract 1
            unsellableList.remove(findUnsellableItem(unsellableIndexOne)); // After adding, removes the item from the unsellableList
        }

        if (unsellableIndexTwo != 0) {

            item.setAddOns(findUnsellableItem(unsellableIndexTwo));
            unsellableList.remove(findUnsellableItem(unsellableIndexTwo));
        }

        if (unsellableIndexThree != 0) {

            item.setAddOns(findUnsellableItem(unsellableIndexThree));
            unsellableList.remove(findUnsellableItem(unsellableIndexThree));
        }
    }

    /**
     * A method to find the unsellable item that the user wishes to put on their combo item
     *
     * @param index - The index of the unsellable item they selected.
     * @return item - The unsellableItem in question.
     */
    public UnsellableItem findUnsellableItem(int index) {

        UnsellableItem item = null;

        switch (index) {

            case 1: // If index is one, then the user wishes to select garlic...
                item = garlic;
                break;
            case 2: // if its two, then they want shallots and so on...
                item = shallots;
                break;
            case 3:
                item = vegOil;
                break;
            case 4:
                item = carrot;
                break;
            case 5:
                item = cabbage;
                break;
            case 6:
                item = chicken;
                break;
        }

        return item; // return the unsellable item relative to the index
    }


    /**
     *  This gets the index of the selected sellable item as an add-on for the combo item.
     *
     * @return index - The index of the sellable item the user wishes to add to their combo item.
     */
    public int addSellable() {

        int index = view.sellableIndex(); // Gets the index of the item the user selected.

        ComboItem item;

        if (friedRice != null) {

            item = friedRice; // If the user selected fried rice, then it is not null and the item becomes friedRice.
        }

        else {

            item = friedNoodles; // else, it becomes friedNoodles.
        }

        switch(index) {

            case 1: // If the index is 1, then the user wishes to add siomai as their sellable item.
                item.setAddOns(siomai);
                break;
            case 2: // If 2, then its hakao, and so on...
                item.setAddOns(hakao);
                break;
            case 3:
                item.setAddOns(wanton);
                break;
            case 4:
                item.setAddOns(fishcake);
                break;
            case 5:
                item.setAddOns(asado);
                break;
            case 6:
                item.setAddOns(egg);
                break;
            case 7:
                item.setAddOns(rice);
                break;
            case 8:
                item.setAddOns(noodles);
                break;
        }

        return index; // return the index to be used in other methods.
    }

    /**
     *  Does the same as the method above, but for unsellable items.
     *
     * @param index
     */
    public void unsellableSwitch(int index) {

        ComboItem item;

        if (friedRice != null) {

            item = friedRice;
        }

        else {

            item = friedNoodles;
        }

        switch(index) {

            case 1: // If user selects index 1, they want garlic as an unsellable item add-on.
                item.setAddOns(garlic);
                break;
            case 2: // If 2, its shallots and so on...
                item.setAddOns(shallots);
                break;
            case 3:
                item.setAddOns(vegOil);
                break;
            case 4:
                item.setAddOns(carrot);
                break;
            case 5:
                item.setAddOns(cabbage);
                break;
            case 6:
                item.setAddOns(chicken);
                break;
        }
    }

    /**
     * Adds the first of three unsellable items the user selected by providing the index of that unsellable item.
     *
     * @return - the index of the selected item.
     */
    public int addUnsellableOne() {

        int index = view.unsellableIndexOne(); // Gets the index based on the inputs done on the view.
        unsellableSwitch(index); // From the index retrieved from the view, pit it against the unsellableSwitch method above.

        return index; // return the index of the unsellable item.
    }

    /**
     * Adds the second of three unsellable items the user selected by providing the index of that unsellable item.
     *
     * @return - the index of the selected item.
     */
    public int addUnsellableTwo() {

        int index = view.unsellableIndexTwo();
        unsellableSwitch(index);

        return index;
    }

    /**
     * Adds the third of three unsellable items the user selected by providing the index of that unsellable item.
     *
     * @return - the index of the selected item.
     */
    public int addUnsellableThree() {

        int index = view.unsellableIndexThree();
        unsellableSwitch(index);

        return index;
    }

    /**
     * Once the inputs have been finalized, click the button to execute this method which sets the inputs in stone.
     */
    public void confirmAddOns() {

        if (friedRice != null) { // If the current Combo Item is fried rice

            friedRice.updateCombo(); // Update the price and calories of the fried rice
            specialVendingMachine.incrementSales(friedRice.getPrice()); // After updating the price and calories, increment the sales based on the price
            buyFriedHelper(friedRice);    // Increments the specific add-ons selected, removes said items from their respective lists
            view.displayCombo(friedRice); // Frame for displaying the combo item's content
            moneyHandler(friedRice); // Prompts for payment
        }

        else {

            friedNoodles.updateCombo(); // Update the price and calories of the fried rice
            specialVendingMachine.incrementSales(friedNoodles.getPrice());
            buyFriedHelper(friedNoodles);    // Increments the specific add-ons selected, removes said items from their respective lists
            view.displayCombo(friedNoodles); // Frame for displaying the combo item's content
            moneyHandler(friedNoodles); // Prompts for payment
        }

        view.exitSvmBuyMenu(); // Exit the following menus after the transaction
        view.exitBuyMenu();
        view.exitDisplayCombo();
    }

}
