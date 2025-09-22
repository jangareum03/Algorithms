package chatGPT.DesignPattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 컴포지트 패턴 - 메뉴판 구성
 */
public class Menu {
	public static void main(String[] args) {
		MenuGroup lunchMenu = new MenuGroup("점심특선");
		lunchMenu.add(new MenuItem("김치찌개", 7000));
		lunchMenu.add(new MenuItem("제육볶음", 8000));

		MenuGroup mainMenu = new MenuGroup("단품 메뉴");
		mainMenu.add(new MenuItem("된장찌개", 6500));
		lunchMenu.add(mainMenu);

		lunchMenu.print();
	}
}


abstract class MenuComponent {
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public abstract void print();
}

class MenuItem extends MenuComponent {
	private final String menu;
	private final int price;

	public MenuItem(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}

	@Override
	public void print() {
		System.out.printf("\t%s - %d원%n", menu, price);
	}
}

class MenuGroup extends MenuComponent {
	private final String groupName;
	private List<MenuComponent> menus = new ArrayList<>();

	public MenuGroup(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public void add(MenuComponent menuComponent) {
		menus.add(menuComponent);
	}

	@Override
	public void remove(MenuComponent menuComponent) {
		menus.add(menuComponent);
	}

	@Override
	public void print() {
		System.out.println(groupName);
		for( MenuComponent component : menus ) {
			component.print();
		}
	}
}