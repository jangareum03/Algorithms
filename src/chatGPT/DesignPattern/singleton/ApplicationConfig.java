package chatGPT.DesignPattern.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 싱글톤 패턴 문제 - 애플리케이션 설정값
 */
public class ApplicationConfig {
	public static void main(String[] args) {
		ConfigManager config1 = ConfigManager.getInstance();
		config1.setConfig("AppName", "MyApp");

		ConfigManager config2 = ConfigManager.getInstance();

		System.out.println("AppName = " + config2.getConfig("AppName"));
		System.out.println("Same instance? " + (config1 == config2));
	}
}

class ConfigManager {
	private static ConfigManager instance;
	private final Map<String, String> configMap = new HashMap<>();

	private ConfigManager() {}

	public static ConfigManager getInstance() {
		if( instance == null ) {
			instance = new ConfigManager();
		}

		return instance;
	}

	public void setConfig(String key, String value) {
		configMap.put(key, value);
	}


	public String getConfig(String key) {
		return configMap.get(key);
	}
}
