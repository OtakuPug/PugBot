package PugBotGradle3;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import java.awt.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;
public class nagaping extends Command{

	public nagaping() {
		this.name = "nagaping";
		this.aliases = new String[]{"np", "nagap"};
	}
	
	 protected void execute(CommandEvent e)
	    {
		 e.getMessage().delete().queue();
			  e.reply("<:nagaping:637871602259984401>");
	    }
}
