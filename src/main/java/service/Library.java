package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entity.Book;

/**
 * Manages a collection of books in the library system.
 */
public class Library {
    private List<Book> books;

    /**
     * Constructor to initialize an empty library.
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the library if it doesn't already exist (based on ISBN).
     *
     * @param book The book to be added
     */
    public void addBook(Book book) {
        if (books.stream().noneMatch(b -> b.getISBN().equals(book.getISBN()))) {
            books.add(book);
        }
    }

    /**
     * Removes a book from the library based on its ISBN.
     *
     * @param ISBN The ISBN of the book to be removed
     */
    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    /**
     * Finds books by title (case-insensitive search).
     *
     * @param title The title to search for
     * @return A list of books matching the given title
     */
    public List<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Finds books by author (case-insensitive search).
     *
     * @param author The author to search for
     * @return A list of books by the given author
     */
    public List<Book> findBookByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of all books in the library.
     *
     * @return A list of all books
     */
    public List<Book> listAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Returns a list of all available books in the library.
     *
     * @return A list of available books
     */
    public List<Book> listAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
}