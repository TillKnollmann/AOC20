package com.aoc20.Day03;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import com.aoc20.Day;

public class Day03 extends Day {

    public Day03() {
        super(3);
    }

    public static void main(String[] args) {
        new Day03().solve();
    }

    @Override
    public String solvePartOne(String input) {
        return "" + getTreesOnPath(input, 1, 3);
    }

    private int getTreesOnPath(String input, int slope_y, int slope_x) {
        // get map
        Map map = new Map(input);
        // iterate the position until it reaches the bottom
        int treeCount = 0;
        while (map.getPosition().getValue0() < map.getMap().length) {
            // if there is a tree increase the count
            if (map.getMap()[map.getPosition().getValue0()][map.getPosition().getValue1()]) {
                treeCount ++;
            }

            // advance the position
            map.setPosition(new Pair<Integer, Integer>(map.getPosition().getValue0() + slope_y, (map.getPosition().getValue1() + slope_x) % map.getMap()[0].length));
        }

        return treeCount;
    }

    @Override
    public String solvePartTwo(String input) {
        List<Integer> values = new ArrayList<Integer>();

        values.add(getTreesOnPath(input, 1, 1));
        values.add(getTreesOnPath(input, 1, 3));
        values.add(getTreesOnPath(input, 1, 5));
        values.add(getTreesOnPath(input, 1, 7));
        values.add(getTreesOnPath(input, 2, 1));

        return "" + values.stream().reduce(1, (a,b) -> a*b);
    }

}
