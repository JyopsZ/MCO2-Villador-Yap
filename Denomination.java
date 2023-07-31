/**
 * This Class Represents a Denomination to be Used as Change in the Vending Machine
 * It has the specific denomination and quantity of it as attributes.
 */
public class Denomination {

    private double denomination;

    /**
     * Constructor that requires the denomination and quantity
     *
     * @param denomination - double value pertaining to specific denomination in pesos
     */
    public Denomination (double denomination) {

        this.denomination = denomination;
    }

    /**
     * Getter for Denomination
     *
     * @return - double denomination in pesos
     */
    public double getDenomination() {

        return denomination;
    }

}
