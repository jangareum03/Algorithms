package chatGPT.DesignPattern.bridge;

/**
 * 브리지 패턴 - 상품 알림 서비스
 */
public class ProductNotice {
	public static void main(String[] args) {
		Notification orderEmail = new OrderNotification(new EmailSender());
		orderEmail.send("사용자 A");

		Notification deliverySMS = new DeliveryNotification(new SMSSender());
		deliverySMS.send("사용자 B");
	}
}

interface Sender {
	void sendMessage(String message);
}

class EmailSender implements Sender {
	@Override
	public void sendMessage(String message) {
		System.out.println("이메일로 " + message);
	}
}

class SMSSender implements Sender {
	@Override
	public void sendMessage(String message) {
		System.out.println("SMS으로 " + message);
	}
}

abstract class Notification {
	protected final Sender sender;

	public Notification(Sender sender) {
		this.sender = sender;
	}

	public abstract void send(String user);
}

class OrderNotification extends Notification {
	public OrderNotification(Sender sender) {
		super(sender);
	}

	@Override
	public void send(String user) {
		sender.sendMessage(user + "에게 주문 확인 알림을 보냅니다.");
	}
}

class DeliveryNotification extends Notification {
	public DeliveryNotification(Sender sender) {
		super(sender);
	}

	@Override
	public void send(String user) {
		sender.sendMessage(user + "에게 배송 완료 알림을 보냅니다.");
	}
}