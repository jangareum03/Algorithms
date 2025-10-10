package chatGPT.DesignPattern.visitor;

/**
 * 비지터 패턴 - 회계 방문자
 */
public class Accounting {
	public static void main(String[] args) {
		Department[] deps = { new HR(), new Sales() };
		SalaryVisitor visitor = new SalaryVisitor();

		for (Department d : deps) d.accept(visitor);
		System.out.println("Total Salary: " + visitor.getTotal());
	}
}

interface Department {
	void accept(DepartmentVisitor visitor);
	int getSalary();
}

class HR implements Department {
	private int salary = 3000;

	@Override
	public void accept(DepartmentVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public int getSalary() {
		return salary;
	}
}

class Sales implements Department {
	private int salary = 5000;

	@Override
	public void accept(DepartmentVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public int getSalary() {
		return salary;
	}
}

interface DepartmentVisitor {
	void visit(HR hr);
	void visit(Sales sales);
}

class SalaryVisitor implements DepartmentVisitor {
	private int total = 0;

	@Override
	public void visit(HR hr) {
		total += hr.getSalary();
	}

	@Override
	public void visit(Sales sales) {
		total += sales.getSalary();
	}

	public int getTotal() {
		return total;
	}
}
