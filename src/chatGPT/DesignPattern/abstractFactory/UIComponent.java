package chatGPT.DesignPattern.abstractFactory;

/**
 * 추상 팩토리 문제 - UI 컴포넌트 생성
 */
public class UIComponent {
	public static void main(String[] args) {
		UIFactory factory = new DesktopUIFactory();

		Button button = factory.createButton();
		Checkbox checkbox = factory.createCheckbox();

		button.render();;
		checkbox.render();
	}
}

interface Button {
	void render();
}

interface Checkbox {
	void render();
}

class DesktopButton implements Button {
	@Override
	public void render() {
		System.out.println("데스크탑 버튼 생성");
	}
}

class MobileButton implements Button {
	@Override
	public void render() {
		System.out.println("모바일 버튼 생성");
	}
}

class DesktopCheckbox implements Checkbox {
	@Override
	public void render() {
		System.out.println("데스크탑 체크박스 생성");
	}
}

class MobileCheckbox implements Checkbox {
	@Override
	public void render() {
		System.out.println("모바일 체크박스 생성");
	}
}

interface UIFactory {
	Button createButton();
	Checkbox createCheckbox();
}

class DesktopUIFactory implements UIFactory {
	@Override
	public Button createButton() {
		return new DesktopButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new DesktopCheckbox();
	}
}

class MobileUIFactory implements UIFactory {
	@Override
	public Button createButton() {
		return new MobileButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new MobileCheckbox();
	}
}