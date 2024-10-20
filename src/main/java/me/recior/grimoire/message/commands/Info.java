package me.recior.grimoire.message.commands;

import me.recior.grimoire.message.Cmd;
import me.recior.grimoire.message.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;

public class Info extends Command {

	public Info() {
		super("info");
	}

	@Override
	public void executeCommand(Cmd command) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("Info");
		embed.appendDescription("Grimoire bot v1.0");
		embed.setImage(command.MessageMember.getJDA().getUserById("1297181091190276146").getAvatarUrl());
		embed.setFooter("Grimoire by Xecior");

		command.channel.sendMessageEmbeds(embed.build()).queue();

	}
}
