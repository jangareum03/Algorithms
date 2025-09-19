package chatGPT.DesignPattern.bridge;

/**
 *	브리지 패턴 - 온라인 결제
 */
public class OnlineCredit {
	public static void main(String[] args) {
		PaymentBridge immediateCard = new ImmediatePayment(new CardPayment());
		immediateCard.pay(10000);

		PaymentBridge installmentBank = new InstallmentPayment(new BankTransferPayment());
		installmentBank.pay(50000);
	}
}

interface Payment {
	void pay(int amount);
}

class CardPayment implements Payment {
	@Override
	public void pay(int amount) {
		System.out.printf("카드로 %d원", amount);
	}
}

class BankTransferPayment implements Payment {
	@Override
	public void pay(int amount) {
		System.out.printf("계좌이체로 %d원", amount);
	}
}

abstract class PaymentBridge {
	protected final Payment payment;

	public PaymentBridge(Payment payment) {
		this.payment = payment;
	}

	public abstract void pay(int amount);
}

class ImmediatePayment extends PaymentBridge{
	public ImmediatePayment(Payment payment) {
		super(payment);
	}

	public void pay(int amount) {
		payment.pay(amount);
		System.out.println(" 즉시 결제합니다.");
	}
}

class InstallmentPayment extends PaymentBridge {
	public InstallmentPayment(Payment payment) {
		super(payment);
	}

	@Override
	public void pay(int amount) {
		payment.pay(amount);
		System.out.println(" 할부 결제합니다.");
	}
}