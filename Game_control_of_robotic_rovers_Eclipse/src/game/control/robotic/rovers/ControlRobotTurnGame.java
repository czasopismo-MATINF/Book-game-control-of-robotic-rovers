package game.control.robotic.rovers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlRobotTurnGame {

	public class CommandMethodNotFoundException extends Exception {
	}

	@PromptCommandAnnotation
	public void testCommand(PromptCommand command, PromptPrinter printer) {
		printer.println("Test Command run.");
		printer.println(command.arguments);
	}

	public void runCommand(PromptCommand command, PromptPrinter printer) {
		try {

			Method m = this.getClass().getMethod(command.camelCasedKeyWords, PromptCommand.class);
			if (m != null && m.isAnnotationPresent(PromptCommandAnnotation.class)) {
				m.invoke(this, command);
			} else {
				throw new CommandMethodNotFoundException();
			}

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CommandMethodNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

}
