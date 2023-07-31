/**
 * A child of the Item class, it behaves exactly the same as a regular Item.
 * The difference being that these cannot be sold like regular items.
 */
public class UnsellableItem extends Item{

    /**
     * Constructor for the UnsellableItem class.
     *
     * @param name - String name of the UnsellableItem.
     * @param price - double price of the item.
     * @param calories - integer calories.
     */
    public UnsellableItem(String name, double price, int calories) {

        super(name, price, calories);
    }
}
