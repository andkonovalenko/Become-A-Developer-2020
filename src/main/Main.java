package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private FileOpener fileOpener = new FileOpener();
    private static ArrayList<Integer> listFromFile = new ArrayList<>(1000000);
    private Scanner consoleInput = new Scanner(System.in);
    private Long start;

    public static void main(String args[]) {
        Main main = new Main();
        main.startApp();
    }

    private void startApp() {
        while (true) {
            System.out.println("\nВыберите вариант:\n"
                    + "1. Запустить программу с файлом из задания\n"
                    + "2. Запустить программу с другим файлом\n"
                    + "3. Выход\n"
                    + "Введите номер: ");

            listFromFile.clear();
            int choice = consoleInput.nextInt();

            switch (choice) {
                case 1: {
                    start = System.currentTimeMillis();

                    fileOpener.readFileToCollection(listFromFile, "src/resources/10m.txt");
                    System.out.println("Открытие файла и запись в коллекцию: " + (System.currentTimeMillis() - start) + "ms");
                    completeTask();
                    break;
                }
                case 2: {
                    System.out.print("Введите полный путь к файлу: ");
                    consoleInput.nextLine();
                    String path = consoleInput.next();
                    start = System.currentTimeMillis();

                    fileOpener.readFileToCollection(listFromFile, path);
                    System.out.println("Open file and write to collection: " + (System.currentTimeMillis() - start) + "ms");
                    completeTask();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {System.out.println("Ошибка ввода"); break;}
            }
        }
    }

    private void completeTask() {

        long i = listFromFile.stream().count();
        System.out.println(i + "\t" + "Количество елементов: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("Минимальное значение: " + CollectionStreams.findMinValue(listFromFile)
                + " Потребовалось времени: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("Максимаольное значение: " + CollectionStreams.findMaxValue(listFromFile)
                + " Потребовалось времени: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("Медиана: " + CollectionStreams.findMedian(listFromFile)
                + " Потребовалось времени: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("Среднее значение: " + CollectionStreams.findAverageValue(listFromFile)
                + " Потребовалось времени: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("Наибольшая возрастающая подпоследовательность: "
                + CollectionStreams.convertMapToString(CollectionStreams.listOfIncreasing(listFromFile), listFromFile)
                + " Потребовалось времени: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("Наибольшая спадающая подпоследовательность: "
                + CollectionStreams.convertMapToString(CollectionStreams.listOfDecreasing(listFromFile), listFromFile)
                + " Потребовалось времени: " + (System.currentTimeMillis() - start) + "ms");
    }
}