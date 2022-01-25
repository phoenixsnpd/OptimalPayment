package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // создаем дорогу с пропусками

        Integer[] road = road();

        // создаем популяцию водителей

        List<Integer[]> population = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            population.add(driver());
        }

        //Генерация нового поколения и ГА
// You create population and right after that you began to multiply them. Why?
// Right flow should be like:
//        1) Create population
//        2) Evaluate and sort his members using fitness function
//        3) Take first half (with the highest value of evaluation) of population
//        4) Multiply them
//        5) Add mutation factor during multiplying
//        6) Back to step 2
        newGeneration((ArrayList<Integer[]>) population, road);

        fitnesFunction((newGeneration((ArrayList<Integer[]>) population, road)), road);

        // вывод итогов

//      If I understood correct, on that part you shuffle you previous results twice. Because of that output results is not valid.
        System.out.println("Лучшей комбинацией для проезда будет:");
        for (int i = 0; i < newGeneration((ArrayList<Integer[]>) population, road).size(); i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(newGeneration((ArrayList<Integer[]>) population, road).get(i)[j] + ". ");
            }
            System.out.println();
        }
    }
    public static List<Integer[]> newGeneration(ArrayList<Integer[]> population, Integer[] road) {
        if (population.size() == 1) {
            return population;
        }
        List<Integer[]> generation = new ArrayList<>();
        Integer[] newDriwer = new Integer[10];
        for (int i = 0; i < population.size() - 1; i++) {
//            just pass newDriver variable generation.add(newDriwer);
            generation.add(newDriwer = new Integer[10]);
        }
        for (int i = 0; i < population.size() - 1; i++) {
            int y = 0;
            int x = 0;
            for (int j = 0; j < 10; j++) {
                y = population.get(i)[j] - road[j];
                x = population.get(i + 1)[j] - road[j];
                if (Math.abs(y) < Math.abs(x)) {
                    generation.get(i)[j] = population.get(i)[j];
                } else {
                    generation.get(i)[j] = population.get(i + 1)[j];
                }
            }
        }
        for (int i = 0; i < generation.size(); i++) {
            mutation(generation.get(i));
        }

// Avoid using recursive calls
        return newGeneration((ArrayList<Integer[]>) generation, road);
    }
//    Terrible naming I have understood nothing from this part of code
//    avoid x,y,z,a,b etc. variable names
    public static void mutation(Integer[] array) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < testArray.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (testArray[i] == array[j]) {
                    count++;
                }
            }
            if (count == 0) {
                int x = testArray[i];
                for (int j = 0; j < array.length; j++) {
                    int count1 = 0;
                    for (int k = 0; k < array.length; k++) {
                        if (array[j] == array[k]) {
                            count1++;
                            if (count1 > 1) {
                                array[j] = testArray[i];
                            }
                        }

                    }
                }
            }
        }
    }

//    Terrible naming I have understood nothing from this part of code
//    avoid x,y,z,a,b etc. variable names
//    What does return int value mean?

    public static int fitnesFunction(List<Integer[]> a, Integer[] b) {
        int z = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < 10; j++) {
                int y = 0;
                y += a.get(i)[j] - b[j];
                if (y > 0) {
                    y = 0;
                }
                z += y;
            }
            System.out.print(z + " ");
            z = 0;
        }
        System.out.println();
        return z;
    }

//    This both methods are OK, in general.
    public static Integer[] road() {
        Integer[] array = new Integer[10];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10 + 1);
            counter += array[i];
            if (i == 9 && counter <= 55) {
                i = 0;
                counter = 0;
            }
        }
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            x += array[i];
        }
        System.out.println("Общая стоимость проезда: " + x);
        System.out.println("Сегодняшняя стоимость на пунктах пропусков: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ". ");
        }
        System.out.println();
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