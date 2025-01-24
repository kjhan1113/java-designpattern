package structural.adapter.amitk;

public class MyPlayer implements Player{

	AudioPlayer audioPlayer = new MyAudioPlayer();
	VideoPlayer videoPlayer = new MyVideoPlayer();
	
	@Override
	public void play(String type, String fileName) {
		if(type.equalsIgnoreCase("avi")) {
			videoPlayer.playVideo(fileName);
		}else if(type.equalsIgnoreCase("mp3")) {
			audioPlayer.playAudio(fileName);
		}
	}
}
