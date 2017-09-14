import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;


/*
http://www.speech.cs.cmu.edu/tools/lmtool-new.html
https://cmusphinx.github.io/wiki/tutoriallm/
https://cmusphinx.github.io/wiki/tutorialsphinx4/
http://osxdaily.com/2007/02/01/how-to-launch-gui-applications-from-the-terminal/
 */

public class TranscriberDemo {

    public static void main(String[] args) throws Exception {

        //Working one right now....
        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("6797.dic");//"resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("6797.lm");//"resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");


        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);

        // Start recognition process pruning previously cached data.
        recognizer.startRecognition(true);
        System.out.println("Made it to starting speech recognition... Started listening.... ");
        SpeechResult result;

        //get results from speech
        result = recognizer.getResult();

        //What it thinks i said
        System.out.println(result.getHypothesis());


        while ((!(result = recognizer.getResult()).equals("MAC QUIT"))) {
            //Get the recognize speech

            //Stop after gets result
            recognizer.startRecognition(false);

            String command = result.getHypothesis();

            if(result.equals("MAC QUIT"))
                break;

            System.out.println("Results: " + command);
            if(command.length()>4)
                if(command.contains("MAC"))
                    new CommandFactory().setCommand(command.substring(4, command.length()));

            //After it tries to go through cmd
            recognizer.startRecognition(true);
        }



        // Pause recognition process. It can be resumed then with startRecognition(false).

    }
}