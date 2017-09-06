/**
 * Created by roberthumphres on 9/1/17.
 */
public class MusicServices extends CommandFactory{


    public static void runCommand(){


        switch(whatAction()){
            case 0:
                //play
                if(command.contains("music"))
                    System.out.println("Playing music....");
                break;
            case 1:
                //Pause
                if(command.contains("music"))
                    System.out.println("Pausing music....");
                break;
            case 2:
                //last
                break;
            case 3:
                //back
                break;
            case 4:
                //forward
                break;
            case 5:
                //repeat
                break;
            case 6:
                //shuffle
                break;
            default:
                System.out.println("Had trouble figuring out the text... (inside Music services):" + command);
        }


    }

    private static int whatAction(){

        for(int x = 0; x<musicType.length;x++){
            if(command.contains(musicType[x]))
               return x;
        }

      return -1;
    }

}
