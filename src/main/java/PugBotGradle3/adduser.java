package PugBotGradle3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.commons.io.FileUtils;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * 
 */



/**
 * @author OtakuPug
 *
 */
public class adduser extends Command {

	/**
	 * 
	 */
	public adduser() {
		this.name = "adduser";
		this.aliases = new String[]{"add", "create"};
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void execute(CommandEvent e) {
		
		File users = new File("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt");
		File Inventory = new File("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Inventory.txt");
		String userID = e.getMember().getId();
		FileOutputStream fout = null;
		
		File Inventories = new File("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Inventory.txt");
		FileOutputStream fileoutput = null;
		try {
			fout = new FileOutputStream("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt", true);
			fileoutput = new FileOutputStream("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Inventory.txt", true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    	  PrintStream out = new PrintStream(fout);
	    	  PrintStream out2 = new PrintStream(fileoutput);
	    	  MessageChannel channel = e.getChannel();
		try {
			if((FileUtils.readFileToString(users).contains((e.getAuthor().getId())))) {
				 e.reply("you already have an account!");
			
			} else {
				 out.append("Account ID: " + userID + "\n" + "Name: " + e.getAuthor().getName() + "\n" + "Hentai Quartz: " + "0" + "\n");
				 out2.append("Account ID: " + userID + "\n" + "Mordred 1 1 0 25 Sword Saber" + "\n");
				 channel.sendMessage("user added").addFile(users).addFile(Inventory).queue();
			 }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		

}
