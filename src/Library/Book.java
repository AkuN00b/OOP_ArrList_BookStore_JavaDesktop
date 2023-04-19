package Library;

public class Book {
    // private instance variables
    private String id;
    private String title;
    private String author;
    private int stock;
    private double price;

    // constructor for the class
    public Book(String id, String title, String author, int stock, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.price = price;
    }

    public Book(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    // a public method to retrieve title
    public String getTitle() {
        return title;
    }

    // a public method to retrieve author
    public String getAuthor() {
        return author;
    }

    // a public method to retrieve quantity
    public int getStock() {
        return stock;
    }

    public double getPrice() { return price; }

    public void stockBuy(int stock) {
        this.stock -= stock;
    }
}
