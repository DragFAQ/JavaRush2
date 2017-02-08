package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int maxSeq = 0;
        int curSeq = 0;
        int lastNum = 0;

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(reader.readLine());
            list.add(num);
            if (i == 0)
                lastNum = num;
            if (lastNum == num)
                curSeq ++;
            else
            {
                maxSeq = curSeq > maxSeq ? curSeq : maxSeq;
                curSeq = 1;
                lastNum = num;
            }
        }
        maxSeq = curSeq > maxSeq ? curSeq : maxSeq;

        System.out.println(maxSeq);
    }
}