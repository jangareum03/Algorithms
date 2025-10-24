package chatGPT.dataStructure.map;

/**
 * 해시 테이블 - 배열 기반 구현
 */
public class IntHashTable {
	private int[] table;

	public IntHashTable(int size) {
		table = new int[size];
	}

	public void put(int key, int value) {
		int index = Math.abs(key) % table.length;

		table[index] = value;
	}

	public int get(int key) {
		int index = Math.abs(key) % table.length;

		return table[index];
	}

	public static void main(String[] args) {
		IntHashTable hashTable = new IntHashTable(10);

		hashTable.put(1, 100);			//인덱스 1에 100저장
		hashTable.put(11, 200);			//인덱스 1에 200저장

		System.out.println(hashTable.get(1));
	}
}
