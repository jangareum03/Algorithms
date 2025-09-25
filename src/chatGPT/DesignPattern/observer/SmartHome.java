package chatGPT.DesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 옵저버 패턴 - 스마트홈
 */
public class SmartHome {
	public static void main(String[] args) {
		TemperatureSensor sensor = new TemperatureSensor();
		sensor.addDevice(new Display());
		sensor.addDevice(new AirConditioner());
		sensor.addDevice(new Heater());

		sensor.setTemperature(30);
		sensor.setTemperature(15);
	}
}

class TemperatureSensor {
	private int temperature;
	private List<Device> deviceList = new ArrayList<>();

	public void addDevice(Device device) {
		deviceList.add(device);
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
		notice();
	}

	public void notice() {
		for( Device d : deviceList ) {
			d.update(temperature);
		}
	}
}

interface Device {
	void update(int temperature);
}

class Display implements Device {
	@Override
	public void update(int temperature) {
		System.out.printf("[%s] 현재 온도: %d도%n", getClass().getSimpleName(), temperature);
	}
}
class Heater implements Device {
	@Override
	public void update(int temperature) {
		if( temperature <= 18 ) {
			System.out.printf("[%s] 온도가 18도 이하입니다. 히터 가동!%n", getClass().getSimpleName());
		}
	}
}
class AirConditioner implements Device {
	@Override
	public void update(int temperature) {
		if( temperature >= 26 ) {
			System.out.printf("[%s] 온도가 26도 이상입니다. 에어컨 가동!%n", getClass().getSimpleName());
		}
	}
}