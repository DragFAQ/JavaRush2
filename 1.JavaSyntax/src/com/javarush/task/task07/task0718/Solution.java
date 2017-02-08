package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int lastLen = 0;
        int failIdx = -1;

        for (int i = 0; i < 10; i++) {
            String str = reader.readLine();
            list.add(str);
            if (str.length() < lastLen && failIdx == -1)
                failIdx = i;
            lastLen = str.length();
        }

        if (failIdx != -1)
            System.out.println(failIdx);
    }
}

