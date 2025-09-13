package chatGPT;

/**
 *		팩토리메서드 패턴 - 게임 아이템 생성
 */
public class GameItemClazz {
	public static void main(String[] args) {
		createGameItem("weapon", 3);
		createGameItem("armor", 2);
		createGameItem("potion", 5);
	}

	private static void createGameItem(String type, int level) {
		ItemFactory factory = ItemSelector.getFactory(type);

		if( factory == null ) {
			System.out.println("알 수 없는 아이템 유형입니다 : " + type);
			return;
		}

		Item item = factory.createItem();
		item.use(level);
	}
}

interface Item {
	void use(int level);
	int getEffect();
}

class Weapon implements Item {
	private final String type = "weapon";

	@Override
	public void use(int level) {
		System.out.println("Weapon Lv " + level + " created. Attack +" + (level * getEffect()));
	}

	@Override
	public int getEffect(){
		return 10;
	}
}

class Armor implements Item {

	@Override
	public void use(int level) {
		System.out.println("Armor Lv " + level + " created. Defense +" + (level * getEffect()));
	}

	@Override
	public int getEffect(){
		return 10;
	}
}

class Potion implements Item {
	@Override
	public void use(int level) {
		System.out.println("Potion Lv " + level + " created. Heal +" + (level * getEffect()));
	}

	@Override
	public int getEffect() {
		return 10;
	}
}

abstract class ItemFactory {
	protected abstract Item createItem();
}

class WeaponFactory extends ItemFactory {
	@Override
	protected Item createItem() {
		return new Weapon();
	}
}

class ArmorFactory extends ItemFactory {
	@Override
	protected Item createItem() {
		return new Armor();
	}
}

class PotionFactory extends ItemFactory {
	@Override
	protected Item createItem() {
		return new Potion();
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