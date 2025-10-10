package chatGPT.DesignPattern.chain;

/**
 * 책임 연쇄 패턴 - 로그 처리
 */
public class LogChain {
	public static void main(String[] args) {

	}
}

abstract class LoggerHandler {
	protected LoggerHandler nextHandler;
	protected String level;

	public void setNextHandler(LoggerHandler handler) {
		this.nextHandler = handler;
	}

	protected void console(String message) {
		System.out.printf("[%s] %s - 콘솔 출력", level, message);
	}

	protected void file(String message) {
		System.out.printf("[%s] %s - 파일 저장", level, message);
	}

	protected abstract void request(String message);
}

class ErrorLogger extends LoggerHandler {

	public ErrorLogger() {
		this.level = "ERROR";
	}

	@Override
	protected void request(String message) {
		console(message);
		file(message);

		if( nextHandler != null ) {
			nextHandler.request(message);
		}
	}
}

class WarnLogger extends LoggerHandler {

	public WarnLogger() {
		this.level = "WARN";
	}

	@Override
	protected void request(String message) {
		console(message);

		if( nextHandler != null ) {
			nextHandler.request(message);
		}
	}
}

class InfoLogger extends LoggerHandler {
	@Override
	protected void request(String message) {
		file(message);
	}
}