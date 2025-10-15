package chatGPT.sort.quick;

/**
 * 퀵 정렬 - 재고 가격 오름차순
 */
public class PriceSort {
	public static void main(String[] args) {
		int[] prices = {3500, 1200, 5600, 1500, 2200};

		quickSort( prices, 0, prices.length-1 );

		for( int p : prices ) System.out.print(p + " ");
	}

	private static void quickSort(int[] arr, int start, int end ) {
		if( start < end ) {
			int pivot = partition(arr, start, end);

			quickSort( arr, start, pivot -1 );						//왼쪽 그룹
			quickSort( arr, pivot + 1, end);		//오른쪽 그룹
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];		//마지막 원소를 피벗

		int move = start - 1;
		for( int i=start; i<end; i++ ) {
			if( arr[i] <= pivot ) {
				move++;

				int temp = arr[move];
				arr[move] = arr[i];
				arr[i] = temp;
			}
		}

		//피벗 위치 알기
		int temp = arr[move + 1];
		arr[move + 1]  = arr[end];
		arr[end] = temp;

		return move + 1;
	}
}
