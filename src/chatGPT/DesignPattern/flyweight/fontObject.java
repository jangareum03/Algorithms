package chatGPT.DesignPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 플라이웨이트 패턴 - 글꼴 공유
 */
public class fontObject {
	public static void main(String[] args) {
		Font arial = FontFactory.getFont("Arial", 12);
		Font times = FontFactory.getFont("Times", 14);

		arial.show('A');
		arial.show('B');
		times.show('C');

		System.out.println("총 Font 객체 수: " + FontFactory.getTotal());
	}
}

class Font {
	private final String name;
	private final int size;

	public Font(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public void show(char text) {
		System.out.printf("문자 %c 출력 (폰트: %s-%d)%n", text, name, size);
	}
}

class FontFactory {
	private static Map<String, Font> fontMap = new HashMap<>();

	public static Font getFont(String name, int size) {
		String key = String.format("%s-%d", name, size);

		if( !fontMap.containsKey(key) ) {
			fontMap.put(key, new Font(name, size));
		}

		return fontMap.get(key);
	}

	public static int getTotal() {
		return fontMap.size();
	}
}