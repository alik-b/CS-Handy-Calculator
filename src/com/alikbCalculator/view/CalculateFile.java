package com.alikbCalculator.view;

import com.alikbCalculator.controller.*;
import com.alikbCalculator.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class takes in a file and reads the file and based on the valid keywords that it finds
 * it will do the necessary calculations and output the result onto a new file.
 *
 * @author Alik Balika
 * @version 2020.11.04
 */
public class CalculateFile {

    /**
     * Tests if the file is valid and if it is, it does all the necessary operations
     * based on the keywords that it finds. If it cannot read a line, it will
     * output an error message.
     *
     * @param fileToSelect string that user passes as a file
     * @throws FileNotFoundException if file is typed wrong or not found
     */
    public static void calculate(String fileToSelect, String fileToSave) throws FileNotFoundException {
        // Use PrintStream to write to a new file
        File file = new File(fileToSelect);

        Scanner input = new Scanner(file);

        File newFile = new File(fileToSave);

        PrintStream out = new PrintStream(newFile);

        double x;
        double y;

        while (input.hasNextLine()) {
            String nextLine = input.nextLine();
            String[] tokens = nextLine.split(" ");

            // testing the scanner
            if (nextLine.startsWith("//")) {
                continue;
            }
            if (nextLine.isEmpty()) {
                continue;
            }

            // test for binary inputs
            if (nextLine.toLowerCase().contains("convert binary to decimal")) {
                if (!Utils.isBinary(tokens[tokens.length - 1])) {
                    out.println("There was an error with the line.");
                    continue;
                }
                Binary binary = new Binary(tokens[tokens.length - 1]);
                out.println("The decimal value of " + binary + " is " + binary.toDecimal());

            } else if (nextLine.toLowerCase().contains("convert decimal to binary")) {
                try {
                    Decimal decimal = new Decimal(Long.parseLong(tokens[tokens.length - 1]));
                    out.println("The binary value of " + decimal + " is " + decimal.toBinary());
                } catch (NumberFormatException e) {
                    out.println("There was an error with the line.");
                }

            } else if (nextLine.toLowerCase().contains("calculate binary")) {
                String binary1;
                String binary2;
                String operator;
                try {
                    binary1 = tokens[tokens.length - 2];
                    binary2 = tokens[tokens.length - 1];
                    operator = tokens[tokens.length - 3];
                } catch (ArrayIndexOutOfBoundsException e) {
                    out.println("There was an error with the line.");
                    continue;
                }
                if ((!Utils.isBinary(binary1) && !Utils.isBinary(binary2)) ||
                        (!Utils.isBinary(binary1) && Utils.isBinary(binary2)) ||
                        (Utils.isBinary(binary1) && !Utils.isBinary(binary2)) || Utils.isOperator(operator)) {
                    out.println("There was an error with the line.");
                    continue;
                }

                Binary b1 = new Binary(binary1);
                Binary b2 = new Binary(binary2);

                switch (operator) {
                    case "+":
                        out.println(b1 + " + " + b2 + " = " + MainCLI.bc.add(b1, b2));
                        break;
                    case "-":
                        out.println(b1 + " - " + b2 + " = " + MainCLI.bc.subtract(b1, b2));
                        break;
                    case "/":
                        if (b2.toDecimal() == 0) {
                            out.println("You cannot divide by zero!");
                        } else {
                            out.println(b1 + " / " + b2 + " = " + MainCLI.bc.divide(b1, b2));
                        }
                        break;
                    case "*":
                        out.println(b1 + " * " + b2 + " = " + MainCLI.bc.multiply(b1, b2));
                        break;
                    default:
                        out.println("There was an error with the line.");
                }

                // test for hexadecimal inputs
            } else if (nextLine.toLowerCase().contains("convert hexadecimal to decimal")) {
                if (!Utils.isHex(tokens[tokens.length - 1])) {
                    out.println("There was an error with the line.");
                    continue;
                }

                Hex hex = new Hex(tokens[tokens.length - 1]);

                out.println("The decimal value of " + hex + " is " + hex.toDecimal());

            } else if (nextLine.toLowerCase().contains("convert decimal to hexadecimal")) {
                try {
                    Decimal decimal = new Decimal(Long.parseLong(tokens[tokens.length - 1]));
                    out.println("The hex value of " + decimal + " is " + decimal.toHex());
                } catch (NumberFormatException e) {
                    out.println("There was an error with the line.");
                }

            } else if (nextLine.toLowerCase().contains("calculate hexadecimal")) {
                String hex1;
                String hex2;
                String operator;
                try {
                    hex1 = tokens[tokens.length - 2];
                    hex2 = tokens[tokens.length - 1];
                    operator = tokens[tokens.length - 3];
                } catch (ArrayIndexOutOfBoundsException e) {
                    out.println("There was an error with the line.");
                    continue;
                }
                if ((!Utils.isHex(hex1) && !Utils.isHex(hex2)) || (!Utils.isHex(hex1) && Utils.isHex(hex2)) ||
                        (Utils.isHex(hex1) && !Utils.isHex(hex2)) || Utils.isOperator(operator)) {
                    out.println("There was an error with the line.");
                    continue;
                }

                Hex h1 = new Hex(hex1);
                Hex h2 = new Hex(hex2);

                switch (operator) {
                    case "+":
                        out.println(h1 + " + " + h2 + " = " + MainCLI.hc.add(h1, h2));
                        break;
                    case "-":
                        out.println(h1 + " - " + h2 + " = " + MainCLI.hc.subtract(h1, h2));
                        break;
                    case "/":
                        if (h2.toDecimal() == 0) {
                            out.println("You cannot divide by zero!");
                        } else {
                            out.println(h1 + " / " + h2 + " = " + MainCLI.hc.divide(h1, h2));
                        }
                        break;
                    case "*":
                        out.println(h1 + " * " + h2 + " = " + MainCLI.hc.multiply(h1, h2));
                        break;
                    default:
                        out.println("There was an error with the line.");
                }

                // test for bandwidth inputs
            } else if (nextLine.toLowerCase().contains("convert data unit to")) {

                // I'm going to assume this works like the website calculator where you input a number and then
                // you input the data unit for that number. So 543.5 Megabytes would output all the equivalent
                // information for the other data types
                try {
                    x = Double.parseDouble(tokens[tokens.length - 1]);
                } catch (NumberFormatException e) {
                    out.println("There was an error with the line.");
                    continue;
                }

                if (Utils.isValidAllKeyword(tokens[tokens.length - 2]) || x > 1000 || x < 1) {
                    out.println("There was an error with the line.");
                } else {
                    Size size = switch (tokens[tokens.length - 2].toLowerCase()) {
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
                        default -> throw new IllegalStateException("Unexpected value: " + tokens[tokens.length - 2].toLowerCase());
                    };
                    SizeUnit sizeUnit = new SizeUnit(size, x);
                    out.println(Converter.convertDataUnit(sizeUnit));
                }

            } else if (nextLine.toLowerCase().contains("calculate download/upload time")) {

                try {
                    x = Double.parseDouble(tokens[tokens.length - 4]);
                    y = Double.parseDouble(tokens[tokens.length - 2]);
                } catch (NumberFormatException e) {
                    out.println("There was an error with the line.");
                    continue;
                }
                if (Utils.isValidBottomKeywords(tokens[tokens.length - 3]) || Utils.isValidUnitPerTimeKeywords(tokens[tokens.length - 1])
                        || x < 1 || x > 1000 || y < 1 || y > 1000) {
                    out.println("There was an error with the line.");
                } else {
                    Size size = switch (tokens[tokens.length - 3].toLowerCase()) {
                        case "bytes" -> Size.BYTE;
                        case "kilobytes" -> Size.KILOBYTE;
                        case "megabytes" -> Size.MEGABYTE;
                        case "gigabytes" -> Size.GIGABYTE;
                        case "terabytes" -> Size.TERABYTE;
                        default -> throw new IllegalStateException("Unexpected value: " + tokens[tokens.length - 2].toLowerCase());
                    };
                    Rate rate = switch (tokens[tokens.length - 1].toLowerCase()) {
                        case "bit/s" -> Rate.BITpS;
                        case "kbit/s" -> Rate.KBITpS;
                        case "mbit/s" -> Rate.MBITpS;
                        case "gbit/s" -> Rate.GBITpS;
                        case "tbit/s" -> Rate.TBITpS;
                        default -> throw new IllegalStateException("Unexpected value: " + tokens[tokens.length - 1].toLowerCase());
                    };
                    SizeUnit sizeUnit = new SizeUnit(size, x);
                    RateUnit rateUnit = new RateUnit(rate, y);
                    out.println("The approximate download/upload time is: ");
                    out.println(DownloadUploadTimeCalculator.calculate(sizeUnit, rateUnit));
                }

            } else if (nextLine.toLowerCase().contains("calculate website bandwidth")) {
                double z;
                try {
                    x = Double.parseDouble(tokens[tokens.length - 6]);
                    y = Double.parseDouble(tokens[tokens.length - 3]);
                    z = Double.parseDouble(tokens[tokens.length - 1]);
                } catch (Exception e) {
                    out.println("There was an error with the line.");
                    continue;
                }

                String time = tokens[tokens.length - 5] + " " + tokens[tokens.length - 4];
                if (Utils.isValidTimeUnits(time) ||
                        Utils.isValidBottomKeywords(tokens[tokens.length - 2]) || x < 1 || x > 1000 || y < 1 ||
                        y > 1024 || z < 1 || z > 10) {
                    out.println("There was an error with the line.");
                } else {
                    Size size = switch (tokens[tokens.length - 2].toLowerCase()) {
                        case "bytes" -> Size.BYTE;
                        case "kilobytes" -> Size.KILOBYTE;
                        case "megabytes" -> Size.MEGABYTE;
                        case "gigabytes" -> Size.GIGABYTE;
                        case "terabytes" -> Size.TERABYTE;
                        default -> throw new IllegalStateException("Unexpected value: " + tokens[tokens.length - 2].toLowerCase());
                    };

                    Frequency frequency = switch (time.toLowerCase()) {
                        case "per second" -> Frequency.SECOND;
                        case "per minute" -> Frequency.MINUTE;
                        case "per hour" -> Frequency.HOUR;
                        case "per day" -> Frequency.DAY;
                        case "per week" -> Frequency.WEEK;
                        case "per month" -> Frequency.MONTH;
                        case "per year" -> Frequency.YEAR;
                        default -> throw new IllegalStateException("Unexpected value: " + time.toLowerCase());
                    };
                    SizeUnit sizeUnit = new SizeUnit(size, x);
                    FrequencyUnit frequencyUnit = new FrequencyUnit(frequency, y);
                    out.println(WebsiteBandwidthCalculator.calculate(sizeUnit, frequencyUnit, z));
                }

            } else if (nextLine.toLowerCase().contains("convert monthly usage to bandwidth")) {
                // assume that user has to enter 0 for one or the other value or else it will output an error line
                try {
                    x = Double.parseDouble(tokens[tokens.length - 4]);
                    y = Double.parseDouble(tokens[tokens.length - 2]);
                } catch (NumberFormatException e) {
                    out.println("There was an error with the line.");
                    continue;
                }

                if (Utils.isValidBottomKeywords(tokens[tokens.length - 3]) || Utils.isValidUnitPerTimeKeywords(tokens[tokens.length - 1]) ||
                        x < 0 || x > 1000 || y < 0 || y > 1000) {
                    out.println("There was an error with the line.");
                } else {
                    Size size = switch (tokens[tokens.length - 3].toLowerCase()) {
                        case "bytes" -> Size.BYTE;
                        case "kilobytes" -> Size.KILOBYTE;
                        case "megabytes" -> Size.MEGABYTE;
                        case "gigabytes" -> Size.GIGABYTE;
                        case "terabytes" -> Size.TERABYTE;
                        default -> throw new IllegalStateException("Unexpected value: " + tokens[tokens.length - 3].toLowerCase());
                    };

                    Rate rate = switch (tokens[tokens.length - 1].toLowerCase()) {
                        case "bit/s" -> Rate.BITpS;
                        case "kbit/s" -> Rate.KBITpS;
                        case "mbit/s" -> Rate.MBITpS;
                        case "gbit/s" -> Rate.GBITpS;
                        case "tbit/s" -> Rate.TBITpS;
                        default -> throw new IllegalStateException("Unexpected value: " + tokens[tokens.length - 1].toLowerCase());
                    };
                    SizeUnit sizeUnit = new SizeUnit(size, x);
                    RateUnit rateUnit = new RateUnit(rate, y);
                    out.println(Converter.convertHostingBandwidth(sizeUnit, rateUnit));
                }

            } else {
                out.println("There was an error with the line.");
            }
            out.println();
        }
        out.println();
//        Scanner test = new Scanner(new File("output.txt"));
//        while (test.hasNextLine()) {
//            System.out.println(test.nextLine());
//        }
    }
}
