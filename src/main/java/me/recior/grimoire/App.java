package me.recior.grimoire;

import me.recior.grimoire.listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;

/**
 * Hello world!
 *
 */
public class App implements EventListener {
	
    public static void main(String[] args) throws InterruptedException
    {
//    	InputStream inputStream = App.class.getClassLoader().getResourceAsStream("token.txt");
//        try (Scanner scanner = new Scanner(inputStream)) {
//			while (scanner.hasNextLine()) {
//			    System.out.println(scanner.nextLine());
//			}
//		}
        JDA jda = JDABuilder.createDefault(args[0], GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
            .addEventListeners(new App())
            .addEventListeners(new MessageListener())
            .build();

        jda.awaitReady();
        
    }

    @Override
    public void onEvent(GenericEvent event)
    {
        if (event instanceof ReadyEvent)
            System.out.println("API is ready!");
    }
}