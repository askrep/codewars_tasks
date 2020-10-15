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

    public static void main(String[] args) {
        // write your code here

        int comb = 3;


        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58, 54));

        System.out.println("\nNumber of comb = " + getNumberCombinations(ts.size(), comb));
        chooseBestSum(6, 2, ts);

    }

    public static Integer chooseBestSum(int dist, int comb, List<Integer> ls) {
        ArrayList<Integer> list = new ArrayList<>();
        getNextPair(0, 1, comb, ls, list);
        return null;
    }

    static void getNextPair(int start, int count, int comb, List<Integer> ls, List list) {
        list.add(start);

        StringBuilder sb = new StringBuilder("");
        for (int j = 1; j <= start; j++) {
            sb.append("----");
        }
        sb.append("s=");

        if (count < comb) {
            for (int i = start; i < ls.size() - count; i++) {
                int s = i + 1;
                int c = count + 1;
                System.out.print("\n" + sb.toString() + start + ";");
                getNextPair(s, c, comb, ls, list);
            }

        } else if (count == comb) {
            System.out.print("\n" + sb.toString());
            for (int i = start; i < ls.size(); i++) {
                System.out.print(" ." + i);
            }
            return;
        }
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
