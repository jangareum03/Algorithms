package chatGPT.DesignPattern.adaptor;

/**
 * 어댑터 패턴 - 결제 시스템 통합
 */
public class PaymentSystem {
	public static void main(String[] args) {
		PaymentGateway kakao = new KakaoPayAdapter(new KakaoPayAPI());
		PaymentGateway pay = new PayPalAdapter(new PayPalAPI());

		kakao.pay(10000);
		pay.pay(26000);
	}
}

//--- 외부 API ---
class KakaoPayAPI {
	void sendPayment(int amountInWon) {
		System.out.println("KakaoPay: " + amountInWon + "원 결제 완료");
	}
}

class PayPalAPI {
	void makePayment(double amount, String currency) {
		System.out.println("PayPal : " + amount + "  " + currency + " 결제 완료");
	}
}

interface PaymentGateway {
	void pay(int amountInWon);
};

class KakaoPayAdapter implements PaymentGateway {
	private final KakaoPayAPI kakaoPayAPI;

	public KakaoPayAdapter(KakaoPayAPI kakaoPayAPI) {
		this.kakaoPayAPI = kakaoPayAPI;
	}

	@Override
	public void pay(int amountInWon) {
		kakaoPayAPI.sendPayment(amountInWon);
	}
}

class PayPalAdapter implements PaymentGateway {
	private final PayPalAPI payPalAPI;

	public PayPalAdapter(PayPalAPI payPalAPI) {
		this.payPalAPI = payPalAPI;
	}

	@Override
	public void pay(int amountInWon) {
		payPalAPI.makePayment( exchangeToUSD(amountInWon), "USD" );
	}

	private double exchangeToUSD(int amountInWon) {
		return amountInWon / (double) 1300;
	}
}