package L10_Collections.P4_Map.SortedMap;

import java.util.*;

public class NavigableMap {
    public static void main(String[] args) {
        // ========================================== Интерфейс NavigableMap ======================================== \\

        // Интерфейс NavigableMap расширяет SortedMap и определяет поведение Map,
        // поддерживающей извлечение элементов на основе ближайшего соответствия заданному ключу или ключам.
        //
        // SortedMap расширена методами навигации, возвращающими ближайшие совпадения для заданных целей поиска:
        //
        // lowerEntry(K), floorEntry(K), ceilingEntry(K) и higherEntry(K) возвращают объекты Map.Entry,
        // связанные с ключами соответственно меньше, меньше или равны, больше или равно и больше,
        // чем данный ключ, возвращая null, если такого ключа нет.
        //
        // lowerKey(K), floorKey(K), ceilingKey(K) и higherKey(K) возвращают ключ
        // соответственно меньше, меньше или равно, больше или равно и больше,
        // чем данный ключ, возвращая null, если такого ключа нет.
        //
        // descendingMap() возвращает NavigableMap в обратном порядке
        //
        // firstEntry(), pollFirstEntry(), lastEntry() и pollLastEntry() возвращают и/или удаляют
        // наименьшие и наибольшие отображения, если таковые имеются, в противном случае возвращая null
        //
        // subMap(K, K), headMap(K) и tailMap(K) предназначены для возврата части NavigableMap
        //
        // subMap(K, boolean, K, boolean), headMap(K, boolean) и tailMap(K, boolean) отличаются от аналогичных методов
        // SortedMap принятием дополнительных аргументов, описывающих, являются ли нижняя и верхняя границы
        // инклюзивными по сравнению с эксклюзивными
        // - K: ключ, для которого нужно получить подмножество элементов.
        // - boolean includeLower:• boolean, определяющий, включать ли в подмножество нижнюю границу ключа.
        // - boolean includeUpper:• boolean, определяющий, включать ли в подмножество верхнюю границу ключа.
        SortedMap<Integer, String> maper = new TreeMap<>();
        maper.put(1, "a");
        maper.put(2, "b");
        maper.put(3, "c");

        // Подмножество элементов с ключами от 1 до 2 (вклюзивное)
        SortedMap<Integer, String> subMap = maper.subMap(1, 2);
        // Подмножество элементов с ключами от 1 до 2 (исклюзивное)
        SortedMap<Integer, String> headMap = maper.headMap(1);
        // Подмножество элементов с ключами от 2 до 3 (вклюзивное)
        SortedMap<Integer, String> tailMap = maper.tailMap( 3);

    }
}
