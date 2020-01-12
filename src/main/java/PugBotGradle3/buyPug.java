package PugBotGradle3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.entities.MessageChannel;
public class buyPug extends Command{

	public buyPug() {
		this.name = "buypug";
		this.aliases = new String[]{"bp"};
	}

	@Override
	protected void execute(CommandEvent e) {
		MessageChannel channel = e.getChannel();
		try {
			channel.sendMessage(buy(e.getAuthor().getId())).queue();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public static String buy(String userIdInput) throws IOException {
		
		int currentBalance;
		String Testwii;
		int currentPugs;
		int counter = 0;
		int counter2 = 0;
		int sentinel = 1;
		Random rand = new Random();
		int amountToBeAdded;
		int oldAmount;
		int newAmount = 0;
		String name;
		String ID;
		String money;
		String fil;
		
		int indexOld;
		int indexOldPugs;
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
		
			
			System.out.println(Infos.get(counter2));
			System.out.println(Infos.get(counter2+1));
			System.out.println(Infos.get(counter2+2));
			System.out.println(Infos.get(counter2+3));
			
			indexOld = Infos.get((counter2+2)).length();
			indexOldPugs = Infos.get((counter2+3)).length();
			currentBalance = Integer.valueOf(Infos.get((counter2+2)).substring(15, indexOld));
			//System.out.println("CB: " + currentBalance);
			currentPugs = Integer.valueOf(Infos.get((counter2+3)).substring(24, indexOldPugs));
			//System.out.println("Current Pugs: " + currentPugs);
			Testwii = Infos.get((counter2+2));
			if(currentBalance > 50 || currentBalance == 50) {
				
				Infos.set((counter2+3), "Inventory: Regular Pug x" + (currentPugs+1));
				Infos.set((counter2+2), "Hentai Quartz: " + (currentBalance-50));
				for(int i = 0; i < Infos.size(); i++) {
					
					if(i == 0) {
						FileChannel.open(Paths.get("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt"), StandardOpenOption.WRITE).truncate(0).close();
						
					}
					
					out.append(Infos.get(i) + "\n");
				}
			} else {
				if(currentBalance < 50) {
					return "Insufficient Hentai Quartz! " + "you have " + currentBalance + " Hentai Quartz!" ;
				}
			}
		return "you bought a Regular Pug!";
		
	}

}
