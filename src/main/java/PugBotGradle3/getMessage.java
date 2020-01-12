/**
 * 
 */
package PugBotGradle3;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
/**
 * @author OtakuPug
 *
 */
public class getMessage extends Command{

	/**
	 * 
	 */
	public getMessage() {
		this.name = "getmessage";
		this.aliases = new String[]{"gm"};
	}

	@Override
	protected void execute(CommandEvent e) {
		Message msg = e.getMessage();
		MessageChannel channel = e.getChannel();
		String u = (String) msg.getContentRaw();
		channel.sendMessage(msg);
		
	}

}
