import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    public static void main(String[] args){
        FileReader fileReader = new FileReader("key.txt");

        JDA api =
                JDABuilder.createDefault(fileReader.getKeyFromFile()).
                        addEventListeners(new CommandListener()).
                        enableIntents(GatewayIntent.MESSAGE_CONTENT).
                        build();
    }
}
