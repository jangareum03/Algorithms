package chatGPT;

/**
 * 팩토리 메서드 패턴 - 알람 생성기
 */
public class AlarmGenerator {
	public static void main(String[] args) {
		AlarmFactory factory;

		factory = new EmailFactory();
		factory.createAlarm("Hello!");

		factory = new SMSFactory();
		factory.createAlarm("Hello!");

		factory = new PushFactory();
		factory.createAlarm("Hello!");
	}
}

interface Alarm {
	void send(String text);
}

class EmailAlarm implements Alarm {
	@Override
	public void send(String text) {
		System.out.println("Email sent: " + text);
	}
}

class SMSAlarm implements Alarm {
	@Override
	public void send(String text) {
		System.out.println("SMS sent: " + text);
	}
}

class PushAlarm implements Alarm {
	@Override
	public void send(String text) {
		System.out.println("Push notification sent: " + text);
	}
}


abstract class AlarmFactory {
	public void createAlarm(String text) {
		Alarm alarm = createAlarm();
		alarm.send(text);
	}

	protected abstract Alarm createAlarm();
}


class EmailFactory extends AlarmFactory {
	@Override
	protected Alarm createAlarm() {
		return new EmailAlarm();
	}
}

class SMSFactory extends AlarmFactory {
	@Override
	protected Alarm createAlarm() {
		return new SMSAlarm();
	}
}


class PushFactory extends AlarmFactory {
	@Override
	protected Alarm createAlarm() {
		return new PushAlarm();
	}
}