package amitk.structural.adapter;

public class MyPlayer implements Player{

	AudioPlayer audioPlayer = new MyAudioPlayer();
	VideoPlayer videoPlayer = new MyVideoPlayer();
	
	@Override
	public void play(String type, String fileName) {
		if(type.equalsIgnoreCase("mp4")) {
			videoPlayer.playVideo(fileName);
		}else if(type.equalsIgnoreCase("mp3")) {
			audioPlayer.playAudio(fileName);
		}else {
			System.out.println("Invalid Type");
		}
	}
}
