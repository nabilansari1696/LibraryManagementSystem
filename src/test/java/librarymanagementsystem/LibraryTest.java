package librarymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Book;
import service.Library;

/**
 * Unit tests for the Library class.
 */
class LibraryTest {

    private Library library;
    private Book book1, book2, book3;

    /**
     * Set up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1111", "Fiction", 1925, Arrays.asList("Classics"), true);
        book2 = new Book("To Kill a Mockingbird", "Harper Lee", "2222", "Fiction", 1960, Arrays.asList("Classics"), false);
        book3 = new Book("1984", "George Orwell", "3333", "Science Fiction", 1949, Arrays.asList("Classics", "Sci-Fi"), true);
    }

    /**
     * Test adding books to the library.
     */
    @Test
    void testAddBook() {
        library.addBook(book1);
        assertEquals(1, library.listAllBooks().size());

        // Try to add a duplicate book (same ISBN)
        Book duplicateBook = new Book("Duplicate", "Author", "1111", "Genre", 2000, Arrays.asList("Department"), true);
        library.addBook(duplicateBook);
        assertEquals(1, library.listAllBooks().size());
    }

    /**
     * Test removing books from the library.
     */
    @Test
    void testRemoveBook() {
        library.addBook(book1);
        library.addBook(book2);
        library.removeBook("1111");
        assertEquals(1, library.listAllBooks().size());
        assertEquals("To Kill a Mockingbird", library.listAllBooks().get(0).getTitle());
    }

    /**
     * Test finding books by title.
     */
    @Test
    void testFindBookByTitle() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> found = library.findBookByTitle("great");
        assertEquals(1, found.size());
        assertEquals("The Great Gatsby", found.get(0).getTitle());

        found = library.findBookByTitle("to");
        assertEquals(1, found.size());
        assertEquals("To Kill a Mockingbird", found.get(0).getTitle());
    }

    /**
     * Test finding books by author.
     */
    @Test
    void testFindBookByAuthor() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> found = library.findBookByAuthor("orwell");
        assertEquals(1, found.size());
        assertEquals("1984", found.get(0).getTitle());
    }

    /**
     * Test listing all books in the library.
     */
    @Test
    void testListAllBooks() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> allBooks = library.listAllBooks();
        assertEquals(3, allBooks.size());
    }

    /**
     * Test listing only available books in the library.
     */
    @Test
    void testListAvailableBooks() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> availableBooks = library.listAvailableBooks();
        assertEquals(2, availableBooks.size());
        assertTrue(availableBooks.stream().allMatch(Book::isAvailable));
    }
}