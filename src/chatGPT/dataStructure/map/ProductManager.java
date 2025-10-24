package chatGPT.dataStructure.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 맵 - 제품 가격 관리
 */
public class ProductManager {
	public static void main(String[] args) {
		Map<String, Integer> products = new LinkedHashMap<>();

		products.put("콜라", 1800);
		products.put("사이다", 1700);
		products.put("물", 1000);

		System.out.println("등록된 상품 목록 ▼");
		for(Map.Entry<String, Integer> product : products.entrySet() ) {
			System.out.println(product.getKey() + ": " + product.getValue() +"원");
		}
	}
}