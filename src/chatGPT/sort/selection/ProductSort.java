package chatGPT.sort.selection;

import java.util.Arrays;

/**
 * 선택 정렬 - 상품 재고 내림차순 or 상품 이름 오름차순
 */
public class ProductSort {
	public static void main(String[] args) {
		int[] stocks = {15, 42, 8, 23, 4, 31};
		descByStock(stocks);

		String[] products = {"Banana", "Apple", "Mango", "Grape"};
		ascByName(products);
	}

	private static void descByStock(int[] products) {
		int maxIndex;

		for( int i=0; i<products.length; i++ ) {
			maxIndex = i;

			for( int j=i+1; j<products.length; j++ ) {
				if( products[maxIndex] < products[j] ) {
					maxIndex = j;
				}

			}

			int temp = products[maxIndex];
			products[maxIndex] = products[i];
			products[i] = temp;

			System.out.println((i+1) + "회차: " + Arrays.toString(products));
		}
	}

	private static void ascByName(String[] product) {
		for( int i=0; i<product.length; i++ ) {
			int minIndex = i;

			for( int j=i+1; j<product.length; j++ ) {
				if( product[minIndex].compareTo(product[j]) > 0 ) {
					minIndex = j;
				}
			}

			String temp = product[minIndex];
			product[minIndex] = product[i];
			product[i] = temp;
		}

		System.out.println(Arrays.toString(product));
	}
}
