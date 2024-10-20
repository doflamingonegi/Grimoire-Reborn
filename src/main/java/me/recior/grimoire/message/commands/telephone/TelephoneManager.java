package me.recior.grimoire.message.commands.telephone;

import java.util.HashMap;
import java.util.LinkedList;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;

public class TelephoneManager {

    private static LinkedList<MessageChannelUnion> WAIT_POOL = new LinkedList<>();
    private static HashMap<MessageChannelUnion, MessageChannelUnion> CHANNEL_PAIRS = new HashMap<>();
    
    public static void addToPool(MessageChannelUnion channel) {
        WAIT_POOL.add(channel);
        channel.sendMessage("**Added to waiting pool....**").queue();
        pairChannel(channel);
    }
    
    public static boolean ifIncluded(MessageChannelUnion channel) {
    	return CHANNEL_PAIRS.containsKey(channel);
    }

    private static void pairChannel(MessageChannelUnion channel) {
        if (WAIT_POOL.size() < 2) {
        	System.out.println("1st true");
            return;
        }
        if(WAIT_POOL.getFirst() == channel) {
        	System.out.println("2st true");
        	return;
        }
        System.out.println("Found one");
        MessageChannelUnion previousChannel = WAIT_POOL.get(WAIT_POOL.size() - 2);

        CHANNEL_PAIRS.put(channel, previousChannel);
        CHANNEL_PAIRS.put(previousChannel, channel);
        
        WAIT_POOL.remove(channel);
        WAIT_POOL.remove(previousChannel);
        
        channel.sendMessage("**Successfully connected!**").queue();
        previousChannel.sendMessage("**Successfully connected!**").queue();
    }
    
    public static void hangup(MessageChannelUnion channel) {
    	 MessageChannelUnion otherChannel = CHANNEL_PAIRS.get(channel);
    	 channel.sendMessage("**You hung up the call.**").queue();
    	 otherChannel.sendMessage("**The other side hung up the call.**").queue();
    	 CHANNEL_PAIRS.remove(channel);
    	 CHANNEL_PAIRS.remove(otherChannel);
    }
    
    public static void sendMessage(Message message) {
    	CHANNEL_PAIRS.get(message.getChannel()).sendMessage("**"+ message.getMember().getUser().getName() +":** " + message.getContentDisplay()).queue();
    }
	
}
