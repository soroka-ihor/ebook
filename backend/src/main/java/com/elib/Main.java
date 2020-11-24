package com.elib;


public class Main {

    public static void main(String[] args) {
        int[] array = {-1000, 1000, 2345, -999999, 87, 34, -15};

        int max = 0;

        for (int i : array) max = i > max ? i : max;

        System.out.println(max);
    }
}
