package com.aoc20.Day04;

import java.util.Arrays;
import java.util.regex.Pattern;

import com.aoc20.Day;
import com.aoc20.utils.Reader;

public class Day04 extends Day {

    static String[] fields = { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid" };

    static Pattern HEXADECIMAL_PATTERN = Pattern.compile("\\p{XDigit}+");

    public Day04() {
        super(4);
    }

    public static void main(String[] args) {
        new Day04().solve();
    }

    @Override
    public String solvePartOne(String input) {
        return "" + Arrays.asList(input.split("\n\n")).stream().map(passport -> isPassportValidOne(passport.replace('\n', ' '), new String[]{"cid"}) ? 1 : 0).mapToInt(Integer::intValue).sum();
    }

    private boolean isPassportValidOne(String passport, String[] ignore) {
        String[] keys = Arrays.asList(passport.split(" ")).stream().map(elem -> elem.split(":")[0]).toArray(String[]::new);
        for (String field: fields) {
            if (!Arrays.asList(ignore).contains(field)) {
                if (!Arrays.asList(keys).contains(field)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String solvePartTwo(String input) {
        return "" + Arrays.asList(input.split("\n\n")).stream().map(passport -> isPassportValidTwo(passport.replace('\n', ' '), new String[]{"cid"}) ? 1 : 0).mapToInt(Integer::intValue).sum();
    }

    private boolean isPassportValidTwo(String passport, String[] ignore) {
        String[] pairs = passport.split(" ");
        for (String field: fields) {
            if (!Arrays.asList(ignore).contains(field)) {
                boolean some = false;
                for (String pair: pairs) {
                    if (pair.split(":")[0].equals(field)) {
                        some = true;
                        String value = pair.split(":")[1];
                        switch(field) {
                            case "byr":
                                try {
                                    int intValue = Integer.parseInt(value);
                                    if (intValue < 1920 || intValue > 2002) {
                                        return false;
                                    }
                                } catch (NumberFormatException e) {
                                    return false;
                                }
                                break;
                            case "iyr":
                                try {
                                    int intValue = Integer.parseInt(value);
                                    if (intValue < 2010 || intValue > 2020) {
                                        return false;
                                    }
                                } catch (NumberFormatException e) {
                                    return false;
                                }
                                break;
                            case "eyr":
                                try {
                                    int intValue = Integer.parseInt(value);
                                    if (intValue < 2020 || intValue > 2030) {
                                        return false;
                                    }
                                } catch (NumberFormatException e) {
                                    return false;
                                }
                                break;
                            case "hgt":
                                try {
                                    int intValue = Integer.parseInt(value.substring(0, value.length()-2));
                                    switch(value.substring(value.length()-2)) {
                                        case "cm":
                                            if (intValue < 150 || intValue > 193) {
                                                return false;
                                            }
                                            break;
                                        case "in":
                                            if (intValue < 59 || intValue > 76) {
                                                return false;
                                            }
                                            break;
                                    }
                                } catch (NumberFormatException e) {
                                    return false;
                                }
                                break;
                            case "hcl":
                                if (value.length() != 7 || value.charAt(0) != '#' || !HEXADECIMAL_PATTERN.matcher(value.substring(1)).matches()) {
                                    return false;
                                }
                                break;
                            case "ecl":
                                String[] check = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" };
                                if (!Arrays.asList(check).contains(value)) {
                                    return false;
                                }
                                break;
                            case "pid":
                                try {
                                    Integer.parseInt(value);
                                    if (value.length() != 9) {
                                        return false;
                                    }
                                } catch (NumberFormatException e) {
                                    return false;
                                }
                                break;
                            case "cid":
                                break;
                        }
                    }
                }
                if (!some) {
                    return false;
                }
            }
        }
        return true;
    }

}
