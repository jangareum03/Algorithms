package chatGPT.DesignPattern.adaptor;

/**
 * 어댑터 패턴 - 레거시 라이브러리 호환성
 */
public class LegacySystem {
	public static void main(String[] args) {
		Printer printer = new LegacyAdaptor(new OldPrinter());
		printer.print("Hello Adaptor!");
	}
}

//--- 현재 시스템 ---
interface Printer {
	void print(String message);
}

//--- 구형 라이브러리 ---
class OldPrinter {
	void printText(String text) {
		System.out.println("구형 출력 메서드 호출: " + text);
	}
}

//--- 어댑터 클래스 ---
class LegacyAdaptor implements Printer{
	private final OldPrinter oldPrinter;

	public LegacyAdaptor(OldPrinter printer) {
		this.oldPrinter = printer;
	}

	@Override
	public void print(String message) {
		oldPrinter.printText(message);
	}
}