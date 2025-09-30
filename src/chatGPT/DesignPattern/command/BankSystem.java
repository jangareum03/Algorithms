package chatGPT.DesignPattern.command;

import java.util.Stack;

/**
 * 커맨드 패턴 - 은행 트랜잭션 시스템
 */
public class BankSystem {
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		TransactionManager manager = new TransactionManager();

		manager.executeCommand(new DepositCommand(account, 1000));

		manager.executeCommand(new WithdrawCommand(account, 300));

		manager.undoLastCommand();

	}
}

class BankAccount {
	private long balance;

	public void deposit(int amount) {
		if(amount <= 0) return;

		balance += amount;
		System.out.printf("계좌에 %d원 입금했습니다. (현재 잔액: %d)%n", amount, balance);
	}

	public void withdraw(int amount) {
		if(amount <= 0) return;
		if( amount > balance ) {
			System.out.println("잔액 부족으로 출금이 실패했습니다. (금액: " + amount + ")");
			return;
		};

		balance -= amount;
		System.out.printf("계좌에 %d원 출금했습니다. (현재 잔액: %d)%n", amount, balance);
	}

	public long getBalance() {
		return balance;
	}
}

interface BankCommand {
	void execute();
	void undo();
}

class DepositCommand implements BankCommand {
	private final BankAccount account;
	private final int amount;

	public DepositCommand(BankAccount account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void execute() {
		account.deposit(amount);
	}

	@Override
	public void undo() {
		account.withdraw(amount);
		System.out.println("입금 명령 취소: " + account +"원 출금");
	}
}

class WithdrawCommand implements BankCommand {
	private final BankAccount account;
	private final int amount;
	private boolean isSuccess;

	public WithdrawCommand(BankAccount account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void execute() {
		if( account.getBalance() < amount ) {
			isSuccess = false;
			System.out.println("잔액 부족으로 출금이 실패했습니다. (금액: " + amount + ")");
		}else {
			isSuccess = true;
			account.withdraw(amount);
		}
	}

	@Override
	public void undo() {
		if(isSuccess) {
			account.deposit(amount);
			System.out.println("출금 명령 취소: " + amount + "원 입금");
		}
	}
}

class TransactionManager {
	private final Stack<BankCommand> commands = new Stack<>();

	public void executeCommand(BankCommand command) {
		command.execute();
		commands.push(command);
	}

	public void undoLastCommand() {
		if( !commands.isEmpty() ) {
			BankCommand command = commands.pop();
			command.undo();
		}else {
			System.out.println("되돌릴 수 있는 명령이 없습니다.");
		}
	}
}