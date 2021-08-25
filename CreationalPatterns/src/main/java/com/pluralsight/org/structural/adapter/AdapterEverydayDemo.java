package com.pluralsight.org.structural.adapter;

import java.util.Arrays;
import java.util.List;

public class AdapterEverydayDemo {

    public static void main(String[] args) {
        Integer[] arraysOfInts = new Integer[] {42, 43, 44};
        List<Integer> listOfInts = Arrays.asList(arraysOfInts);

        System.out.println(arraysOfInts);
        System.out.println(listOfInts);
    }
}
