package L10_Collections.P2_Set.SortedSet.NavigableSet;

import java.util.Set;

public class TreeSet {
    public static void main(String[] args) {
        // =============================================== TreeSet ================================================== \\

        // Класс TreeSet реализует интерфейс NavigableSet, который поддерживает элементы
        // в отсортированном по возрастанию порядке. Под капотом использует TreeMap

        // Для хранения объектов использует бинарное красно-черное дерево
        // Сортировка происходит благодаря тому, что все добавляемые элементы реализуют интерфейсы Comparator и Comparable

        // Временная сложность базовых операций add(), remove(), contains() медленнее, чем в хэш-множествах,
        // но быстрее, чем в списках: O(log(n))

        // Если TreeSet пустой – можно положить единственное значение null
        // При этом все операции кроме size() и clear() перестанут работать.
        // В непустой TreeSet положить null уже нельзя из-за вызова compareTo()

        java.util.TreeSet<String> treeSet = new java.util.TreeSet<>();
        treeSet.add("Cherry");
        treeSet.add("Banana");
        treeSet.add("Apple");
        // Элементы автоматически сортируются
        System.out.println(treeSet); // Вывод в отсортированном порядке
        if (treeSet.contains("Banana")) System.out.println("Banana is in the set");
        treeSet.remove("Cherry");
        System.out.println(treeSet);
        // Дополнительные операции TreeSet
        System.out.println("First: " + treeSet.first()); // Первый (самый маленький) элемент
        System.out.println("Last: " + treeSet.last()); // Последний (самый большой) элемент

        // ================================ TreeSet vs. HashSet vs. LinkedHashSet =================================== \\

        // В чем отличия TreeSet и HashSet?
        // TreeSet обеспечивает упорядоченно хранение элементов в виде красно-черного дерева.
        // Сложность выполнения основных операций не хуже O(log(N)). HashSet использует для хранения элементов
        // такой же подход, что и HashMap, за тем отличием, что в HashSet в качестве ключа и значения выступает
        // сам элемент, кроме того HashSet не поддерживает упорядоченное хранение элементов и обеспечивает временную
        // сложность выполнения операций аналогично HashMap.

        // Что будет, если добавлять элементы в TreeSet по возрастанию?
        // В основе TreeSet лежит красно-черное дерево, которое умеет само себя балансировать. В итоге, TreeSet все
        // равно в каком порядке вы добавляете в него элементы, преимущества этой структуры данных будут сохраняться.

        // Чем LinkedHashSet отличается от HashSet?
        // LinkedHashSet отличается от HashSet только тем, что в его основе лежит LinkedHashMap вместо HashMap.
        // Благодаря этому порядок элементов при обходе коллекции является идентичным порядку добавления элементов
        // (insertion-order). При добавлении элемента, который уже присутствует в LinkedHashSet
        // (т.е. с одинаковым ключом), порядок обхода элементов не изменяется
    }
}
