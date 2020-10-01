package com.kas.best_travel.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
John and Mary want to travel between a few towns A, B, C ...
 Mary has on a sheet of paper a list of distances between these towns.
 ls = [50, 55, 57, 58, 60]. John is tired of driving and he says to Mary that
 he doesn't want to drive more than t = 174 miles and he will visit only 3 towns.

 ts = [50, 55, 56, 57, 58] choose_best_sum(163, 3, ts) -> 163
 xs = [50] choose_best_sum(163, 3, xs) -> null
 ys = [91, 74, 73, 85, 73, 81, 87] choose_best_sum(230, 3, ys) -> 228

 Note: don't modify the input list ls
*/

public class BestTravel {
    public static void main(String[] args) {
        // write your code here
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        System.out.println(chooseBestSum(163, 3, ts));
    }
    public static Integer chooseBestSum(int i, int i1, List<Integer> ls) {

        return null;
    }

}
