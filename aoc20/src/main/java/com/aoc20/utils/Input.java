package com.aoc20.utils;

/**
 * This class represents an input consisting of an input string
 * and the correct result
 */
public class Input {
    private String content;
    private String result;

    public Input(String content) {
        this.content = content;
    }

    public Input(String content, String result) {
        this.content = content;
        this.result = result;
    }

    public String getContent() {
        return this.content;
    }

    public String getResult() {
        return this.result;
    }
}
