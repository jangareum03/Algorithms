package chatGPT.DesignPattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 컴포지트 패턴 - 파일 탐색기
 */
public class FileSearch {
	public static void main(String[] args) {
		// 최상위 폴더
		FileSystemComponent root = new Folder("root");
		root.add(new File("doc.txt", 100));
		root.add(new File("image.png", 200));

		// work 폴더
		FileSystemComponent work = new Folder("work");
		work.add(new File("report.pdf", 150));
		work.add(new File("image_final.png", 300));

		root.add(work);

		// 전체 구조 출력
		System.out.println("=== 전체 파일 구조 ===");
		root.show(0);

		// "image" 키워드 검색
		System.out.println("\n=== 'image' 검색 결과 ===");
		root.find("image", 0);

		// "report" 키워드 검색
		System.out.println("\n=== 'report' 검색 결과 ===");
		root.find("report", 0);
	}
}

abstract class FileSystemComponent {
	protected int size;

	protected FileSystemComponent(int size) {
		this.size = size;
	}

	protected void printIndentation(int index) {
		System.out.print("\t".repeat(index));
	}

	public void add(FileSystemComponent fileSystemComponent) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + "는 add 기능을 지원하지 않습니다.");
	}

	public abstract void find(String keyword, int index);
	public abstract void show(int index);
	public abstract int getSize();
}

class File extends FileSystemComponent {
	private final String name;

	public File(String fileName, int size) {
		super(size);
		this.name = fileName;
	}

	@Override
	public void find(String keyword, int index) {
		if( name.contains(keyword) ) {
			printIndentation(index);
			System.out.printf("[FILE] %s\t(%dKB)%n", name, getSize());
		}
	}

	@Override
	public void show(int index) {
		printIndentation(index);
		System.out.printf("%s	(%dKB)%n", name, getSize());
	}

	@Override
	public int getSize() {
		return size;
	}
}

class Folder extends FileSystemComponent {
	private final String name;
	private final List<FileSystemComponent> fileList = new ArrayList<>();

	public Folder(String name) {
		super(0);
		this.name = name;
	}

	public void add(FileSystemComponent fileSystemComponent) {
		fileList.add(fileSystemComponent);
	}

	@Override
	public void find(String keyword, int index) {
		if( name.contains(keyword) ) {
			printIndentation(index);
			System.out.println("[FOLDER] " + name + "\t(총 크기: " + getSize() + "KB)");
		}

		for( FileSystemComponent file : fileList ) {
			file.find(keyword, index+1);
		}
	}

	@Override
	public void show(int index) {
		printIndentation(index);
		System.out.println(name + "	(총 크기: " + getSize() + "KB)");

		for( FileSystemComponent file : fileList ) {
			file.show(index + 1);
		}
	}

	@Override
	public int getSize() {
		return fileList.stream()
				.mapToInt(FileSystemComponent::getSize)
				.sum();
	}

}