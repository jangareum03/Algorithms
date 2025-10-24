package chatGPT.dataStructure.map;

import java.util.HashMap;
import java.util.Map;
/**
 * 맵 - 직원 및 부서 관리
 */
public class EmployeeDepartment {
	static Map<String, String> employee = new HashMap<>();

	public static void main(String[] args) {
		add("홍길동", "인사팀");
		add("김철수", "개발팀");
		add("이영희", "마케팅팀");

		String name = "김철수";
		System.out.println(name +"의 부서: " + getDepartment(name));

		removeEmployee("이영희");

		printAllEmployee();
	}

	private static void add(String name, String department) {
		employee.put(name, department);
	}

	private static String getDepartment(String name) {
		return employee.get(name);
	}

	private static void removeEmployee(String name) {
		if( employee.containsKey(name) ) {
			employee.remove(name);
			return;
		}

		System.out.println("직원이 존재하지 않습니다.");
	}

	private static void printAllEmployee() {
		for(String key : employee.keySet() ) {
			System.out.println(key + " - " + getDepartment(key));
		}
	}
 }
