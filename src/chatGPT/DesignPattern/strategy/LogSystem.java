package chatGPT.DesignPattern.strategy;

/**
 * 전략 패턴 - 로그 저장
 */
public class LogSystem {
	public static void main(String[] args) {
		LogService service = new LogService(new ConsoleLog());
		service.saveLog("사용자 로그인 성공");

		service = new LogService(new FileLog());
		service.saveLog("사용자 로그인 성공");

		service = new LogService(new DatabaseLog());
		service.saveLog("사용자 로그인 성공");
	}
}

interface LogStrategy {
	void saveLog(String message);
}

class ConsoleLog implements LogStrategy {
	@Override
	public void saveLog(String message) {
		System.out.println("[Console] " + message);
	}
}

class FileLog implements LogStrategy {
	@Override
	public void saveLog(String message) {
		System.out.println("[File] " + message);
	}
}

class DatabaseLog implements LogStrategy {
	@Override
	public void saveLog(String message) {
		System.out.println("[Database] " + message);
	}
}

class LogService {
	private final LogStrategy strategy;

	public LogService(LogStrategy strategy) {
		this.strategy = strategy;
	}

	public void saveLog(String message) {
		strategy.saveLog(message);
	}
}