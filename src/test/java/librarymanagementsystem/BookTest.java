package librarymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import entity.Book;

/**
 * Unit tests for the Book class.
 */
class BookTest {

    /**
     * Test the Book constructor and getters.
     */
    @Test
    void testBookConstructorAndGetters() {
        Book book = new Book("Test Title", "Test Author", "1234567890", "Fiction", 2023, Arrays.asList("Science", "Fiction"), true);

        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertEquals("1234567890", book.getISBN());
        assertEquals("Fiction", book.getGenre());
        assertEquals(2023, book.getPublicationYear());
        assertEquals(Arrays.asList("Science", "Fiction"), book.getDepartments());
        assertTrue(book.isAvailable());
    }

    /**
     * Test the Book setters.
     */
    @Test
    void testBookSetters() {
        Book book = new Book("", "", "", "", 0, Arrays.asList(), false);

        book.setTitle("New Title");
        book.setAuthor("New Author");
        book.setISBN("0987654321");
        book.setGenre("Non-Fiction");
        book.setPublicationYear(2024);
        book.setDepartments(Arrays.asList("History"));
        book.setAvailability(true);

        assertEquals("New Title", book.getTitle());
        assertEquals("New Author", book.getAuthor());
        assertEquals("0987654321", book.getISBN());
        assertEquals("Non-Fiction", book.getGenre());
        assertEquals(2024, book.getPublicationYear());
        assertEquals(Arrays.asList("History"), book.getDepartments());
        assertTrue(book.isAvailable());
    }
}