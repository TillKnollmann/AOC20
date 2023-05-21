package com.aoc20.Day05;

import java.util.Arrays;

import com.aoc20.Day;

public class Day05 extends Day {

    public Day05() {
        super(5);
    }

    public static void main(String[] args) {
        new Day05().solve();
    }

    @Override
    public String solvePartOne(String input) {
        return "" + Arrays.asList(input.split("\n")).stream().map(pass -> new Seat(pass).getSeatID()).mapToInt(Integer::valueOf).max().getAsInt();
    }

    @Override
    public String solvePartTwo(String input) {
        int[] seats = Arrays.asList(input.split("\n")).stream().map(pass -> new Seat(pass).getSeatID()).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(seats);
        for (int i = 0; i < seats.length-1; i++) {
            // check if seatIDs have distance 2
            if (seats[i] == seats[i+1] - 2) {
                return "" + (seats[i] + 1);
            }
        }
        return "-1";
    }

}
