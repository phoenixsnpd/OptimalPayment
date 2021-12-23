package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] points = road(); // присваиваем в массив.

        int x = 0; // проверяем что сумма за все оплаты больше 55.
        for (int i = 0; i < points.length; i++) {
            x += points[i];
        }
        System.out.println("Общая стоимость проезда: " + x);

        System.out.println("Сегодняшняя стоимость на пунктах пропусков: ");
        for (int i = 0; i < points.length; i++) {
            System.out.print(points[i] + ", ");
        }

        List<Integer[]> population = new ArrayList<>(); // создаем популяцию.
        for (int i = 0; i < 10000; i++) {
            population.add(driver());
        }
    }

    public static int[] road() {
        int[] array = new int[10];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10 + 1);
            counter += array[i];
            if (i == 9 && counter <= 55) {
                i = 0;
                counter = 0;
            }
        }
        return array;
    }

    public static Integer[] driver() {
        List<Integer> newDriver = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            newDriver.add(i);
        }
        Collections.shuffle(newDriver);
        Integer[] array = newDriver.toArray(new Integer[10]);
        return array;
    }
}