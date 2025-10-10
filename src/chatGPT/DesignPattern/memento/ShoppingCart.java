package chatGPT.DesignPattern.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 메멘토 패턴 - 쇼핑카트 상태
 */
public class ShoppingCart {
	public static void main(String[] args) {
		Cart cart = new Cart();
		CartCaretaker caretaker = new CartCaretaker();

		cart.addItem("Laptop");
		caretaker.save(cart);
		cart.addItem("Mouse");

		caretaker.undo(cart);
		cart.showItems();
	}
}

class Cart {
	private List<String> items = new ArrayList<>();

	public void addItem(String item) {
		items.add(item);
	}

	public void removeItem(String item) {
		if( !items.isEmpty() ) {
			items.remove(item);
		}
	}

	public CartMemento save() {
		return new CartMemento(new ArrayList<>(items));
	}

	public void restore(CartMemento memento) {
		this.items = new ArrayList<>(memento.getItem());
	}

	public void showItems() {
		System.out.println(items);
	}
}

class CartMemento {
	private final List<String> item;

	public CartMemento(List<String> item) {
		this.item = new ArrayList<>(item);
	}

	public List<String> getItem() {
		return new ArrayList<>(item);
	}
}

class CartCaretaker {
	private Stack<CartMemento> history = new Stack<>();

	public void save(Cart cart) {
		history.push(cart.save());
	}

	public void undo(Cart cart) {
		if( !history.isEmpty() ) {
			CartMemento memento = history.pop();
			cart.restore(memento);
		}
	}
}