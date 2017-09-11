import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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
        //System.out.println("it got the results... ");
        result = recognizer.getResult();



        System.out.println(result.getHypothesis());
        while ((!(result = recognizer.getResult()).equals("MAC QUIT"))) {
            //Get the recognize speech
            String command = result.getHypothesis();
            if(result.equals("MAC QUIT"))
                break;
            System.out.println("Results: " + command);
            if(command.length()>4)
            new CommandFactory().setCommand(command.substring(4, command.length()));
        }

//        recognizer.stopRecognition();
//
//        String [] testStrings = {"play music", "Mac volume down",
//                "Mac open Spotify","Mac Pause music",
//                "Mac skip song","Mac replay", "Mac spread",
//                "Mac volume up","play song"
//
//        };
//
//        for(String test : testStrings) {
//            new CommandFactory().setCommand(test.substring(4, test.length()));
//        }
       // new CommandFactory().setCommand(result.getHypothesis());




        // Pause recognition process. It can be resumed then with startRecognition(false).

    }
}