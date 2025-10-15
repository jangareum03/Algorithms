package chatGPT.sort.heap;

/**
 * 힙 정렬 - 파일 크기 내림차순
 */
public class FileSize {
	public static void main(String[] args) {
		int[] size = {104, 87, 150, 32, 78, 92};

		heapSort(size);
		for( int i : size ) System.out.print(i + "   ");
	}

	private static void heapSort(int[] arr) {
		//최소힙 구하기
		for( int i = arr.length/2 - 1; i>=0; i-- ) {
			heapify( arr, i, arr.length);
		}

		for( int i = arr.length - 1; i >=0; i-- ) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			heapify(arr, 0, i);
		}
	}

	private static void heapify(int[] arr, int root, int length ) {
		int r = root;
		int left = root * 2 + 1;
		int right = root * 2 + 2;

		//루트보다 자식이 작으면 변경
		if( left < length && arr[left]  < arr[r] ) {
			r = left;
		}

		//루트보다 자식이 작으면 변경
		if( right < length && arr[right] < arr[r] ) {
			r = right;
		}

		//루트가 변경되었다는 뜻(자식이 루트보다 작음)
		if( root != r ) {
			int temp = arr[root];
			arr[root] = arr[r];
			arr[r] = temp;

			heapify( arr, r, length );
		}
	}
}