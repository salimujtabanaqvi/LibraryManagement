package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                break;
            }
        }
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}

public class LibraryManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display all books");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter the book ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the book title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter the book author:");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.println("Enter the book ID to remove:");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    library.removeBook(removeId);
                    System.out.println("Book removed successfully!");
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}

