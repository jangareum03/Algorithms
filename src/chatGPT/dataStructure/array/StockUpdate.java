package chatGPT.dataStructure.array;

import java.util.Arrays;

/**
 * 배열 - 재고 수량 업데이트
 */
public class StockUpdate {
	public static void main(String[] args) {
		int[] stocks = new int[] {5, 3, 10, 2};

		decreaseStock(stocks);
		System.out.println(Arrays.toString(stocks));
	}

	private static void decreaseStock(int[] stocks) {
		int[] soldIndex = {0, 2, 2, 3};

		for( int idx : soldIndex ) {
			stocks[idx]--;	//인덱스 위치의 재고수량을 1씩 감소
		}
	}
}

