
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
import net.dv8tion.jda.api.entities.Message;
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
	MessageChannel channel = e.getChannel();
	Message msg = e.getMessage();
	ArrayList<String> profInfo = new ArrayList<String>();
	String getId;
	try {
		profInfo.addAll(UserInfo(e.getAuthor().getId(), msg));
		System.out.println("profInfo" + profInfo);
		EmbedBuilder profiles = new EmbedBuilder();
		getId = profInfo.get(4);
		System.out.println(getId);
		
		String author = e.getJDA().getUserById(getId).getAsMention();
		 	profiles.setDescription( "Mention: " + author + "\n" + profInfo.get(1) + "\n"  + profInfo.get(0) + "\n" + profInfo.get(2));
		 	profiles.setColor(Color.green);
		    profiles.setThumbnail(e.getJDA().getUserById(getId).getAvatarUrl());
		 	channel.sendMessage(profiles.build()).queue();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}

	}
	
	public static ArrayList<String> UserInfo(String userIdInput, Message msg2) throws IOException {
		String Message = msg2.getContentRaw();
			
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
			    
		if(Message.startsWith("mprofile") && Message.length() > 8 || Message.startsWith("mp") && Message.length() > 2) {
			System.out.println("1: " + Message);
			int index1 = (Message.indexOf("<")+3);
			System.out.println("2: " + index1);
			int index2 = (Message.indexOf(">"));
			System.out.println("3: " + index2);
			userIdInput = Message.substring(index1, index2);
			System.out.println("4: " + userIdInput);

			while(fileinput.hasNextLine()) {
				System.out.println("5: ");
			fil = fileinput.nextLine();
			System.out.println("6: ");
			counter++;
			System.out.println("7: ");
			if(fil.equals("Account ID: " + userIdInput)) {
				System.out.println("8: ");
				counter2 = counter;
				System.out.println("9: ");
				}
			System.out.println("10: ");
			}
			System.out.println("11: ");
			Infos.add((String) FileUtils.readLines(users).get((counter2-1)));
			System.out.println("12: ");
			Infos.add((String) FileUtils.readLines(users).get((counter2)));
			System.out.println("13: ");
			Infos.add((String) FileUtils.readLines(users).get((counter2+1)));
			System.out.println("14: ");
			//Infos.add((String) FileUtils.readLines(users).get((counter2+2)));
			System.out.println("15: ");
			Infos.add(userIdInput);
			System.out.println("16: ");
			System.out.println(Infos);
			System.out.println("17: ");
			
		return Infos;		
		} else {
			//System.out.println("1");
		while(fileinput.hasNextLine()) {
			//System.out.println("2");
		fil = fileinput.nextLine();
		//System.out.println("3");
		counter++;
		//System.out.println("4");
		//System.out.println("c: " + counter);
		//Infos.add(fil);
		if(fil.equals("Account ID: " + userIdInput)) {
			//System.out.println("5");
			counter2 = counter;
			//System.out.println("6");
			//System.out.println("c2: " + counter2);
			//System.out.println("7");
			}
	//	System.out.println("8");
		}
		System.out.println("9");
		Infos.add((String) FileUtils.readLines(users).get((counter2-1)));
		System.out.println("10");
		Infos.add((String) FileUtils.readLines(users).get((counter2)));
		System.out.println("11");
		Infos.add((String) FileUtils.readLines(users).get((counter2+1)));
		Infos.add("extra");
		System.out.println("12");
		Infos.add(userIdInput);
		System.out.println("13");
		System.out.println(Infos);
		System.out.println("14");
	return Infos;
		}
		
	}

}
