package entities;

public class Book {
    private String bookTitle;
    private String isbn;
    private String author;
    private String publication;
    private int inventory;

    public Book(String bookTitle, String isbn, String author, String publication, int inventory) {
        this.bookTitle = bookTitle;
        this.isbn = isbn;
        this.author = author;
        this.publication = publication;
        this.inventory = inventory;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication() {
        return publication;
    }

    public int getInventory() {
        return inventory;
    }

    public void updateInventory(int bookCount){
        this.inventory+=bookCount;

    }

    public String toString() {
        return bookTitle + "," + isbn + "," + author + "," + publication + "," + inventory;
    }

    public static Book fromFileFormat(String line) {
        String[] parts = line.split(",");
        return new Book(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
    }
}
