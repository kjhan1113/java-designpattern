package amitk.structural.adapter;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyPlayerTest {

	/* 
	 * Adapter pattern works as a bridge between two incompatible interfaces.
	 * 
	 * Connecting incompatible interfaces
	 * 	- Enables collaboration between classes with different interfaces.
	 *
	 *	Intermediate Object (Adapter)
	 *	- Converts the interface used by the client and the interface of the existing class.
	 *
	 *	Reusability
	 *	- Add new features or support different interfaces without changing existing code.
	 */

	private MyPlayer myPlayer;
	
	// Mock Object
	private AudioPlayer mockAudioPlayer;
	private VideoPlayer mockVideoPlayer;
	
	@BeforeEach
	void setUp() {
		myPlayer = new MyPlayer();
		
		mockAudioPlayer = mock(AudioPlayer.class);
		mockVideoPlayer = mock(VideoPlayer.class);
		
		myPlayer.audioPlayer = mockAudioPlayer;
		myPlayer.videoPlayer = mockVideoPlayer;
	}
	
	@Test
	void testPlayAudio() {
		String type = "mp3";
		String fileName = "test_audio.mp3";
		
		myPlayer.play(type, fileName);

		// verify mock class calls playAudio method
		verify(mockAudioPlayer, times(1)).playAudio(fileName);
		verify(mockVideoPlayer, never()).playVideo(anyString());
	}
	
	@Test
	void testPlayVideo() {
		String type = "avi";
		String fileName = "test_video.avi";
		
		myPlayer.play(type, fileName);
		verify(mockVideoPlayer, times(1)).playVideo(fileName);
		verify(mockAudioPlayer, never()).playAudio(fileName);
	}
	
	@Test
	void testPlayUnsupportedType() {
		String type = "txt";
		String fileName = "unsupported_file.txt";
		
		myPlayer.play(type, fileName);
		
		// Checking unsupported types
		verify(mockAudioPlayer, never()).playAudio(fileName);
		verify(mockVideoPlayer, never()).playVideo(fileName);
	}
}
