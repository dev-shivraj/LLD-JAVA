package comparable;

public class Item implements Comparable<Item> {
    private String id;
    private String name;
    private int quantity;
    private double price;

    public Item(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*
     * here we are comparing two objects, but we are having only one as parameter, why ?
     * because the object on which compareTo is called is implicitly passed as "this"
     * so it is comparing "this" object with the "other" object passed as parameter,
     * and we are returning an integer value, which is the result of comparison
     *
     * if the result is negative, it means "this" object is less than "other" object
     * if the result is positive, it means "this" object is greater than "other" object
     * if the result is zero, it means "this" object is equal to "other" object
     *
     *
     * so we can use this result to sort the list of items in ascending order
     * we can also use this result to sort the list of items in descending order by reversing the comparison
     * we can also use this result to sort the list of items based on any attribute of the Item class, like name, quantity, price, etc.
     * we can also use this result to sort the list of items based on multiple attributes of the Item class, like name and price, by comparing them in sequence
     *
     *
     * if we want this to come first, return -ve value
     * if we want other to come first, return +ve value
     * if both are same then return 0
     */

    /*
     * if we want to sort in ascending order:
     *   we need to return -ve value : if "this" object is less than "other" object
     *   +ve value : if "this" object is greater than "other" object,
     *   and 0 if both are equal
     *
     *
     * if we want to sort in descending order:
     *   we need to return +ve value : if "this" object is less than "other" object
     *   -ve value : if "this" object is greater than "other" object
     *   and 0 : if both are equal
     *
     */
    @Override
    public int compareTo(Item other) {
        /*
         * we can compare the items based on their price, quantity, name, etc.
         * here we are comparing the items based on their price
         * if we want to compare based on quantity, we can use this.quantity - other.quantity
         * if we want to compare based on name, we can use this.name.compareTo(other.name)
         *
         */

        /*
            // sort by price in ascending order
            if (this.price < other.price) {
                return -1;
            } else if (this.price > other.price) {
                return 1;
            } else {
                return 0;
            }
         */

        /*
            // above can be simplified to :
            return (int) (this.price - other.price);
         */

        // further simplified to :
        return Double.compare(this.price, other.price);
    }
}
