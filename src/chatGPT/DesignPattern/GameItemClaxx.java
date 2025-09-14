package chatGPT.DesignPattern;

/**
 * 추상팩토리 문제 - 게임 아이템 제작 시스템
 */
public class GameItemClaxx {
	public static void main(String[] args) {
		Race race = new Elf();
		Weapon weapon = race.createWeapon(10);
		Armor armor = race.createArmor(10);

		weapon.attack();
		armor.defend();
	}
}

//--- 무기 ---
interface Weapon {
	void attack();
	void setPower(int level);
	int getPower();
}

class Bow implements Weapon {
	private int power;

	@Override
	public void attack() {
		System.out.println("활로 원거리 공격! (공격력 " + getPower() + ")");
	}

	@Override
	public void setPower(int level) {
		this.power = level * 5;
	}

	@Override
	public int getPower() {
		return power;
	}
}

class Axe implements Weapon {
	private int power;

	@Override
	public void attack() {
		System.out.println("도끼로 강력한 일격! (공격력 " + getPower() + ")");
	}

	@Override
	public void setPower(int level) {
		this.power = level * 6;
	}

	@Override
	public int getPower() {
		return power;
	}
}


//--- 방어구
interface Armor {
	void defend();
	void setPower(int level);
	int getPower();
}

class Robe implements Armor {
	private int power;

	@Override
	public void defend() {
		System.out.println("로브로 마법 방어! (방어력 " + getPower() + ")");
	}

	@Override
	public void setPower(int level) {
		this.power = level * 2;
	}

	@Override
	public int getPower() {
		return power;
	}
}

class LeatherArmor implements Armor {
	private int power;

	@Override
	public void defend() {
		System.out.println("가죽 갑옷으로 방어! (방어력 " + getPower() + ")");
	}

	@Override
	public void setPower(int level) {
		this.power = level * 3;
	}

	@Override
	public int getPower() {
		return power;
	}
}


//--- 종족 ---
interface Race {
	Weapon createWeapon(int level);
	Armor createArmor(int level);
}

class Elf implements Race {
	@Override
	public Weapon createWeapon(int level) {
		Bow weapon = new Bow();
		weapon.setPower(level);

		System.out.println("엘프 활 생성 (레벨 " + level + ", 공격력 " + weapon.getPower() + ")");
		return weapon;
	}

	@Override
	public Armor createArmor(int level) {
		Robe robe = new Robe();
		robe.setPower(level);

		System.out.println("엘프 로브 생성 (레벨 " + level + ", 방어력력 " + robe.getPower() + ")");
		return robe;
	}
}

class Oak implements Race {
	@Override
	public Weapon createWeapon(int level) {
		Axe weapon = new Axe();
		weapon.setPower(level);

		System.out.println("오크 도끼 생성 (레벨 " + level + ", 공격력 " + weapon.getPower() + ")");
		return weapon;
	}

	@Override
	public Armor createArmor(int level) {
		LeatherArmor armor = new LeatherArmor();
		armor.setPower(level);

		System.out.println("오크 가죽갑옷 생성 (레벨 " + level + ", 방어력 " + armor.getPower() + ")");
		return armor;
	}
}