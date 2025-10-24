package chatGPT.dataStructure.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 맵 - 상품재고 및 가격 통합 관리 시스템
 */
public class InventorySystem {
	public static void main(String[] args) {
		Map<String, HashMap<String, Integer>> products = new TreeMap<>();

		products.put("식품", new HashMap<>());
		products.get("식품").put("커피", 40);
		products.get("식품").put("초콜릿", 30);

		products.put("의류", new HashMap<>());
		products.get("의류").put("티셔츠", 50);

		products.put("전자제품", new HashMap<>());
		products.get("전자제품").put("노트북", 12);
		products.get("전자제품").put("스마트폰", 25);

		//출력
		for(String key : products.keySet() ) {
			System.out.printf("[%s]%n", key);

			for( Map.Entry<String, Integer> p : products.get(key).entrySet() ) {
				System.out.printf("- %s: %d개%n", p.getKey(), p.getValue());
			}
		}

		//특정 상품 개수
		String keyword = "커피";
		int count = 0;
		for(Map<String, Integer> p : products.values() ) {
			count += p.getOrDefault(keyword, 0);
		}
		System.out.printf("전체 '%s' 재고 수량: %d%n",keyword, count);
	}
}
