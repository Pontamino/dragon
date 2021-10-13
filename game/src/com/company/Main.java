package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        int people = 10;
        int gold = 100;
        int army = 0;
        int tax = 2;
        int armyTax = 4;
        double peopleGain = 0.1;

        int week = 1;
        while (true) {

            if (isGameOver(people, gold)) {
                break;
            }

            if (week % 3 == 0) {
                int gain = (int) (people * peopleGain);
                if (gain == 0) {
                    gain = 1;
                }
                people = people + gain;
                System.out.println("Бабы народили:" + gain);
            }

            if (week % 4 == 0) {
                gold = gold + (people * tax);
                System.out.println("В казну поступило:" + (people * tax));
                gold = gold - (army * armyTax);
                System.out.println("Милорд, содержание армии стоило Вам: " + (army * armyTax));

            }

            if (week % 6 == 0) {
                System.out.println("Теперь вы можете рекрутировать крестьян. Введите количество");

                while (true) {
                    int countArmy = in.nextInt();
                    if (countArmy > people) {
                        System.out.println("Вы не можете набрать больше: " + people);
                        continue;
                    }
                    army = army + countArmy;
                    people = people - countArmy;
                    break;
                }
            }
            if (random.nextInt(3 + army) == 0) {
                int stolen = random.nextInt(gold / 2) + 1;
                gold = gold - stolen;
                System.out.println("Грабители проникли в хранилище и похитили:" + stolen);
            }
            System.out.printf("Батраки:%d Армия:%d Золото:%d Неделя:%d\n", people, army, gold, week);

            if (random.nextInt(5 + army) == 0) {
                int troublePeople = random.nextInt(people / 3) + 1;
                int troubleGold = random.nextInt(gold / 3) + 1;
                System.out.println("На вас напал дракон. Что будем делать, милорд?");
                System.out.println("(1) Отдать в жертву батраков:" + troublePeople);
                System.out.println("(2) Отдать в жертву золото:" + troubleGold);

                while (true) {
                    int choice = in.nextInt();
                    if (choice == 1) {
                        people = people - troublePeople;
                        break;
                    }
                    if (choice == 2) {
                        gold = gold - troubleGold;
                        break;
                    }
                    System.out.println("(1) или (2), дурень?");
                }
                week++;
                continue;

            }
            if (week > 8 && random.nextInt(3) == 0) {
                int mzda = gold / 3;
                int bound = army;
                if (bound == 0) {
                    bound = 1;
                }
                int enemyArmy = random.nextInt(bound) + 1;

                System.out.println("На вас напал сосед. Что будем делать, Милорд?");
                System.out.println("(1) Выплатить дань.В размере: " + mzda);
                System.out.println("(2) Вступить в бой. Вражеская армия: " + enemyArmy);
                while (true) {
                    int choice = in.nextInt();
                    if (choice == 1) {
                        gold = gold - mzda;
                        break;
                    }
                    if (choice == 2) {
                        int armyLosses;
                        int peopleLosses = 0;
                        if (army > enemyArmy) {
                            armyLosses = army - enemyArmy;
                        } else {
                            peopleLosses = (enemyArmy - army) * 2;
                            armyLosses = army;

                        }
                        if (peopleLosses == 0) {
                            System.out.println("Потери составили: " + armyLosses + " ");
                        } else {
                            System.out.println("Потери составили: " + armyLosses + peopleLosses);
                        }
                        army = army - armyLosses;
                        people = people - peopleLosses;

                        break;
                    }
                    System.out.println("(1) или (2), дурень?");
                }

            }


            System.out.println("(0) следующий ход");

            while (in.nextInt() != 0) {
                System.out.println("Введи (0), дурень!");
            }
            week++;
        }
    }

    private static boolean isGameOver(int people, int gold) {
        if (people <= 0) {
            System.out.println("Ты просрал весь человеческий ресурс. Гаме овер");
            return true;
        }
        if (gold < 0) {
            System.out.println("Ты просрал все наследство. Гаме овер");
            return true;
        }
        return false;
    }
}

