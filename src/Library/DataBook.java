package Library;

import java.util.ArrayList;
import java.util.List;

public class DataBook implements BookAccess {
    // private instance variables
    ArrayList<Book> listbook = new ArrayList<Book>();
    ArrayList<Cart> listcart = new ArrayList<Cart>();

    // return the listbook value
    public List getAll() {
        return listbook;
    }

    public List getCart() {
        return listcart;
    }

    // method for add the book into the list
    public void insertBook(String id, String title, String author, int qty, double price) {
        Book book = new Book(id, title, author, qty, price);
        listbook.add(book);
    }

    @Override
    public List<Book> ListBook() {
        if(listbook.size() == 0) {
            System.out.println("Book is Empty");
        }

        return listbook;
    }

    public List<Cart> ListCart() {
        if(listcart.size() == 0) {
            System.out.println("Cart is Empty");
        }

        return listcart;
    }

    public boolean verifikasiID(Book book) {
        for (Book book1 : listbook) {
            if (book1.getId().equals(book.getId())) {
                return true;
            }
            if (!book1.getId().equals(book.getId())) {
                return false;
            }
            if (listbook.isEmpty()) {
                System.out.println("Book is Empty");
            }
        }

        return false;
    }

    public boolean verifikasiIDCart(Cart cart) {
        for (Cart cart1 : listcart) {
            if (cart1.getId().equals(cart.getId())) {
                return true;
            }
            if (!cart1.getId().equals(cart.getId())) {
                return false;
            }
            if (listbook.isEmpty()) {
                System.out.println("Cart is Empty");
            }
        }

        return false;
    }

    public boolean delete (String id) {
        for (Book book : listbook) {
            if (book.getId().equals(id)) {
                listbook.remove(book);
                return true;
            }
        }

        return false;
    }

    public boolean buy (String id, int qty) {
        for (Book book : listbook) {
            if (book.getId().equals(id)) {
                book.stockBuy(qty);

                Cart cart = new Cart(id);
                cart.setId(id);
                verifikasiIDCart(cart);

                if (verifikasiIDCart(cart) == false) {
                    double price = book.getPrice() * (double) qty;

                    Cart cart1 = new Cart(book.getId(), book.getTitle(), qty, book.getPrice(), price);
                    listcart.add(cart1);
                } else {
                    for (Cart cart2 : listcart) {
                        if (cart2.getId().equals(id)) {
                            double price = book.getPrice() * (double) qty;
                            cart2.setQuantity(qty);
                            cart2.setPrice(price);
                        }
                    }
                }

                return true;
            }
        }

        return false;
    }
}
