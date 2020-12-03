package se.pekelund.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {

    public static ArrayList<Integer> fileToArrayList(String fileName) {
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
}
