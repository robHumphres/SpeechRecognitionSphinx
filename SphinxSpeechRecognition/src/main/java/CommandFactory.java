/**
 * Created by roberthumphres on 9/1/17.
 */
public class CommandFactory {

    /*
    Spotify
    Spread
    Open appium, chrome, firefox, Studio,
     */

    protected static final String [] musicType = {
            "play","pause","last","skip back","skip next","repeat","shuffle", "skip","replay", "skip song"
    };

    protected static final String [] macCommandType = {
            "spread", "volume up", "volume down", "volume mute", "brightness up", "brightness down"
    };

    protected static final String [] openCommandType = {
            "open spotify", "appium", "android studios"
    };

    protected static String command;

    public void setCommand(String comm){
        command = comm.toLowerCase();
        int typeOfAction;
        typeOfAction = typeCategory(command);

        switch(typeOfAction){
            case 1:
                //Music Services
                MusicServices.runCommand();
                break;
            case 2:
                //Opening Application
                RunApplication.runCommand();
                break;
            case 3:
                //Mac specific command
                MacCommands.runCommand();
                break;
            default:
                System.out.println("There was an error getting what type it is.... " + command);
        }//end of switch

    }
        /*
        1 = music service
        2 = opening service
        3 = mac command
         */

    public int typeCategory(String command){

        for(String s : musicType)
            if (command.contains(s)){
                return 1;
            }

        if(command.contains("open"))
            return 2;

        for(String s : macCommandType)
            if(command.contains(s))
                return 3;


        return 0;
    }



}
