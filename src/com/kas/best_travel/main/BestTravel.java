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
    private static int close_sum = 0;
    private static Integer fin_sum = 0;

    public static void main(String[] args) {
        // write your code here
        int dist = 230; // >=0
        int comb = 3; // >=1
        List<Integer> ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87)); // size >=1

        chooseBestSum(dist, comb, ts);
        System.out.println("\nNumber of comb = " + getNumberCombinations(ts.size(), comb));
        System.out.println("TEST=" + testCount);
    }

    public static Integer chooseBestSum(int dist, int comb, List<Integer> ls) {
        ArrayList<Integer> list = new ArrayList<>();
        if (ls.size() == 1) return null;
        return (Integer) getNextPairRecursive(dist, comb, ls, 0, 1, list);
    }

    static Integer getNextPairRecursive(int dist, int comb, List<Integer> ls, int start, int count, List<Integer> elements) {

        if (count < comb) { // recursively call while looking for the last element
            for (int index = start; index <= ls.size() - (comb - count); index++) {
                elements.add(ls.get(index));
                //System.out.print(index);
                fin_sum = getNextPairRecursive(dist, comb, ls, index + 1, count + 1, elements);
                elements.remove(elements.size() - 1);

                if (fin_sum == dist) return dist;
                else if (fin_sum > close_sum) close_sum = fin_sum;

            }
        } else if (count == comb) { //when this is last item of combination
            for (int i = start; i < ls.size(); i++) {
                testCount++; //for test , delme
                System.out.println("\nIndex of last=" + i); //for test , delme

                elements.add(ls.get(i));
                Integer sum = getSumDistances(elements);

                System.out.println(" :sum[" + i + "]=" + sum);

                elements.remove(elements.size() - 1);

                if (sum == dist) return dist;
                if (sum < dist) return sum;
            }
        }
        return 0;
    }

    private static Integer getSumDistances(List<Integer> list) {

        return list.stream().reduce(0, Integer::sum);
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
