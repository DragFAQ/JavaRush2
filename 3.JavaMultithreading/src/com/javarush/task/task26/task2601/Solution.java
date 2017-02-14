package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        for (Integer i : sort(new Integer[]{13, 8, 15, 5, 17, 11}))
            System.out.println(i);
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));

        Comparator<Integer> compareByMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - 13) - Math.abs(o2 - 13) == 0)
                    return o1 - o2;
                else
                    return Math.abs(o1 - 13) - Math.abs(o2 - 13);
            }
        };

        Collections.sort(list, compareByMedian);

        array = new Integer[list.size()];
        array = list.toArray(array);
        return array;
    }
}
