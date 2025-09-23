package chatGPT.DesignPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 플라이웨이트 패턴 - 이미지 아이콘
 */
public class ImageIcon {
	public static void main(String[] args) {
		Icon saveIcon = IconFactory.getIcon("/img/save.png");
		saveIcon.show("Save1");

		Icon saveIcon2 = IconFactory.getIcon("/img/save.png");
		saveIcon2.show("Save2");

		System.out.println("총 Icon 객체 수: " + IconFactory.getTotalIcon());
	}
}

class Icon {
	private final String path;

	public Icon(String path) {
		this.path = path;
		System.out.println("Icon 객체 생성: " + path);
	}

	public void show(String name) {
		System.out.println("버튼 생성: " + name + "	(아이콘: " + path + ")");
	}
}

class IconFactory {
	private static Map<String, Icon> iconMap = new HashMap<>();

	public static Icon getIcon(String iconPath) {
		if( !iconMap.containsKey(iconPath) ) {
			iconMap.put(iconPath, new Icon(iconPath));
		}

		return iconMap.get(iconPath);
	}

	public static int getTotalIcon() {
		return iconMap.size();
	}

}