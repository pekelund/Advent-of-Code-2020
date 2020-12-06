package se.pekelund.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {

    public static ArrayList<Integer> fileToArrayListInteger(String fileName) {
        ArrayList<Integer> returnValue = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(Paths.get("inputs/" + fileName))) {
                returnValue.add(Integer.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnValue;
    }

    public static ArrayList<String> fileToArrayListString(String fileName) {
        ArrayList<String> returnValue = new ArrayList<>();
        try {
            returnValue.addAll(Files.readAllLines((Paths.get("inputs/" + fileName))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnValue;
    }
}
