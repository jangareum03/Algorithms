package chatGPT.sort.bubble;

import java.util.Arrays;

/**
 * 버블 정렬 - 로그 분석 시스템
 */
public class LogSort {
	public static void main(String[] args) {
		int[] responseTimes = {120, 98, 101, 99, 97, 102};

		sortTimesByAsc(responseTimes);

		double avg = Arrays.stream(responseTimes).average().orElse(0);
		System.out.printf("평균 응답 시간: %.2fms", avg );
	}

	public static void sortTimesByAsc(int[] times) {
		boolean isSwaped;
		int swaped;
		int totalLoop = 0, totalSwap = 0;

		for(int i=0; i<times.length; i++) {
			isSwaped = false;
			swaped = 0;

			for( int j=0; j<times.length -i -1; j++ ) {
				if( times[j] > times[j+1] ) {
					int temp = times[j];
					times[j] = times[j+1];
					times[j+1] = temp;

					isSwaped = true;
					swaped++;
				}
			}

			System.out.printf("%d회전 - 교환: %d회%n", (i+1),swaped);
			totalLoop++;
			totalSwap += swaped;

			if( !isSwaped ) break;
		}

		System.out.println("총 루프 수 : " + totalLoop);
		System.out.println("총 교환 수 : " + totalSwap);
		System.out.println("정렬 결과: " + Arrays.toString(times));

	}
}