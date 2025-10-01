package chatGPT.DesignPattern.state;

/**
 * 상태 패턴 - 교통 신호등 관리
 */
public class TrafficSystem {
	public static void main(String[] args) {
		TrafficLight light = new TrafficLight();

		for(int i=0; i<6; i++) {
			light.change();
		}
	}
}

interface TrafficState {
	void handle(TrafficLight light);
}

class RedState implements TrafficState {
	@Override
	public void handle(TrafficLight light) {
		System.out.println("RED -> 대기중");
		light.setLightState(new GreenState());
	}
}

class GreenState implements TrafficState {
	@Override
	public void handle(TrafficLight light) {
		System.out.println("GREEN -> 진행 중");
		light.setLightState(new YellowState());
	}
}

class YellowState implements TrafficState {
	@Override
	public void handle(TrafficLight light) {
		System.out.println("YELLOW -> 주의");
		light.setLightState(new RedState());
	}
}

class TrafficLight {
	private TrafficState lightState;

	public TrafficLight() {
		this.lightState = new RedState();
	}

	public void setLightState(TrafficState lightState) {
		this.lightState = lightState;
	}

	public void change() {
		lightState.handle(this);
	}
}