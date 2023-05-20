package com.aoc20;

import com.aoc20.utils.Input;
import com.aoc20.utils.Reader;

/**
 * Represents a day of the advent
 * and its solution to part one
 * and two.
 */
public abstract class Day {

    /**
     * The number of the day in [1,25]
     */
    private int number;

    public Day(int number) {
        this.number = number;
    }

    /**
     * @return int - the number of the day in [1,25]
     */
    public int getNumber() {
        return number;
    }

    protected void solve() {
        System.out.println("\n" + "-----------------" + " Day " + this.number + "-----------------");
        System.out.println("Part 1: " + this.solvePartOne(new Reader().getInput(this.number, 1).getContent()));
        System.out.println("Part 2: " + this.solvePartTwo(new Reader().getInput(this.number, 2).getContent()));
    }

    /**
     * Given an input, solve part one.
     *
     * @param input - the input for part one
     * @return - the solution
     */
    public abstract String solvePartOne(String input);

    /**
     * Given an input, solve part two.
     *
     * @param input - the input for part two
     * @return - the solution
     */
    public abstract String solvePartTwo(String input);
}
