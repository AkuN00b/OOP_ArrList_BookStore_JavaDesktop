package Library;

import java.text.DecimalFormat;
import java.util.*;

public class BookStore {
    private int choice;
    Scanner scan = new Scanner(System.in);
    Scanner anw = new Scanner(System.in);
    DataBook data = new DataBook();

    // method to show menu
    public int getMenus() {
        System.out.println("\n============================");
        System.out.println("== BOOK STORE APPLICATION ==");
        System.out.println("============================");
        System.out.println("1. Menambahkan buku");
        System.out.println("2. Menampilkan buku");
        System.out.println("3. Pembelian Buku");
        System.out.println("4. Keluar");
        System.out.print("\nPilihan: ");

        this.choice = scan.nextInt();
        return this.choice;
    }

    // method to get the choice menu
    public int getChoice(int choice) {
        switch (choice) {
            case 1: firstMenu(); break;
            case 2: secondMenu(); break;
            case 3: thirdMenu(); break;
            case 4: fourthMenu(); break;
            default: System.out.println("Pilihan Anda Salah!\t:"); break;
        }
        return choice;
    }

    // method to add a new book
    private void firstMenu() {
        System.out.print("\nBook ID: ");
        String id = anw.next();
        anw.nextLine();

        Book book = new Book(id);
        book.setId(id);

        data.verifikasiID(book);
        if (data.verifikasiID(book) == true) {
            System.out.println("\nBook ID already exists");
            System.out.println("");
        } else {
            System.out.print("Title: ");
            String title = anw.nextLine();

            System.out.print("Author: ");
            String author = anw.next();
            anw.nextLine();

            System.out.print("Stock: ");
            int qty = anw.nextInt();

            System.out.print("Price: ");
            double price = anw.nextInt();

            data.insertBook(id, title, author, qty, price);
            System.out.println("\nMenambahkan Buku Berhasil");
            System.out.println("");
        }

        getChoice(getMenus());
    }

    // method to show list book
    private void secondMenu() {
        DecimalFormat twoDForm = new DecimalFormat("#.00");

        List listBook = new ArrayList();
        listBook = data.getAll();

        if (listBook.size() == 0) {
            System.out.println("\nBook is Empty");
        } else {
            System.out.println("\nNo\t\tID Book\t\tTitle\t\t\tAuthor\t\tStock\t\tPrice");
            System.out.println("======================================================" +
                    "======================");

            for (int i = 0; i < listBook.size(); i++) {
                Book a = (Book) listBook.get(i);
                System.out.println(i+1+"\t\t"+a.getId()+"\t\t"+a.getTitle()+"\t\t\t"+a.getAuthor()+"\t\t"+a.getStock()+"\t\tRp. "+twoDForm.format(a.getPrice()));
            }

            System.out.println("======================================================" +
                    "======================");
        }

        getChoice(getMenus());
    }

    private void thirdMenu() {
        System.out.print("\nBook ID want to buy: ");
        String id = anw.next();
        anw.nextLine();

        Book book = new Book(id);
        book.setId(id);

        System.out.print("Qty: ");
        int qty = anw.nextInt();

        boolean buy;
        buy = data.buy(book.getId(), qty);

        if (buy) {
            System.out.println("\nTransaction Successfully");
            listCart();
        }

        getChoice(getMenus());
    }

    private void fourthMenu() {
        System.out.println("\nThanks for using Library Application!");
    }

    private void listCart() {
        double total = 0;
        DecimalFormat twoDForm = new DecimalFormat("#.00");

        List listCart = new ArrayList();
        listCart = data.getCart();

        if (listCart.size() == 0) {
            System.out.println("\nBook is Empty");
        } else {
            System.out.println("\nNo\t\tID Book\t\tTitle\t\t\tStock\t\tPrice");
            System.out.println("======================================================" +
                    "======================");

            for (int i = 0; i < listCart.size(); i++) {
                Cart a = (Cart) listCart.get(i);
                total += a.getPrice();
                System.out.println(i+1+"\t\t"+a.getId()+"\t\t"+a.getTitle()+"\t\t\t"+a.getQuantity()+"\t\tRp. "+twoDForm.format(a.getSubPrice()));
            }

            System.out.println("======================================================" +
                    "======================");
            System.out.println("Total: \t\t\t\t\t\t\t\t\t\t\tRp. " + twoDForm.format(total));
        }
    }

    public static void main(String[] args) {
        BookStore app = new BookStore();
        app.getChoice(app.getMenus());
    }
}
