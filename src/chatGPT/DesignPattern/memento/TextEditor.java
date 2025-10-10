package chatGPT.DesignPattern.memento;

import java.util.Stack;

/**
 * 메멘토 패턴 - 문서 편집기
 */
public class TextEditor {
	public static void main(String[] args) {
		Document doc = new Document();
		TextCaretaker caretaker = new TextCaretaker();

		doc.setText("Hello");
		doc.setFont("Arial");
		doc.setSize(12);
		caretaker.save(doc);

		doc.setText("Hello World");
		doc.setFont("Times");
		doc.setSize(14);

		caretaker.undo(doc);
		doc.show();

	}
}

class Document {
	private String text;
	private String font;
	private int size;

	public void setText(String text) {
		this.text = text;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public TextMemento save() {
		return new TextMemento(text, font, size);
	}

	public void restore(TextMemento memento) {
		this.font = memento.getFont();
		this.text = memento.getText();
		this.size = memento.getSize();
	}

	public void show() {
		System.out.println("Text: " + text);
		System.out.println("Font: " + font);
		System.out.println("Size: " + size);
	}
}

class TextMemento {
	private final String text;
	private final String font;
	private final int size;

	public TextMemento(String text, String font, int size) {
		this.text = text;
		this.font = font;
		this.size = size;
	}

	public String getText() {
		return text;
	}

	public String getFont() {
		return font;
	}

	public int getSize() {
		return size;
	}
}

class TextCaretaker {
	private Stack<TextMemento> history = new Stack<>();

	public void save(Document document) {
		history.push(document.save());
	}

	public void undo(Document document) {
		if( !history.isEmpty() ) {
			TextMemento memento = history.pop();

			document.restore(memento);
		}
	}
}