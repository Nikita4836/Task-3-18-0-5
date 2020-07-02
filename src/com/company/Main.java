package com.company;

import java.util.Locale;
import java.util.PriorityQueue;

public class Main {
   public static PriorityQueue <String> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                (new Window()).setVisible(true);
            }
        });

        List list = new List();
        priorityQueue.comparator();
        Object[] a = priorityQueue.toArray();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        Cast.queueToStringArray(priorityQueue);
    }

    public static String[] process(String[] arr) {
        for (int i = 0; i < Cast.queueToStringArray(priorityQueue).length; i++) {
            System.out.println(Cast.queueToStringArray(priorityQueue)[i]);
        }
        List.arrayToList(arr).sort();
        return arr;
    }
}
