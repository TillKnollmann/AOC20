package com.aoc20.Day02;

import com.aoc20.Day;

public class Day02 extends Day {

    public Day02() {
        super(2);
    }

    public static void main(String[] args) {
        new Day02().solve();
    }

    @Override
    public String solvePartOne(String input) {
        // check each line and check if the password is legit
        String[] lines = input.split("\n");
        int count = 0;
        for (String line: lines) {
            if (isPasswordLegitOne(line)) {
                count++;
            }
        }
        return "" + count;
    }

    /**
     * Returns true if the line contains a legit password
     * subject to part one.
     *
     * @param line - the line of the input
     * @return - true if the password is legit
     */
    private boolean isPasswordLegitOne(String line) {
        String[] parts = line.split(" ");
        String[] range = parts[0].split("-");
        int least = Integer.parseInt(range[0]);
        int most = Integer.parseInt(range[1]);
        char toCheck = parts[1].charAt(0);
        String password = parts[2];

        int count = 0;

        for (char c: password.toCharArray()) {
            if (c == toCheck) {
                count ++;
                if (count > most) {
                    return false;
                }
            }
        }
        if (count < least) {
            return false;
        }

        return true;
    }

    @Override
    public String solvePartTwo(String input) {
        String[] lines = input.split("\n");
        int count = 0;
        for (String line: lines) {
            if (isPasswordLegitTwo(line)) {
                count++;
            }
        }
        return "" + count;
    }

    /**
     * Returns true if the line contains a legit password with
     * respect to part two.
     *
     * @param line - the line of the input
     * @return - true if the password is legit
     */
    private boolean isPasswordLegitTwo(String line) {
        String[] parts = line.split(" ");
        String[] range = parts[0].split("-");
        int first = Integer.parseInt(range[0]);
        int second = Integer.parseInt(range[1]);
        char toCheck = parts[1].charAt(0);
        String password = parts[2];

        if ((password.charAt(first - 1) == toCheck && password.charAt(second - 1) == toCheck) || (password.charAt(first-1) != toCheck && password.charAt(second-1) != toCheck)) {
            return false;
        }

        return true;
    }

}
