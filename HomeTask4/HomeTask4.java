import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HomeTask4 {
    public static void main(String[] args) {
        //firstLastSwitch();
        reversedList();
    }

//    Принимаем от пользователя и “запоминаем” строки.
//    Если введено print, выводим строки так, чтобы последняя введенная была первой в списке,
//    а первая - последней. Если введено revert, удаляем предыдущую введенную строку из памяти.

    private static void firstLastSwitch(){
        List<String> linkedList = new LinkedList<>();
        String inputLine = "";
        Scanner lineScanner = new Scanner(System.in);

        label:
        while (true) {
            System.out.println("Enter string or command(exit, print, revert): ");
            try {
                inputLine = lineScanner.nextLine();
            } catch (Exception e) {
                System.out.print("Error!");
                e.printStackTrace();
            }
            switch (inputLine) {
                case "exit":
                    break label;
                case "print":
                    System.out.println(inputLine);
                    break;
                case "revert":
                    linkedList.remove(0);
                    break;
                default:
                    linkedList.add(0, inputLine);
                    break;
            }
            System.out.println(linkedList);
        }
    }

//    Пусть дан LinkedList с несколькими элементами.
//    Реализуйте метод, который вернет “перевернутый” список.

    private static void reversedList() {
        LinkedList<String> inputList = new LinkedList<>();

        for (int i = 0; i < 20; i++) {
            inputList.add("s" + i);
        }
        System.out.println("Начальный список: " + inputList);

        List<String> reversedList = new LinkedList<>();
        Iterator<String> iterator = inputList.descendingIterator();
        while (iterator.hasNext()) {
            reversedList.add(iterator.next());
        }
        System.out.println("Перевернутый список: "+ reversedList);
    }
}