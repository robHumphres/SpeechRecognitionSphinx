/**
 * Created by roberthumphres on 9/1/17.
 */
public class MacCommands extends CommandFactory{

    public static void runCommand(){
        System.out.println("Made it to Mac Command :" + command);
    }


    private static int whatAction(){

        for(int x = 0; x<musicType.length;x++){
            if(command.contains(macCommandType[x]))
                return x;
        }

        return -1;
    }

}
