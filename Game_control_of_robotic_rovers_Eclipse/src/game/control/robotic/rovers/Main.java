package game.control.robotic.rovers;

import java.util.Scanner;

public class Main {

	PromptPrinterConfig promptConfig = new PromptPrinterConfig();
	PromptPrinter promptPrinter = new PromptPrinter();

	PromptCommandConfig promptCommandConfig = new PromptCommandConfig();
	PromptCommandHelper promptCommandHelpter = new PromptCommandHelper();

	ControlRobotTurnGame game = new ControlRobotTurnGame();

	public void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			for (;;) {
				this.promptPrinter.print(this.promptConfig.COMMAND_LINE_PROMPT);
				String commandLine = scanner.nextLine();
				PromptCommand promptCommand = new PromptCommand(commandLine, this.promptCommandHelpter,
						this.promptCommandConfig);
				this.game.runCommand(promptCommand, this.promptPrinter);
			}
		}
	}

	public static void main(String[] args) {

		Main main = new Main();
		main.run();

	}

}