package com.aoc20.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.ArrayUtils;


/**
 * This class allows to read example and final inputs for a day.
 */
public class Reader {


    /**
     * Returns the example input for a day and part.
     *
     * @param day - the day in [1,25]
     * @param part - the part in [1,2]
     * @return - the example Input
     */
    public Input getExample(int day, int part) {
        String fileContent = getFileContent(getPath() + "examples/day" + String.format("%02d", day) + "-part" + String.format("%02d", part) + ".txt");

        String[] lines = fileContent.split("\n");
        return new Input(String.join("\n", ArrayUtils.subarray(lines, 0, lines.length - 2)), lines[lines.length - 1]);
    }


    /**
     * Returns the input for a day and part
     *
     * @param day - the day in [1,25]
     * @param part - the part in [1,2]
     * @return - the input for the day
     */
    public Input getInput(int day, int part) {
        return new Input(getFileContent(getPath() + "inputs/day" + String.format("%02d", day) + "-part" + String.format("%02d", part) + ".txt"));
    }

    /**
     * Returns all content of a file
     *
     * @param filePath - the path to the file
     * @return - the file content
     */
    private String getFileContent(String filePath) {
        String result = null;
        try {
            result = String.join("\n", Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("File " + filePath + " not found!");
            // e.printStackTrace();
        }
        return result;
    }

    private String getPath() {
        String path = "src/main/java/com/aoc20/";
        if (!System.getProperty("user.dir").contains("aoc20")) {
            path = "aoc20/" + path;
        }
        return path;
    }
}
