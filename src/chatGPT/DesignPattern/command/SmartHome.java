package chatGPT.DesignPattern.command;

/**
 * 커맨트 패턴 - 전등 제어
 */
public class SmartHome {
	public static void main(String[] args) {
		RemoteControl control = new RemoteControl();
		Light light = new Light();

		control.setCommand(new LightOnCommand(light));
		control.pressButton();

		control.setCommand(new LightOffCommand(light));
		control.pressButton();
	}
}

interface Command {
	void execute();
}

class LightOnCommand implements Command {
	private Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}
}

class LightOffCommand implements Command {
	private Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}
}

class Light {
	void on() {
		System.out.println("전등이 켜졌습니다.");
	}
	void off() {
		System.out.println("전등이 꺼졌습니다.");
	}
}

class RemoteControl {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}
}