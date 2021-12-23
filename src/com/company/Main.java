package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        road();
        int[] points = road();
        System.out.println("Сегодняшняя стоимость на пунктах пропусков: ");
        for (int i = 0; i < points.length; i++) {
            System.out.print(points[i] + ", ");
        }
        driver();
        Integer[] driver1 =  driver();
        for (int i = 0; i < driver1.length; i++) {
            System.out.print(driver1[i]);
        }
    }

    public static int[] road() {
        int[] array = new int[10];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10 + 1);
            counter += array[i];
            if (i == 9 && counter <= 55) {
                road();
        }
        }
        return array;
    }

    public static Integer[] driver() {
        List<Integer> newDriver = new ArrayList<>();
        for (int i = 0; i < newDriver.size(); i++) {
            newDriver.add(i);
        }
        Collections.shuffle(newDriver);
        Integer[] array = newDriver.toArray(new Integer[10]);
        return array;
    }
}


