import java.util.*;

public class HomeTask3 {
    public static void main(String[] args) {
        //finderOfMinMaxMean();
        //removeEvens();
        removeRepeats();
    }

    //Пусть дан произвольный список целых чисел,
    // удалить из него четные числа (в языке уже есть что-то готовое для этого)
    private static void removeEvens() {
        LinkedList<Integer> nums = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            nums.add(random.nextInt(-10, 11));
        }
        System.out.printf("Первоначальный список:\n %s\n", nums);

        nums.removeIf(a -> a % 2 == 0);

        System.out.printf("Результирующий список:\n %s", nums);
    }

    //Задан целочисленный список ArrayList.
    // Найти минимальное, максимальное и среднее арифметическое из этого списка.
    private static void finderOfMinMaxMean() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(-100, 101));
        }
        System.out.printf("Первоначальный список %s\n", numbers);

        int sum = 0;
        for (Integer number : (numbers)) {
            sum += number;
        }
        double mean = sum / numbers.size();

        System.out.printf("Минимальное значение: %d%n", Collections.min(numbers));
        System.out.printf("Максимальное значение: %d%n", Collections.max(numbers));
        System.out.printf("Среднее арифметическое: %f%n", mean);
    }

    private static void removeRepeats() {
        String[] solarSystemPlanets =
                {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        Random random = new Random();
        ArrayList<String> planets = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            planets.add(solarSystemPlanets[random.nextInt(solarSystemPlanets.length)]);
        }
        System.out.printf("Cписок с повторениями:\n %s\n", planets);

        Set<String> noRepeatSet = new HashSet<>(planets);
        System.out.printf("Cписок без повторений:\n %s", noRepeatSet);
    }
}