package PugBotGradle3;

import java.io.File;
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

public class buyMordred extends Command{
		public buyMordred() {
			this.name = "buyMordred";
			this.aliases = new String[]{"bp"};
		}

		@Override
		protected void execute(CommandEvent e) {
			MessageChannel channel = e.getChannel();
			try {
				channel.sendMessage(buy(e.getAuthor().getId(), e.getMessage().getContentRaw())).queue();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
		}
			
}
		public static String buy(String userIdInput, String Message) throws IOException {
			
			int currentBalance;
			String Testwii;
			int currentMordreds;
			int counter = 0;
			int counter2 = 0;
			int sentinel = 1;
			System.out.println(Message);
			System.out.println(Message.length());
			int numToBuy = Integer.valueOf(Message.substring(12, (Message.length())));
			
			Random rand = new Random();
			int amountToBeAdded;
			int oldAmount;
			int newAmount = 0;
			String name;
			String ID;
			String money;
			String fil;
			String fil2;
			int inventoryId = 0;
			int invCounter;
			Scanner messageIn = new Scanner(Message);
			int indexOld;
			int indexOldPugs;
			ArrayList<String> Infos = new ArrayList<String>();
			ArrayList<String> inventoryInfo = new ArrayList<String>();
			 File users = new File("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt");
			 File Inventories = new File("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Inventory.txt");
			 Scanner fileinput = new Scanner(users);
			 Scanner inventoryInput = new Scanner(Inventories);
			    FileReader filereader = new FileReader(users);
			    LineNumberReader numreader = new LineNumberReader(filereader);
			    FileOutputStream fout = new FileOutputStream("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt", true);
		    	  PrintStream out = new PrintStream(fout);
		    	  FileReader filereader2 = new FileReader(Inventories);
				    LineNumberReader numreader2 = new LineNumberReader(filereader2);
				    FileOutputStream fout2 = new FileOutputStream("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Inventory.txt", true);
			    	  PrintStream out2 = new PrintStream(fout2);
			    	  
			while(fileinput.hasNextLine()) {
			fil = fileinput.nextLine();
			counter++;
			Infos.add(fil);
			}
			
			while(inventoryInput.hasNextLine()) {
				fil2 = fileinput.nextLine();
				counter++;
				Infos.add(fil2);
				}
			
			for(int index2 = 0; index2 < Infos.size(); index2++) {
				if(Infos.get(index2).equals("Account ID: " + userIdInput)) {
					counter2 = index2;
				}
			}
			
			for(invCounter = 0; invCounter < Infos.size(); invCounter++) {
				if(Infos.get(invCounter).equals("Account ID: " + userIdInput)) {
					inventoryId = invCounter;
				}
			}
			
				if(messageIn.hasNext()) {
					System.out.println(Infos.get(counter2));
				System.out.println(Infos.get(counter2+1));
				System.out.println(Infos.get(counter2+2));
				System.out.println(Infos.get(counter2+3));
				System.out.println(inventoryInfo.get(inventoryId));
				System.out.println(inventoryInfo.get(inventoryId+1));
				Scanner temp = new Scanner(inventoryInfo.get((inventoryId+1)));
				String[] inventoryline2 = new String[8];
				for(int in = 0; in < inventoryline2.length; in++) {
					inventoryline2[in] = temp.next();
				}
				String temp2 = temp.next();
				System.out.println(temp2);
				String numOfMordreds = temp.next();
				System.out.println(numOfMordreds);
				indexOld = Infos.get((counter2+2)).length();
				indexOldPugs = Infos.get((counter2+3)).length();
				currentBalance = Integer.valueOf(Infos.get((counter2+2)).substring(15, indexOld));
				//System.out.println("CB: " + currentBalance);
				currentMordreds = Integer.valueOf(numOfMordreds);
				//System.out.println("Current Pugs: " + currentPugs);
				
				if(currentBalance > 250 || currentBalance == 250) {
					numOfMordreds = inventoryline2[0] + currentMordreds+numToBuy + inventoryline2[2] + inventoryline2[3] + inventoryline2[4] + inventoryline2[5] + inventoryline2[6];
					inventoryInfo.set(inventoryId+1, numOfMordreds);
					Infos.set((counter2+2), "Hentai Quartz: " + (currentBalance-(250*numToBuy)));
					
					for(int i = 0; i < Infos.size(); i++) {
						
						if(i == 0) {
							FileChannel.open(Paths.get("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt"), StandardOpenOption.WRITE).truncate(0).close();
							
						}
						
						out.append(Infos.get(i) + "\n");
					}
					
					for(int i = 0; i < inventoryInfo.size(); i++) {
						
						if(i == 0) {
							FileChannel.open(Paths.get("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Inventory.txt"), StandardOpenOption.WRITE).truncate(0).close();
							
						}
						
						out2.append(inventoryInfo.get(i) + "\n");
					}
					
				} else {
					if(currentBalance < 250) {
						return "Insufficient Hentai Quartz! " + "you have " + currentBalance + " Hentai Quartz!" ;
					}
				}
			return "you bought Mordred!";
			//else
				} else {
					
					    	  
					while(fileinput.hasNextLine()) {
					fil = fileinput.nextLine();
					counter++;
					Infos.add(fil);
					}
					
					while(inventoryInput.hasNextLine()) {
						fil2 = fileinput.nextLine();
						counter++;
						Infos.add(fil2);
						}
					
					for(int index2 = 0; index2 < Infos.size(); index2++) {
						if(Infos.get(index2).equals("Account ID: " + userIdInput)) {
							counter2 = index2;
						}
					}
					
					for(invCounter = 0; invCounter < Infos.size(); invCounter++) {
						if(Infos.get(invCounter).equals("Account ID: " + userIdInput)) {
							inventoryId = invCounter;
						}
					}
					
						if(messageIn.hasNext()) {
							System.out.println(Infos.get(counter2));
						System.out.println(Infos.get(counter2+1));
						System.out.println(Infos.get(counter2+2));
						System.out.println(Infos.get(counter2+3));
						System.out.println(inventoryInfo.get(inventoryId));
						System.out.println(inventoryInfo.get(inventoryId+1));
						Scanner temp = new Scanner(inventoryInfo.get((inventoryId+1)));
						String[] inventoryline2 = new String[8];
						for(int in = 0; in < inventoryline2.length; in++) {
							inventoryline2[in] = temp.next();
						}
						String temp2 = temp.next();
						System.out.println(temp2);
						String numOfMordreds = temp.next();
						System.out.println(numOfMordreds);
						indexOld = Infos.get((counter2+2)).length();
						indexOldPugs = Infos.get((counter2+3)).length();
						currentBalance = Integer.valueOf(Infos.get((counter2+2)).substring(15, indexOld));
						//System.out.println("CB: " + currentBalance);
						currentMordreds = Integer.valueOf(numOfMordreds);
						//System.out.println("Current Pugs: " + currentPugs);
						
						if(currentBalance > 250 || currentBalance == 250) {
							numOfMordreds = inventoryline2[0] + currentMordreds+1 + inventoryline2[2] + inventoryline2[3] + inventoryline2[4] + inventoryline2[5] + inventoryline2[6];
							inventoryInfo.set(inventoryId+1, numOfMordreds);
							Infos.set((counter2+2), "Hentai Quartz: " + (currentBalance-250));
							
							for(int i = 0; i < Infos.size(); i++) {
								
								if(i == 0) {
									FileChannel.open(Paths.get("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Users.txt"), StandardOpenOption.WRITE).truncate(0).close();
									
								}
								
								out.append(Infos.get(i) + "\n");
							}
							
							for(int i = 0; i < inventoryInfo.size(); i++) {
								
								if(i == 0) {
									FileChannel.open(Paths.get("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Inventory.txt"), StandardOpenOption.WRITE).truncate(0).close();
									
								}
								
								out2.append(inventoryInfo.get(i) + "\n");
							}
							
						} else {
							if(currentBalance < 250) {
								return "Insufficient Hentai Quartz! " + "you have " + currentBalance + " Hentai Quartz!" ;
							}
						}
					return "you bought Mordred!";
					}
				return "this shouldn't happen!";
				
			
				}
		}
}
