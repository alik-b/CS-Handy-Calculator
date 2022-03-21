package com.alikbCalculator.view;

import com.alikbCalculator.controller.*;
import com.alikbCalculator.model.*;

import java.util.Scanner;

/**
 * This is the main driver class that provides a menu and instructions for the user to choose what they want to do.
 * It can read a file or take the user through different menus to allow them to choose their desired operation.
 * THIS IS FOR THE CLI
 *
 * @author Alik Balika
 * @version 2020.11.04
 */
public class MainCLI {

    /**
     * These constants can change the color of the text in the terminal
     */
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * A final String for when the user types in an incorrect input
     */
    public static final String INCORRECT_INPUT = "The value you entered is invalid. Please try again or enter r to go back to the main menu: ";

    /**
     * A final Scanner object that you can use from anywhere in the class
     */
    public static Scanner input = new Scanner(System.in);

    /**
     * Keeps the main while loop running and depending on the input from the user, will change the boolean if necessary
     */
    private static boolean runCalculator;


    /**
     * Calculator objects that take in Number objects and do calculations with them.
     */
    public static final Calculator bc = new BinaryCalculator();
    public static final Calculator hc = new HexCalculator();

    /**
     * Contains the instructions and the main menu
     *
     * @param args args
     */
    public static void main(String[] args) {

        // Intro message and describes which options to press to run the calculator
        System.out.print(ANSI_BLUE + "--------------------------------------------\n" +
                "Welcome to the CS Student's Handy Calculator!\n--------------------------------------------\n" +
                "This calculator is able to do a wide variety of binary, hex and bandwidth operations.\n" +
                "In each menu you will get a list of characters showing each of your available options.\n" + ANSI_RESET);

        runCalculator = true;

        // main loop that runs the program
        main:
        while (runCalculator) {
            System.out.print(ANSI_PURPLE + "\n\n--------------------------------------------\n\t\t\t\tMAIN MENU:\n" +
                    "--------------------------------------------\n1: ENTER A FILE\n" +
                    "2: USE THE CALCULATOR\n" + "Q: QUIT\nPlease enter here: " + ANSI_RESET);
            String fileOrUse = input.next().toUpperCase();

            // assume the input is incorrect until proven otherwise
            boolean incorrectInput = true;

            // switch statement to check what the user inputs and to take action accordingly
            while (incorrectInput) {
                switch (fileOrUse) {
                    case "1":
                        Scanner fileScanner = new Scanner(System.in);
                        System.out.print(ANSI_PURPLE + "Please enter the name of your file: " + ANSI_RESET);
                        String file = fileScanner.nextLine();
//                        try {
//                            CalculateFile.calculate(file);
//                        } catch (FileNotFoundException e) {
//                            System.out.println(ANSI_RED + "Something went wrong with the file." + ANSI_RESET);
//                        }
                        incorrectInput = false;
                        break;
                    case "2":
                        userCalculate();
                        incorrectInput = false;
                        break;
                    case "Q":
                        break main;
                    default:
                        System.out.print(ANSI_RED + "The value you entered is invalid. Please try again" + ANSI_RESET);
                        continue main;
//                        fileOrUse = input.next().toUpperCase();
                        // break;
                }
            }
        }
    }

    /**
     * Outputs a menu for the user to use which kind of calculation they would like to use
     */
    public static void userCalculate() {
        System.out.print(ANSI_PURPLE + "\n\n--------------------------------------------\n\t\t\t\tUSER MENU:\n" +
                "--------------------------------------------\n1: BINARY CALCULATOR\n2: HEX CALCULATOR\n" +
                "3: BANDWIDTH CALCULATOR\nR: RESET\nQ: QUIT\nPlease enter here: " + ANSI_RESET);
        String calcChoice = input.next().toUpperCase();
        boolean incorrectInput = true;

        while (incorrectInput) {
            switch (calcChoice) {
                case "1":
                    binaryCalculations();
                    incorrectInput = false;
                    break;
                case "2":
                    hexCalculations();
                    incorrectInput = false;
                    break;
                case "3":
                    bandwidthCalculations();
                    incorrectInput = false;
                    break;
                case "R":
                    return;
                case "Q":
                    runCalculator = false;
                    return;
                default:
                    System.out.print(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                    calcChoice = input.next().toUpperCase();
                    break;
            }
        }
    }

    /**
     * Outputs a menu for the user to choose which binary calculations they would like to use. Then based on the user input
     * it will calculate the necessary operation
     */
    public static void binaryCalculations() {
        System.out.print(ANSI_PURPLE + "\n\n--------------------------------------------\n\t\t\t\tBINARY MENU:\n" +
                "--------------------------------------------\n1: CONVERT BINARY TO DECIMAL\n2: CONVERT DECIMAL TO BINARY\n" +
                "3: ADD, SUBTRACT, MULTIPLY, OR DIVIDE TWO BINARY NUMBERS\nR: RESET\nQ: QUIT\nPlease enter here: " + ANSI_RESET);
        String binaryChoice = input.next().toUpperCase();
        boolean incorrectChoice = true;
        boolean incorrectValue;

        while (incorrectChoice) {
            switch (binaryChoice) {
                case "1":
                    System.out.println("Please enter a 16 bit binary number.\nFor example, entering " +
                            "1000 would output 8.\nEnter only valid strings or you will be re-prompted to enter another value.\n" +
                            "Enter r to go back to the main menu.");
                    System.out.print(ANSI_PURPLE + "Enter your binary number here: " + ANSI_RESET);
                    String binary = input.next();
                    incorrectValue = true;

                    while (incorrectValue) {
                        if (binary.toLowerCase().equals("r")) {
                            return;
                        } else if (!Utils.isBinary(binary)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter your binary number here: " + ANSI_RESET);
                            binary = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }
                    Binary b = new Binary(binary);

                    System.out.println(ANSI_YELLOW + "The decimal value of " + b + " is " + b.toDecimal() + ANSI_RESET);
                    incorrectChoice = false;
                    break;
                case "2":
                    System.out.println("Please enter a decimal number in the range of 0-2147483647.\n" +
                            "For example, entering 8 would output 1000.\nPlease enter only valid numbers between the " +
                            "specified range or you will be re-prompted to enter another value.\nEnter r to go back to the main menu");
                    System.out.print(ANSI_PURPLE + "Enter your number here: " + ANSI_RESET);
                    String decimal = input.next();
                    incorrectValue = true;

                    long dec = 0;
                    while (incorrectValue) {
                        if (decimal.toLowerCase().equals("r")) {
                            return;
                        } else if (Utils.isInteger(decimal)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter your number here: " + ANSI_RESET);
                            decimal = input.next();
                        } else {
                            dec = Long.parseLong(decimal);
                            incorrectValue = false;
                        }
                    }

                    Decimal d = new Decimal(dec);

                    System.out.println(ANSI_YELLOW + "The binary value of " + d + " is " + d.toBinary() + ANSI_RESET);
                    incorrectChoice = false;
                    break;

                case "3":
                    System.out.println("Please enter the operator that you would like to perform on the two binary numbers.\n" +
                            "Enter r to go back to the main menu.");
                    System.out.print(ANSI_PURPLE + "Enter the operator ( +, -, *, / ): ");
                    String operator = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (operator.toLowerCase().equals("r")) {
                            return;
                        } else if (Utils.isOperator(operator)) {
                            System.out.println(ANSI_RED + "Please enter a valid operator!" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the operator ( +, -, *, / ): " + ANSI_RESET);
                            operator = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    System.out.println("Please enter your binary numbers when prompted.\nYou must enter valid binary " +
                            "numbers of 16 bits or you will be re-prompted to enter them.\nEnter r to go back to the main menu.");
                    System.out.print(ANSI_PURPLE + "Enter the first binary number: " + ANSI_RESET);
                    String binary1 = input.next();
                    System.out.print(ANSI_PURPLE + "Enter the second binary number: " + ANSI_RESET);
                    String binary2 = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (binary1.toLowerCase().equals("r") || binary2.toLowerCase().equals("r")) {
                            return;
                        } else if ((!Utils.isBinary(binary1) && !Utils.isBinary(binary2)) ||
                                (!Utils.isBinary(binary1) && Utils.isBinary(binary2)) ||
                                (Utils.isBinary(binary1) && !Utils.isBinary(binary2))) {
                            System.out.println(ANSI_RED + "Both numbers must be valid binary numbers! Please try again or enter r to go back to the main menu:" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the first binary number: " + ANSI_RESET);
                            binary1 = input.next();
                            System.out.print(ANSI_PURPLE + "Enter the second binary number: " + ANSI_RESET);
                            binary2 = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    Binary b1 = new Binary(binary1);
                    Binary b2 = new Binary(binary2);

                    switch (operator) {
                        case "+" -> System.out.println(ANSI_YELLOW + b1 + " + " + b2 + " = " + bc.add(b1, b2) + ANSI_RESET);
                        case "-" -> System.out.println(ANSI_YELLOW + b1 + " - " + b2 + " = " + bc.subtract(b1, b2) + ANSI_RESET);
                        case "*" -> System.out.println(ANSI_YELLOW + b1 + " * " + b2 + " = " + bc.multiply(b1, b2) + ANSI_RESET);
                        case "/" -> {
                            if (b2.toDecimal() == 0) {
                                System.out.println(ANSI_RED + "Denominator cannot equal 0!" + ANSI_RESET);
                            } else {
                                System.out.println(ANSI_YELLOW + b1 + " / " + b2 + " = " + bc.divide(b1, b2) + ANSI_RESET);
                            }
                        }
                    }
                    incorrectChoice = false;
                    break;
                case "R":
                    return;
                case "Q":
                    runCalculator = false;
                    return;
                default:
                    System.out.print(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                    binaryChoice = input.next().toUpperCase();
                    break;
            }
        }
    }

    /**
     * Outputs a menu for the user to choose which hex calculations they would like to use. Then based on the user input
     * it will calculate the necessary operation
     */
    public static void hexCalculations() {
        System.out.print(ANSI_PURPLE + "\n\n--------------------------------------------\n\t\t\t\tHEX MENU:\n" +
                "--------------------------------------------\n1: CONVERT HEX TO DECIMAL\n2: CONVERT DECIMAL TO HEX\n" +
                "3: ADD, SUBTRACT, MULTIPLY, OR DIVIDE TWO HEX NUMBERS\nR: RESET\nQ: QUIT\nPlease enter here: " + ANSI_RESET);
        String hexChoice = input.next().toUpperCase();
        boolean incorrectChoice = true;
        boolean incorrectValue;

        while (incorrectChoice) {
            switch (hexChoice) {
                case "1":
                    System.out.println("Please enter your hex number between 0000-FFFF. \n" +
                            "For example, typing F or 000f would output 15.\nPlease enter only valid hex strings of length 4" +
                            " or you will be re-prompted to enter another value.\nEnter r to go back to the main menu");
                    System.out.print(ANSI_PURPLE + "Enter your hex number here: " + ANSI_RESET);
                    String hex = input.next();
                    incorrectValue = true;

                    while (incorrectValue) {
                        if (hex.toLowerCase().equals("r")) {
                            return;
                        } else if (!Utils.isHex(hex)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter your hex number here: " + ANSI_RESET);
                            hex = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    Hex h = new Hex(hex);

                    System.out.println(ANSI_YELLOW + "The decimal value of " + h + " is " + h.toDecimal() + ANSI_RESET);
                    incorrectChoice = false;
                    break;
                case "2":
                    System.out.println("Please enter your decimal number in the range of 0-2147483647.\n" +
                            "For example, typing 15 would output F.\nPlease enter only valid numbers between the " +
                            "specified range or you will be re-prompted to enter another value.\nEnter r to go back to the main menu");
                    System.out.print(ANSI_PURPLE + "Enter your number here: " + ANSI_RESET);
                    String decimal = input.next();
                    incorrectValue = true;

                    int dec = 0;
                    while (incorrectValue) {
                        if (decimal.toLowerCase().equals("r")) {
                            return;
                        } else if (Utils.isInteger(decimal)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter your number here: " + ANSI_RESET);
                            decimal = input.next();
                        } else {
                            dec = Integer.parseInt(decimal);
                            incorrectValue = false;
                        }
                    }

                    Decimal d = new Decimal(dec);

                    System.out.println(ANSI_YELLOW + "The hex value of " + d + " is " + d.toHex() + ANSI_RESET);
                    incorrectChoice = false;
                    break;
                case "3":
                    System.out.println("Please enter the operator that you would like to perform on the two hex numbers.\n" +
                            "Enter r to go back to the main menu.");
                    System.out.print(ANSI_PURPLE + "Enter the operator ( +, -, *, / ): ");
                    String operator = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (operator.toLowerCase().equals("r")) {
                            return;
                        } else if (Utils.isOperator(operator)) {
                            System.out.println(ANSI_RED + "Please enter a valid operator!" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the operator ( +, -, *, / ): " + ANSI_RESET);
                            operator = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    System.out.println("Please enter your hex numbers when prompted.\nYou must enter valid hex " +
                            "numbers of length 4 or you will be re-prompted to enter them.\nEnter r to go back to the main menu");
                    System.out.print(ANSI_PURPLE + "Enter the first hex number: " + ANSI_RESET);
                    String hex1 = input.next();
                    System.out.print(ANSI_PURPLE + "Enter the second hex number: " + ANSI_RESET);
                    String hex2 = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (hex1.toLowerCase().equals("r") || hex2.toLowerCase().equals("r")) {
                            return;
                        } else if ((!Utils.isHex(hex1) && !Utils.isHex(hex2)) || (!Utils.isHex(hex1) && Utils.isHex(hex2)) ||
                                (Utils.isHex(hex1) && !Utils.isHex(hex2))) {
                            System.out.println(ANSI_RED + "Both numbers must be valid hex numbers! Please try again or enter r to go back to the main menu:" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the first hex number: " + ANSI_RESET);
                            hex1 = input.next();
                            System.out.print(ANSI_PURPLE + "Enter the second hex number: " + ANSI_RESET);
                            hex2 = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    Hex h1 = new Hex(hex1);
                    Hex h2 = new Hex(hex2);

                    switch (operator) {
                        case "+" -> System.out.println(ANSI_YELLOW + h1 + " + " + h2 + " = " + hc.add(h1, h2) + ANSI_RESET);
                        case "-" -> System.out.println(ANSI_YELLOW + h1 + " - " + h2 + " = " + hc.subtract(h1, h2) + ANSI_RESET);
                        case "*" -> System.out.println(ANSI_YELLOW + h1 + " * " + h2 + " = " + hc.multiply(h1, h2) + ANSI_RESET);
                        case "/" -> {
                            if (h2.toDecimal() == 0) {
                                System.out.println(ANSI_RED + "Denominator cannot equal 0!" + ANSI_RESET);
                            } else {
                                System.out.println(ANSI_YELLOW + h1 + " / " + h2 + " = " + hc.divide(h1, h2) + ANSI_RESET);
                            }
                        }
                    }
                    incorrectChoice = false;
                    break;
                case "R":
                    return;
                case "Q":
                    runCalculator = false;
                    return;
                default:
                    System.out.print(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                    hexChoice = input.next().toUpperCase();
                    break;
            }
        }
    }

    /**
     * Outputs a menu for the user to choose which bandwidth calculations they would like to use. Then based on the user input
     * it will calculate the necessary operation
     */
    public static void bandwidthCalculations() {
        System.out.print(ANSI_PURPLE + "\n\n--------------------------------------------\n\t\t\t\tBANDWIDTH MENU:\n" +
                "--------------------------------------------\n1: DATA UNIT CONVERTER\n2: DOWNLOAD/UPLOAD TIME\n" +
                "3: WEBSITE BANDWIDTH\n4: HOSTING BANDWIDTH\nR: RESET\nQ: QUIT\nPlease enter " +
                "here: " + ANSI_RESET);
        String hexChoice = input.next().toUpperCase();
        boolean incorrectChoice = true;
        boolean incorrectValue;

        Size size;
        Rate rate;
        SizeUnit sizeUnit;
        RateUnit rateUnit;

        while (incorrectChoice) {
            switch (hexChoice) {
                case "1":
                    System.out.println("Please enter the amount of bits above 0.\n" +
                            "Then when prompted, please enter the appropriate data unit.\nEnter r to go back to the main menu");
                    String bits;

                    incorrectValue = true;

                    double d = 0;
                    while (incorrectValue) {
                        System.out.print(ANSI_PURPLE + "Enter the number of bits: " + ANSI_RESET);
                        bits = input.next();
                        if (bits.toLowerCase().equals("r")) {
                            return;
                        }
                        try {
                            d = Double.parseDouble(bits);
                            incorrectValue = false;
                        } catch (NumberFormatException e) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            continue;
                        }

                        if (d < 0) {
                            System.out.println(ANSI_RED + "Please stay within the appropriate range! " +
                                    "Please enter a new value or r to go to the main menu." + ANSI_RESET);
                            incorrectValue = true;
                        }
                    }

                    System.out.print(ANSI_PURPLE + "Enter the data unit (enter L to list the possible keywords): " + ANSI_RESET);
                    String unit = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (unit.toLowerCase().equals("r")) {
                            return;
                        } else if (unit.toLowerCase().equals("l")) {
                            System.out.println(ANSI_GREEN + "Accepted keywords(case insensitive):\n'bits', 'kilobits', 'megabits', 'gigabits', " +
                                    "'terabits'\n'Bytes', 'Kilobytes', 'Megabytes', 'Gigabytes', 'Terabytes'" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit: " + ANSI_RESET);
                            unit = input.next();
                        } else if (Utils.isValidAllKeyword(unit)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit: " + ANSI_RESET);
                            unit = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    size = switch (unit.toLowerCase()) {
                        case "bits" -> Size.BIT;
                        case "kilobits" -> Size.KILOBIT;
                        case "megabits" -> Size.MEGABIT;
                        case "gigabits" -> Size.GIGABIT;
                        case "terabits" -> Size.TERABIT;
                        case "bytes" -> Size.BYTE;
                        case "kilobytes" -> Size.KILOBYTE;
                        case "megabytes" -> Size.MEGABYTE;
                        case "gigabytes" -> Size.GIGABYTE;
                        case "terabytes" -> Size.TERABYTE;
                        default -> throw new IllegalStateException("Unexpected value: " + unit.toLowerCase());
                    };

                    sizeUnit = new SizeUnit(size, d);

                    System.out.println(ANSI_YELLOW + Converter.convertDataUnit(sizeUnit) + ANSI_RESET);
                    incorrectChoice = false;
                    break;
                case "2":
                    System.out.println("Please enter the file size with a range above 0.\n" +
                            "Then when prompted, please enter the appropriate data unit for the file size.\nYou will then be asked for " +
                            "a bandwidth between a range above 0.\nThen when prompted, please enter the appropriate " +
                            "data units for the bandwidth.\nEnter r to go back to the main menu");
                    String fileSize;

                    incorrectValue = true;

                    double fileSizeValue = 0;
                    while (incorrectValue) {
                        System.out.print(ANSI_PURPLE + "Enter the file size: " + ANSI_RESET);
                        fileSize = input.next();
                        if (fileSize.toLowerCase().equals("r")) {
                            return;
                        }

                        try {
                            fileSizeValue = Double.parseDouble(fileSize);
                            incorrectValue = false;
                        } catch (NumberFormatException e) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            continue;
                        }

                        if (fileSizeValue < 0) {
                            System.out.println(ANSI_RED + "Please stay within the appropriate range! " +
                                    "Please enter a new value or r to go to the main menu." + ANSI_RESET);
                            incorrectValue = true;
                        }
                    }

                    System.out.print(ANSI_PURPLE + "Enter the data unit for the file size (enter L to list the possible keywords): " + ANSI_RESET);
                    String dataUnit = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (dataUnit.toLowerCase().equals("r")) {
                            return;
                        } else if (dataUnit.toLowerCase().equals("l")) {
                            System.out.println(ANSI_GREEN + "Accepted keywords(case insensitive):\n'Bytes', " +
                                    "'Kilobytes', 'Megabytes', 'Gigabytes', 'Terabytes'" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit for the file size: " + ANSI_RESET);
                            dataUnit = input.next();
                        } else if (Utils.isValidBottomKeywords(dataUnit)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit for the file size: " + ANSI_RESET);
                            dataUnit = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    size = switch (dataUnit.toLowerCase()) {
                        case "bytes" -> Size.BYTE;
                        case "kilobytes" -> Size.KILOBYTE;
                        case "megabytes" -> Size.MEGABYTE;
                        case "gigabytes" -> Size.GIGABYTE;
                        case "terabytes" -> Size.TERABYTE;
                        default -> throw new IllegalStateException("Unexpected value: " + dataUnit.toLowerCase());
                    };

                    String bandwidth;
                    incorrectValue = true;

                    double bandValue = 0;
                    while (incorrectValue) {
                        System.out.print(ANSI_PURPLE + "Enter the bandwidth value: " + ANSI_RESET);
                        bandwidth = input.next();

                        if (bandwidth.toLowerCase().equals("r")) {
                            return;
                        }

                        try {
                            bandValue = Double.parseDouble(bandwidth);
                            incorrectValue = false;
                        } catch (NumberFormatException e) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            continue;
                        }

                        if (bandValue < 0) {
                            System.out.println(ANSI_RED + "Please stay within the appropriate range! " +
                                    "Please enter a new value or r to go to the main menu." + ANSI_RESET);
                            incorrectValue = true;
                        }
                    }

                    System.out.print(ANSI_PURPLE + "Enter the data unit for bandwidth (enter L to list the possible keywords): " + ANSI_RESET);
                    String bandUnit = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (bandUnit.toLowerCase().equals("r")) {
                            return;
                        } else if (bandUnit.toLowerCase().equals("l")) {
                            System.out.println(ANSI_GREEN + "Accepted keywords(case insensitive):\n'bit/s', " +
                                    "'Kbit/s', 'Mbit/s', 'Gbit/s', 'Tbit/s'" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit for bandwidth: " + ANSI_RESET);
                            bandUnit = input.next();
                        } else if (Utils.isValidUnitPerTimeKeywords(bandUnit)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit for bandwidth: " + ANSI_RESET);
                            bandUnit = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    rate = switch (bandUnit.toLowerCase()) {
                        case "bit/s" -> Rate.BITpS;
                        case "kbit/s" -> Rate.KBITpS;
                        case "mbit/s" -> Rate.MBITpS;
                        case "gbit/s" -> Rate.GBITpS;
                        case "tbit/s" -> Rate.TBITpS;
                        default -> throw new IllegalStateException("Unexpected value: " + bandUnit.toLowerCase());
                    };

                    sizeUnit = new SizeUnit(size, fileSizeValue);
                    rateUnit = new RateUnit(rate, bandValue);

                    System.out.println(ANSI_YELLOW + "The approximate download/upload time is: ");
                    System.out.println(DownloadUploadTimeCalculator.calculate(sizeUnit, rateUnit) + ANSI_RESET);
                    incorrectChoice = false;
                    break;

                case "3":
                    System.out.println("Please enter the number of page views between a range above 0.\n" +
                            "Then when prompted, please enter the appropriate time unit for the page views.\nYou will then be asked for " +
                            "the average page size between the range above 0.\nThen when prompted, please enter the appropriate " +
                            "data units for the page size.\nYou will then be prompted to enter a redundancy factor of 1 or higher.\n" +
                            "Enter r to go back to the main menu. ");
                    String pageViews;

                    incorrectValue = true;

                    double pageViewValue = 0;
                    while (incorrectValue) {
                        System.out.print(ANSI_PURPLE + "Enter the number of page views: " + ANSI_RESET);
                        pageViews = input.next();
                        if (pageViews.toLowerCase().equals("r")) {
                            return;
                        }

                        try {
                            pageViewValue = Double.parseDouble(pageViews);
                            incorrectValue = false;
                        } catch (NumberFormatException e) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            continue;
                        }

                        if (pageViewValue < 0) {
                            System.out.println(ANSI_RED + "Please stay within the appropriate range! " +
                                    "Please enter a new value or r to go to the main menu." + ANSI_RESET);
                            incorrectValue = true;
                        }
                    }

                    System.out.print(ANSI_PURPLE + "Enter the time unit for page views (enter L to list the possible keywords): " + ANSI_RESET);
                    String timeUnit = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (timeUnit.toLowerCase().equals("r")) {
                            return;
                        } else if (timeUnit.toLowerCase().equals("l")) {
                            System.out.println(ANSI_GREEN + "Accepted keywords(case insensitive):\n'perSecond', 'perMinute', 'perHour', 'perDay', 'perWeek'" +
                                    ", 'perMonth', 'perYear'" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the time unit for page views: " + ANSI_RESET);
                            timeUnit = input.next();
                        } else if (Utils.isValidTimeUnits(timeUnit)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the time unit for page views: " + ANSI_RESET);
                            timeUnit = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    String avgPageSize;
                    incorrectValue = true;

                    double avgPageSizeValue = 0;
                    while (incorrectValue) {
                        System.out.print(ANSI_PURPLE + "Enter the average page size: " + ANSI_RESET);
                        avgPageSize = input.next();

                        if (avgPageSize.toLowerCase().equals("r")) {
                            return;
                        }

                        try {
                            avgPageSizeValue = Double.parseDouble(avgPageSize);
                            incorrectValue = false;
                        } catch (NumberFormatException e) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            continue;
                        }

                        if (avgPageSizeValue < 0) {
                            System.out.println(ANSI_RED + "Please stay within the appropriate range! " +
                                    "Please enter a new value or r to go to the main menu." + ANSI_RESET);
                            incorrectValue = true;
                        }
                    }

                    System.out.print(ANSI_PURPLE + "Enter the data unit for page size (enter L to list the possible keywords): " + ANSI_RESET);
                    String unitForPageSize = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (unitForPageSize.toLowerCase().equals("r")) {
                            return;
                        } else if (unitForPageSize.toLowerCase().equals("l")) {
                            System.out.println(ANSI_GREEN + "Accepted keywords(case insensitive):\n'Bytes', " +
                                    "'Kilobytes', 'Megabytes', 'Gigabytes', 'Terabytes'" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit for page size: " + ANSI_RESET);
                            unitForPageSize = input.next();
                        } else if (Utils.isValidBottomKeywords(unitForPageSize)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit for page size: " + ANSI_RESET);
                            unitForPageSize = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    String redundancy;
                    incorrectValue = true;

                    double redundancyValue = 0;
                    while (incorrectValue) {
                        System.out.print(ANSI_PURPLE + "Enter the redundancy factor: " + ANSI_RESET);
                        redundancy = input.next();
                        if (redundancy.toLowerCase().equals("r")) {
                            return;
                        }

                        try {
                            redundancyValue = Double.parseDouble(redundancy);
                            incorrectValue = false;
                        } catch (NumberFormatException e) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            continue;
                        }

                        if (redundancyValue < 1) {
                            System.out.println(ANSI_RED + "Please stay within the appropriate range! " +
                                    "Please enter a new value or r to go to the main menu." + ANSI_RESET);
                            incorrectValue = true;
                        }
                    }

                    size = switch (unitForPageSize.toLowerCase()) {
                        case "bytes" -> Size.BYTE;
                        case "kilobytes" -> Size.KILOBYTE;
                        case "megabytes" -> Size.MEGABYTE;
                        case "gigabytes" -> Size.GIGABYTE;
                        case "terabytes" -> Size.TERABYTE;
                        default -> throw new IllegalStateException("Unexpected value: " + unitForPageSize.toLowerCase());
                    };

                    Frequency frequency = switch (timeUnit.toLowerCase()) {
                        case "persecond" -> Frequency.SECOND;
                        case "perminute" -> Frequency.MINUTE;
                        case "perhour" -> Frequency.HOUR;
                        case "perday" -> Frequency.DAY;
                        case "perweek" -> Frequency.WEEK;
                        case "permonth" -> Frequency.MONTH;
                        case "peryear" -> Frequency.YEAR;
                        default -> throw new IllegalStateException("Unexpected value: " + timeUnit.toLowerCase());
                    };

                    sizeUnit = new SizeUnit(size, avgPageSizeValue);
                    FrequencyUnit frequencyUnit = new FrequencyUnit(frequency, pageViewValue);

                    System.out.println(ANSI_YELLOW + WebsiteBandwidthCalculator.calculate(sizeUnit, frequencyUnit, redundancyValue) + ANSI_RESET);
                    incorrectChoice = false;
                    break;

                case "4":
                    System.out.println("Please enter the monthly usage with a value of anything above 1 or 0 to convert from bandwidth to monthly usage.\n" +
                            "Then when prompted, please enter the appropriate data unit for the monthly usage. \n" +
                            "You will then be prompted to type in the value of bandwidth between anything above 1 or 0 to convert from monthly usage to bandwidth.\n" +
                            "You will then be prompted to type in the appropriate bandwidth" +
                            " unit that you wish to convert to.\nEnter r to go back to the main menu.");
                    String monthlyUsage;

                    incorrectValue = true;

                    double monthlyUsageValue = 0;
                    while (incorrectValue) {
                        System.out.print(ANSI_PURPLE + "Enter the monthly usage (enter 0 if you wish to convert from bandwidth to monthly usage): " + ANSI_RESET);
                        monthlyUsage = input.next();
                        if (monthlyUsage.toLowerCase().equals("r")) {
                            return;
                        }

                        try {
                            monthlyUsageValue = Double.parseDouble(monthlyUsage);
                            incorrectValue = false;
                        } catch (NumberFormatException e) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            continue;
                        }

                        if (monthlyUsageValue < 0) {
                            System.out.println(ANSI_RED + "Please stay within the appropriate range! " +
                                    "Please enter a new value or r to go to the main menu." + ANSI_RESET);
                            incorrectValue = true;
                        }
                    }

                    System.out.print(ANSI_PURPLE + "Enter the data unit for monthly usage (enter L to list the possible keywords): ");
                    String monthlyData = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (monthlyData.toLowerCase().equals("r")) {
                            return;
                        } else if (monthlyData.toLowerCase().equals("l")) {
                            System.out.println(ANSI_GREEN + "Accepted keywords(case insensitive):\n'Bytes', " +
                                    "'Kilobytes', 'Megabytes', 'Gigabytes', 'Terabytes'" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit for monthly usage: ");
                            monthlyData = input.next();
                        } else if (Utils.isValidBottomKeywords(monthlyData)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit for monthly usage: ");
                            monthlyData = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    String b;

                    incorrectValue = true;

                    double bandwidthValue = 0;
                    while (incorrectValue) {
                        System.out.print(ANSI_PURPLE + "Please enter the bandwidth (enter 0 if you wish to convert from" +
                                " monthly usage to bandwidth): " + ANSI_RESET);
                        b = input.next();

                        try {
                            bandwidthValue = Double.parseDouble(b);
                            incorrectValue = false;
                        } catch (NumberFormatException e) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            continue;
                        }

                        if (bandwidthValue < 0) {
                            System.out.println(ANSI_RED + "Please stay within the appropriate range! " +
                                    "Please enter a new value or r to go to the main menu." + ANSI_RESET);
                            incorrectValue = true;
                        }
                    }

                    System.out.print(ANSI_PURPLE + "Enter the data unit for bandwidth (enter L to list the possible keywords): " + ANSI_RESET);
                    String bandwidthUnit = input.next();

                    incorrectValue = true;
                    while (incorrectValue) {
                        if (bandwidthUnit.toLowerCase().equals("r")) {
                            return;
                        } else if (bandwidthUnit.toLowerCase().equals("l")) {
                            System.out.println(ANSI_GREEN + "Accepted keywords(case insensitive):\n'bit/s', 'Kbit/s', " +
                                    "'Mbit/s', 'Gbit/s', 'Tbit/s'" + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit for bandwidth: " + ANSI_RESET);
                            bandwidthUnit = input.next();
                        } else if (Utils.isValidUnitPerTimeKeywords(bandwidthUnit)) {
                            System.out.println(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                            System.out.print(ANSI_PURPLE + "Enter the data unit for bandwidth: " + ANSI_RESET);
                            bandwidthUnit = input.next();
                        } else {
                            incorrectValue = false;
                        }
                    }

                    size = switch (monthlyData.toLowerCase()) {
                        case "bytes" -> Size.BYTE;
                        case "kilobytes" -> Size.KILOBYTE;
                        case "megabytes" -> Size.MEGABYTE;
                        case "gigabytes" -> Size.GIGABYTE;
                        case "terabytes" -> Size.TERABYTE;
                        default -> throw new IllegalStateException("Unexpected value: " + monthlyData.toLowerCase());
                    };

                    rate = switch (bandwidthUnit.toLowerCase()) {
                        case "bit/s" -> Rate.BITpS;
                        case "kbit/s" -> Rate.KBITpS;
                        case "mbit/s" -> Rate.MBITpS;
                        case "gbit/s" -> Rate.GBITpS;
                        case "tbit/s" -> Rate.TBITpS;
                        default -> throw new IllegalStateException("Unexpected value: " + bandwidthUnit.toLowerCase());
                    };

                    sizeUnit = new SizeUnit(size, monthlyUsageValue);
                    rateUnit = new RateUnit(rate, bandwidthValue);

                    System.out.println(ANSI_YELLOW + Converter.convertHostingBandwidth(sizeUnit, rateUnit) + ANSI_RESET);

                    incorrectChoice = false;
                    break;
                case "R":
                    return;
                case "Q":
                    runCalculator = false;
                    return;
                default:
                    System.out.print(ANSI_RED + INCORRECT_INPUT + ANSI_RESET);
                    hexChoice = input.next().toUpperCase();
                    break;
            }
        }
    }

}
