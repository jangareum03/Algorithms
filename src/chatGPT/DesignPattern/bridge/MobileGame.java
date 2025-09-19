package chatGPT.DesignPattern.bridge;

/**
 * 브리지 패턴 - 모바일 게임 공격 방식
 */
public class MobileGame {
	public static void main(String[] args) {
		Weapon bow = new Bow(new PowerAttack());
		bow.attack();

		Weapon sword = new Sword(new BasicAttack());
		sword.attack();
	}
}

interface Weapon {
	void attack();
}

class Bow implements Weapon {
	private final AttackMethod attackMethod;

	public Bow(AttackMethod method) {
		this.attackMethod = method;
	}

	@Override
	public void attack() {
		attackMethod.attack("활");
	}
}

class Sword	implements Weapon {
	private final AttackMethod attackMethod;

	public Sword(AttackMethod method) {
		this.attackMethod = method;
	}
	@Override
	public void attack() {
		attackMethod.attack("검");
	}
}

abstract class AttackMethod {
	public abstract void attack(String weaponType);
}

class BasicAttack extends AttackMethod {
	@Override
	public void attack(String weaponType) {
		System.out.println(weaponType + "(으)로 기본 공격합니다.");
	}
}

class PowerAttack extends AttackMethod {
	@Override
	public void attack(String weaponType) {
		System.out.println(weaponType + "(으)로 강력하게 공격합니다.");
	}
}