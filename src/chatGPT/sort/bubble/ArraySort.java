package chatGPT.sort.bubble;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 버블 정렬 <br><br>
 * 1. ascSort - 오름차순 정렬이 끝나면 배열 출력하는 메서드<br>
 * 2. descSort - 내림차순 정렬을 회차가 끝나면 출력하는 메서드<br>
 * 3. breakSort - 교환이 일어나지 않으면 종료하는 메서드<br>
 */
public class ArraySort {
	private static final Logger logger = Logger.getLogger(ArraySort.class.getName());

	public static void main(String[] args) {
		ascSort(new int[]{4500, 1200, 3200, 8900, 1500});
		System.out.println("=================================================");

		descSort(new int[] {80, 95, 67, 88, 92});
		System.out.println("=================================================");

		breakSort(new int[] {2, 3, 4, 5, 6});
		System.out.println("=================================================");
	}

	private static void ascSort(int[] arr) {
		for( int i=0; i<arr.length; i++ ) {
			for( int j=0; j < arr.length - 1 - i; j++ ) {
				if( arr[j] > arr[j+1] ) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		System.out.println("최종결과: " + Arrays.toString(arr));
	}


	private static void descSort(int[] arr) {
		for( int i=0; i<arr.length; i++ ) {
			for( int j=0; j<arr.length - 1; j++ ) {
				if( arr[j] < arr[j+1] ) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}

			System.out.println((i+1) + "회전: " + Arrays.toString(arr));
		}

		System.out.println("최종결과: " + Arrays.toString(arr));
	}


	private static void breakSort(int[] arr) {
		int pass = 0;
		boolean swap;

		for( int i=0; i<arr.length; i++ ) {
			swap = false;

			for( int j=0; j<arr.length-1-i; j++ ) {
				if( arr[j] > arr[j+1] ) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;

					swap = true;
				}
			}

			pass++;

			if(!swap) break;
		}

		System.out.println("반복횟수: " + pass);
		System.out.println("결과: " + Arrays.toString(arr));
	}
}

