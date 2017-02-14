package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        final double median;
        if (array.length % 2 == 0)
            median = ((double) array[array.length / 2 - 1] + (double) array[array.length / 2]) / 2;
        else
            median = array[array.length / 2];

        Comparator<Integer> compareByMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - median) - Math.abs(o2 - median) == 0)
                    return o1 - o2;
                else
                    return (int) (Math.abs(o1 - median) - Math.abs(o2 - median));
            }
        };

        Arrays.sort(array, compareByMedian);

        return array;
    }
}
