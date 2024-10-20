package me.recior.grimoire.message.commands.telephone;

import me.recior.grimoire.message.Cmd;
import me.recior.grimoire.message.Command;

public class Hangup extends Command {

	public Hangup() {
		super("hangup");
	}
	
	@Override
	public void executeCommand(Cmd command) {
		if(!TelephoneManager.ifIncluded(command.channel)) {
			command.channel.sendMessage("**You aren't connected to any call!**");
			return;
		}
		TelephoneManager.hangup(command.channel);
	}

}
