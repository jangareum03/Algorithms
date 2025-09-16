package chatGPT.DesignPattern.adaptor;

import java.util.HashMap;
import java.util.Map;

/**
 * 어댑터 패턴 - 로그 시스템
 */
public class LogSystem {
	public static void main(String[] args) {
		Logger consoleLogger = LoggerFactory.getLogger("console");
		consoleLogger.log("Service started");

		Logger fileLogger = LoggerFactory.getLogger("file");
		fileLogger.log("Service started");

		Logger jsonLogger =LoggerFactory.getLogger("json");
		jsonLogger.log("Service started");
	}
}

//--- 인터페이스 ---
interface Logger {
	void log(String message);
}


//--- 어댑터 ---
class ConsoleAdapter implements Logger {
	private  final ConsoleLogger logger;

	public ConsoleAdapter(ConsoleLogger logger) {
		this.logger = logger;
	}

	@Override
	public void log(String message) {
		logger.logMessage(message);
	}
}

class FileAdapter implements Logger {
	private final FileLogger logger;

	public FileAdapter(FileLogger logger) {
		this.logger = logger;
	}

	@Override
	public void log(String message) {
		 logger.writeLog("app.log", message);
	}
}

class JsonAdapter implements Logger {
	private final JsonLogger logger;

	public JsonAdapter( JsonLogger logger ) {
		this.logger = logger;
	}

	@Override
	public void log(String message) {
		Map<String, Object> messageMap = new HashMap<>();
		messageMap.put("log", message);

		logger.logJson(messageMap);
	}
}


//--- 서비스에서 제공하는 로그 시스템 ---
class ConsoleLogger {
	public void logMessage(String message) {
		System.out.println("ConsoleLogger: " + message);
	}
}

class FileLogger {
	public void writeLog(String fileName, String msg) {
		String message = String.format("FileLogger(%s): %s", fileName, msg);

		System.out.println(message);
	}
}

class JsonLogger {
	public void logJson(Map<String, Object> data) {
		System.out.print("JsonLogger: {");

		for( String key : data.keySet() ) {
			System.out.printf("\"%s\": \"%s\"", key, data.get(key));
		}

		System.out.println("}");
	}
}


//--- 팩소리 메서드 ---
class LoggerFactory {
	public static Logger getLogger(String type) {
		return switch (type.toLowerCase()) {
			case "console" -> new ConsoleAdapter(new ConsoleLogger());
			case "file" -> new FileAdapter(new FileLogger());
			case "json" -> new JsonAdapter(new JsonLogger());
			default -> throw new IllegalArgumentException("알 수 없는 Logger 타입입니다: " + type);
		};
	}
}