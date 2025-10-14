package chatGPT.sort.merge;

import java.util.Arrays;

/**
 * 병합 정렬 - 상품 가격  오름차순 / 내림차순
 */
public class ProductPriceSort {
	public static void main(String[] args) {
		int[] prices = {4500, 1200, 3200, 800, 2500};

		System.out.println("오름차순: " + Arrays.toString(mergeSort(prices, false)));
		System.out.println("내림차순: " + Arrays.toString(mergeSort(prices, true)));
	}

	private static int[] mergeSort(int[] arr, boolean reverse) {
		if( arr.length <= 1 ) return arr;

		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);

		left = mergeSort(left, reverse);
		right = mergeSort(right, reverse);

		return merge(left, right, reverse);
	}

	private static int[] merge(int[] left, int[] right, boolean reverse) {
		int[] merge = new int[left.length + right.length];

		int l = 0;
		int r = 0;
		int m = 0;

		while ( l < left.length && r < right.length ) {
			if( left[l] <= right[r] && !reverse || right[r] < left[l] && reverse ) {
				merge[m++] = left[l++];
			}else {
				merge[m++] = right[r++];
			}
		}

		while ( l < left.length ) {
			merge[m++] = left[l++];
		}

		while ( r < right.length ) {
			merge[m++] = right[r++];
		}

		return merge;
	}
}

