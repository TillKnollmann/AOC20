package com.aoc20;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.aoc20.Day03.Day03;
import com.aoc20.Day03.Map;
import com.aoc20.utils.Input;
import com.aoc20.utils.Reader;

public class Day03Test extends DayTest {

    @Test
    public void testMap() {
        Input input = new Reader().getExample(3, 1);
        Map map = new Map(input.getContent());
        assertEquals(map.getMapString(), input.getContent());
    }


    @Test
    @Override
    public void testSolvePartOne() {
        testPartOne(new Day03());
    }

    @Test
    @Override
    public void testSolvePartTwo() {
        testPartTwo(new Day03());
    }

}
