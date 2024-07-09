package service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entity.Book;

/**
 * Provides a text-based menu interface for interacting with the library system.
 */
public class LibraryMenu {
    private Library library;
    private Scanner scanner;

    /**
     * Constructor to initialize the library and scanner.
     */
    public LibraryMenu() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the menu-driven interface.
     */
    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    findBookByTitle();
                    break;
                case 4:
                    findBookByAuthor();
                    break;
                case 5:
                    listAllBooks();
                    break;
                case 6:
                    listAvailableBooks();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays the main menu options.
     */
    private void displayMenu() {
        System.out.println("\nLibrary Menu:");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Find books by title");
        System.out.println("4. Find books by author");
        System.out.println("5. List all books");
        System.out.println("6. List available books");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles the process of adding a new book to the library.
     */
    private void addBook() {
        // Prompt for book details
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter departments (comma-separated): ");
        List<String> departments = Arrays.asList(scanner.nextLine().split(","));
        System.out.print("Is the book available? (true/false): ");
        boolean availability = scanner.nextBoolean();

        // Create and add the book
        Book book = new Book(title, author, ISBN, genre, year, departments, availability);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    /**
     * Handles the process of removing a book from the library.
     */
    private void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
        System.out.println("Book removed successfully.");
    }

    /**
     * Handles the process of finding books by title.
     */
    private void findBookByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        List<Book> found = library.findBookByTitle(title);
        displayBooks(found);
    }

    /**
     * Handles the process of finding books by author.
     */
    private void findBookByAuthor() {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine();
        List<Book> found = library.findBookByAuthor(author);
        displayBooks(found);
    }

    /**
     * Displays all books in the library.
     */
    private void listAllBooks() {
        List<Book> allBooks = library.listAllBooks();
        displayBooks(allBooks);
    }

    /**
     * Displays all available books in the library.
     */
    private void listAvailableBooks() {
        List<Book> availableBooks = library.listAvailableBooks();
        displayBooks(availableBooks);
    }

    /**
     * Helper method to display a list of books.
     *
     * @param books The list of books to display
     */
    private void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Genre: " + book.getGenre());
                System.out.println("Year: " + book.getPublicationYear());
                System.out.println("Departments: " + book.getDepartments());
                System.out.println("Available: " + book.isAvailable());
                System.out.println("--------------------");
            }
        }
    }

    /**
     * Main method to run the LibraryMenu.
     */
    public static void main(String[] args) {
        new LibraryMenu().start();
    }
}