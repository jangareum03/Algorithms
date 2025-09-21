package chatGPT.DesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 컴포지트 패턴 - 회사 조직도
 */
public class Organization {
	public static void main(String[] args) {
		Employee development = new Team("개발팀");
		development.add(new Staff("김철수", "개발자"));
		development.add(new Staff("이영희", "개발자"));

		Employee frontEnd = new Team("프론트엔드팀");
		frontEnd.add(new Staff("박민수","프론트엔드 개발자"));
		frontEnd.add(new Staff("최지현","프론트엔드 개발자"));

		development.add(frontEnd);
		development.showHierarchy(0);
	}
}

interface Employee {
	default void add(Employee employee) {
		throw new UnsupportedOperationException("Staff는 add를 지원하지 않습니다.");
	}

	void showHierarchy(int index);
}

class Staff implements Employee {
	private final String name;
	private final String job;

	public Staff(String name, String job) {
		this.name = name;
		this.job = job;
	}

	@Override
	public void showHierarchy(int index) {
		printHierarchy(index);
		System.out.printf("%s (%s)%n", name, job);
	}

	private void printHierarchy(int index) {
		System.out.print("\t".repeat(index));
	}
}

class Team implements Employee {
	private final String name;
	private List<Employee> teams = new ArrayList<>();

	public Team(String name) {
		this.name = name;
	}

	@Override
	public void add(Employee employee) {
		teams.add(employee);
	}

	@Override
	public void showHierarchy(int index) {
		printHierarchy(index);
		System.out.println(name);

		for(Employee e : teams) {
			e.showHierarchy(index + 1);
		}
	}

	private void printHierarchy(int index) {
		System.out.print("\t".repeat(index));
	}
}