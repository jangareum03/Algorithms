package chatGPT.DesignPattern.proxy;

/**
 * 프록시 패턴 - 결제 API 로깅
 */
public class PaymentLogging {
	public static void main(String[] args) {
		Payment payment = new PaymentProxy();
		payment.pay("Alice", 10000);
	}
}

interface Payment{
	void pay(String user, int amount);
}

class PaymentService implements Payment{
	public void pay(String user, int amount) {
		System.out.printf("결제 완료: %s - %d원%n", user, amount);
	}
}

class PaymentProxy implements Payment{
	private Payment paymentService;

	public void pay(String user, int amount) {
		showLogging(user, amount);

		getPaymentService().pay(user, amount);
	}

	private Payment getPaymentService() {
		if( paymentService == null ) {
			paymentService = new PaymentService();
		}

		return paymentService;
	}

	private void showLogging(String user, int amount) {
		System.out.printf("로그: %s가 %d원 결제를 요청했습니다.%n", user, amount);
	}
}

