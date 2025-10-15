package chatGPT.sort.quick;

import java.util.Arrays;

/**
 * 퀵 정렬 - 거래 금액 내림차순으로 상위 3개만 출력
 */
public class TransactionSort {
	public static void main(String[] args) {
		int[] transactions = {25000, 18000, 56000, 32000, 40000, 15000};

		quickSort(transactions, 0, transactions.length - 1);

		// 상위 3개만 출력
		System.out.println(Arrays.toString(Arrays.copyOfRange(transactions, 0, 3)));
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(arr, start, end);
			quickSort(arr, start, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (arr[j] > pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// 피벗 위치 확정
		int temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;

		return i + 1;
	}
}
