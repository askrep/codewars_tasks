package com.kas.best_travel.main;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * John and Mary want to travel between a few towns A, B, C ...
 * Mary has on a sheet of paper a list of distances between these towns.
 * ls = [50, 55, 57, 58, 60]. John is tired of driving and he says to Mary that
 * he doesn't want to drive more than t = 174 miles and he will visit only 3 towns.
 * <p>
 * ts = [50, 55, 56, 57, 58] choose_best_sum(163, 3, ts) -> 163
 * xs = [50] choose_best_sum(163, 3, xs) -> null
 * ys = [91, 74, 73, 85, 73, 81, 87] choose_best_sum(230, 3, ys) -> 228
 * <p>
 * Note: don't modify the input list ls
 */

public class BestTravel {
    private static int length;
    private static StringBuilder sb;

    public static void main(String[] args) {
        // write your code here
        int size = 5;
        int comb = 2;

        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        chooseBestSum(5, comb, ts);


        length = ts.size();

        System.out.println("\nNumber of comb = " + getNumberCombinations(size, comb));


    }

    public static Integer chooseBestSum(int dist, int comb, List<Integer> ls) {

        for (int index = 0; index < comb; index++) { //перебор по индексу элемента комбинации

            for (int j = 0; j < ls.size() - 1; j++) {
                getLastPairComb(j, comb - index, ls);
            }
        }

        return null;
    }

    private static void getLastPairComb(int start, int count, List<Integer> ls) {

        if (count == 1) {
            for (int j = start + 1; j < ls.size(); j++) {
                System.out.print(" " + start + "." + j);
            }
            System.out.println("");
        } else getLastPairComb(start + 1, count - 1, ls);

    }

    static int getNumberCombinations(int n, int k) {
        BigInteger a1 = factorialResult(n);
        BigInteger a2 = factorialResult(k);
        BigInteger a3 = factorialResult(n - k);

        return a1.divide(a2.multiply(a3)).intValue();
    }

    static BigInteger factorialResult(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
