/**
 * Created by roberthumphres on 9/1/17.
 */
public class RunApplication extends CommandFactory{

    public static void runCommand(){
        System.out.println("made it into Running an application with command : " + command);
    }

    private static int whatAction(){
        for(int x = 0; x<musicType.length;x++){
            if(command.contains(openCommandType[x]))
                return x;
        }

        return -1;
    }

}
