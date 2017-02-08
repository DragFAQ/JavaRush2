package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            String numString = reader.readLine();
            int num = Integer.parseInt(numString);
            if (num == -1)
                break;
            list.add(num);
        }
        reader.close();

        double avg = 0;
        for (Integer i : list)
            avg += i;

        System.out.println(avg / list.size());
    }
}

