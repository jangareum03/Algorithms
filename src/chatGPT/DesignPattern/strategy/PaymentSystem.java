package chatGPT.DesignPattern.strategy;

/**
 * 전략 패턴 - 결제 방식 선택
 */
public class PaymentSystem {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart(new CreditCardPayment());
		cart.pay(50000);

		cart = new ShoppingCart(new KakaoPayPayment());
		cart.pay(30000);

		cart = new ShoppingCart(new BankTransferPayment());
		cart.pay(10000);
	}
}

interface PaymentStrategy {
	void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
	@Override
	public void pay(int amount) {
		System.out.printf("신용카드로 %d원을 결제했습니다.%n", amount);
	}
}

class KakaoPayPayment implements  PaymentStrategy {
	@Override
	public void pay(int amount) {
		System.out.printf("카카오페이로 %d원을 결제했습니다.%n", amount);
	}
}

class BankTransferPayment implements PaymentStrategy {
	@Override
	public void pay(int amount) {
		System.out.printf("계좌이체로 %d원을 결제했습니다.%n", amount);
	}
}

class ShoppingCart {
	private final PaymentStrategy paymentStrategy;

	public ShoppingCart(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void pay(int amount) {
		paymentStrategy.pay(amount);
	}
}