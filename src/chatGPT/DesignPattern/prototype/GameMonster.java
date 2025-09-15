package chatGPT.DesignPattern.prototype;

/**
 * 프로토타입 패턴 문제 - 몬스터 생성
 */
public class GameMonster {
	public static void main(String[] args) {
		Oak oak = new Oak("오크", 100, 15);
		oak.print("오크 생성: ");

		Troll troll = new Troll("트롤", 120, 10);
		 troll.print("트롤 생성: ");

		 MonsterPrototype cloneOak = oak.clone();
		cloneOak.print("복제된 오크: ");
	}
}

interface MonsterPrototype extends Cloneable {
	MonsterPrototype clone();
	void print(String prefix);
}

abstract class Monster implements MonsterPrototype {
	public String name;
	public int stamina;
	public int attack;

	@Override
	public void print(String prefix) {
		System.out.println(prefix + "이름=" + getName() +", 체력=" + getStamina() + ", 공격력=" + getAttack());
	}

	public String getName() {
		return name;
	}

	public int getStamina() {
		return stamina;
	}

	public int getAttack() {
		return attack;
	}

	public abstract MonsterPrototype clone();
}

class Oak extends Monster {
	public Oak(String name, int stamina, int attack) {
		this.name = name;
		this.stamina = stamina;
		this.attack = attack;
	}

	@Override
	public MonsterPrototype clone() {
		return new Oak(this.name, this.stamina , this.attack);
	}
}

class Troll extends Monster  {

	public Troll(String name, int stamina, int attack) {
		this.name = name;
		this.stamina = stamina;
		this.attack = attack;
	}

	@Override
	public MonsterPrototype clone() {
		return new Troll(this.name ,this.stamina, this.attack);
	}
}