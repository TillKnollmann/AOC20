package com.aoc20.Day06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

import com.aoc20.Day;

public class Day06 extends Day {

    public Day06() {
        super(6);
    }

    public static void main(String[] args) {
        new Day06().solve();
    }

    /**
     * Returns the total number of questions a group answers with yes
     *
     * @param groupInput - the lines of input of a group
     * @return - the total number of questions anyone in the group answers with yes
     */
    private int getYesAnswersOfGroup(String groupInput) {
        // Build a hashmap and keep track of answered questions
        HashMap<Character, Boolean> answers = new HashMap<Character, Boolean>();
        for (char c : groupInput.replace("\n", "").toCharArray()) {
            answers.put(c, true);
        }
        return answers.keySet().size();
    }

    /**
     * Returns the number of questions everyone of a given group answers with yes
     *
     * @param groupInput - the lines of input of a group
     * @return - the total number of questions everyone in the group answers with
     *         yes
     */
    private int getEveryoneYesOfGroup(String groupInput) {
        // create a set of questions that the first person answers with yes
        String[] persons = groupInput.split("\n");
        Set<Character> result = persons[0].chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        // identify the cut of all sets of questions each person answers with yes
        for (int i = 1; i < persons.length; i++) {
            Set<Character> personSet = persons[i].chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
            result.retainAll(personSet);
        }

        // the size is the searched value
        return result.size();
    }

    @Override
    public String solvePartOne(String input) {
        // split the input at blank lines, process each group and sum up the result
        return "" + Arrays.asList(input.split("\n\n")).stream().map(group -> getYesAnswersOfGroup(group))
                .mapToInt(Integer::intValue).sum();
    }

    @Override
    public String solvePartTwo(String input) {
        // split the input at blank lines, process each group and sum up the result
        return "" + Arrays.asList(input.split("\n\n")).stream().map(group -> getEveryoneYesOfGroup(group))
                .mapToInt(Integer::intValue).sum();
    }

}
