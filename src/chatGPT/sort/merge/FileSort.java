package chatGPT.sort.merge;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 병합 정렬 - 파일 데이터 정렬
 */
public class FileSort {
	public static void main(String[] args) {
		List<Employee> list = readCSV("src/chatGPT/sort/merge/employees.csv");

		Employee[] sorted = mergeSortEmployees(list.toArray(new Employee[0]));
		writeCSV("src/chatGPT/sort/merge/sorted_employees.csv", sorted);
	}

	private static Employee[] mergeSortEmployees(Employee[] employees) {
		if(employees.length <= 1) return employees;

		int mid = employees.length / 2;
		Employee[] left = Arrays.copyOfRange( employees, 0, mid );
		Employee[] right = Arrays.copyOfRange(employees , mid, employees.length);

		left = mergeSortEmployees(left);
		right = mergeSortEmployees(right);

		return merge(left, right);
	}

	private static Employee[] merge(Employee[] left, Employee[] right) {
		Employee[] merge = new Employee[left.length + right.length];

		int m = 0, l = 0, r = 0;
		while ( l < left.length && r < right.length ) {
			if( left[l].getSalary() < right[r].getSalary() ||
					(left[l].getSalary() == right[r].getSalary() && left[l].getName().compareTo(right[r].getName()) <= 0)) {
				merge[m++] = left[l++];
			}else {
				merge[m++] = right[r++];
			}
		}

		while ( l < left.length ) {
			merge[m++] = left[l++];
		}

		while ( r < right.length ) {
			merge[m++] = right[r++];
		}

		return merge;
	}

	private static List<Employee> readCSV(String file) {
		List<Employee> result = new ArrayList<>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line;

			br.readLine();

			while ( (line = br.readLine()) != null ) {
				String[] words = line.split(",");

				Long id = Long.parseLong(words[0]);
				String name = words[1];
				int salary = Integer.parseInt(words[2]);

				result.add(new Employee(id, name, salary));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	private static void writeCSV(String file, Employee[] employees) {
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			writer.write("id,name,salary");
			writer.newLine();

			for( Employee e : employees ) {
				String id = String.valueOf(e.getId());
				String name = e.getName();
				String salary = String.valueOf(e.getSalary());

				writer.write( String.join(",", id, name, salary ));
				writer.newLine();
			}

			writer.close();	//파일 닫기
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		System.out.println("파일 생성 완료");
	}
}

class Employee {
	private final long id;
	private final String name;
	private final int salary;

	public Employee(Long id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + salary;
	}
}