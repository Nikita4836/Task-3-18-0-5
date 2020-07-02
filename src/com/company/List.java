package com.company;


import java.util.ArrayList;

public class List {
    private LinkList head;
    public static java.util.List<String> list = new ArrayList<String>();
    public static String[] arr;
    public List() {
        head = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void add(String data) {
        LinkList temp = new LinkList(data);
        temp.next = head;
        head = temp;
    }

    public void addString(String sData) {
        LinkList temp = new LinkList(sData);
        temp.next = head;
        head = temp;
    }

    public void remove(int key) {
        LinkList cur = head;
        LinkList prev = null;
        int cout = 0;
        if (isEmpty()) {
            System.err.print("Лист пуст");
            return;
        } else {
            while (find(cur.data) != key - 1) {
                cout++;
                if (cout == size()) {
                    System.err.println("Такого элемента нет");
                    return;
                }
                prev = cur;
                cur = cur.next;
            }
            if (cur == head) {
                head = head.next;
            } else {
                prev.next = cur.next;
            }
        }
    }

    public int find(int key) {
        LinkList cur = head;
        int n = 0;
        while (cur != null) {
            if (cur.data == key) {
                return n;
            }
            cur = cur.next;
            n++;
        }
        return -1;
    }

    public String getString(int n){
        LinkList cur = head;
        int k = 0;
        while (cur != null) {
            if (k == n){
                return cur.sData;
            }
            cur = cur.next;
            k++;
        }
        return null;
    }


    public void sort() {
        list.clear();
        boolean flag = true;
        String tmp = "";
        while (flag) {
            LinkList cur = head;
            flag = false;
            while (cur != null && cur.next != null) {
                if (cur.sData.length() < cur.next.sData.length()) {
                    tmp = cur.sData;
                    cur.sData = cur.next.sData;
                    cur.next.sData = tmp;
                    flag = true;
                }
                cur = cur.next;
            }
        }
        LinkList cur = head;

        while (cur != null) {
            list.add(cur.sData);
            cur = cur.next;
        }
        arr = new String[list.size()];
    }

    public static List arrayToList(String[] arr) {
        List list = new List();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static String [] coupList (){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void printAd(int key) {
        LinkList cur = head;

        while (cur == null) {
            System.out.print(cur.sData);
            System.out.println();
            cur = cur.next;
        }
    }


    public void print() {
        LinkList cur = head;

        while (cur != null) {
            System.out.print(cur.sData);
            System.out.println();
            cur = cur.next;
        }
    }

    public int size() {
        LinkList cur = head;
        int counter = 0;
        while (cur != null) {
            counter++;
            cur = cur.next;
        }
        return counter;
    }

    public void removeTo(int n, int k) {
        LinkList cur = head;
        int counter = -1;
        LinkList prev = null;
        k = find(k);
        n = find(n);
        System.out.println(n);
        System.out.println(k);
        if (isEmpty()) {
            System.err.print("Лист пуст");
            return;
        } else {
            while (cur.next != null) {
                counter++;
                if ((counter != n) && (counter != k)) {
                    prev = cur;
                    cur = cur.next;
                }
                if (cur == head) {
                    head = head.next;
                } else {
                    prev.next = cur.next;
                }
                return;
            }
        }
    }
}



