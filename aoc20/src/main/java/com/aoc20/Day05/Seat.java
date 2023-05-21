package com.aoc20.Day05;

/**
 * This class represents a seat.
 */
public class Seat {

    private static int rowNum = 127;

    private static int colNum = 7;

    private String boardingPass;

    public String getBoardingPass() {
        return boardingPass;
    }

    private int row;

    public int getRow() {
        return row;
    }

    private int column;

    public int getColumn() {
        return column;
    }

    private int seatID;

    public int getSeatID() {
        return seatID;
    }

    public Seat(String pass) {
        this.boardingPass = pass;
        calculateRowCol();
        calculateSeatID();
    }

    /**
     * Calculates the seat row, column and ID based on the boarding pass.
     */
    private void calculateRowCol() {
        int minRow = 0;
        int maxRow = rowNum;
        int minCol = 0;
        int maxCol = colNum;

        for (char c: this.boardingPass.toCharArray()) {
            switch (c) {
                case 'F':
                    maxRow = minRow + (int) Math.floor((maxRow - minRow) / 2.0);
                    break;
                case 'B':
                    minRow = maxRow - (int) Math.floor((maxRow - minRow) / 2.0);
                    break;
                case 'L':
                    maxCol = minCol + (int) Math.floor((maxCol - minCol) / 2.0);
                    break;
                case 'R':
                    minCol = maxCol - (int) Math.floor((maxCol - minCol) / 2.0);
                    break;
            }
        }
        if (minCol != maxCol || minRow != maxRow) {
            System.out.println("Calculation of seat failed for pass " + this.boardingPass + " at row " + minRow + ", " + maxRow + " and column " + minCol + ", " + maxCol);
        } else {
            this.row = minRow;
            this.column = minCol;
            this.seatID = minRow * 8 + minCol;
        }
    }

    private void calculateSeatID() {

    }

}
