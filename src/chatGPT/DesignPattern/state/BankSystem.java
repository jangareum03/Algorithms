package chatGPT.DesignPattern.state;

/**
 * 상태 패턴 - 은행 계좌 상태
 */
public class BankSystem {
	public static void main(String[] args) {
		Account account = new Account(1000);

		account.withdraw(900);
		account.withdraw(200);
		account.deposit(500);
		account.withdraw(600);
		account.deposit(100);
	}
}

class Account {
	private AccountState state;
	private long balance;

	public Account(long balance) {
		this.state = new Normal();
		this.balance = balance;
	}

	public void setState(AccountState state) {
		this.state = state;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public long getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		state.withdraw(this, amount);
	}

	public void deposit(int amount) {
		state.deposit(this, amount);
	}
}

interface AccountState {
	void withdraw(Account account, int amount);
	void deposit(Account account, int amount);
}

class Normal implements AccountState {
	@Override
	public void withdraw(Account account, int amount) {
		long newBalance = account.getBalance() - amount;

		if( newBalance < 0 ) {
			System.out.println("잔액 부족으로 입금/출금이 제한된 상태로 변경됩니다. (상태: 정상 -> 제한)");
			account.setState(new Overdrawn());

			return;
		}

		account.setBalance(newBalance);
		System.out.printf("계좌에서 %d원이 출금이 되었습니다. (잔액: %d)%n", amount, newBalance);
	}

	@Override
	public void deposit(Account account, int amount) {
		long newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);

		System.out.printf("계좌에서 %d원이 입금이 되었습니다. (잔액: %d)%n", amount, account.getBalance());
	}
}

class Overdrawn implements AccountState {
	@Override
	public void withdraw(Account account, int amount) {
		System.out.println("계좌가 제한 상태이므로 출금이 불가능합니다.");
	}

	@Override
	public void deposit(Account account, int amount) {
		 long newBalance = account.getBalance() + amount;
		 account.setBalance(newBalance);

		System.out.printf("계좌에서 %d원이 입금이 되었습니다. (잔액: %d)%n", amount, account.getBalance());

		account.setState(new Normal());
	}
}

class Frozen implements AccountState {
	@Override
	public void withdraw(Account account, int amount) {
		System.out.println("계좌가 정지 상태이므로 입금이 불가능합니다.");
	}

	@Override
	public void deposit(Account account, int amount) {
		System.out.println("계좌가 정지 상태이므로 출금이 불가능합니다.");
	}
}