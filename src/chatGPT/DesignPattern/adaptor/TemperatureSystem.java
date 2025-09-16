package chatGPT.DesignPattern.adaptor;

/**
 * 어댑터 패턴 - 서로 다른 API 통합
 */
public class TemperatureSystem {
	public static void main(String[] args) {
		Temperature cTemp = new CelsiusSensorAdaptor(new CelsiusSensor());
		Temperature sTemp = new FahrenheitSensorAdaptor(new FahrenheitSensor());

		System.out.println("CelsiusSensor: " + Math.round(cTemp.getCelsiusTemperature() * 10) / 10.0);
		System.out.println("FahrenheitSensor: " + Math.round(sTemp.getCelsiusTemperature() * 10) / 10.0);
	}
}

//--- 외부 API ---
class CelsiusSensor {
	public double getCelsius() {
		return 20 + Math.random() * 10;
	}
}

 class FahrenheitSensor {
	public double getFahrenheit() {
		return 68 + Math.random() * 18;
	}
}


//--- 기존 프로그램 ---
interface Temperature {
	double getCelsiusTemperature();
}


//--- 어댑터 ---
class CelsiusSensorAdaptor implements Temperature {
	private final CelsiusSensor sensor;

	public CelsiusSensorAdaptor(CelsiusSensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public double getCelsiusTemperature() {
		return sensor.getCelsius();
	}
}

class FahrenheitSensorAdaptor implements Temperature {
	private final FahrenheitSensor sensor;

	public FahrenheitSensorAdaptor(FahrenheitSensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public double getCelsiusTemperature() {
		return (sensor.getFahrenheit() - 32) * 5 / 9;
	}
}