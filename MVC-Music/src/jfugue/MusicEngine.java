package jfugue;

import org.jfugue.Player;

public class MusicEngine {
	//Singleton pattern
	private static MusicEngine instance;
	private Thread playThread;
	private volatile boolean noStop;
	private Player player;
	private String music;
	
	private MusicEngine(){
		player= new Player();
	}
	
	public static MusicEngine getInstance(){
		if(instance == null) instance= new MusicEngine();
		return instance;
	}

	//---------------------------------------------------------------
	public void startThread(String m) {
		music= m;
		noStop = true;
		// Use this inner class to hide the public run method
		Runnable r= new Runnable() {
			public void run() {
				while(noStop) {
					player.play(music);
				}
			}
		};
		playThread= new Thread(r, "MusicPlayer");
		playThread.start();
	}
	
	//---------------------------------------------------------------
	public void stopThread() {
		noStop = false;
		player.stop();
	}
	

}
