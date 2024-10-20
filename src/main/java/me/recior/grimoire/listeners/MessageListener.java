package me.recior.grimoire.listeners;

import me.recior.grimoire.message.Cmd;
import me.recior.grimoire.message.CommandHandler;
import me.recior.grimoire.message.commands.telephone.TelephoneManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

	@Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
		if(event.getAuthor().isBot()) {
			return;
		}
		
		if(!event.getMessage().getContentRaw().startsWith(".")) {
			if(!TelephoneManager.ifIncluded(event.getChannel())) {
				return;
			}
			TelephoneManager.sendMessage(event.getMessage());
			return;
		}
		
		String Message = event.getMessage().getContentDisplay();
		String[] MessageArguments = Message.split("\\s+");
		String commandName = MessageArguments[0].toLowerCase().substring(1);
		CommandHandler.execute(new Cmd(commandName, event.getMessage(), MessageArguments));
    }
	
}
