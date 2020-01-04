
/**
 * 
 */
package PugBotGradle3;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
/**
 * @author OtakuPug
 *
 */
public class profile extends Command{

	/**
	 * 
	 */
	public profile() {
		this.name = "profile";
		this.aliases = new String[]{"p"};
	}

	@Override
	protected void execute(CommandEvent e) {
	String textFromMethod;
	MessageChannel channel = e.getChannel();
	ArrayList<String> profInfo = new ArrayList<String>();
	try {
		profInfo.addAll(UserInfo(e.getAuthor().getId()));
		EmbedBuilder profiles = new EmbedBuilder();
		 String author = e.getAuthor().getAsMention();
		 	profiles.setDescription("Nickname: " + author + "\n" + profInfo.get(1) + "\n"  + profInfo.get(0) + "\n" + profInfo.get(2) + "\n" + profInfo.get(3));
		 	profiles.setColor(Color.green);
		 	profiles.setThumbnail(e.getAuthor().getAvatarUrl());
		 	channel.sendMessage(profiles.build()).queue();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}

	}
	
	public static ArrayList<String> UserInfo(String userIdInput) throws IOException {
		int counter = 0;
		int counter2 = 0;
		int sentinel = 1;
		String name;
		String ID;
		String money;
		String fil;
		ArrayList<String> Infos = new ArrayList<String>();
		 File users = new File("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt");
		 Scanner fileinput = new Scanner(users);
		    FileReader filereader = new FileReader(users);
		    LineNumberReader numreader = new LineNumberReader(filereader);
		    
		while(fileinput.hasNextLine()) {
		fil = fileinput.nextLine();
		counter++;
		//System.out.println("c: " + counter);
		//Infos.add(fil);
		if(fil.equals("Account ID: " + userIdInput)) {
			counter2 = counter;
			//System.out.println("c2: " + counter2);
			}
		}
		Infos.add((String) FileUtils.readLines(users).get((counter2-1)));
		Infos.add((String) FileUtils.readLines(users).get((counter2)));
		Infos.add((String) FileUtils.readLines(users).get((counter2+1)));
		Infos.add((String) FileUtils.readLines(users).get((counter2+2)));
		System.out.println(Infos);
		
	return Infos;
	}

}
