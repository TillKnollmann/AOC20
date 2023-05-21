package com.aoc20.Day03;

import org.javatuples.Pair;

/**
 * This class represents a map for day 3.
 * A map consists of a 2d Map with trees and
 * the current position of the player.
 */
public class Map {

    private Boolean[][] map;

    private Pair<Integer, Integer> position;

    /**
     * Initializes the map with position (0,0)
     * and a boolean map interpretation of the
     * input string.
     *
     * @param mapString - the input string map
     */
    public Map(String mapString) {
        this.position = new Pair<Integer, Integer>(0, 0);
        this.setMapByString(mapString);
    }

    /**
     * Sets the boolean 2d array according to
     * the input string map representing trees
     * as true values.
     *
     * @param mapString - the input map
     */
    private void setMapByString(String mapString) {
        String[] lines = mapString.split("\n");
        map = new Boolean[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                if (lines[i].charAt(j) == '#') {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }
    }

    /**
     *
     * @return - a string representation of the map
     */
    public String getMapString() {
        String result = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j]) {
                    result += "#";
                } else {
                    result += ".";
                }
            }
            if (i != map.length - 1) {
                result += "\n";
            }
        }
        return result;
    }

    /**
     * @return - the current position of the player
     */
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    /**
     * Sets the current position to the given one.
     *
     * @param newPos - the new position
     */
    public void setPosition(Pair<Integer, Integer> newPos) {
        this.position = newPos;
    }

    /**
     * @return - the boolen map
     */
    public Boolean[][] getMap() {
        return this.map;
    }
}
