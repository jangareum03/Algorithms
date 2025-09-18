package chatGPT.DesignPattern.proxy;

/**
 * 프록시 패턴 - 원격 API 요청 대리
 */
public class RemoteAPI {
	public static void main(String[] args) {
		Weather weather = new WeatherProxy(null);
		weather.today();
	}
}

interface Weather {
	void today();
}

class WeatherService implements Weather{

	@Override
	public void today() {
		System.out.println("실제 WeatherService에서 날씨 데이터를 가져옵니다.");
		System.out.println("오늘 날씨: 맑음");
	}
}

class WeatherProxy implements Weather{
	private Weather weather;

	public WeatherProxy(Weather weather) {
		this.weather = weather;
	}

	@Override
	public void today() {
		System.out.println("프록시: API 서버에 요청을 전달합니다.");

		if( weather == null ) {
			weather = new WeatherService();
		}

		weather.today();
	}
}