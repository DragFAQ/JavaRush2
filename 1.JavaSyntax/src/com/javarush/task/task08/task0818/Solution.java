package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> result = new HashMap<>();

        result.put("FIO1", 100);
        result.put("FIO2", 200);
        result.put("FIO3", 300);
        result.put("FIO4", 400);
        result.put("FIO5", 500);
        result.put("FIO6", 600);
        result.put("FIO7", 700);
        result.put("FIO8", 800);
        result.put("FIO9", 900);
        result.put("FIO10", 1000);

        return result;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();

        while (itr.hasNext())
        {
            if (itr.next().getValue() < 500)
                itr.remove();
        }
    }

    public static void main(String[] args) {
        removeItemFromMap(createMap());
    }
}