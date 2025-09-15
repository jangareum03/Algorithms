package chatGPT.DesignPattern.prototype;

/**
 * 프로토타입 패턴 문제 - 문서 편집기
 */
public class DocumentEdit {
	public static void main(String[] args) {
		ImagePrototype image = new Image("logo.png", 5);
		System.out.println("이미지 로드: " + image);

		ImagePrototype cloneImage = image.clone();
		System.out.println("이미지 복제 완료: " + cloneImage);
	}
}

interface ImagePrototype extends Cloneable {
	ImagePrototype clone();
}

class Image implements ImagePrototype {
	private final String name;
	private final int size;

	public Image(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public ImagePrototype clone() {
		return new Image(this.name, this.size);
	}

	@Override
	public String toString() {
		return "file=" + name + ", size=" + size +"MB";
	}
}