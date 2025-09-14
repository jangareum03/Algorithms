package chatGPT.DesignPattern;

/**
	싱글톤 패턴 문제 - 로그 기록
 */


public class RecordLogger {
	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		Logger newLogger = Logger.getInstance();

		logger.log("Hello");
		logger.log("Singleton test");

		System.out.println("Same instance? " + (logger == newLogger));
	}
}

class Logger {
	private static Logger logger;

	private Logger() {}

	public static Logger getInstance() {
		if( logger == null ) {
			logger = new Logger();
		}

		return logger;
	}

	//메시지 출력 메서드
	public void log(String message) {
		System.out.println("LOG: " + message);
	}
}
