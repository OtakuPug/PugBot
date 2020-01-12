/**
 * 
 */
package PugBotGradle3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.examples.command.PingCommand;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

/**
 * @author OtakuPug
 *
 */
public class BotPug {

	/**
	 * @param args
	 * @throws LoginException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws LoginException, IOException {
		String token;
		String ownerId;
		EventWaiter waiter;
		CommandClientBuilder client;
		
		List<String> list = Files.readAllLines(Paths.get("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Info.txt"));
		token = list.get(0);
		ownerId = list.get(1);
		client = new CommandClientBuilder();
		waiter = new EventWaiter();
		
		client.setOwnerId(ownerId);
		client.setEmojis("\u2713", "\uD83D\uDE2E", "\uD83D\uDE26");
		client.setPrefix("m");
		  client.addCommands(new PingCommand(), new nagaping(), new adduser(), new profile(), new Work(), new buyMordred(), new getMessage(), new Inventory());
		  
	
	        new JDABuilder(AccountType.BOT)
	                .setToken(token)
	                .setStatus(OnlineStatus.DO_NOT_DISTURB)
	                .setActivity(Activity.playing("running in" + "servers!"))
	                .addEventListeners(waiter, client.build())
	                .build();
		

	}

}
