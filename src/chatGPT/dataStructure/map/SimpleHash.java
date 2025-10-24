package chatGPT.dataStructure.map;

/**
 * 해시 테이블 - 해시함수 설계
 */
public class SimpleHash {
	private int capacity;	//배열크기

	public SimpleHash(int capacity) {
		this.capacity = capacity;
	}

	public int getIndex(int key) {
		return Math.abs(key) % capacity;
	}

	public static void main(String[] args) {
		SimpleHash hash = new SimpleHash(10);
		System.out.println(hash.getIndex(15));
		System.out.println(hash.getIndex(-7));
	}
}