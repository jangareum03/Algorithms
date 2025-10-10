package chatGPT.DesignPattern.memento;

import java.util.Stack;

/**
 * 메멘토 패턴 - 게임 캐릭터 체력
 */
public class GameCharacter {
	public static void main(String[] args) {
		Character hero = new Character("Knight", 100);
		GameCaretaker caretaker = new GameCaretaker();

		caretaker.save(hero);
		hero.takeDamage(30);
		System.out.println(hero.getHp());
		caretaker.undo(hero);
		System.out.println(hero.getHp());

	}
}

class Character {
	private final String name;
	private int hp;

	public Character(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public void takeDamage(int damage) {
		this.hp = hp - damage;
	}

	public GameMemento save() {
		return new GameMemento(hp);
	}

	public void restore(GameMemento memento) {
		this.hp = memento.getHp();
	}

	public int getHp() {
		return hp;
	}
}

class GameMemento {
	private final int hp;

	public GameMemento(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}
}

class GameCaretaker {
	private Stack<GameMemento> history = new Stack<>();

	public void save(Character character) {
		history.push(character.save());
	}

	public void undo(Character character) {
		if( !history.isEmpty() ) {
			GameMemento memento = history.pop();
			character.restore(memento);
		}
	}

}