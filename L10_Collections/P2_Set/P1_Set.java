package L10_Collections.P2_Set;

import java.util.HashSet;
import java.util.Set;

public class P1_Set {
    public static void main(String[] args) {
        // ================================================== Set =================================================== \\

        // Set в Java — это неупорядоченная коллекция, которая содержит лишь уникальные элементы.
        // Уникальность определяется за счет контракта hashcode() и equals(), нет индексов

        // Можно делать три типа операций: добавлять, удалять и проверять, есть ли во множестве элемент.
        // Методов get() и set() нет.

        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2); // Этот элемент не будет добавлен, так как он уже есть в множестве
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}
