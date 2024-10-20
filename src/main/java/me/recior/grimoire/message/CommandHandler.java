package me.recior.grimoire.message;

import java.util.HashMap;

import me.recior.grimoire.message.commands.Info;
import me.recior.grimoire.message.commands.telephone.Hangup;
import me.recior.grimoire.message.commands.telephone.Telephone;

public class CommandHandler {

	private static final HashMap<String, Command> commands = new HashMap<>();

	static {
		commands.put("info", new Info());
		commands.put("telephone", new Telephone());
		commands.put("hangup", new Hangup());
	}

	public static void execute(Cmd command) {
		Command cmd = commands.get(command.Name);
		if (cmd != null) {
			cmd.executeCommand(command);
		}
	}
}
