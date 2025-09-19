package chatGPT.DesignPattern.bridge;

/**
 * 브리지패턴 - 문서 생성 시스템
 */
public class DocumentSystem {
	public static void main(String[] args) {
		Document pdf = new PDFDocument(new WebViewer());
		pdf.display();
	}
}

interface Document {
	void display();
}

class PDFDocument implements Document {
	private final Renderer renderer;

	public PDFDocument(Renderer renderer) {
		this.renderer = renderer;
	}

	@Override
	public void display() {
		System.out.print("PDF ");

		renderer.rend();
	}
}

class WordDocument implements Document {
	private final Renderer renderer;

	public WordDocument(Renderer renderer) {
		this.renderer = renderer;
	}

	@Override
	public void display() {
		System.out.print("Word ");
	}
}

abstract class Renderer {
	public abstract void rend();
}

class WebViewer extends Renderer {
	@Override
	public void rend() {
		System.out.println("문서를 웹으로 표시합니다.");
	}
}

class Printer extends Renderer {
	@Override
	public void rend() {
		System.out.println(" 문서를 인쇄합니다.");
	}
}