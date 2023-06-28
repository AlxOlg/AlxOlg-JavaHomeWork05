package JavaHomeWork05;

// Телефонный справочник.
// ADD фамилия №тел - добавить в справочник.
// GET фамилия - список номеров по фамилии.
// REMOVE фамилия - удалить все номера по фамилии.
// LIST - посмотреть все записи.
// EXIT - завершить программу.
// Если при GET или REMOVE нужной фамилии нет, вывести информацию об этом.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * program
 */
public class program {

// Добавление записи.
    private static void addEntry(HashMap<String, List<String>> map, String name, String number) {
        if (!map.containsKey(name)) {
            map.put(name, new ArrayList<>(Arrays.asList(number)));
        } else {
            List<String> newNumber = map.get(name);
            newNumber.add(number);
        }
    }

// Показать запись.
    private static void getEntry(HashMap<String, List<String>> map, String name) {
        if (map.containsKey(name)) {
            System.out.println(map.get(name));
        } else {
            System.out.println("Данные отсутствуют.");
        }
    }

// Удаление записи.
    private static void removeEntry(HashMap<String, List<String>> map, String name) {
        if (map.containsKey(name)) {
            map.remove(name);
        } else {
            System.out.println("Данные отсутствуют.");
        }
    }

// Показать все записи.
    private static void getList(HashMap<String, List<String>> map) {
        for (String key : map.keySet()) {
            System.out.printf(key + ": ");
            System.out.println(map.get(key));
        }
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> phonebook = new HashMap<>();
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                String[] arrayStrings = scan.nextLine().split("\\s++", 3);
                String operation = arrayStrings[0].toLowerCase();
                int length = arrayStrings.length;
                if ("add".equals(operation) && length == 3) {
                    addEntry(phonebook, arrayStrings[1], arrayStrings[2]);
                } else if ("get".equals(operation) && length == 2) {
                    getEntry(phonebook, arrayStrings[1]);
                } else if ("remove".equals(operation) && length == 2) {
                    removeEntry(phonebook, arrayStrings[1]);
                } else if ("list".equals(operation)) {
                    getList(phonebook);
                } else if ("exit".equals(operation)) {
                    System.exit(0);
                } else {
                    System.out.println("Не верный ввод данных.");
                }
            }
        }
    }
}
