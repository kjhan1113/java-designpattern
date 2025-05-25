package amitk.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyPlayerTest {

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private MyPlayer player;

	@BeforeEach
	void setUp() {
		System.setOut(new PrintStream(output));
		player = new MyPlayer();
	}

	@Test
	void testPlayAudio() {
		assertDoesNotThrow(() -> player.play("mp3", "song.mp3"));
	}

	@Test
	void testPlayVideo() {
		assertDoesNotThrow(() -> player.play("mp4", "movie.mp4"));
	}

	@Test
	void testInvalidType() {
		assertDoesNotThrow(() -> player.play("txt", "document.txt"));
	}

	@Test
	void testPlayAudioOutput() {
		player.play("mp3", "song.mp3");
		assertTrue(output.toString().trim().contains("Playing... Name : song.mp3"));
	}
	
    @Test
    void testPlayVideoOutput() {
        player.play("mp4", "movie.mp4");
        assertTrue(output.toString().trim().contains("Playing... Name : movie.mp4"));
    }

    @Test
    void testInvalidTypeOutput() {
        player.play("txt", "document.txt");
        assertTrue(output.toString().trim().contains("Invalid Type"));
    }
}
