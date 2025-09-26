package chatGPT.DesignPattern.TemplateMethod;

/**
 * 템플릿 메서드 패턴 - 게임 행동
 */
public class GameAction {
	public static void main(String[] args) {
		GameAI warrior = new WarriorAI();
		warrior.performAction();

		GameAI escape = new EscaperAI();
		escape.performAction();
	}
}

abstract class GameAI {
	public final void performAction() {
		quest();
		move();
		action();
		log();
	}

	protected abstract void quest();
	protected abstract void move();
	protected abstract void action();
	protected void log() {}
}

class WarriorAI extends GameAI {
	@Override
	protected void quest() {
		System.out.println("적 탐색");
	}

	@Override
	protected void move() {
		System.out.println("적에게 이동");
	}

	@Override
	protected void action() {
		System.out.println("공격 수행");
	}

	@Override
	protected void log() {
		System.out.println("행동 로그 기록");
	}
}

class GathererAI extends GameAI {
	@Override
	protected void quest() {
		System.out.println("지원 탐색");
	}

	@Override
	protected void move() {
		System.out.println("지원 위치로 이동");
	}

	@Override
	protected void action() {
		System.out.println("채집 수행");
	}

	@Override
	protected void log() {
		System.out.println("행동 로그 기록");
	}
}

class EscaperAI extends GameAI {
	@Override
	protected void quest() {
		System.out.println("안전한 위치 탐색");
	}

	@Override
	protected void move() {
		System.out.println("빠르게 이동");
	}

	@Override
	protected void action() {
		System.out.println("도망 수행");
	}
}