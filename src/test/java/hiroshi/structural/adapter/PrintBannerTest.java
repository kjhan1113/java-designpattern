package hiroshi.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrintBannerTest {
	
	private PrintBanner printBanner;
	
	@BeforeEach
	void setUp() {
		// Create an instance of PrintBanner
		printBanner = new PrintBanner("Hello");
	}

	@Test
	void testPrintWeak() {
		// Execute the printWeak method
		String result = printBanner.printWeak();
		
		String expectedOutput = "(Hello)";
		
		assertEquals(expectedOutput, result);
	}
	
	@Test
	void testPrintStrong() {
		// Execute the printStrong method
		String result = printBanner.printStrong();
		
		String expectedOutput = "*Hello*";
		assertEquals(expectedOutput, result);
	}
}
