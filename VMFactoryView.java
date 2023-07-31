import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The VendingMachineFactoryView class serves as the
 */
public class VMFactoryView {

    // Main Menu View
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel welcomeMsg;
    private JButton createMachine;
    private JButton testMachine;
    private JButton exitMenu;

    // Create Menu View
    private JFrame createFrame = new JFrame();
    private JPanel createPanel = new JPanel();
    private JLabel selectLabel = new JLabel();
    private JButton rvmButton = new JButton();
    private JButton svmButton = new JButton();

    // Testing Menu View
    private JFrame testFrame = new JFrame();
    private JPanel testPanel = new JPanel();
    private JLabel testLabel = new JLabel();
    private JButton testVendingButton = new JButton();
    private JButton maintainVendingButton = new JButton();
    private JButton exitTestMenuButton = new JButton();

    // Test Vending Features View
    private JFrame testVendingFrame = new JFrame();
    private JPanel testVendingPanel = new JPanel();
    private JLabel testVendingLabel = new JLabel();
    private JButton viewItemsButton = new JButton();
    private JButton buyItemButton = new JButton();
    private JButton exitVendingFeatureButton = new JButton();

    // Buy Item View
    private JFrame buyItemFrame = new JFrame();
    private JLabel buyItemLabel = new JLabel();
    private JPanel buyItemPanel = new JPanel();
    private JButton buySiomai = new JButton();
    private JButton buyHakao = new JButton();
    private JButton buyWanton = new JButton();
    private JButton buyFishcake = new JButton();
    private JButton buyAsado = new JButton();
    private JButton buyEgg = new JButton();
    private JButton buyRice = new JButton();
    private JButton buyNoodles = new JButton();
    private JButton exitBuyMenu = new JButton();

    // SVM Buy Item
    private JButton buyFriedRice = new JButton();
    private JButton buyFriedNoodles = new JButton();

    // Display Current Prices View
    private JFrame displayCurFrame = new JFrame();

    // Maintain Machine View
    private JFrame maintainFrame = new JFrame();
    private JButton exitMaintainMenu = new JButton();

    // Addon ComboBoxes
    private JFrame addOnFrame = new JFrame();
    private JPanel addOnPanel = new JPanel();
    private JLabel addOnLabel = new JLabel();
    private JLabel sellableLabel = new JLabel();
    private JLabel unsellable1 = new JLabel();
    private JLabel unsellable2 = new JLabel();
    private JLabel unsellable3 = new JLabel();

    private JComboBox sellableItems = new JComboBox();
    private JComboBox unsellableItems1 = new JComboBox();
    private JComboBox unsellableItems2 = new JComboBox();
    private JComboBox unsellableItems3 = new JComboBox();
    private JButton confirmAddOns = new JButton();

    // Combo
    private JFrame buyComboFrame = new JFrame();
    private JPanel buyComboPanel = new JPanel();

    // Buy Combo View
    private JLabel buyCombo = new JLabel();
    private JPanel comboPanel = new JPanel();

    // Display Combo View
    private JLabel comboLabel = new JLabel();
    private JLabel baseItemOne = new JLabel();
    private JLabel baseItemTwo = new JLabel();
    private JLabel baseItemThree = new JLabel();
    private JLabel comboTwoLabel = new JLabel();
    private JLabel addOnOne = new JLabel();
    private JLabel addOnTwo = new JLabel();
    private JLabel addOnThree = new JLabel();
    private JLabel addOnFour = new JLabel();
    private JLabel totalCombo = new JLabel();


    public VMFactoryView() {

        mainFrame = new JFrame("Main Menu"); // Instantiates the GUI components for the main menu in the constructor
        createMachine = new JButton("Create a Machine");
        testMachine = new JButton("Test Vending Machine");
        exitMenu = new JButton("Exit Factory");

        mainPanel = new JPanel(new GridLayout(4,0)); // Sets a grid layout for the mainPanel

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // IF the frame is closed, the program terminates
        mainFrame.setSize(500,250);

        welcomeMsg = new JLabel("Welcome to the Vending Machine Factory!");
        mainPanel.add(welcomeMsg);

        mainPanel.add(createMachine); // Adds buttons that lead to more sub-menus
        mainPanel.add(testMachine);
        mainPanel.add(exitMenu);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    public void addCreateMachineListener(ActionListener e) {

        createMachine.addActionListener(e);
    }

    public void addTestMachineListener(ActionListener e) {

        testMachine.addActionListener(e);
    }

    public void addExitMenuListener(ActionListener e) {

        exitMenu.addActionListener(e);
    }

    public void exitMainFrame() {

        mainFrame.dispose();
    }

    public void createMenuView() { // View frame for Create Vending Machine Sub-menu

        createFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createFrame.setSize(500,250);
        createFrame.setTitle("Create a Machine");

        rvmButton.setText("Regular Vending Machine");
        svmButton.setText("Special Vending Machine");

        createPanel.setLayout(new GridLayout(3,0));

        selectLabel.setText("Please Select a Type of Vending Machine to Create:");

        createPanel.add(selectLabel);
        createPanel.add(rvmButton);
        createPanel.add(svmButton);
        createFrame.add(createPanel);

        createFrame.setVisible(true);
    }

    public void addCreateRvmButton (ActionListener e) {

        rvmButton.addActionListener(e);
    }

    public void addCreateSvmButton (ActionListener e) {

        svmButton.addActionListener(e);
    }

    public void exitCreateMenu () {

        createFrame.dispose();
    }

    public void testMenuView () {

        testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Only closes the current frame, does not terminate the program
        testFrame.setSize(500,250);
        testFrame.setTitle("Test Menu");

        testVendingButton.setText("Test Vending Features");
        maintainVendingButton.setText("Test Maintenance Features");
        exitTestMenuButton.setText("Exit Test Menu");

        testPanel.setLayout(new GridLayout(4,0));

        testLabel.setText("Please Select the Action You Wish to Perform:");

        testPanel.add(testLabel); // Adds the different buttons of the menu
        testPanel.add(testVendingButton);
        testPanel.add(maintainVendingButton);
        testPanel.add(exitTestMenuButton);

        testFrame.add(testPanel);
        testFrame.setVisible(true);
    }

    public void addTestVendingListener(ActionListener e) {

        testVendingButton.addActionListener(e);
    }

    public void addMaintainVendingListener(ActionListener e) {

        maintainVendingButton.addActionListener(e);
    }

    public void addExitTestMenuListener(ActionListener e) {

        exitTestMenuButton.addActionListener(e);
    }

    public void exitTestMenu() {

        testFrame.dispose();
    }

    public void testVendingFeaturesView() {

        testVendingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        testVendingFrame.setSize(500,250);
        testVendingFrame.setTitle("Vending Features");

        viewItemsButton.setText("View the Items For Sale");
        buyItemButton.setText("Buy an Item");
        exitVendingFeatureButton.setText("Exit Vending Menu");

        testVendingPanel.setLayout(new GridLayout(4,0));

        testVendingLabel.setText("Please Select The Action You Wish to Perform:");

        testVendingPanel.add(testVendingLabel);
        testVendingPanel.add(viewItemsButton);
        testVendingPanel.add(buyItemButton);
        testVendingPanel.add(exitVendingFeatureButton);

        testVendingFrame.add(testVendingPanel);
        testVendingFrame.setVisible(true);
    }

    public void addViewItemsListener(ActionListener e) {

        viewItemsButton.addActionListener(e);
    }

    public void addBuyItemListener(ActionListener e) {

        buyItemButton.addActionListener(e);
    }

    public void addExitVendingFeatureListener(ActionListener e) {

        exitVendingFeatureButton.addActionListener(e);
    }

    public void exitVendingFeatures() {

        testVendingFrame.dispose();
    }


    public void displayRvmItems (Item siomai, int siomaiStock, Item hakao, int hakaoStock, Item wanton, int wantonStock, Item fishcake, int fishcakeStock, Item asado,
                                 int asadoStock, Item egg, int eggStock, Item rice, int riceStock, Item noodles, int noodleStock) {

        JFrame displayItemFrame = new JFrame("Item Display");
        displayItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayItemFrame.setSize(500,250);

        JPanel displayItemPanel = new JPanel(new GridLayout(9,0));
        JLabel displayItemLabel = new JLabel("List of Items Currently Available:");

        JLabel siomaiLabel = new JLabel("Item 1: " + siomai.getName() + " Price: P" + siomai.getPrice() + " Calories: " + siomai.getCalories() + " Stock: " + siomaiStock);
        JLabel hakaoLabel = new JLabel("Item 2: " + hakao.getName() + " Price: P" + hakao.getPrice() + " Calories: " + hakao.getCalories() + " Stock: " + hakaoStock);
        JLabel wantonLabel = new JLabel("Item 3: " + wanton.getName() + " Price: P" + wanton.getPrice() + " Calories: " + wanton.getCalories() + " Stock: " + wantonStock);
        JLabel fishcakeLabel = new JLabel("Item 4: " + fishcake.getName() + " Price: P" + fishcake.getPrice() + " Calories: " + fishcake.getCalories() + " Stock: " + fishcakeStock);

        JLabel asadoLabel = new JLabel("Item 5: " + asado.getName() + " Price: P" + asado.getPrice() + " Calories: " + asado.getCalories() + " Stock: " + asadoStock);
        JLabel eggLabel = new JLabel("Item 6: " + egg.getName() + " Price: P" + egg.getPrice() + " Calories: " + egg.getCalories() + " Stock: " + eggStock);
        JLabel riceLabel = new JLabel("Item 7: " + rice.getName() + " Price: P" + rice.getPrice() + " Calories: " + rice.getCalories() + " Stock: " + riceStock);
        JLabel noodlesLabel = new JLabel("Item 8: " + noodles.getName() + " Price: P" + noodles.getPrice() + " Calories: " + noodles.getCalories() + " Stock: " + noodleStock);

        displayItemPanel.add(displayItemLabel);
        displayItemPanel.add(siomaiLabel);
        displayItemPanel.add(hakaoLabel);
        displayItemPanel.add(wantonLabel);
        displayItemPanel.add(fishcakeLabel);
        displayItemPanel.add(asadoLabel);
        displayItemPanel.add(eggLabel);
        displayItemPanel.add(riceLabel);
        displayItemPanel.add(noodlesLabel);

        displayItemFrame.add(displayItemPanel);
        displayItemFrame.setVisible(true);
    }

    public void displayCurPrices(String siomai, String hakao, String wanton, String fishcake, String asado, String egg, String rice, String noodles) {

        displayCurFrame.setTitle("Current Prices");
        displayCurFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayCurFrame.setSize(500,250);

        JPanel displayCurPanel = new JPanel(new GridLayout(9,0));

        JLabel displayCurLabel = new JLabel("List of Current Items");
        JLabel siomaiLabel = new JLabel("1.  " + siomai);
        JLabel hakaoLabel = new JLabel("2.  " + hakao);
        JLabel wantonLabel = new JLabel("3.  " + wanton);
        JLabel fishcakeLabel = new JLabel("4.  " + fishcake);
        JLabel asadoLabel = new JLabel("5.  " + asado);
        JLabel eggLabel = new JLabel("6.  " + egg);
        JLabel riceLabel = new JLabel("7.  " + rice);
        JLabel noodlesLabel = new JLabel("8.  " + noodles);

        displayCurPanel.add(displayCurLabel);
        displayCurPanel.add(siomaiLabel);
        displayCurPanel.add(hakaoLabel);
        displayCurPanel.add(wantonLabel);
        displayCurPanel.add(fishcakeLabel);
        displayCurPanel.add(asadoLabel);
        displayCurPanel.add(eggLabel);
        displayCurPanel.add(riceLabel);
        displayCurPanel.add(noodlesLabel);

        displayCurFrame.add(displayCurPanel);
        displayCurFrame.setVisible(true);
    }

    public void exitDisplayCurrent() {

        displayCurFrame.dispose();
    }

    public void displayDenoms(Denomination hundred, int hundredStock, Denomination fifty, int fiftyStock, Denomination twenty, int twentyStock, Denomination ten, int tenStock, Denomination five,
                              int fiveStock, Denomination one, int oneStock, Denomination fiveCents, int twFiveCentStock, Denomination twFiveCents, int fiveCentStock) {

        JFrame displayDenomFrame = new JFrame("Denominations");
        displayDenomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayDenomFrame.setSize(500,250);

        JPanel displayDenomPanel = new JPanel(new GridLayout(9,0));
        JLabel displayDenomLabel = new JLabel("List of Denominations Currently Stocked:");

        JLabel hundredLabel = new JLabel("P" + hundred.getDenomination() + " Stock: " + hundredStock);
        JLabel fiftyLabel = new JLabel("P" + fifty.getDenomination() + " Stock: " + fiftyStock);
        JLabel twentyLabel = new JLabel("P" + twenty.getDenomination() + " Stock: " + twentyStock);
        JLabel tenLabel = new JLabel("P" + ten.getDenomination() + " Stock: " + tenStock);
        JLabel fiveLabel = new JLabel("P" + five.getDenomination() + " Stock: " + fiveStock);
        JLabel oneLabel = new JLabel("P" + one.getDenomination() + " Stock: " + oneStock);
        JLabel fiveCentsLabel = new JLabel("P" + fiveCents.getDenomination() + " Stock: " + fiveCentStock);
        JLabel twFiveCentsLabel = new JLabel("P" + twFiveCents.getDenomination() + " Stock: " + twFiveCentStock);

        displayDenomPanel.add(displayDenomLabel);
        displayDenomPanel.add(hundredLabel);
        displayDenomPanel.add(fiftyLabel);
        displayDenomPanel.add(twentyLabel);
        displayDenomPanel.add(tenLabel);
        displayDenomPanel.add(fiveLabel);
        displayDenomPanel.add(oneLabel);
        displayDenomPanel.add(fiveCentsLabel);
        displayDenomPanel.add(twFiveCentsLabel);

        displayDenomFrame.add(displayDenomPanel);
        displayDenomFrame.setVisible(true);
    }

    public void buyRvmItem(Item siomai, int siomaiStock, Item hakao, int hakaoStock, Item wanton, int wantonStock, Item fishcake, int fishcakeStock,
                           Item asado, int asadoStock, Item egg, int eggStock, Item rice, int riceStock, Item noodles, int noodleStock) {

        buyItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buyItemFrame.setSize(750,750);
        buyItemFrame.setTitle("Buy Menu");
        buyItemFrame.setLayout(new GridLayout(3,0));

        buyItemPanel.setLayout(new GridLayout(2,4));

        buyItemLabel.setText("Select the Item You Wish to Purchase:");
        buyItemLabel.setHorizontalAlignment(SwingConstants.CENTER);

        buySiomai.setText("<html>Item 1: " + siomai.getName() + "<br>Price: " + siomai.getPrice() + "<br>Calories: " + siomai.getCalories() + "<br>Stock: " + siomaiStock + "</html>");
        buyHakao.setText("<html>Item 2: " + hakao.getName() + "<br>Price: " + hakao.getPrice() + "<br>Calories: " + hakao.getCalories() + "<br>Stock: " + hakaoStock + "</html>");
        buyWanton.setText("<html>Item 3: " + wanton.getName() + "<br>Price: " + wanton.getPrice() + "<br>Calories: " + wanton.getCalories() + "<br>Stock: " + wantonStock + "</html>");
        buyFishcake.setText("<html>Item 4: " + fishcake.getName() + "<br>Price: " + fishcake.getPrice() + "<br>Calories: " + fishcake.getCalories() + "<br>Stock: " + fishcakeStock + "</html>");
        buyAsado.setText("<html>Item 5: " + asado.getName() + "<br>Price: " + asado.getPrice() + "<br>Calories: " + asado.getCalories() + "<br>Stock: " + asadoStock + "</html>");
        buyEgg.setText("<html>Item 6: " + egg.getName() + "<br>Price: " + egg.getPrice() + "<br>Calories: " + egg.getCalories() + "<br>Stock: " + eggStock + "</html>");
        buyRice.setText("<html>Item 7: " + rice.getName() + "<br>Price: " + rice.getPrice() + "<br>Calories: " + rice.getCalories() + "<br>Stock: " + riceStock + "</html>");
        buyNoodles.setText("<html>Item 8: " + noodles.getName() + "<br>Price: " + noodles.getPrice() + "<br>Calories: " + noodles.getCalories() + "<br>Stock: " + noodleStock + "</html>");

        exitBuyMenu.setText("Exit Buy Menu");
        exitBuyMenu.setVerticalTextPosition(SwingConstants.CENTER);
        exitBuyMenu.setHorizontalTextPosition(SwingConstants.CENTER);

        buyItemPanel.add(buySiomai);
        buyItemPanel.add(buyHakao);
        buyItemPanel.add(buyWanton);
        buyItemPanel.add(buyFishcake);
        buyItemPanel.add(buyAsado);
        buyItemPanel.add(buyEgg);
        buyItemPanel.add(buyRice);
        buyItemPanel.add(buyNoodles);

        buyItemFrame.add(buyItemLabel);
        buyItemFrame.add(buyItemPanel);
        buyItemFrame.add(exitBuyMenu);

        buyItemFrame.setVisible(true);
    }

    public void addBuySiomaiListener(ActionListener e) {

        buySiomai.addActionListener(e);
    }

    public void addBuyHakaoListener(ActionListener e) {

        buyHakao.addActionListener(e);
    }

    public void addBuyWantonListener(ActionListener e) {

        buyWanton.addActionListener(e);
    }

    public void addBuyFishcakeListener(ActionListener e) {

        buyFishcake.addActionListener(e);
    }

    public void addBuyAsadoListener(ActionListener e) {

        buyAsado.addActionListener(e);
    }

    public void addBuyEggListener(ActionListener e) {

        buyEgg.addActionListener(e);
    }

    public void addBuyRiceListener(ActionListener e) {

        buyRice.addActionListener(e);
    }

    public void addBuyNoodlesListener(ActionListener e) {

        buyNoodles.addActionListener(e);
    }

    public void addExitBuyMenuListener(ActionListener e) {

        exitBuyMenu.addActionListener(e);
    }

    public void exitBuyMenu() {

        buyItemFrame.dispose();
    }

    public double amountInput (double requiredAmount) {

        double input = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount of Money (Price: P" + requiredAmount + ")"));

        return input;
    }

    public void displayChange(int hundredCount, int fiftyCount, int twentyCount, int tenCount, int fiveCount, int oneCount, int fiveCentCount, int tfCentCount, double change) {

        JFrame changeFrame = new JFrame("Change Due");
        changeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changeFrame.setSize(500,250);

        JPanel changePanel = new JPanel(new GridLayout(9,0));

        JLabel totalChangeText = new JLabel("Total Change: P" + change);
        JLabel hundredText = new JLabel("100 x "  + hundredCount);
        JLabel fiftyText = new JLabel("50 x "  + fiftyCount);
        JLabel twentyText = new JLabel("20 x "  + twentyCount);
        JLabel tenText = new JLabel("10 x "  + tenCount);
        JLabel fiveText = new JLabel("5 x "  + fiveCount);
        JLabel oneText = new JLabel("1 x "  + oneCount);
        JLabel fiveCentText = new JLabel("0.5 x "  + fiveCentCount);
        JLabel tfCentText = new JLabel("0.25 x "  + tfCentCount);


        changePanel.add(totalChangeText);
        changePanel.add(hundredText);
        changePanel.add(fiftyText);
        changePanel.add(twentyText);
        changePanel.add(tenText);
        changePanel.add(fiveText);
        changePanel.add(oneText);
        changePanel.add(fiveCentText);
        changePanel.add(tfCentText);


        changeFrame.add(changePanel);
        changeFrame.setVisible(true);
    }

    public int maintainMachineMenu() {

        int input = 0;

        maintainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        maintainFrame.setSize(500,250);

        JPanel maintainPanel = new JPanel (new GridLayout(9,0));

        JLabel maintainLabel = new JLabel("Type the Key of the Action You Would Like to Perform");
        JLabel viewItemLabel = new JLabel("1.  View Current Item Stock"); // 1
        JLabel viewDenomLabel = new JLabel("2.  View Current Denominations"); // 2
        JLabel viewSalesLabel = new JLabel("3.  View Sales"); // 3
        JLabel restockItemLabel = new JLabel("4.  Restock Current Items"); // 4
        JLabel restockChangeLabel = new JLabel("5.  Restock Change Denominations"); // 5
        JLabel setPriceLabel = new JLabel("6.  Set Item Price"); // 6
        JLabel collectSales = new JLabel("7.  Collect Sales and Reset Balance"); // 7

        exitMaintainMenu.setText("Exit Maintenance Menu");

        maintainPanel.add(maintainLabel);
        maintainPanel.add(viewItemLabel);
        maintainPanel.add(viewDenomLabel);
        maintainPanel.add(viewSalesLabel);
        maintainPanel.add(restockItemLabel);
        maintainPanel.add(restockChangeLabel);
        maintainPanel.add(setPriceLabel);
        maintainPanel.add(collectSales);
        maintainPanel.add(exitMaintainMenu);

        maintainFrame.add(maintainPanel);
        maintainFrame.setFocusable(true);
        maintainFrame.setVisible(true);

        String userInput = JOptionPane.showInputDialog(null, "Enter Choice:");
        if (userInput != null) {

            input = Integer.parseInt(userInput);
        }

        else {

            input = 8;
        }

        while (input < 1 || input > 8) {

            String userInput2 = JOptionPane.showInputDialog(null, "Invalid Input, Please Try Again", JOptionPane.ERROR_MESSAGE);
            if (userInput2 != null) {

                input = Integer.parseInt(userInput2);
            }

            else {

                input = 8;
            }
        }

        return input;
    }

    public void displaySales(double totalSales) {

        JFrame salesFrame = new JFrame("Total Sales");
        salesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        salesFrame.setSize(500,250);

        JPanel displaySalesPanel = new JPanel(new GridLayout(2,0));

        JLabel displaySalesLabel = new JLabel("Current Sales:");
        JLabel totalSalesLabel = new JLabel("P " + totalSales);

        displaySalesPanel.add(displaySalesLabel);
        displaySalesPanel.add(totalSalesLabel);

        salesFrame.add(displaySalesPanel);
        salesFrame.setVisible(true);
    }

    public void confirmItemRestock() {

        JOptionPane.showMessageDialog(null, "Items Successfully Restocked!", "Restock", JOptionPane.INFORMATION_MESSAGE);
    }

    public void confirmDenomRestock() {

        JOptionPane.showMessageDialog(null, "Denominations Successfully Restocked!", "Restock", JOptionPane.INFORMATION_MESSAGE);
    }

    public void confirmPayment() {

        JOptionPane.showMessageDialog(null, "Item Successfully Purchased!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
    }

    public void exitMaintain() {

        maintainFrame.dispose();
    }

    public void addExitMaintainButton(ActionListener e) {

        exitMaintainMenu.addActionListener(e);
    }

    public int askItemType() {

        int input = 0;

        String userInput = JOptionPane.showInputDialog(null,"Enter The Number of The Item to be Changed:", "Item Type", JOptionPane.PLAIN_MESSAGE);
        if (userInput != null) {

            input = Integer.parseInt(userInput);
        }

        else {

            input = 8;
        }

        return input;
    }

    public double askItemPrice(double curPrice) {

        double input = curPrice;

        String userInput = JOptionPane.showInputDialog(null, "Enter Price of the Item:", "Item Price", JOptionPane.PLAIN_MESSAGE);
        if (userInput != null) {

            input = Double.parseDouble(userInput);
        }

        else {

            input = curPrice;
        }

        return input;
    }

    public void confirmPriceChange() {

        JOptionPane.showMessageDialog(null, "Price Successfully Changed!", "Change Price", JOptionPane.INFORMATION_MESSAGE);
        exitMaintain();
    }

    public void confirmSalesCollection(double sales) {

        JOptionPane.showMessageDialog(null, "Sales Successfully Collected: P " + sales, "Change Price", JOptionPane.INFORMATION_MESSAGE);
        exitMaintain();
    }


    public void displaySvmItems(Item siomai, int siomaiStock, Item hakao, int hakaoStock, Item wanton, int wantonStock, Item fishcake, int fishcakeStock, Item asado, int asadoStock, Item egg,
                                int eggStock, Item rice, int riceStock, Item noodles, int noodleStock, UnsellableItem garlic, int garlicStock, UnsellableItem shallots, int shallotsStock,
                                UnsellableItem vegOil, int vegOilStock, UnsellableItem carrot, int carrotStock, UnsellableItem cabbage, int cabbageStock, UnsellableItem chicken,
                                int chickenStock) {

        JFrame displayItemFrame = new JFrame("Item Display");
        displayItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayItemFrame.setSize(500,500);

        JPanel displayItemPanel = new JPanel(new GridLayout(16,0));
        JLabel displayItemLabel = new JLabel("List of Items Currently Available:");

        JLabel siomaiLabel = new JLabel("Item 1: " + siomai.getName() + " Price: P" + siomai.getPrice() + " Calories: " + siomai.getCalories() + " Stock: " + siomaiStock);
        JLabel hakaoLabel = new JLabel("Item 2: " + hakao.getName() + " Price: P" + hakao.getPrice() + " Calories: " + hakao.getCalories() + " Stock: " + hakaoStock);
        JLabel wantonLabel = new JLabel("Item 3: " + wanton.getName() + " Price: P" + wanton.getPrice() + " Calories: " + wanton.getCalories() + " Stock: " + wantonStock);
        JLabel fishcakeLabel = new JLabel("Item 4: " + fishcake.getName() + " Price: P" + fishcake.getPrice() + " Calories: " + fishcake.getCalories() + " Stock: " + fishcakeStock);

        JLabel asadoLabel = new JLabel("Item 5: " + asado.getName() + " Price: P" + asado.getPrice() + " Calories: " + asado.getCalories() + " Stock: " + asadoStock);
        JLabel eggLabel = new JLabel("Item 6: " + egg.getName() + " Price: P" + egg.getPrice() + " Calories: " + egg.getCalories() + " Stock: " + eggStock);
        JLabel riceLabel = new JLabel("Item 7: " + rice.getName() + " Price: P" + rice.getPrice() + " Calories: " + rice.getCalories() + " Stock: " + riceStock);
        JLabel noodlesLabel = new JLabel("Item 8: " + noodles.getName() + " Price: P" + noodles.getPrice() + " Calories: " + noodles.getCalories() + " Stock: " + noodleStock);

        JLabel displayUnsellableLabel = new JLabel("List of Add-on Items for Combo Meals:");
        JLabel garlicLabel = new JLabel("Item 1: " + garlic.getName() + " Price: P" + garlic.getPrice() + " Calories: " + garlic.getCalories() + " Stock: " + garlicStock);
        JLabel shallotsLabel = new JLabel("Item 2: " + shallots.getName() + " Price: P" + shallots.getPrice() + " Calories: " + shallots.getCalories() + " Stock: " + shallotsStock);
        JLabel vegOilLabel = new JLabel("Item 3: " + vegOil.getName() + " Price: P" + vegOil.getPrice() + " Calories: " + vegOil.getCalories() + " Stock: " + vegOilStock);
        JLabel carrotLabel = new JLabel("Item 4: " + carrot.getName() + " Price: P" + carrot.getPrice() + " Calories: " + carrot.getCalories() + " Stock: " + carrotStock);
        JLabel cabbageLabel = new JLabel("Item 5: " + cabbage.getName() + " Price: P" + cabbage.getPrice() + " Calories: " + cabbage.getCalories() + " Stock: " + cabbageStock);
        JLabel chickenLabel = new JLabel("Item 6: " + chicken.getName() + " Price: P" + chicken.getPrice() + " Calories: " + chicken.getCalories() + " Stock: " + chickenStock);

        displayItemPanel.validate();
        displayItemPanel.repaint();

        displayItemPanel.add(displayItemLabel);
        displayItemPanel.add(siomaiLabel);
        displayItemPanel.add(hakaoLabel);
        displayItemPanel.add(wantonLabel);
        displayItemPanel.add(fishcakeLabel);
        displayItemPanel.add(asadoLabel);
        displayItemPanel.add(eggLabel);
        displayItemPanel.add(riceLabel);
        displayItemPanel.add(noodlesLabel);

        displayItemPanel.add(displayUnsellableLabel);
        displayItemPanel.add(garlicLabel);
        displayItemPanel.add(shallotsLabel);
        displayItemPanel.add(vegOilLabel);
        displayItemPanel.add(carrotLabel);
        displayItemPanel.add(cabbageLabel);
        displayItemPanel.add(chickenLabel);

        displayItemFrame.add(displayItemPanel);
        displayItemFrame.setVisible(true);
    }

    public void buySvmItems(Item siomai, int siomaiStock, Item hakao, int hakaoStock, Item wanton, int wantonStock, Item fishcake, int fishcakeStock, Item asado, int asadoStock, Item egg,
                            int eggStock, Item rice, int riceStock, Item noodles, int noodleStock, UnsellableItem garlic, int garlicStock, UnsellableItem shallots, int shallotsStock,
                            UnsellableItem vegOil, int vegOilStock, UnsellableItem carrot, int carrotStock, UnsellableItem cabbage, int cabbageStock, UnsellableItem chicken, int chickenStock) {

        buyItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buyItemFrame.setSize(750,750);
        buyItemFrame.setTitle("Buy Menu");
        buyItemFrame.setLayout(new GridLayout(4,0));

        buyItemLabel.setText("Select the Item You Wish to Purchase:");
        buyItemLabel.setHorizontalAlignment(SwingConstants.CENTER);

        buySiomai.setText("<html>Item 1: " + siomai.getName() + "<br>Price: " + siomai.getPrice() + "<br>Calories: " + siomai.getCalories() + "<br>Stock: " + siomaiStock + "</html>");
        buyHakao.setText("<html>Item 2: " + hakao.getName() + "<br>Price: " + hakao.getPrice() + "<br>Calories: " + hakao.getCalories() + "<br>Stock: " + hakaoStock + "</html>");
        buyWanton.setText("<html>Item 3: " + wanton.getName() + "<br>Price: " + wanton.getPrice() + "<br>Calories: " + wanton.getCalories() + "<br>Stock: " + wantonStock + "</html>");
        buyFishcake.setText("<html>Item 4: " + fishcake.getName() + "<br>Price: " + fishcake.getPrice() + "<br>Calories: " + fishcake.getCalories() + "<br>Stock: " + fishcakeStock + "</html>");
        buyAsado.setText("<html>Item 5: " + asado.getName() + "<br>Price: " + asado.getPrice() + "<br>Calories: " + asado.getCalories() + "<br>Stock: " + asadoStock + "</html>");
        buyEgg.setText("<html>Item 6: " + egg.getName() + "<br>Price: " + egg.getPrice() + "<br>Calories: " + egg.getCalories() + "<br>Stock: " + eggStock + "</html>");
        buyRice.setText("<html>Item 7: " + rice.getName() + "<br>Price: " + rice.getPrice() + "<br>Calories: " + rice.getCalories() + "<br>Stock: " + riceStock + "</html>");
        buyNoodles.setText("<html>Item 8: " + noodles.getName() + "<br>Price: " + noodles.getPrice() + "<br>Calories: " + noodles.getCalories() + "<br>Stock: " + noodleStock + "</html>");

        buyCombo.setText("Combo Items:");
        buyCombo.setHorizontalAlignment(SwingConstants.CENTER);;

        buyFriedRice.setText("Combo Meal 1: Fried Rice");
        buyFriedNoodles.setText("Combo Meal 2: Fried Noodles");

        comboPanel.setLayout(new GridLayout(0,2));

        comboPanel.add(buyFriedRice);
        comboPanel.add(buyFriedNoodles);

        buyItemPanel.add(buySiomai);
        buyItemPanel.add(buyHakao);
        buyItemPanel.add(buyWanton);
        buyItemPanel.add(buyFishcake);
        buyItemPanel.add(buyAsado);
        buyItemPanel.add(buyEgg);
        buyItemPanel.add(buyRice);
        buyItemPanel.add(buyNoodles);

        buyItemFrame.add(buyItemLabel);
        buyItemFrame.add(buyItemPanel);
        buyItemFrame.add(buyCombo);
        buyItemFrame.add(comboPanel);

        buyItemFrame.setVisible(true);
    }

    public void addBuyFrRiceListener (ActionListener e) {

        buyFriedRice.addActionListener(e);
    }

    public void addBuyFrNoodlesListener (ActionListener e) {

        buyFriedNoodles.addActionListener(e);
    }

    public void selectAddOns() {

        addOnFrame.setTitle("Select Add-ons");
        addOnFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addOnFrame.setSize(500,500);

        String[] sellItems = {"None", "Siomai", "Hakao", "Fried Wanton", "Fishcake", "Pork Asado", "Scrambled Egg", "Plain Rice", "Plain Noodles"};
        String[] unsellItems = {"None", "Garlic", "Shallots", "Vegetable Oil", "Carrot", "Cabbage", "Chicken"};

        addOnPanel.setLayout(new GridLayout(10,0));

        addOnLabel.setText("Select Add-ons:");
        addOnLabel.setHorizontalAlignment(SwingConstants.CENTER);

        sellableLabel.setText("Select a Main Topping:");
        sellableLabel.setHorizontalAlignment(SwingConstants.CENTER);

        unsellable1.setText("Select an Ingredient:");
        unsellable1.setHorizontalAlignment(SwingConstants.CENTER);

        unsellable2.setText("Select a Second Ingredient:");
        unsellable2.setHorizontalAlignment(SwingConstants.CENTER);

        unsellable3.setText("Select a Third Ingredient:");
        unsellable3.setHorizontalAlignment(SwingConstants.CENTER);

        sellableItems.setModel(new DefaultComboBoxModel(sellItems));
        unsellableItems1.setModel(new DefaultComboBoxModel(unsellItems));
        unsellableItems2.setModel(new DefaultComboBoxModel(unsellItems));
        unsellableItems3.setModel(new DefaultComboBoxModel(unsellItems));

        confirmAddOns.setText("Confirm Add-ons");

        addOnPanel.add(addOnLabel);

        addOnPanel.add(sellableLabel);
        addOnPanel.add(sellableItems);

        addOnPanel.add(unsellable1);
        addOnPanel.add(unsellableItems1);

        addOnPanel.add(unsellable2);
        addOnPanel.add(unsellableItems2);

        addOnPanel.add(unsellable3);
        addOnPanel.add(unsellableItems3);

        addOnPanel.add(confirmAddOns);

        addOnFrame.add(addOnPanel);
        addOnFrame.setVisible(true);
    }

    public int sellableIndex() {

        return sellableItems.getSelectedIndex();
    }

    public int unsellableIndexOne() {

        return unsellableItems1.getSelectedIndex();
    }

    public int unsellableIndexTwo() {

        return unsellableItems2.getSelectedIndex();
    }

    public int unsellableIndexThree() {

        return unsellableItems3.getSelectedIndex();
    }

    public void addSellableListener(ActionListener e) {

        sellableItems.addActionListener(e);
    }

    public void addUnsellableOneListener(ActionListener e) {

        unsellableItems1.addActionListener(e);
    }

    public void addUnsellableTwoListener(ActionListener e) {

        unsellableItems2.addActionListener(e);
    }

    public void addUnsellableThreeListener(ActionListener e) {

        sellableItems.addActionListener(e);
    }

    public void addConfirmAddOnsListener(ActionListener e) {

        confirmAddOns.addActionListener(e);
    }

    public void exitSvmBuyMenu() {

        addOnFrame.dispose();
    }

    public void displayCombo(ComboItem friedRice) {

        buyComboFrame.setTitle("Purchase Combo Item");
        buyComboFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buyComboFrame.setSize(500,250);

        buyComboPanel.setLayout(new GridLayout(11,0));

        comboLabel.setText("Base Combo Meal:");
        baseItemOne.setText("Item 1: " + friedRice.getSpecificAddOn(0).getName() + " Price: P" + friedRice.getSpecificAddOn(0).getPrice() + " Calories: " + friedRice.getSpecificAddOn(0).getCalories());
        baseItemTwo.setText("Item 2: " + friedRice.getSpecificAddOn(1).getName() + " Price: P" + friedRice.getSpecificAddOn(1).getPrice() + " Calories: " + friedRice.getSpecificAddOn(1).getCalories());
        baseItemThree.setText("Item 3: " + friedRice.getSpecificAddOn(2).getName() + " Price: P" + friedRice.getSpecificAddOn(2).getPrice() + " Calories: " + friedRice.getSpecificAddOn(2).getCalories());

        comboTwoLabel.setText("Add-Ons Selected:");

        buyComboPanel.add(comboLabel);
        buyComboPanel.add(baseItemOne);
        buyComboPanel.add(baseItemTwo);
        buyComboPanel.add(baseItemThree);
        buyComboPanel.add(comboTwoLabel);


        if (friedRice.getAddOns().size() >= 4) {

            addOnOne.setText("Item 4: " + friedRice.getSpecificAddOn(3).getName() + " Price: P" + friedRice.getSpecificAddOn(3).getPrice() + " Calories: " + friedRice.getSpecificAddOn(3).getCalories());
            buyComboPanel.add(addOnOne);
        }

        if (friedRice.getAddOns().size() >= 5) {

            addOnTwo.setText("Item 5: " + friedRice.getSpecificAddOn(4).getName() + " Price: P" + friedRice.getSpecificAddOn(4).getPrice() + " Calories: " + friedRice.getSpecificAddOn(4).getCalories());
            buyComboPanel.add(addOnTwo);
        }

        if (friedRice.getAddOns().size() >= 6) {

            addOnThree.setText("Item 6: " + friedRice.getSpecificAddOn(5).getName() + " Price: P" + friedRice.getSpecificAddOn(5).getPrice() + " Calories: " + friedRice.getSpecificAddOn(5).getCalories());
            buyComboPanel.add(addOnThree);
        }

        if (friedRice.getAddOns().size() >= 7) {

            addOnFour.setText("Item 7: " + friedRice.getSpecificAddOn(6).getName() + " Price: P" + friedRice.getSpecificAddOn(6).getPrice() + " Calories: " + friedRice.getSpecificAddOn(6).getCalories());
            buyComboPanel.add(addOnFour);
        }

        totalCombo.setText(friedRice.getName() + " | Total Price: P" + friedRice.getPrice() + " | Total Calories: " + friedRice.getCalories());
        buyComboPanel.add(totalCombo);

        buyComboFrame.add(buyComboPanel);
        buyComboFrame.setVisible(true);
    }

    public void exitDisplayCombo() {

        buyComboFrame.dispose();
    }

    public void warningNoMachine() {

        JOptionPane.showMessageDialog(null,"Vending Machine Has not Been Created, Please Contact Admin...","Warning", JOptionPane.WARNING_MESSAGE);
    }

    public void showSuccessMachine() {

        JOptionPane.showMessageDialog(null, "Regular Vending Machine Successfully Created!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void insufficientFunds(double remainingAmount) {

        JOptionPane.showMessageDialog(null, "Additional funds required: P" + remainingAmount, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void insufficientFundsTwo(String itemName) {

        JOptionPane.showMessageDialog(null, itemName + " purchase failed. Insufficient funds.", "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public void svmSuccess() {

        JOptionPane.showMessageDialog(null, "Special Vending Machine Successfully Created!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
