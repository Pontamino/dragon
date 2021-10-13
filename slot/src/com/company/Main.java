package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int money = 100;

        int move = 1;
        while (true) {

            while (true) {

                System.out.println("Ваш баланс " + money);
                System.out.println("Делайте вашу ставку");
                int choiceBet = in.nextInt();
                if (choiceBet > money) {
                    System.out.println("Ставка не может быть больше баланса");
                }
                if (choiceBet < money) {
                    System.out.println("Удачи");
                    int slot1 = 1 + random.nextInt(3);
                    int slot2 = 1 + random.nextInt(3);
                    int slot3 = 1 + random.nextInt(3);
                    System.out.println(slot1 + "  " + slot2 + "  " + slot3);
                    if (slot1 == slot2 && slot2 == slot3) {
                        int win = choiceBet * 20;
                        money = money + win;
                        System.out.println("Ваш выигрыш составил: " + win);

                    } else {
                        money = money - choiceBet;
                        System.out.println("Попробуйте еще раз!");

                    }

                }

                move++;
            }

        }
    }
}
