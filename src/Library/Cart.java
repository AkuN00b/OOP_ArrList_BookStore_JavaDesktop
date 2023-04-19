package Library;

public class Cart {
    // private instance variables
    private String id;
    private String title;
    private int quantity;
    private double subprice;
    private double price;

    // constructor for the class
    public Cart(String id, String title, int quantity, double subprice, double price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.subprice = subprice;
        this.price = price;
    }

    public Cart(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    // a public method to retrieve title
    public String getTitle() {
        return title;
    }

    // a public method to retrieve quantity
    public int getQuantity() {
        return quantity;
    }

    public double getPrice() { return price; }
    public double getSubPrice() { return subprice; }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void setPrice(double price) {
        this.price += price;
    }
}
