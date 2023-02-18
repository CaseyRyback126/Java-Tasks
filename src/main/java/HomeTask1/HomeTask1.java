package HomeTask1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class HomeTask1 {
    public static void main(String[] args) {
        //isLeapYear();
        moveElementToEnd();
        //maxMinArray();
    }

    //Задать одномерный массив и найти в нем минимальный и максимальный элементы
    private static void maxMinArray() {
        int[] array = new int[20];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(30);
        }
        System.out.println(Arrays.toString(array));

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Максимальное значение: " + array[array.length - 1]);
        System.out.println("Минимальное значение: " + array[0]);
    }

    //метод, который определяет, является ли год високосным,
    // и возвращает boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean isLeapYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        boolean isLeap;
        if ((year % 4 != 0) || ((year % 100 == 0) && (year % 400 != 0))) {
            isLeap = false;
            System.out.println(false);
        } else {
            isLeap = true;
            System.out.println(true);
        }
        return isLeap;
    }

    //Дан массив nums = [3,2,2,3] и число val = 3.
    //Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
    //Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
    // а остальные - равны ему.

    private static void moveElementToEnd() {
        int[] nums = new int[]{3, 2, 3, 2, 5, 3, 7, 2, 4, 1, 12, 3, 8, 2, 3};
        int val = 3;
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val)
                nums[count++] = nums[i];

        while (count < nums.length)
            nums[count++] = val;

        System.out.println(Arrays.toString(nums));

    }
}
