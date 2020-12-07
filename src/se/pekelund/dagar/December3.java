package se.pekelund.dagar;

import se.pekelund.file.FileReader;
import java.awt.*;
import java.util.ArrayList;

class SlopeMap {
    private final Point currentPosition = new Point(0, 0);
    private final ArrayList<String> map;
    private final Integer mapHeight;
    private final Integer mapOrgWidth;

    public SlopeMap(ArrayList<String> map) {
        this.map = map;
        mapHeight = this.map.size()-1;
        mapOrgWidth = map.get(0).length();
    }

    public boolean checkCurrentLine() {
        return map.get((int) currentPosition.getY()).charAt((int)currentPosition.getX()) == '#';
    }

    public void reset() {
        currentPosition.move(0, 0);
    }

    public void move(Integer moveX, Integer moveY) {
        int currX = (int)currentPosition.getX();
        int currY = (int)currentPosition.getY();
        int newX = (currX + moveX) % mapOrgWidth;
        currentPosition.move(newX, currY+moveY);
    }

    public boolean notOnLastLine() {
        return !(currentPosition.getY() >= mapHeight);
    }
}

public class December3 extends BaseDag {

    private void part1(ArrayList<String> inputData) {
        SlopeMap map = new SlopeMap(inputData);
        int hitCount = 0;

        while (map.notOnLastLine()) {
            if (map.checkCurrentLine()) {
                hitCount++;
            }
            map.move(3, 1);
        }
        
        System.out.println("Part 1; Number of hits are: " + hitCount);

    }

    private void part2(ArrayList<String> inputData) {
        SlopeMap map = new SlopeMap(inputData);
        int totalHitCount = 1;
        int hitCount = 0;

        Integer[] moveX = {1, 3, 5, 7, 1};
        Integer[] moveY = {1, 1, 1, 1, 2};

        for (int i = 0; i < moveX.length; i++) {
            while (map.notOnLastLine()) {
                if (map.checkCurrentLine()) {
                    hitCount++;
                }
                map.move(moveX[i], moveY[i]);
            }
            totalHitCount *= hitCount;
            hitCount = 0;
            map.reset();
        }
        System.out.println("Part 2; Total number of hits are: " + totalHitCount);
    }

    public void solve() {
        ArrayList<String> inputData = FileReader.fileToArrayListString("december3.txt");

        part1(inputData);
        part2(inputData);
    }
}
