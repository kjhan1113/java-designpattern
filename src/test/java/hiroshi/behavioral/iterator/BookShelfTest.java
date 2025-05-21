package hiroshi.behavioral.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookShelfTest {
	
	private BookShelf bookShelf;

	@BeforeEach
	void setUp() {
		// Create a BookShelf with max size 5
		bookShelf = new BookShelf(4);
		
		// Add Books to bookShelf
		bookShelf.appendBook(new Book("Design Patterns"));
		bookShelf.appendBook(new Book("Clean Code"));
		bookShelf.appendBook(new Book("Effective Java"));
		bookShelf.appendBook(new Book("Java Concurrency in Practice"));
	}

	@Test
	void testBookShelfSizeOfBooks() {
		assertEquals(4, bookShelf.getLength());
		assertThrows(ArrayIndexOutOfBoundsException.class, ()->{bookShelf.appendBook(new Book(""));}, "ArrayIndexOutOfBoundsException should be thrown");
	}
	
	@Test
	void testIteratorHasNext() {
		Iterator iterator = bookShelf.iterator();
		
		assertTrue(iterator.hasNext(), "The iterator must point to the first book.");
		Book book1 = (Book) iterator.next();
		assertEquals("Design Patterns", book1.getName());
		
		assertTrue(iterator.hasNext(), "The iterator must point to the second book.");
		Book book2 = (Book) iterator.next();
		assertEquals("Clean Code", book2.getName());
		
		assertTrue(iterator.hasNext(), "The iterator must point to the third book.");
		Book book3 = (Book) iterator.next();
		assertEquals("Effective Java", book3.getName());
		
		assertTrue(iterator.hasNext(), "The iterator must point to the fourth book.");
		Book book4 = (Book) iterator.next();
		assertEquals("Java Concurrency in Practice", book4.getName());
		
		assertFalse(iterator.hasNext(), "The Iterator should no longer point to books.");
	}
	
	@Test
	void testIteratorExceedNext() {
		Iterator iterator = bookShelf.iterator();		
		while(iterator.hasNext()) { iterator.next(); }
		
		assertFalse(iterator.hasNext());
		assertThrows(ArrayIndexOutOfBoundsException.class, iterator::next, "ArrayIndexOutOfBoundsException should be thrown");
	}
}
