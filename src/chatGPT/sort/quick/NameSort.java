package chatGPT.sort.quick;

/**
 * 퀵 정렬 - 고객 이름 오름차순
 */
public class NameSort {
	public static void main(String[] args) {
		String[] names = {"Jin", "Alexander", "Bob", "Chris", "Amy"};

		quickSort(names, 0, names.length - 1);

		for (String name : names)
			System.out.print(name + " ");
	}

	private static void quickSort(String[] arr, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(arr, start, end);
			quickSort(arr, start, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, end);
		}
	}

	private static int partition(String[] arr, int start, int end) {
		String pivot = arr[end];
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (compare(arr[j], pivot) <= 0) {
				i++;
				String temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// 피벗을 올바른 위치로 이동
		String temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;

		return i + 1;
	}

	private static int compare(String a, String b) {
		if (a.length() != b.length()) {
			return Integer.compare(a.length(), b.length()); // 짧은 게 먼저
		} else {
			return a.compareTo(b); // 같은 길이면 알파벳순
		}
	}
}
