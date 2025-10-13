package chatGPT.sort.selection;

import java.util.Arrays;

/**
 *	선택 정렬 - 직원 급여 오름차순
 */
public class SalarySort {
	public static void main(String[] args) {
		int[] salaries = {3200, 4500, 2800, 3900, 5000};

		ascBySalary(salaries);
	}

	private static void ascBySalary(int[] salary) {
		for( int i=0; i<salary.length; i++ ) {
			int minIndex = i;

			for( int j=i+1; j<salary.length; j++ ) {
				if( salary[minIndex] > salary[j] ) {
					minIndex = j;
				}
			}

			int temp = salary[minIndex];
			salary[minIndex] = salary[i];
			salary[i] = temp;
		}

		System.out.println(Arrays.toString(salary));
	}
}