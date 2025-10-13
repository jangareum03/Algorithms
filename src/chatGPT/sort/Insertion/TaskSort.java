package chatGPT.sort.Insertion;

/**
 * 삽입 정렬 - 작업의 우선순위 내림차순
 */
public class TaskSort {
	public static void main(String[] args) {
		Task[] tasks = {
				new Task("Email", 3),
				new Task("Deploy", 5),
				new Task("Build", 2),
				new Task("Test", 4)
		};

		for( int i = 1; i<tasks.length; i++ ) {
			Task key = tasks[i];
			int j = i-1;

			while ( j >= 0 && tasks[j].priority < key.priority ) {
				tasks[j+1] = tasks[j];
				j--;
			}

			tasks[j + 1] = key;
		}

		for( Task t : tasks ) {
			System.out.println(t.name + "(" + t.priority + ")");
		}
	}
}

class Task {
	String name;
	int priority;

	public Task(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
}