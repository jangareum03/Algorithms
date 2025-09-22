package chatGPT.DesignPattern.facade;

/**
 * 퍼사드 패턴 - TV &  사운드 시스템 제어
 */
public class HomeAppliance {
	public static void main(String[] args) {
		HomeTheaterFacade homeTheater = new HomeTheaterFacade();
		homeTheater.watchMovie("Matrix");
	}
}

class HomeTheaterFacade {
	private final Tv tv = new Tv();
	private final Sound sound = new Sound();
	private final SetTopBox setTopBox = new SetTopBox();

	void watchMovie(String channel) {
		tv.turnOn();
		sound.turnOn();
		setTopBox.change(channel);

		System.out.println("영화 감상 시작!");
	}
}

class Tv {
	void turnOn() {
		System.out.println("TV 켜짐");
	}
}

class Sound {
	void turnOn() {
		System.out.println("사운드 시스켐 켜짐");
	}
}

class SetTopBox {
	void change(String channel) {
		System.out.printf("셋톱박스에서 '%s' 채널로 전환%n", channel);
	}
}