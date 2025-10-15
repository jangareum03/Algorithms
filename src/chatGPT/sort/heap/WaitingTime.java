package chatGPT.sort.heap;

/**
 * 힙 정렬 - 고객 대기시간 오름차순
 */
public class WaitingTime {
	public static void main(String[] args) {
		int[] times = {42, 10, 18, 7, 56, 23};

		heapSort(times);
		for( int i : times ) System.out.print(i + "   ");
	}

	private static void heapSort(int[] arr) {
		int n = arr.length;

		//전체 배열중에 제일 큰 값(=루트) 찾기
		for( int i= n/2-1; i  >= 0; i-- ) {
			heapify( arr, i, n );
		}

		//루트와 마지막 원소 교환
		for( int i=n-1; i >0; i-- ) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify( arr, 0, i );
		}
	}

	private static void heapify(int[] arr, int r, int n) {
		int root = r;						//루트
		int left = 2 * r + 1;			//왼쪽 자식
		int right = 2 * r + 2;		//오른쪽 자식

		//왼쪽 자식이 부모보다 크다(자식 노드가 없는 부모인 경우 조건 불만족)
		if( left < n && arr[left] > arr[root] ) {
			root = left;
		}

		//오른쪽 자식이 부모보다 크다(자식 노드가 없는 부모인 경우 조건 불만족)
		if( right<n && arr[right] > arr[root] ) {
			root = right;
		}

		//기존 루트가 아니면 변경(자식이 더 크다는 뜻)
		if(r != root ) {
			int temp = arr[r];
			arr[r] = arr[root];
			arr[root] = temp;

			heapify( arr, root, n );
		}
	}
}

