package me.recior.grimoire.message.commands.telephone;

import me.recior.grimoire.message.Cmd;
import me.recior.grimoire.message.Command;

public class Telephone extends Command {

	public Telephone() {
		super("telephone");
	}
	
	@Override
	public void executeCommand(Cmd command) {
		command.channel.sendMessage("**Calling someone on the telephone...**").queue();
		TelephoneManager.addToPool(command.channel);
	}

}
