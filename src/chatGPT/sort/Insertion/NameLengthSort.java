package chatGPT.sort.Insertion;

/**
 * 삽입 정렬 - 이름 길이순 오름차순
 */
public class NameLengthSort {
	public static void main(String[] args) {
		String[] names = {"Kim", "Park", "Lee", "Choi", "Jung"};

		for( int i=1; i<names.length; i++ ) {
			String key = names[i];
			int j = i-1;

			while ( j >= 0 && names[j].length() > key.length() ) {
				names[j+1] = names[j];
				j--;
			}

			names[j+1] =  key;
		}

		for(String n : names) System.out.print(n + " ");
	}
}

