package L9_Streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorEx {
    public static void main(String[] args) {
        // ============================================ Класс Collectors ============================================ \\

        // Collectors нужен для сбора потока в коллекцию (или для выполнения операций: сложения, min/max, группировки)
        // Класс представляет ряд статических методов

        // Сбор элементов в список

        Stream<String> stream = Stream.of("apple", "banana", "cherry", "date");
        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list);

        // Группировка элементов по критерию

        List<String> items = List.of("apple", "banana", "cherry", "apple", "banana", "cherry", "apple");
        Map<String, Long> itemCount = items.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(itemCount);
        // Здесь элементы списка группируются по их значению, и для каждой группы подсчитывается количество элементов.

        // Сбор в карту
        Stream<String> stream1 = Stream.of("apple", "banana", "cherry");
        Map<String, Integer> map = stream1.collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map);
        // Здесь элементы потока собираются в карту, где ключом является сам элемент, а значением — его длина.

        // Соединение строк
        Stream<String> stream2 = Stream.of("apple", "banana", "cherry");
        String result = stream2.collect(Collectors.joining("; "));
        System.out.println(result);
        // Здесь элементы потока соединяются в одну строку, разделенную запятыми.

        // Агрегирующие операции
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        int sum = stream3.collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum: " + sum);
        // Здесь с помощью коллектора summingInt вычисляется сумма элементов потока целых чисел.

        // Collectors предоставляет мощный инструментарий для работы с потоками данных в Java,
        // позволяя эффективно собирать, группировать, преобразовывать и агрегировать элементы потока.
    }
}
