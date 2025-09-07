package backjoon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTwoNumbersTest {

	@Test
	@DisplayName("입력값이 1~9 내 범위면 true를 반환한다.")
	void shouldReturnTrue_whenNumberIsBetween1And9() {
		assertTrue(SumTwoNumbers.isValid(1));
		assertTrue(SumTwoNumbers.isValid(5));
		assertTrue(SumTwoNumbers.isValid(9));
	}


	@Test
	@DisplayName("입력값이 1~9 범위에 벗어나면 false를 반환한다.")
	void shouldReturnFalse_whenNumberIsNotBetween1And9() {
		assertFalse(SumTwoNumbers.isValid(0));
		assertFalse(SumTwoNumbers.isValid(10));
		assertFalse(SumTwoNumbers.isValid(-3));
	}


	@Test
	@DisplayName("입력값의 허용 범위가 벗어나면 IllegalArgumentException 예외가 발생한다.")
	void shouldThrowException_whenNumberOutOfRange() {
		//given
		int[][] inputNumbers = {
				{0, 5},
				{5, 10},
				{-1, 11},
				{0, 0},
				{10, 10}
		};

		for( int[] number : inputNumbers ) {
			//when
			int num1 = number[0];
			int num2 = number[1];

			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				if(!SumTwoNumbers.isValid(num1) || !SumTwoNumbers.isValid(num2)) {
					throw new IllegalArgumentException("숫자는 0보다 크고 10보다 작아야 합니다.");
				}
			});

			//then
			assertEquals("숫자는 0보다 크고 10보다 작아야 합니다.", exception.getMessage());
		}
	}
}