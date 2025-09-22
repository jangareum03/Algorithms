package chatGPT.DesignPattern.facade;


/**
 * 퍼사드 패턴 - 컴퓨터 부팅 과정
 */
public class ComputerBooting {
	public static void main(String[] args) {
		ComputerFacade computerFacade = new ComputerFacade();
		computerFacade.startComputer();
	}
}

class ComputerFacade {
	private final CPU cpu = new CPU();
	private final Memory memory = new Memory();
	private final HardDisk disk = new HardDisk();
	private final OS os = new OS();

	public void startComputer() {
		cpu.start();
		memory.start();
		disk.start();
		os.start();
	}
}

class CPU {
	public void start() {
		System.out.println("CPU 초기화");
	}
}

class Memory {
	public void start() {
		System.out.println("메모리 초기화");
	}
}

class HardDisk {
	public void start() {
		System.out.println("하드디스크 초기화");
	}
}

class OS {
	public void start() {
		System.out.println("OS 부팅 완료");
	}
}