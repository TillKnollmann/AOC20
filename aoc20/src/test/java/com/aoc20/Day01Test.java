package com.aoc20;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.aoc20.utils.Input;
import com.aoc20.utils.Reader;

public class Day01Test {

    @Test
    public void testSolvePartOne() {
        Input testInput = new Reader().getExample(1, 1);
        assertEquals(testInput.getResult(), new Day01().solvePartOne(testInput.getContent()));
    }

    @Test
    public void testSolvePartTwo() {
        Input testInput = new Reader().getExample(1, 2);
        assertEquals(testInput.getResult(), new Day01().solvePartTwo(testInput.getContent()));
    }
}
