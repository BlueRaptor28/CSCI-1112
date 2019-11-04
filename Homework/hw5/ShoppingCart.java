/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

At the heart of the shopping cart is a list; however, a shopping cart is more 
than just a list.  We may need our list class for a number of different 
applications, so we implement it in another class that is easy to reuse.
Because the cart is a list, we use the list class in the shopping cart class and
many of the methods of cart simply pass-through/wrap list functions.
Because the cart is also more than a list, we also might include other 
specialized cart only functions like subtotal()  

CAVEAT: when you learn inheritance, you will realize that since the cart IS A
list, ShoppingCart can inherit the List class which will eliminate much of the 
need for the wrapper functions and will simplify this class considerably. 

authors: Grayson Buchholz, Aaron Coplan, James Levy, James Taylor 
------------------------------------------------------------------------------*/

public class ShoppingCart {
 
    private final List list;

    // Parameterized constructor.  The list type must be provided at 
    // construction because the List contructor requires it 
    public ShoppingCart(List.Type type) {
        list = new List(type);
    }

    // Adds a product to the shopping cart
    public void add(Product product, int quantity, double discount) {
        list.add(product, quantity, discount);
    }

    // Removes a product from the shopping cart
    // @return true if the product is found and removed; otherwise, returns 
    // false
    public boolean remove(Product product) {
        return list.remove(product);
    }

    // Retrieves a product in the cart based on index/position in the list.
    // @return a product if the index is within the bounds of the list;
    //         otherwise returns null
    public Product get(int i) {
        return list.get(i);
    }

    // The length/number of elements in the cart
    // @return the number of elements in the cart
    public int length() {
        return list.length();
    }

    // Clears the cart of all products
    public void clear() {
        list.clear();
    }

    // Checks for whether the cart is empty or not
    // @return true if the cart contains no items; otherwise, returns false
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Get a string containing all the cart information.  This includes all of
    // the information about the list
    // @return a string containing cart information
    public String toString() {
        return list.toString(); 
    }

    //----------------------------- Extension ---------------------------------
    // Computes the cost sum of all items in the cart
    // @return the cost sum of all items in the cart
    public double subtotal() {
        return list.subtotal();
    }

    // Applies a discount to all items matching the product currently in the
    // cart.  Any future product with matching criteria is not automatically
    // discounted unless applyDiscount is used with that product in the cart.
    // @param product the product to discount
    // @param discount the amount of discount to apply to the product
    //        this value is in a unfactored format (not percentage) and cannot
    //        exceed a factor of 1.0 (100%)
    // @return true if a product matching the criteria was found and a discount
    //         was applied; otherwise, returns false
    public boolean applyDiscount(Product product, double discount) {
        return list.applyDiscount(product, discount);
    }


    // Computes the final total of the cart and then empties the cart
    // This simulates the purchase transaction
    // @param salestax the amount of salestax to apply to the transaction
    //        this value is in a unfactored format (not percentage)
    // @return the overall sales total of the cart
    public double checkout(double salestax) {
        double cost = 0.0;
        // Ensure that salestax is not negative
        if(salestax > 0.0){
            // Increase cost by salestax
            cost = subtotal() + (subtotal() * salestax);
            // Empty cart
            list.clear();
        }
        // Round to 2 decimal places
        double scale = Math.pow(10, 2);
        return Math.round(cost * scale) / scale;
    }
}
