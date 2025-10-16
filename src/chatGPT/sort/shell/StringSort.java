package chatGPT.sort.shell;

/**
 * 셸 정렬 - 문자열 사전순(=오름차순)
 */
public class StringSort {
	public static void main(String[] args) {
		String[] products = {"banana", "Apple", "grape", "apple", "Orange"};

		shellSort(products);
		for(String s : products ) System.out.print(s + " ");
	}

	private static void shellSort(String[] arr) {
		int n = arr.length;

		for( int gap = n/2; gap >0; gap /= 2 ) {
			for( int i=gap; i < n; i++ ) {
				String temp = arr[i];
				int j;

				for( j=i; j >= gap && arr[j - gap].compareToIgnoreCase(temp) > 0 ; j-= gap ) {
					arr[j] = arr[j-gap];
				}

				arr[j] = temp;
			}
		}
	}
}
