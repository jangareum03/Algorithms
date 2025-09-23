package chatGPT.DesignPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 플라이웨이트 패턴 - 온라인 상품 썸네일
 */
public class ProductThumbnail {
	public static void main(String[] args) {
		Thumbnail nikeShoe = ThumbnailFactory.getThumbnail("nike-Shoes");
		Thumbnail nikeClothe = ThumbnailFactory.getThumbnail("nike-Clothes");
		Thumbnail adidasShoe = ThumbnailFactory.getThumbnail("adidas-Shoes");
		Thumbnail pumaShoe = ThumbnailFactory.getThumbnail("puma-Shoes");

		nikeShoe.show();
		nikeShoe.show();
		nikeClothe.show();
		adidasShoe.show();
		adidasShoe.show();
		pumaShoe.show();

		System.out.println("총 Thumbnail 객체 수: " +ThumbnailFactory.getTotalThumbnail());
	}
}

class Thumbnail {
	private final String brand;
	private final String category;
	private final String imagePath;

	public Thumbnail(String brand, String category) {
		this.brand = brand;
		this.category = category;
		this.imagePath = String.join("/", "/images", brand, category);

		System.out.println("Thumbnail 객체 생성: " + String.join("-", brand, category));
	}

	public void show() {
		System.out.println("상품 출력: " + brand + "-" + category);
	}
}


class ThumbnailFactory {
	private static Map<String, Thumbnail> thumbnailMap = new HashMap<>();

	public static Thumbnail getThumbnail(String key) {
		if( !thumbnailMap.containsKey(key) ) {
			String[] values = key.split("-");

			thumbnailMap.put(key, new Thumbnail(values[0], values[1]));
		}

		return thumbnailMap.get(key);
	}

	public static int getTotalThumbnail() {
		return thumbnailMap.size();
	}
}