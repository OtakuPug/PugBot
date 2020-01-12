package PugBotGradle3;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.EmbedBuilder;
public class Inventory extends Command{
	public Inventory() {
		this.name = "Inventory";
		this.aliases = new String[]{"i"};
	}

	@Override
	protected void execute(CommandEvent e) {
		ArrayList<String> Info = new ArrayList<String>();
		
		try {
			Info.addAll(getInventories(e.getAuthor().getId()));
			EmbedBuilder Inventory = new EmbedBuilder();
			
			Inventory.setTitle(e.getMember().getAsMention() + "'s" + " Inventory");
			 	Inventory.setDescription(Info.get(0) + " x" + Info.get(1) + "lv" + Info.get(2));
			 	Inventory.setColor(Color.green);
			 	Inventory.setThumbnail(e.getAuthor().getAvatarUrl());
			 	e.getChannel().sendMessage(Inventory.build()).queue();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public ArrayList<String> getInventories(String userIdInput) throws FileNotFoundException {
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
		String unitInfo;
		String unitName;
		String numOfUnit;
		String level;
		String currentLevelProgress;
		String untilNextLevel;
		String unitClass;
		String currentEquipment;
		
		ArrayList<String> Infos = new ArrayList<String>();
		ArrayList<String> UnitInfos = new ArrayList<String>();
		 File Inventories = new File("C:\\Users\\OtakuPug\\Documents\\Melsa\\PugBotGradle3\\Inventory.txt");
		 Scanner fileinput = new Scanner(Inventories);
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
		unitInfo = Infos.get(counter2+1);
		Scanner unitInfoInput = new Scanner(unitInfo);
		 unitName = unitInfoInput.next();
		 numOfUnit = unitInfoInput.next();
		 level = unitInfoInput.next();
	     currentLevelProgress = unitInfoInput.next();
		 untilNextLevel = unitInfoInput.next();
		 currentEquipment = unitInfoInput.next();
		 unitClass = unitInfoInput.next();
		 UnitInfos.add(unitName);
		 UnitInfos.add(numOfUnit + " ");
		 UnitInfos.add(level);
		 UnitInfos.add(currentLevelProgress);
		 UnitInfos.add(untilNextLevel);
		 UnitInfos.add(currentEquipment);
		 UnitInfos.add(unitClass);
		
		 
		return UnitInfos;
		
	}
}
