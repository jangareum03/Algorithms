package chatGPT.DesignPattern.state;

/**
 * 상태 패턴 - 동영상 재생
 */
public class VideoSystem {
	public static void main(String[] args) {
		VideoPlayer player = new VideoPlayer("크라임씬 제로");

		player.play();
		player.pause();
		player.pause();
		player.stop();
		player.play();
	}
}

class VideoPlayer {
	private PlayerState state;
	private final String video;

	public VideoPlayer(String video) {
		this.video = video;
		state = new Stopped();
	}

	public String getVideo() {
		return video;
	}

	public void setState(PlayerState state) {
		this.state = state;
	}

	public void play() {
		state.play(this);
	}

	public void pause() {
		state.pause(this);
	}

	public void stop() {
		state.stop(this);
	}
}

interface PlayerState {
	void play(VideoPlayer player);
	void pause(VideoPlayer player);
	void stop(VideoPlayer player);
}

class Playing implements PlayerState {
	@Override
	public void play(VideoPlayer player) {
		System.out.println(player.getVideo() + " 비디오는 이미 재생 중입니다.");
	}

	@Override
	public void pause(VideoPlayer player) {
		System.out.println(player.getVideo() + " 비디오를 일시정지 합니다.");
		player.setState(new Paused());
	}

	@Override
	public void stop(VideoPlayer player) {
		System.out.println(player + " 비디오를 정지합니다.");
		player.setState(new Stopped());
	}
}

class Paused implements PlayerState {
	@Override
	public void play(VideoPlayer player) {
		System.out.println(player.getVideo() + " 비디오를 다시 재생합니다.");
		player.setState(new Playing());
	}

	@Override
	public void pause(VideoPlayer player) {
		System.out.println("이미 일시정지 상태입니다.");
	}

	@Override
	public void stop(VideoPlayer player) {
		System.out.println(player.getVideo() + " 비디오 정지합니다.");
		player.setState(new Stopped());
	}
}

class Stopped implements PlayerState {

	@Override
	public void play(VideoPlayer player) {
		System.out.println(player.getVideo() + " 비디오를 처음부터 재생합니다.");
		player.setState(new Playing());
	}

	@Override
	public void pause(VideoPlayer player) {
		System.out.println("정지 상태여서 일시정지를 할 수 없습니다.");
		player.setState(new Paused());
	}

	@Override
	public void stop(VideoPlayer player) {
		System.out.println("이미 정지 상태입니다.");
	}
}