package chatGPT;

/**
 *		팩토리메서드 패턴 - 게임 아이템 생성
 */
public class GameItemClazz {
	public static void main(String[] args) {
		createGameItem("weapon", "range",3);
		createGameItem("armor", "buckler", 2);
		createGameItem("potion", "hp",5);
	}

	private static void createGameItem(String type, String name, int level) {
		ItemFactory factory = ItemSelector.getFactory(type);

		if( factory == null ) {
			System.out.println("알 수 없는 아이템 유형입니다 : " + type);
			return;
		}

		if( level < 0 ) {
			System.out.println("레벨은 1 이상이여야 합니다 : " + level);
			return;
		}

		Item item = factory.createItem(name);
		item.use(level);
	}
}

interface Item {
	void use(int level);
	int getEffect(int level);
	int getPrice();
}

abstract class Weapons implements Item {
	private final String type = "Weapons";
	private static final int MIN_PRICE = 10;
	private static final int MIN_EFFECT = 10;

	@Override
	public void use(int level) {
		System.out.println( getType() + " Lv " + level + " created. Attack +" + getEffect(level) + ", Price: " + getPrice());
	}

	@Override
	public int getEffect(int level) {
		return MIN_EFFECT + extendEffect(level);
	}

	@Override
	public int getPrice() {
		return MIN_PRICE + extendPrice();
	}

	protected String getType() {
		return type;
	}

	protected abstract int extendEffect(int level);
	protected abstract int extendPrice();
}

class Melee extends Weapons {

	@Override
	protected String getType() {
		return "Melee";
	}

	@Override
	protected int extendEffect(int level) {
		return level * 5;
	}

	@Override
	protected int extendPrice() {
		return 10;
	}
}

class Ranged extends Weapons {

	@Override
	protected String getType() {
		return "Range";
	}

	@Override
	protected int extendEffect(int level) {
		return level * 3;
	}

	@Override
	protected int extendPrice() {
		return 8;
	}
}

class Wand extends Weapons {

	@Override
	protected String getType() {
		return "Wand";
	}

	@Override
	protected int extendEffect(int level) {
		return level * 8;
	}

	@Override
	protected int extendPrice() {
		return 20;
	}
}


abstract class Armor implements Item {
	private final String type = "armor";
	private static final int MIN_PRICE = 10;
	private static final int MIN_EFFECT = 5;

	@Override
	public void use(int level) {
		System.out.println(getType() + " Lv " + level + " created. Defense +" + getEffect(level) + ", Price : " + getPrice());
	}

	@Override
	public int getPrice() {
		return MIN_PRICE + extendPrice();
	}

	@Override
	public int getEffect(int level) {
		return MIN_EFFECT + extendEffect(level);
	}

	private String getType() {
		return type;
	}

	protected abstract int extendEffect(int level);
	protected abstract int extendPrice();
}

class Tower extends Armor {

	@Override
	protected int extendEffect(int level) {
		return level * 10;
	}

	@Override
	protected int extendPrice() {
		return 10;
	}
}

class Buckler extends Armor {
	@Override
	protected int extendEffect(int level) {
		return level * 5;
	}

	@Override
	protected int extendPrice() {
		return 7;
	}
}


abstract class Potion implements Item {
	private final String type = "Potion";
	private static final int MIN_PRICE = 5;
	private static final int MIN_EFFECT = 3;

	@Override
	public void use(int level) {
		System.out.println(getType() + " Lv " + level + " created. Heal +" + getEffect(level) + ", Price : " + getPrice());
	}

	@Override
	public int getEffect(int level) {
		return MIN_EFFECT + extendEffect(level);
	}

	@Override
	public int getPrice() {
		return MIN_PRICE + extendPrice();
	}

	private String getType() {
		return type;
	}

	protected abstract int extendEffect(int level);
	protected abstract int extendPrice();
}

class HpPotion extends Potion {
	@Override
	protected int extendEffect(int level) {
		return level * 5;
	}

	@Override
	protected int extendPrice() {
		return 5;
	}
}

class MpPotion extends Potion {
	@Override
	protected int extendEffect(int level) {
		return level * 3;
	}

	@Override
	protected int extendPrice() {
		return 3;
	}
}



abstract class ItemFactory {
	public Item createItem(String name) {
		return selectedItem(name);
	}

	protected abstract Item selectedItem(String name);
}

class WeaponFactory extends ItemFactory {
	@Override
	protected Item selectedItem(String name) {
		return switch (name.toLowerCase()) {
			case "melee" -> new Melee();
			case "range" -> new Ranged();
			case "wand" -> new Wand();
			default -> null;
		};
	}
}

class ArmorFactory extends ItemFactory {
	@Override
	protected Item selectedItem(String name) {
		return switch (name.toLowerCase()) {
			case "tower" -> new Tower();
			case "buckler" -> new Buckler();
			default -> null;
		};
	}
}

class PotionFactory extends ItemFactory {
	@Override
	protected Item selectedItem(String name) {
		return switch (name.toLowerCase()) {
			case "hp" -> new HpPotion();
			case "mp" -> new MpPotion();
			default -> null;
		};
	}
}

class ItemSelector {
	public static ItemFactory getFactory(String type) {
		switch (type.toLowerCase()) {
			case "weapon" : return new WeaponFactory();
			case "armor" : return new ArmorFactory();
			case "potion" : return new PotionFactory();
			default: return null;
		}
	}
}