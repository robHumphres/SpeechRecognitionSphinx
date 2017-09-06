import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class TranscriberDemo {

    public static void main(String[] args) throws Exception {

//        Configuration configuration = new Configuration();
//
//        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
//        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
//        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
//
//        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
//        // Start recognition process pruning previously cached data.
//        recognizer.startRecognition(true);
//        SpeechResult result = recognizer.getResult();
//        // Pause recognition process. It can be resumed then with startRecognition(false).
//        recognizer.stopRecognition();
//
//        //recognizer.startRecognition(stream);
//        //SpeechResult result;
//        while ((result = recognizer.getResult()) != null) {
//            System.out.format("Hypothesis: %s\n", result.getHypothesis());
//        }
//        recognizer.stopRecognition();


//
        //Working one right now....
        Configuration configuration = new Configuration();
//
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("2208.dic");//"resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("2208.lm");//"resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");


        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
        // Start recognition process pruning previously cached data.
        recognizer.startRecognition(true);
        System.out.println("Made it to starting speech recognition... Started listening.... ");
        SpeechResult result;
        System.out.println("it got the results... ");
        result = recognizer.getResult();

        recognizer.stopRecognition();
        System.out.println(result.getHypothesis());

        String [] testStrings = {"play music", "Mac volume down",
                "Mac open Spotify","Mac Pause music",
                "Mac skip song","Mac replay", "Mac spread",
                "Mac volume up","play song"

        };

        for(String test : testStrings) {
            new CommandFactory().setCommand(test.substring(4, test.length()));
        }
       // new CommandFactory().setCommand(result.getHypothesis());



//        while ((!(result = recognizer.getResult()).equals("mac quit"))) {
//        //Get the recognize speech
//        String command = result.getHypothesis();
//            System.out.println("Results: " + command);
//    }
        // Pause recognition process. It can be resumed then with startRecognition(false).

    }
}