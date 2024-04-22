package L10_Collections.P2_Set;

import java.util.LinkedHashSet;
import java.util.Set;

public class P3_LinkedHashSet {
    public static void main(String[] args) {
        // ============================================= LinkedHashSet ============================================== \\

        // - Основное использование: LinkedHashSet используется, когда необходимо сохранять порядок добавления элементов
        //   в коллекцию без дубликатов. Поддерживает связанный список элементов множества
        // - Особенности: Является наследником HashSet с дополнительной связной структурой для поддержания порядка.
        // - Производительность: Незначительно медленнее HashSet из-за дополнительных затрат на поддержание порядка.

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Cherry");
        linkedHashSet.add("Apple"); // Дубликаты не добавляются, порядок сохраняется
        System.out.println(linkedHashSet); // Вывод сохраняет порядок вставки
        if (linkedHashSet.contains("Banana")) System.out.println("Banana is in the set");
        linkedHashSet.remove("Cherry");
        System.out.println(linkedHashSet);
    }
}
