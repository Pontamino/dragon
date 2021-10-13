package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

 int d = 7;
 int dd =1;
 int ddd =d;
        System.out.println(d +" "+dd);
ddd = dd; // d=7 dd=1 ddd=1
dd=d;     // d=7 dd=7 ddd=1
d=ddd;   // d=7 dd=7 ddd=7

        System.out.println(d/d);






      // sort();
    }

    private static void youngPodovan() {
        int[] numbers = new int[]{2, 4, 1, 9, 7};
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers.length != i + 1) {
                if (numbers[i] > numbers[i + 1]) {
                    count++;
                }
                System.out.println(i + " " + numbers[i] + " " + (numbers[i + 1]));
            }
        }

        System.out.println("счет = " + count);
    }

    private static void sort() {
        int[] sort = new int[]{2, 1, 3, 4, 5};
        int[] sort2 = new int[sort.length];


        for (int i = 0; i < sort.length; i++) {
            if (i + 1 > 4) {
                break;
            }

            if (sort[i] < sort[i + 1]) {
                sort[i] = sort[i+1];
              //  sort[i+1]=

            }
        }

        printArray(sort);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}



