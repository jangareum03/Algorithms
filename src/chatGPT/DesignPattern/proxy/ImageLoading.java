package chatGPT.DesignPattern.proxy;

/**
 * 프록시 패턴 - 이미지 로딩 최적화
 */
public class ImageLoading {
	public static void main(String[] args) {
		Image image = new ImageProxy("강아지.jpg");
		image.display();

		image.display();
	}
}

interface Image {
	void display();
}

class RealImage implements Image{
	private String image;

	public RealImage(String image) {
		this.image = image;
		roadingImage();
	}

	private void roadingImage() {
		System.out.println(image +" 이미지 로드 중...");
	}

	@Override
	public void display() {
		System.out.println(image + " 이미지 출력");
	}
}

class ImageProxy implements Image {
	private RealImage realImage;
	private String image;

	public ImageProxy( String image ) {
		this.image = image;
	}

	@Override
	public void display() {
		if( realImage == null ) {
			realImage = new RealImage(image);
		}

		realImage.display();
	}
}