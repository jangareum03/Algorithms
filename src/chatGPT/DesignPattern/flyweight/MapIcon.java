package chatGPT.DesignPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 플라이웨이트 패턴 - 지도 마커 공유
 */
public class MapIcon {
	public static void main(String[] args) {
		MarkerIcon cafeIcon = MarkerIconFactory.getMarkerIcon("카페");
		MarkerIcon hospitalIcon = MarkerIconFactory.getMarkerIcon("병원");
		MarkerIcon gasIcon = MarkerIconFactory.getMarkerIcon("주유소");

		cafeIcon.showLocation(37.12, 127.11);
		cafeIcon.showLocation(37.15, 127.20);
		hospitalIcon.showLocation(37.22, 127.40);
		gasIcon.showLocation(37.25, 127.50);
		hospitalIcon.showLocation(37.30, 127.55);

		System.out.println("총 MarkerIcon 객체 수: " + MarkerIconFactory.getTotalIcon());
	}
}

class MarkerIcon {
	private final String type;
	private final String path;

	public MarkerIcon(String type) {
		this.type = type;
		this.path = getPath();

		System.out.println("MarkerIcon 객체 생성: " + type);
	}

	private String getPath() {
		return switch (type) {
			case "카페" -> "/image/cafe.png";
			case "주유소" -> "/image/gas.png";
			case "병원" -> "/image/hospital.png";
			default -> throw new IllegalArgumentException("알 수 없는 타입: " + type);
		};
	}

	public void showLocation(double x, double y) {
		System.out.printf("마커 생성: (%.2f, %.2f) %s%n", x, y, type);
	}

}

class MarkerIconFactory {
	private static Map<String, MarkerIcon> iconMap = new HashMap<>();

	public static MarkerIcon getMarkerIcon(String type) {
		if( !iconMap.containsKey(type) ) {
			iconMap.put(type, new MarkerIcon(type));
		}

		return iconMap.get(type);
	}

	public static int getTotalIcon() {
		return iconMap.size();
	}
}