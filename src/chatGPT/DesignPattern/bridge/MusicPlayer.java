package chatGPT.DesignPattern.bridge;

/**
 * 브리지 패턴 - 음악 재생 시스템
 */
public class MusicPlayer {
	public static void main(String[] args) {
		Music mp3 = new MP3(new Headphone());
		mp3.play();

		mp3 = new MP3(new Speaker());
		mp3.play();
	}
}

interface Player {
	void start(String type);
}

class Speaker implements Player {
	@Override
	public void start(String type) {
		System.out.printf("스피커로 %s 음악을 재생합니다.%n", type);
	}
}

class Headphone implements Player {
	@Override
	public void start(String type) {
		System.out.printf("헤드폰으로 %s 음악을 재생합니다.%n", type);
	}
}

abstract class Music {
	protected final Player player;

	public Music(Player player) {
		this.player = player;
	}

	public abstract void play();
}

class MP3 extends Music {
	public MP3(Player player) {
		super(player);
	}

	@Override
	public void play() {
		player.start("MP3");
	}
}

class FLAC extends Music {
	public FLAC(Player player) {
		super(player);
	}

	@Override
	public void play() {
		player.start("FLAC");
	}
}