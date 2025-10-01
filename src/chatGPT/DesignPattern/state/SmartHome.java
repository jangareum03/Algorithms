package chatGPT.DesignPattern.state;

/**
 * 상태 패턴 - 스마트 홈 전등 제어
 */
public class SmartHome {
	public static void main(String[] args) {
		SmartLight smartLight = new SmartLight();

		smartLight.dim();
		smartLight.turnOn();
		smartLight.dim();
		smartLight.turnOff();
	}
}

interface LightState {
	void turnOn(SmartLight smartLight);
	void turnOff(SmartLight smartLight);
	void dim(SmartLight smartLight);
}

class TurnOn implements LightState {
	@Override
	public void turnOn(SmartLight smartLight) {
		System.out.println("🚨ERROR - 전등이 이미 켜져있는 상태입니다.");
	}

	@Override
	public void turnOff(SmartLight smartLight) {
		System.out.println("전등이 꺼졌습니다. 에너지 소비는 0W 입니다.");
		smartLight.setState(new TurnOff());
	}

	@Override
	public void dim(SmartLight smartLight) {
		System.out.println("조광 상태로 전환됩니다. 에너지 소비는 20W 입니다.");
		smartLight.setState(new Dim());
	}
}

class TurnOff implements LightState {
	@Override
	public void turnOn(SmartLight smartLight) {
		System.out.println("전등이 켜졌습니다. 에너지 소비는 60W 입니다.");
		smartLight.setState(new TurnOn());
	}

	@Override
	public void turnOff(SmartLight smartLight) {
		System.out.println("🚨ERROR - 전등이 이미 꺼진 상태입니다.");
	}

	@Override
	public void dim(SmartLight smartLight) {
		System.out.println("🚨ERROR - 전등이 켜져있지 않습니다.");
	}
}

class Dim implements LightState {
	@Override
	public void turnOn(SmartLight smartLight) {
		System.out.println("🚨ERROR - 전등이 이미 켜져있는 상태입니다.");
	}

	@Override
	public void turnOff(SmartLight smartLight) {
		System.out.println("전등이 꺼졌습니다. 에너지 소비는 0W 입니다.");
		smartLight.setState(new TurnOff());
	}

	@Override
	public void dim(SmartLight smartLight) {
		System.out.println("🚨ERROR - 이미 조광 상태입니다.");
	}
}

class SmartLight {
	private LightState state;

	public SmartLight() {
		this.state = new TurnOff();
	}

	public void setState(LightState state) {
		this.state = state;
	}

	public void turnOn() {
		state.turnOn(this);
	}

	public void turnOff() {
		state.turnOff(this);
	}

	public void dim() {
		state.dim(this);
	}
}