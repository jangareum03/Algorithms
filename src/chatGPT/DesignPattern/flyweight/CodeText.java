package chatGPT.DesignPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 플라이웨이트 패턴 - 코드 편집기
 */
public class CodeText {
	public static void main(String[] args) {
		SyntaxColor keywords = ColorFactory.getSyntaxColor("키워드");
		SyntaxColor variable = ColorFactory.getSyntaxColor("변수");
		SyntaxColor Strings = ColorFactory.getSyntaxColor("문자열");

		keywords.show("public");
		keywords.show("class");
		variable.show("Main");
		Strings.show("Hello");
		variable.show("System");

		System.out.println("총 SyntaxColor 객체 수: " + ColorFactory.getTotalColor());
	}
}

class SyntaxColor {
	private final String colorCode;

	public SyntaxColor(String code) {
		this.colorCode = code;

		System.out.println("SyntaxColor 객체 생성: " + colorCode);
	}

	public void show(String keyword) {
		System.out.println("토큰 출력: " + keyword + "(색상: " + colorCode + ")" );
	}
}

class ColorFactory {
	private static final Map<String, SyntaxColor> token = new HashMap<>();

	public static SyntaxColor getSyntaxColor(String keyword) {
		if( !token.containsKey(keyword) ) {
			String code = switch (keyword) {
				case "키워드" -> "#FF0000";
				case "변수" -> "#0000FF";
				case "문자열" -> "#00FF00";
				default -> "#000000";
			};

			token.put(keyword, new SyntaxColor(code));
		}

		return token.get(keyword);
	}

	public static int getTotalColor() {
		return token.size();
	}
}