package com.aoc20;

import static org.junit.Assert.assertEquals;

import com.aoc20.utils.Input;
import com.aoc20.utils.Reader;

public abstract class DayTest {

    /**
     * Tests part one of the given day against example input
     *
     * @param day - the day to test
     */
    public void testPartOne(Day day) {
        Input testInput = new Reader().getExample(day.getNumber(), 1);
        assertEquals(testInput.getResult(), day.solvePartOne(testInput.getContent()));
    }

    /**
     * Tests part two of the given day against example input
     *
     * @param day - the day to test
     */
    public void testPartTwo(Day day) {
        Input testInput = new Reader().getExample(day.getNumber(), 2);
        assertEquals(testInput.getResult(), day.solvePartTwo(testInput.getContent()));
    }
}
