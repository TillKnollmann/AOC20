package com.aoc20.Day03;

import org.javatuples.Pair;

public class Map {

    private Boolean[][] map;

    private Pair<Integer, Integer> position;

    public Map(String mapString) {
        this.position = new Pair<Integer, Integer>(0, 0);
        this.setMapByString(mapString);
    }

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

    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    public void setPosition(Pair<Integer, Integer> newPos) {
        this.position = newPos;
    }

    public Boolean[][] getMap() {
        return this.map;
    }
}
