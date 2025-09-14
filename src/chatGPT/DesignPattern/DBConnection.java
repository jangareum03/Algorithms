package chatGPT.DesignPattern;

/**
 * 추상 팩토리 문제 - 데이터베이스 연결
 */
public class DBConnection {
	public static void main(String[] args) {
		DatabaseFactory factory = DatabaseProvider.getDatabase("mysql");

		if(factory == null) {
			System.out.println("알 수 없는 데이터베이스입니다.");
			return;
		}

		Connection connection = factory.getConnection();
		connection.connect();

		Command command = factory.getCommand();
		command.execute("SELECT * FROM users");
	}
}

interface Connection {
	void connect();
}

class MySqlConnection implements Connection {
	@Override
	public void connect() {
		System.out.println("MySQL 연결 성공");
	}
}

class OracleConnection implements Connection {
	@Override
	public void connect() {
		System.out.println("Oracle DB 연결 성공");
	}
}

interface Command {
	void execute(String query);
}

class MySqlCommand implements Command {
	@Override
	public void execute(String query) {
		System.out.println("MySQL 쿼리 실행 : " + query);
	}
}

class OracleCommand implements Command {
	@Override
	public void execute(String query) {
		System.out.println("Oracle 쿼리 실행 : " + query);
	}
}


interface DatabaseFactory {
	Connection getConnection();
	Command getCommand();
}

class MySqlFactory implements DatabaseFactory {
	@Override
	public Connection getConnection() {
		return new MySqlConnection();
	}

	@Override
	public Command getCommand() {
		return new MySqlCommand();
	}
}

class OracleFactory implements DatabaseFactory {
	@Override
	public Command getCommand() {
		return new OracleCommand();
	}

	@Override
	public Connection getConnection() {
		return new OracleConnection();
	}
}

class DatabaseProvider {
	public static DatabaseFactory getDatabase(String db) {
		if( db.equalsIgnoreCase("mysql") ) {
			return new MySqlFactory();
		}else if( db.equalsIgnoreCase("oracle") ) {
			return new OracleFactory();
		}else {
			return null;
		}
	}
}