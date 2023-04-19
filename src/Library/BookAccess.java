package Library;

import java.util.List;

public interface BookAccess {
    public List<Book> ListBook();
    public List<Cart> ListCart();

    public boolean verifikasiID(Book book);
    public boolean verifikasiIDCart(Cart cart);
}
