package chatGPT.DesignPattern.command;

import java.util.Random;

/**
 * 커맨드 패턴 - 음악 플레이어
 */
public class MusicPlayer {
	public static void main(String[] args) {
		AppInvoker invoker = new AppInvoker();
		MP3 mp3 = new MP3();

		invoker.setCommand(new PlayCommand(mp3));
		invoker.executeCommand();

		invoker.setCommand(new StopCommand(mp3));
		invoker.executeCommand();
	}
}

class MP3 {
	private final String[] playList = new String[] {"그남자 그여자", "모르시나요", "바람기억"};
	private String music;

	public void play() {
		music = playList[new Random().nextInt(playList.length)];
		System.out.println(music + " 음악이 재생됩니다.");
	}

	public void stop() {
		System.out.println(music + " 음악이 정지됩니다.");
	}
}

interface Mp3Command {
	void execute();
}

class PlayCommand implements Mp3Command {
	private final MP3 mp3;

	public PlayCommand(MP3 mp3) {
		this.mp3 = mp3;
	}

	@Override
	public void execute() {
		mp3.play();
	}
}

class StopCommand implements Mp3Command {
	private final MP3 mp3;

	public StopCommand(MP3 mp3) {
		this.mp3 = mp3;
	}

	@Override
	public void execute() {
		mp3.stop();
	}
}

class AppInvoker {
	private Mp3Command command;

	public void setCommand(Mp3Command command) {
		this.command = command;
	}

	public void executeCommand() {
		command.execute();
	}
}