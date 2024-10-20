package me.recior.grimoire.message;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;

public class Cmd {

	public User author;
	public MessageChannelUnion channel;
	public Message message;
	public String content;
	public String Args[];
	public String Name;
	public Member MessageMember;
	
	public Cmd(String name, Message msg, String[] args) {
		Name = name;
		author = msg.getAuthor();
		channel = msg.getChannel();
		content = msg.getContentRaw();
		message = msg;
		MessageMember = msg.getMember();
	}
	
}
