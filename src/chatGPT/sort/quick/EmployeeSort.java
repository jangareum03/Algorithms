package chatGPT.sort.quick;

/**
 * 퀵 정렬 - 사원 정렬
 * <p>
 *     1. 부서 이름 오름차순 <br>
 *     2. 부서가 같으면 급여 내림차순 <br>
 *     3. 급여까지 같으면 이름 오름차순
 * </p>
 */
public class EmployeeSort {
	public static void main(String[] args) {
		Employee[] employees = {
				new Employee("Alice", "HR", 3500),
				new Employee("Bob", "Finance", 5000),
				new Employee("Charlie", "HR", 4200),
				new Employee("Dave", "Finance", 5000),
				new Employee("Eve", "IT", 4700)
		};

		quickSort( employees, 0, employees.length -1 );
		for( Employee e : employees ) System.out.println(e.toString());
	}

	private static void quickSort(Employee[] arr, int start, int end) {
		if( start >= end ) return; //배열길이가 1이면 종료

		int mark = partition(arr, start, end);
		quickSort( arr, start, mark - 1 );
		quickSort( arr, mark + 1, end );
	}

	private static int partition(Employee[] arr, int start, int end) {
		Employee pivot = arr[start];	//배열의 첫번째 값을 피벗으로

		int left = start - 1;		//피벗의 왼쪽 인덱스
		int right = end + 1;	//피벗의 오른쪽 인덱스

		while ( true ){
			do {
				left ++;
			}while (
				compareEmployee(arr[left], pivot) < 0
			);

			do {
				right --;
			}while (
					compareEmployee(arr[right], pivot) > 0
			);

			if( left >= right ) return right;

			Employee temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
	}

	private static int compareEmployee(Employee e1, Employee e2) {
		int deptCompare = e1.getDepartment().compareTo(e2.getDepartment());
		if (deptCompare != 0) return deptCompare;

		int salaryCompare = Integer.compare(e2.getSalary(), e1.getSalary());
		if (salaryCompare != 0) return salaryCompare;

		return e1.getName().compareTo(e2.getName());
	}
}

class Employee {
	private final String name;
	private final String department;
	private final int salary;

	public Employee(String name, String department, int salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.join("-", name, department, String.valueOf(salary));
	}

	public String getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}
}