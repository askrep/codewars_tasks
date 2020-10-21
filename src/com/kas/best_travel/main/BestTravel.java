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

    private static int close_sum = 0;

    public static void main(String[] args) {
        // write your code here
        int distance = 230; // >=0
        int comb = 3; // >=1
        List<Integer> ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87)); // size >=1

        chooseBestSum(distance, comb, ts);
        System.out.println("\nNumber of comb = " + getNumberCombinations(ts.size(), comb));

    }

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        ArrayList<Integer> list = new ArrayList<>();
        if (ls.size() <= 1 || k < 1 || t < 0) return null;
        Integer result = getNextPairRecursive(t, k, ls, 0, 1, list);
        if (result > t) return null;
        return result;
    }

    private static Integer getNextPairRecursive(int distance, int comb, List<Integer> ls, int start, int count, List<Integer> elements) {

        if (count < comb) { // recursively call while looking for the last element
            for (int index = start; index <= ls.size() - (comb - count); index++) {
                elements.add(ls.get(index));
                Integer result_sum = getNextPairRecursive(distance, comb, ls, index + 1, count + 1, elements);
                elements.remove(elements.size() - 1);

                if (result_sum == distance) return distance;
                else if (result_sum > close_sum) close_sum = result_sum; //looking for close smaller number
            }
        } else if (count == comb) { //when this is last item of combination
            for (int i = start; i < ls.size(); i++) {
                elements.add(ls.get(i));
                Integer sum = getSumDistances(elements);

                elements.remove(elements.size() - 1);

                if (sum == distance) return distance;
                else if (sum < distance) return sum;
            }
        }
        return close_sum;
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
