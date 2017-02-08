package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            String str = reader.readLine();
            minLen = str.length() < minLen ? str.length() : minLen;
            maxLen = str.length() > maxLen ? str.length() : maxLen;
            list.add(str);
        }

        for (String s : list)
        {
            if (s.length() == minLen || s.length() == maxLen) {
                System.out.println(s);
                break;
            }
        }
    }
}
