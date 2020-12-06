package se.pekelund.dagar;

import se.pekelund.file.FileReader;
import se.pekelund.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class December1 extends BaseDag {
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

    private void part1(ArrayList<Integer> inputData) {
        Collections.sort(inputData);

        Pair<Integer> p = findPair(2020, inputData);

        if (p != null) {
            System.out.println("Part 1; Product is: " + p.getP1() * p.getP2());
        }
    }

    private void part2(ArrayList<Integer> inputData) {
        Collections.sort(inputData);

        for (Integer i: inputData) {
            ArrayList<Integer> newData = createCopy(inputData, i);

            Pair<Integer> p = findPair(2020-i, newData);
            if (p != null) {
                System.out.println("Part 2; Product is: " + p.getP1() * p.getP2() * i);
                break;
            }
        }
    }

    public void solve() {
        ArrayList<Integer> inputData = FileReader.fileToArrayListInteger("december1.txt");

        part1(inputData);
        part2(inputData);
    }
}
