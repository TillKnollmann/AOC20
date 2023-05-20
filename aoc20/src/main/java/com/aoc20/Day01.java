package com.aoc20;

import java.util.Arrays;

import com.aoc20.utils.Reader;

public class Day01 extends Day {

    public Day01() {
        super(1);
    }

    public static void main(String[] args) {
        Day day1 = new Day01();
        System.out.println("Part 1: " + day1.solvePartOne(new Reader().getInput(1, 1).getContent()));
    }

    @Override
    public String solvePartOne(String input) {
        int[] numbers = Arrays.stream(input.split("\n")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == 2020) {
                    return ""+(numbers[i] * numbers[j]);
                }
            }
        }
        return "No solution found";
    }

    @Override
    public String solvePartTwo(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solvePartTwo'");
    }
}
