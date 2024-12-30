package creational.factory.hiroshi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IDCardFactoryTest {

	private IDCardFactory factory;
	
	@BeforeEach
	public void setUp() {
		factory = new IDCardFactory();
	}
	
	@Test
	void testCreateProduct() {
		Product card1 = factory.create("Alice");
		Product card2 = factory.create("Spring");
		
		// Verify that the card had been created 
		assertNotNull(card1);
		assertNotNull(card2);
		
		// Check whether the card type is IDCard
		assertTrue(card1 instanceof IDCard);
		assertTrue(card2 instanceof IDCard);
		
		assertEquals("Alice", ((IDCard)card1).getOwner());
		assertEquals("Spring", ((IDCard) card2).getOwner());
	}
	
	@Test
	void testRegisterProduct() {
		factory.create("Charlie");
		factory.create("Bob");
		
		// Checking the size of created card list
		List<String> owners = factory.getOwners();
		assertEquals(2, owners.size());
		
		assertTrue(owners.contains("Charlie"));
		assertTrue(owners.contains("Bob"));
		assertFalse(owners.contains("Anonymous"));
	}

}
