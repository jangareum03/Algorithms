package chatGPT.DesignPattern.decorator;

/**
 * 데코레이터 패턴 - 온라인 결제 시스템
 */
public class OnlineShopping {
	public static void main(String[] args) {
		System.out.println("1. 해외 결제 시");
		Payment overseasPay = new CreditCardPayment();
		overseasPay = new CurrencyDecorator(overseasPay);
		overseasPay = new SecurityDecorator(overseasPay);
		overseasPay.pay(100);

		System.out.println("2. 프로모션 결제 시");
		Payment promotionPay = new CreditCardPayment();
		promotionPay = new PointDecorator(promotionPay);
		promotionPay = new DiscountDecorator(promotionPay);
		promotionPay.pay(50000);
	}
}

interface Payment {
	void pay(double amount);
}

class CreditCardPayment implements Payment{
	@Override
	public void pay(double amount) {
		System.out.println("신용카드로 " +(int)amount + "원 결제 완료");
	}
}

abstract class PaymentDecorator implements Payment {
	private final Payment payment;

	public PaymentDecorator(Payment payment) {
		this.payment = payment;
	}

	@Override
	public void pay(double amount) {
		payment.pay(amount);
	}
}

class CurrencyDecorator extends PaymentDecorator{

	public CurrencyDecorator(Payment payment) {
		super(payment);
	}

	@Override
	public void pay(double amount) {
		System.out.printf("[환율 변환] %d USD → %d KRW%n", (int)amount, exchangeUsdToWon(amount));
		super.pay( exchangeUsdToWon(amount) );
	}

	private int exchangeUsdToWon(double amount) {
		int won = 1350;

		return (int) (amount * won);
	}
}

class DiscountDecorator extends PaymentDecorator {
	private final int discountPercent = 10;

	public DiscountDecorator(Payment payment) {
		super(payment);
	}

	@Override
	public void pay(double amount) {
		int discountPrice = getDiscountAmount(amount);
		System.out.printf("[할인 적용] %d원 → %d원%n", (int)amount, discountPrice);

		super.pay(discountPrice);
	}

	private int getDiscountAmount(double amount) {
		double discount = amount * (discountPercent / 100.0);

		return (int) (amount - discount);
	}
}

class PointDecorator extends PaymentDecorator {
	private final double percent = 0.01;

	public PointDecorator(Payment payment) {
		super(payment);
	}


	@Override
	public void pay(double amount) {
		int eranAmount = (int) (amount * percent);
		System.out.printf("[포인트 적립] %d원 적립 완료%n", eranAmount);

		super.pay(amount);
	}
}

class SecurityDecorator extends PaymentDecorator {
	public SecurityDecorator(Payment payment) {
		super(payment);
	}

	@Override
	public void pay(double amount) {
		System.out.println("[보안검증] 결제 정보 확인 완료");
		super.pay(amount);
	}
}