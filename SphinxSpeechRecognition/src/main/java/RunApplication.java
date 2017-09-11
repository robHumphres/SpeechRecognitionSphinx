import java.io.IOException;

/**
 * Created by roberthumphres on 9/1/17.
 */
public class RunApplication extends CommandFactory{

    private static String openCmd = "open -a ";

    //https://stackoverflow.com/questions/15356405/how-to-run-a-command-at-terminal-from-java-program

    public static void runCommand(){
        System.out.println("made it into Running an application with command : " + command);


        /*
            "open spotify", //0
            "android studios",//1
            "mac open appium",//2
            "mac open eclipse",//3
            "mac open github",//4
            "mac open mongodb",//5
            "mac open spotify"//6
         */
        switch(whatAction()){
            case 0:
                //open spotify
                executeCmd("Spotify");
                break;
            case 1:
                executeCmd("Android\\ Studio");
                break;
            case 2:
                executeCmd("Appium");
                break;
            case 3:
                executeCmd("Eclipse");
                break;
            case 4:
                executeCmd("GitHub\\ Desktop");
                break;
            case 5:
                executeCmd("MongoDB\\ Compass");
                break;
            default:
                System.out.println("Wasn't able to figure out the action... ");

        }

    }

    private static void executeCmd(String command){

        //String command = "ping -c 3 www.google.com";

        try {
            Process proc = Runtime.getRuntime().exec(openCmd + command);
            //proc.waitFor();
        } catch (IOException e) {
            System.out.println("Wasn't able to execute command open executeCmd");
        }
    }

    private static int whatAction(){
        for(int x = 0; x<openCommandType.length;x++){
            if(command.contains(openCommandType[x]))
                return x;
        }

        return -1;
    }

}
