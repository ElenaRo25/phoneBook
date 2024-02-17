package org.example;

import java.util.*;

public class phonebook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Пример данных для телефонной книги
        String[][] data = {
                {"Иванов", "111-222-333"},
                {"Петров", "444-555-666"},
                {"Сидоров", "777-888-999"},
                {"Иванов", "123-456-789"},
                {"Петров", "999-888-777"}
        };

        // Заполнение телефонной книги данными
        for (String[] entry : data) {
            String name = entry[0];
            String phone = entry[1];

            // Если в книге уже есть запись с таким именем, добавляем телефон к списку
            phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
        }

        // Создаем список записей для сортировки
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию числа телефонов
        entries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));
        Collections.reverse(entries);

        // Вывод результатов
        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phones = entry.getValue();
            System.out.println(name + ": " + phones.size() + " телефон(ов)");
            for (String phone : phones) {
                System.out.println("\t" + phone);
            }
        }
    }
}