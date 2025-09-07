package backjoon;

import java.util.Scanner;

/**
 * <p>
 * 패키지이름    : backjoon<br>
 * 파일이름       : SumTwoNumbers<br>
 * 작성자          : areum Jang<br>
 * 생성날짜       : 25. 9. 8
 * </p>
 * <p color='#FFC658'>두 수의 합 구하기</p>
 */
public class SumTwoNumbers {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();

			//정수값 범위 확인
			if (!isValid(num1) || !isValid(num2)) {
				throw new IllegalArgumentException("숫자는 0보다 크고 10보다 작아야 합니다.");
			}

			System.out.println(num1 + num2);
		} catch (Exception e) {
			System.out.println("오류: " + e.getMessage());
		}
	}

	public static boolean isValid(int number) {
		return 0 < number && number < 10;
	}
}
