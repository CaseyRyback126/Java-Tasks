import java.util.*;

public class HomeTask5 {

    //    Реализуйте структуру телефонной книги с помощью HashMap,
//    учитывая, что 1 человек может иметь несколько телефонов.
    public static class PhoneBook {
        public static HashMap<String, List<String>> phoneBook = new HashMap<>();

        public static void main(String[] args) {
            addToPhoneBook();
            findInPhoneBook("Чуня");
        }

        public static void addToPhoneBook() {
            phoneBook.put("Иванов", List.of("+7(000)000-00-00", "+7(111)111-11-11"));
            phoneBook.put("Петров", List.of("+7(222)222-22-22", "+7(333)333-33-33"));
            phoneBook.put("Сидоров", List.of("+7(123)444-44-44", "+7(555)555-55-55"));
            phoneBook.put("Чуня", List.of("+7(978)586-79-16", "+7(777)777-77-77"));
        }

        public static void findInPhoneBook(String surname) {
            System.out.printf("%s: %s", surname, phoneBook.get(surname));
        }
    }

    //    Пусть дан список сотрудников. Написать программу,
//    которая найдет и выведет повторяющиеся имена с количеством повторений.
//    Отсортировать по убыванию популярности.
    public static class WorkersList {
        public static void main(String[] args) {
            Map<String, Integer> nameMap = new HashMap<>();
            String employees = "Иван Иванов " + "Светлана Петрова " +
                    "Кристина Белова " + "Анна Мусина " +
                    "Анна Крутова " + "Иван Юрин " + "Петр Лыков " +
                    "Павел Чернов " + "Петр Чернышов " + "Мария Федорова " +
                    "Марина Светлова " + "Мария Савина " +
                    "Мария Рыкова " + "Марина Лугова " +
                    "Анна Владимирова " + "Иван Мечников " +
                    "Петр Петин " + "Иван Ежов ";
            String[] listOfNamesAndSurnames = employees.split(" ");
            for (int i = 0; i < listOfNamesAndSurnames.length; i += 2) {
                if (nameMap.containsKey(listOfNamesAndSurnames[i])) {
                    nameMap.replace(listOfNamesAndSurnames[i], nameMap.get(listOfNamesAndSurnames[i]) + 1);
                } else {
                    nameMap.put(listOfNamesAndSurnames[i], 1);
                }
            }
            System.out.println(nameMap);
            Map<String, Integer> sortedNameMap = new LinkedHashMap<>();
            int max = 1;
            for (int value : nameMap.values()) {
                if (value > max) {
                    max = value;
                }
            }
            for (int i = max; i > 0; i--) {
                for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
                    String key = entry.getKey();
                    if (nameMap.get(key) == i) {
                        sortedNameMap.put(key, nameMap.get(key));
                    }
                }
            }
            System.out.println(sortedNameMap);
        }
    }

    //Реализовать алгоритм пирамидальной сортировки (HeapSort).
    public static class HeapSort {
        public static void main(String[] args) {
            Integer[] numbers = new Integer[20];
            Random random = new Random();
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = random.nextInt(101);
            }

            System.out.println(Arrays.toString(numbers));
            sort(numbers);
            System.out.println(Arrays.toString(numbers));
        }

        private static void sort(Integer[] numbers) {
            for (int i = numbers.length / 2 - 1; i >= 0; i--) {
                updateHeap(numbers, numbers.length, i);
            }

            for (int i = numbers.length - 1; i >= 0; i--) {
                int temp = numbers[0];
                numbers[0] = numbers[i];
                numbers[i] = temp;

                updateHeap(numbers, i, 0);
            }
        }

        private static void updateHeap(Integer[] numbers, int length, int i) {
            int startPos = i;
            int leftSide = 2 * i + 1;
            int rightSide = 2 * i + 2;

            if (leftSide < length && numbers[leftSide] > numbers[startPos]) {
                startPos = leftSide;
            }
            if (rightSide < length && numbers[rightSide] > numbers[startPos]) {
                startPos = rightSide;
            }
            if (startPos != i) {
                int temp = numbers[i];
                numbers[i] = numbers[startPos];
                numbers[startPos] = temp;

                updateHeap(numbers, length, startPos);
            }
        }
    }

    //На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
    public static class Queens {
        private final int SIZE;
        private final int[][] board;
        private int results_count;

        public Queens(int N) {
            SIZE = N;
            board = new int[N][N];
            results_count = 0;
        }
        public static void main(String[] args) {
            Queens queens = new Queens(8);
            queens. setQueen(0);
        }
        public boolean tryQueen(int a, int b) {
            for (int i = 0; i < a; ++i)
                if (board[i][b] == 1)
                    return false;

            for (int i = 1; i <= a && b - i >= 0; ++i)
                if (board[a - i][b - i] == 1)
                    return false;

            for (int i = 1; i <= a && b + i < SIZE; i++)
                if (board[a - i][b + i] == 1)
                    return false;

            return true;
        }

        public void setQueen(int a) {
            if (a == SIZE) {
                ++results_count;
                System.out.print("Result #" + results_count + '\n');
                showBoard();
                return;
            }
            for (int i = 0; i < SIZE; ++i) {
                if (tryQueen(a, i)) {
                    board[a][i] = 1;
                    setQueen(a + 1);
                    board[a][i] = 0;
                }
            }

        }

        public void showBoard() {
            for (int a = 0; a < SIZE; ++a) {
                for (int b = 0; b < SIZE; ++b) {
                    System.out.print((board[a][b] == 1) ? "Q " : "_ ");
                }
                System.out.print('\n');
            }
        }
    }
}