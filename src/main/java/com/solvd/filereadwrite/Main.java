package com.solvd.filereadwrite;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//TODO OUTPUT to an OUTPUT.txt - change output formatting
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args){
        File file = new File("src\\main\\resources\\input.txt");
        File outputFile = new File("src\\main\\resources\\output.txt");

        Map<String, Integer> uniqueWords = new HashMap<>();

        try {
            //Reads file to String using FileUtils
            String fileToString = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

            //Converts String to array of Words
            String[] wordsNotUnique = fileToString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");


            //Counts each word's occurrence and adds 1 if it's already in it
            for(String word: wordsNotUnique){
                uniqueWords.merge(word, 1, Integer::sum);
            }

        } catch (IOException e) {
            logger.info("Unable to read file " + e);
            e.printStackTrace();
        }

        String outputCount = "";
        for(String key: uniqueWords.keySet()){
            outputCount += key + ": " + uniqueWords.get(key) + "\n";
        }


        try {
            //Will attempt to create a new file, if already there, it won't do anything
            outputFile.createNewFile();

            FileUtils.writeStringToFile(outputFile,
                    outputCount,

                    StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
