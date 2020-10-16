package com.kas.best_travel.main;

import java.math.BigInteger;
import java.util.*;

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
    static int testCount = 0; // test: to compare the number of items

    public static void main(String[] args) {
        // write your code here
        int comb = 4;

        List<Integer> ts = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1));

        chooseBestSum(6, comb, ts);
        System.out.println("\nNumber of comb = " + getNumberCombinations(ts.size(), comb));
        System.out.println("TEST=" + testCount);
    }

    public static Integer chooseBestSum(int dist, int comb, List<Integer> ls) {
        ArrayList<Integer> list = new ArrayList<>();

        getNextPairRecursive(0, 1, comb, ls, list);
        return null;
    }

    static void getNextPairRecursive(int start, int count, int comb, List<Integer> ls, List<Integer> list) {
        StringBuilder sb = new StringBuilder("");

        if (count < comb) { // recursively call while looking for the last element
            for (int index = start; index <= ls.size() - (comb - count); index++) {

                //System.out.print("." + sb.toString() + index + "; ");

                list.add(ls.get(index));
                getNextPairRecursive(index + 1, count + 1, comb, ls, list);

                list.remove(list.size() - 1);
            }

        } else if (count == comb) { //when this is last item of combination
            //System.out.print("\n" + sb.toString());

            for (int i = start; i < ls.size(); i++) {
                testCount++;
                list.add(ls.get(i));

                System.out.println(" :sum[" + i + "]=" + getSumDistances(list));
                list.remove(list.size() - 1);
            }

           // System.out.print("\n");
            return;
        }
    }

    private static Integer getSumDistances(List<Integer> list) {

        return list.stream().reduce(0, (a, b) -> a + b);
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
