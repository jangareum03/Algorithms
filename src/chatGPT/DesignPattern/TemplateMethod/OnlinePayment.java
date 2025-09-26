package chatGPT.DesignPattern.TemplateMethod;

/**
 * 템플릿 메서드 패턴 - 온라인 결제
 */
public class OnlinePayment {
	public static void main(String[] args) {
		PaymentProcessor card = new CardPaymentProcessor("1234123412341234", "12/26");
		card.processPayment();

		PaymentProcessor bank = new BankTransferProcessor("123412341234123");
		bank.processPayment();
	}
}

abstract class PaymentProcessor {
	public final void processPayment() {
		verification();
		approve();
		resultLog();
	}

	private void resultLog() {
		System.out.println("결제 로그 기록 완료");
	}

	protected abstract void verification();
	protected abstract void approve();
}

class CardPaymentProcessor extends PaymentProcessor {
	private final String cardNumber;
	private final String expirationPeriod;

	public CardPaymentProcessor(String cardNumber, String expirationPeriod) {
		this.cardNumber = cardNumber;
		this.expirationPeriod = expirationPeriod;
	}

	@Override
	protected void verification() {
		if( cardNumber.length() < 16 ) {
			throw new IllegalArgumentException("잘못된 카드번호: " + cardNumber);
		}

		if( !expirationPeriod.matches("^(0[1-9]|1[0-2])/\\d{2}$") ) {
			throw new IllegalArgumentException("잘못된 유효기간: " + expirationPeriod);
		}

		System.out.println("카드 정보 검증");
	}

	@Override
	protected void approve() {
		System.out.println("카드사 승인 요청");
	}
}

class BankTransferProcessor extends PaymentProcessor {
	private final String account;

	public BankTransferProcessor(String account) {
		this.account = account;
	}

	@Override
	protected void verification() {
		if( account.length() < 14 ) {
			throw  new IllegalArgumentException("잘못된 계좌정보: " + account);
		}

		System.out.println("계좌 정보 검증");
	}

	@Override
	protected void approve() {
		System.out.println("은행 이체 요청");
	}
}