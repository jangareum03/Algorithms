package chatGPT.DesignPattern.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 커맨트 패턴 - 초기 세팅 매크로
 */
public class MacroSystem {
	public static void main(String[] args) {
		Player player = new Player();
		List<PlayerCommand> setup = Arrays.asList(
				new WeaponCommand(player),
				new ShieldCommand(player),
				new PotionCommand(player)
		);

		MacroCommand macro = new MacroCommand(setup);
		macro.execute();
	}
}

class Player {
	public void equipWeapon() {
		System.out.println("무기를 장착했습니다.");
	}

	public void equipShield() {
		System.out.println("방패를 들었습니다.");
	}

	public void drinkPotion() {
		System.out.println("물약을 마셨습니다.");
	}
}

interface PlayerCommand {
	void execute();
}

class WeaponCommand implements PlayerCommand {
	private final Player player;

	public WeaponCommand(Player player) {
		this.player = player;
	}

	@Override
	public void execute() {
		player.equipWeapon();
	}
}

class ShieldCommand implements PlayerCommand {
	private final Player player;

	public ShieldCommand(Player player) {
		this.player = player;
	}

	@Override
	public void execute() {
		player.equipShield();
	}
}

class PotionCommand implements PlayerCommand {
	private final Player player;

	public PotionCommand(Player player) {
		this.player = player;
	}

	@Override
	public void execute() {
		player.drinkPotion();
	}
}

class MacroCommand {
	private List<PlayerCommand> commands = new ArrayList<>();

	public MacroCommand(List<PlayerCommand> commands) {
		this.commands = commands;
	}

	public void execute() {
		for( PlayerCommand command : commands ) {
			command.execute();
		}
	}
}