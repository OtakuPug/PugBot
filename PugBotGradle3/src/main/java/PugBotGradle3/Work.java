/**
 * 
 */
package PugBotGradle3;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.entities.MessageChannel;
/**
 * @author OtakuPug
 *
 */
public class Work extends Command{

	/**
	 * 
	 */
	public Work() {
		this.name = "work";
		this.help = "get 25-50 hquartz";
	}

	@Override
	protected void execute(CommandEvent e) {
		MessageChannel channel = e.getChannel();
		try {
			channel.sendMessage(addhq(e.getAuthor().getId())).queue();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public static String addhq(String userIdInput) throws IOException {
		
	
		int counter = 0;
		int counter2 = 0;
		int sentinel = 1;
		Random rand = new Random();
		int amountToBeAdded;
		int oldAmount;
		int newAmount;
		String name;
		String ID;
		String money;
		String fil;
		
		int indexOld;
		ArrayList<String> Infos = new ArrayList<String>();
		 File users = new File("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt");
		 Scanner fileinput = new Scanner(users);
		    FileReader filereader = new FileReader(users);
		    LineNumberReader numreader = new LineNumberReader(filereader);
		    FileOutputStream fout = new FileOutputStream("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt", true);
	    	  PrintStream out = new PrintStream(fout);
		while(fileinput.hasNextLine()) {
		fil = fileinput.nextLine();
		counter++;
		Infos.add(fil);
		}
		
		for(int index2 = 0; index2 < Infos.size(); index2++) {
			if(Infos.get(index2).equals("Account ID: " + userIdInput)) {
				counter2 = index2;
			}
		}
		
		
		amountToBeAdded = rand.nextInt((50-25)+1)+25;
		indexOld = Infos.get((counter2+2)).length();
		oldAmount = Integer.valueOf(Infos.get((counter2+2)).substring(15, indexOld));
		newAmount = oldAmount + amountToBeAdded;
		Infos.set((counter2+2), "hentai quartz: " + newAmount);
		
		/* for (int i = 0; i < Infos.size(); i++) {
		    if (Infos.get(i).equals(Infos.get((counter2+2)))) {
		        Infos.set(i, "hentai quartz: " + newAmount);
		        
		    }
		} */
		
		for(int i = 0; i < Infos.size(); i++) {
			
			if(i == 0) {
				FileChannel.open(Paths.get("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt"), StandardOpenOption.WRITE).truncate(0).close();
				
			}
			
			out.append(Infos.get(i) + "\n");
		}
		
		return "you got " + amountToBeAdded + " Hentai Quartz!";
		
	}

}
