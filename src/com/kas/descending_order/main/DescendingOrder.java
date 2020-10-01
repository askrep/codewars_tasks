package com.kas.descending_order.main;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;

public class DescendingOrder {
    /**
     * Your task is to make a function that can take any non-negative
     * integer as an argument and return it with its digits in descending order.
     * Essentially, rearrange the digits to create the highest possible number.
     * <p>
     * Examples:
     * Input: 42145 Output: 54421
     * Input: 145263 Output: 654321
     * Input: 123456789 Output: 987654321
     */

    public static void main(String[] args) {
        // write your code here
        sortDesc(123456789);
    }

    public static int sortDesc(int i) {
        String result = Integer.toString(i).chars()
                .boxed()
                .map(obj -> String.valueOf(obj - '0'))
                .sorted(reverseOrder())
                .collect(Collectors.joining());

/*        String result = intStream
                .boxed()
                .sorted(reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());*/


        System.out.println(result);

        return Integer.valueOf(result);
    }
}
