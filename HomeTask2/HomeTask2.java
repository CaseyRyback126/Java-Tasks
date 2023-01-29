package HomeTask2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class HomeTask2 {
    public static void main(String[] args) {
        //isPalindrome();
        repeatsToFile();
    }

    //    Напишите метод, который принимает на вход строку (String) и определяет
//    является ли строка палиндромом (возвращает boolean значение).
    private static void isPalindrome() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Введите строку: ");
            input = scanner.nextLine();
        } while (input.isBlank());
        scanner.close();

        StringBuilder line = new StringBuilder();
        line.append(input);
        System.out.println(line.toString().equals(line.reverse().toString())
                ? "Это палиндром" : "Это не палиндром");
    }


    //Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
    //который запишет эту строку в простой текстовый файл, обработайте исключения.
    private static void repeatsToFile() {
        Scanner scanner = new Scanner(System.in);
        String input;
        String path = "file.txt";
        StringBuilder sb = new StringBuilder();
        do {
            System.out.print("Введите слово: ");
            input = scanner.nextLine();
        } while (input.isBlank());

        sb.append(input.repeat(100));
        try {
            FileOutputStream fileOutStream = new FileOutputStream(path);
            fileOutStream.write(sb.toString().getBytes());
            fileOutStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка вывода!");
            e.printStackTrace();
        }
    }
}