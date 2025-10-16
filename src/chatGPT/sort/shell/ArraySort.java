package chatGPT.sort.shell;

import java.util.Arrays;

/**
 * 셸 정렬 - 정수 배열 오름차순 / 내림차순
 */
public class ArraySort {
	public static void main(String[] args) {
		int[] arr = {23, 12, 1, 8, 34, 54, 2, 3};

		//오름차순
		shellSort(arr, true);
		System.out.println("오름차순: " + Arrays.toString(arr));

		//내림차순
		shellSort(arr, false);
		System.out.println("내림차순: " + Arrays.toString(arr));
	}

	private static void shellSort(int[] arr, boolean asc) {
		int gap = arr.length / 2;

		for(int i=gap; i > 0; i /= 2) {	//gap이 1까지만 반복(전체 회차)
			for( int j=i; j < arr.length; j++ ) {	//gap이 배열길이만큼 증가(gap뒤의 원소로 돌아감)
				int temp = arr[j];

				int k;
				if( asc ) {
					for( k=j; k >= i && arr[k - i] > temp; k -= i) {
						arr[k] = arr[k-i];
					}
				}else {
					for( k=j; k >= i && arr[k - i] < temp; k-= i ) {
						arr[k] = arr[k-i];
					}
				}

				arr[k] = temp;
			}
		}
	}
}
