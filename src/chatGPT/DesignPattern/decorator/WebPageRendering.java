package chatGPT.DesignPattern.decorator;

/**
 * 데코레이터 패턴 - 웹 페이지 렌더링
 */
public class WebPageRendering {
	public static void main(String[] args) {
		Page page = new BasicPage();

		page = new AdBanner(page);
		page = new ScrollBar(page);

		page.render();
	}
}

interface Page {
	void render();
	String getInfo();
}

class BasicPage implements Page {
	@Override
	public void render() {
		System.out.println("기본 페이지 내용");
	}

	@Override
	public String getInfo() {
		return "기본 페이지 내용";
	}

}

abstract class PageDecorator implements Page {
	private final Page page;

	public PageDecorator(Page page) {
		this.page = page;
	}

	@Override
	public void render() {
		System.out.println(getInfo());
	}

	@Override
	public String getInfo() {
		return page.getInfo();
	}
}

class AdBanner extends PageDecorator {

	public AdBanner(Page page) {
		super(page);
	}

	@Override
	public String getInfo() {
		return super.getInfo() + " + 광고 배너";
	}
}

class ScrollBar extends PageDecorator {
	public ScrollBar(Page page) {
		super(page);
	}

	@Override
	public String getInfo() {
		return super.getInfo() + " + 스크롤바";
	}
}

class DarkMode extends PageDecorator {

	public DarkMode(Page page) {
		super(page);
	}

	@Override
	public String getInfo() {
		return super.getInfo() + " + 다크모드";
	}
}