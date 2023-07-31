/**
 * Driver of the Vending Machine Factory Simulation.
 * Instantiates the view and controller (the various models are instantiated later on in the controller).
 */

public class MainDriver {

    public static void main(String[] args) {

        VMFactoryView view = new VMFactoryView();

        VMFactoryController vendingMachineFactoryController = new VMFactoryController(view);
    }
}
