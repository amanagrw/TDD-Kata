package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String numbersWithoutDelimiter = numbers;

        if (numbers.startsWith("//")) {
            Matcher m = Pattern.compile("//(\\[.*?\\])+\n").matcher(numbers);
            if (m.find()) {
                delimiter = "";
                Matcher dm = Pattern.compile("\\[(.*?)]").matcher(m.group());
                while (dm.find()) {
                    delimiter += Pattern.quote(dm.group(1)) + "|";
                }
                delimiter = delimiter.substring(0, delimiter.length() - 1);
                numbersWithoutDelimiter = numbers.substring(m.end());
            } else {
                delimiter = Pattern.quote(numbers.substring(2, 3));
                numbersWithoutDelimiter = numbers.substring(4);
            }
        }

        String[] numberArray = numbersWithoutDelimiter.split(delimiter);
        return calculateSum(numberArray);
    }

    private int calculateSum(String[] numberArray) {
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;
        for (String number : numberArray) {
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    negativeNumbers.add(num);
                } else if (num <= 1000) {
                    sum += num;
                }
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }

        return sum;
    }
}