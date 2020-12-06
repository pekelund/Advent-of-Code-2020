package se.pekelund.dagar;

import se.pekelund.file.FileReader;
import se.pekelund.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordRule {
    int max;
    int min;
    char character;

    public PasswordRule(int min, int max, char character) {
        this.min = min;
        this.max = max;
        this.character = character;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int check(String password) {
        long num_occurences = password.chars().filter(ch -> ch == this.character).count();

        if (num_occurences >= min && num_occurences <= max) {
            return 1;
        } else {
            return 0;
        }
    }

    public int check2(String password) {
        boolean pos1 = password.charAt(min) == character;
        boolean pos2 = password.charAt(max) == character;

        if (pos1 ^ pos2) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class December2 extends BaseDag {
    private ArrayList<Integer> createCopy(ArrayList<Integer> input, Integer remove) {
        ArrayList<Integer> newData = new ArrayList<>(input.size());
        for (Integer i: input) {
            if (!i.equals(remove)) {
                newData.add(i);
            }
        }
        return newData;
    }

    private Pair<Integer> findPair(int targetValue, ArrayList<Integer> inputData) {
        HashMap<Integer, Integer> workingData = new HashMap<>();
        for (Integer i : inputData) {
            workingData.put(i, targetValue-i);
        }

        for (Integer i : workingData.values()) {
            if (workingData.containsKey(i)) {
                return new Pair<>(i, workingData.get(i));
            }
        }
        return null;
    }

    private void part1(ArrayList<String> inputData) {
        Collections.sort(inputData);

        int numberOfMatches = 0;
        int numberOfMatches2 = 0;
        for (String passwd : inputData) {
            PasswordRule passwordRule = createPasswordRule(passwd);
            String password = getPassword(passwd);

            numberOfMatches += passwordRule.check(password);
            numberOfMatches2 += passwordRule.check2(password);
        }

        System.out.println("Part 1; Number of valid passwords: " + numberOfMatches);
        System.out.println("Part 2; Number of valid passwords: " + numberOfMatches2);

    }

    private String getPassword(String passwd) {
        int pos = passwd.indexOf(':');
        return passwd.substring(pos+1);
    }

    private PasswordRule createPasswordRule(String passwd) {
        int pos = passwd.indexOf('-');
        int posSpace = passwd.indexOf(' ');
        int min = Integer.parseInt(passwd.substring(0, pos));
        int max = Integer.parseInt(passwd.substring(pos+1, posSpace));
        char character = passwd.charAt(posSpace+1);

        return new PasswordRule(min, max, character);
    }

    private void part2(ArrayList<String> inputData) {
        Collections.sort(inputData);
    }

    public void solve() {
        ArrayList<String> inputData = FileReader.fileToArrayListString("december2.txt");

        part1(inputData);
        part2(inputData);
    }
}
