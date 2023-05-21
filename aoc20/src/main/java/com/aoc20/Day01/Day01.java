package com.aoc20.Day01;

import java.util.Arrays;

import com.aoc20.Day;

public class Day01 extends Day {

    public Day01() {
        super(1);
    }

    public static void main(String[] args) {
        new Day01().solve();
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
        int[] numbers = Arrays.stream(input.split("\n")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == 2020) {
                        return ""+(numbers[i] * numbers[j] * numbers[k]);
                    }
                }
            }
        }
        return "No solution found";
    }
}
