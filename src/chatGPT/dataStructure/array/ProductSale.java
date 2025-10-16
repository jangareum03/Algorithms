package chatGPT.dataStructure.array;

import java.util.Arrays;

/**
 * 배열 - 상품 매출 합산
 */
public class ProductSale {
	public static void main(String[] args) {
		int[][] sales = new int[][] {
				{100, 200, 300},
				{400, 500, 600},
				{150, 250, 350}
		};

		int[] total = new int[sales[0].length];

		for (int[] sale : sales) {
			for (int c = 0; c < sale.length; c++) {
				total[c] += sale[c];
			}
		}

		printTotalByProduct(total);
	}


	private static void printTotalByProduct(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
