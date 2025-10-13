package chatGPT.sort.Insertion;

/**
 * 삽입 정렬 - 나이 오름차순, 나이가 같으면 이름 오름차순
 */
public class MultipleSort {
	public static void main(String[] args) {
		User[] users = {
				new User("Kim", 30),
				new User("Park", 25),
				new User("Lee", 25),
				new User("Choi", 40),
				new User("Jung", 30)
		};

		for( int i=1; i < users.length; i++ ) {
			User key = users[i];
			int j = i-1;

			while(j >= 0 && compare(users[j], key) > 0) {
				users[j+1] = users[j];
				j--;
			}

			users[j+1] = key;
		}

		for( User u : users ) {
			System.out.println(u.toString());
		}
	}

	private static int compare(User a, User b) {
		if( a.getAge() != b.getAge() )
			return a.getAge() - b.getAge();

		return a.getName().compareTo(b.getName());
	}
}

class User {
	private final String name;
	private final int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return getName() + "(" + getAge() + ")";
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}