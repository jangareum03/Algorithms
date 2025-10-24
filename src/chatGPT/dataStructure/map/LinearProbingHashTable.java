package chatGPT.dataStructure.map;

/**
 * 해시 테이블 - 충돌 처리(선형 탐색)
 */
public class LinearProbingHashTable {
	private int[] keys;
	private int[] values;
	private int capacity;

	public LinearProbingHashTable(int capacity) {
		this.capacity = capacity;

		keys = new int[capacity];
		values = new int[capacity];
		for( int i=0; i<capacity; i++ ) keys[i] = -1;
	}

	public void put( int key, int value ) {
		int index = Math.abs(key) % capacity;

		while ( keys[index] != -1 && keys[index] != key ) {
			index = (index+1) % capacity;
		}

		keys[index] = key;
		values[index] = value;
	}

	public Integer get(int key) {
		int index = Math.abs(key) % capacity;

		while ( keys[index] != -1 ) {
			if( keys[index] == key ) return values[index];

			index = (index+1) % capacity;
		}

		return null;
	}

	public static void main(String[] args) {
		LinearProbingHashTable hashTable = new LinearProbingHashTable(5);

		hashTable.put(1, 100);
		hashTable.put(6, 200);

		System.out.println(hashTable.get(6));
	}
}
