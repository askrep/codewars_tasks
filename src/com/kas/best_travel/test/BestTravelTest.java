package com.kas.best_travel.test;

import com.kas.best_travel.main.BestTravel;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BestTravelTest {

    @Test
    public void test_1() {
         List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = BestTravel.chooseBestSum(163, 3, ts);
        assertEquals(163, n);
    }

    @Test
    public void test_2(){
        List<Integer> ts = new ArrayList<>(Arrays.asList(50));
        Integer m = BestTravel.chooseBestSum(163, 3, ts);
        assertEquals(null, m);
    }

    @Test
    public void test_3(){
        List<Integer> ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        int n = BestTravel.chooseBestSum(230, 3, ts);
        assertEquals(228, n);
    }

}
