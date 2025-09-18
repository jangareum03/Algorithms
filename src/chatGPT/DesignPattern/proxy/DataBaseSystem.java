package chatGPT.DesignPattern.proxy;


/**
 * 프록시 패턴 - 데이터베이스 접근 제어
 */
public class DataBaseSystem {
	public static void main(String[] args) {
		DataSystem userData = new DatabaseProxy("기존 데이터", Role.USER);
		userData.readData();
		userData.writeData("새로운 데이터 저장");

		DataSystem adminData = new DatabaseProxy("기존 데이터", Role.ADMIN);
		adminData.readData();
		adminData.writeData("새로운 데이터 저장");
	}
}

enum Role { USER, ADMIN }

interface DataSystem {
	void readData();
	void writeData(String data);
}

class Database implements DataSystem{
	private String data;

	public Database(String data) {
		this.data = data;
	}

	public void readData() {
		System.out.println("데이터 읽기: " + data);
	}

	public void writeData(String data) {
		this.data = data;
		System.out.println("데이터 쓰기: " + data);
	}
}

class DatabaseProxy implements DataSystem {
	private Database database;
	private String data;
	private Role role;

	public DatabaseProxy(String data, Role role) {
		this.data = data;
		this.role = role;
	}

	private Database getDatabase() {
		if( database == null ) {
			database = new Database(data);
		}

		return database;
	}

	@Override
	public void readData() {
		getDatabase().readData();
	}

	@Override
	public void writeData(String data) {
		if( role == Role.USER ) {
			System.out.println("권한이 없습니다.");
			return;
		}

		getDatabase().writeData(data);
	}
}