package com.company;

import java.util.PriorityQueue;

public class Cast {
    public static String[] arrCast;

    public static String[] listToStringArray(List list) {
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.getString(i);
        }
        return arr;
    }

    public static Object[] queueToStringArray(PriorityQueue priorityQueue) {
        Object[] arr = priorityQueue.toArray();
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = (String) arr[i];
        }

        return arr;
    }
}
