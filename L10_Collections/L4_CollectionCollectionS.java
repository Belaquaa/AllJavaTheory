package L10_Collections;

public class L4_CollectionCollectionS {
    public static void main(String[] args) {

        // ======================================= Collection vs. CollectionS ======================================= \\

        // Collection
        // - основной интерфейс, на котором базируются все коллекции (кроме Map), расширяет Iterable.
        // - определяет общие методы для работы с коллекциями объектов: добавление, удаление, проверка размера
        // - можно использовать его с любыми типами объектов Collection<E>
        // - Под интерфейс Collection подпадают такие интерфейсы как List, Set, и Queue, каждый из которых имеет свои
        //   особенности и реализации, например, ArrayList, LinkedList, HashSet, LinkedHashSet, PriorityQueue и т.д.
        //
        // Collections
        // - утилитарный класс (вспомогательный), предоставляет статические методы для коллекций и массивов:
        //   поиск, сортировка, копирование, обработка потоков данных
        // - Класс Collections не предназначен для создания объектов, ли лишь предоставляет методы:
        //   Collections.sort(list), Collections.shuffle(list), Collections.unmodifiableList(list) и т.д.

        // ========================================= Общие методы Collection ======================================== \\

        // - boolean add(E e) - добавляет элемент в коллекцию.
        // - boolean remove(Object o) - удаляет один экземпляр указанного элемента из коллекции, если он присутствует.
        // - boolean contains(Object o) - возвращает true, если коллекция содержит указанный элемент.
        // - int size() - возвращает количество элементов в коллекции.
        // - boolean isEmpty() - возвращает true, если коллекция не содержит элементов.
        // - void clear() - удаляет все элементы из коллекции.
        // - boolean addAll(Collection<? extends E> c) - добавляет все элементы из указанной коллекции в текущую коллекцию.
        // - boolean removeAll(Collection<?> c) - удаляет из текущей коллекции все ее элементы, которые содержатся в указанной коллекции.
        // - boolean retainAll(Collection<?> c) - оставляет в текущей коллекции только те ее элементы, которые содержатся в указанной коллекции.
        // - Iterator<E> iterator() - возвращает итератор для элементов в коллекции.
        // - stream() - Возвращает последовательный поток с этой коллекцией в качестве источника.
        // - toArray() - Возвращает массив, содержащий все элементы этой коллекции.

        // =================================== Основные методы Collections (класса) ================================= \\

        // Класс Collections содержит различные статические методы для работы с Коллекциями.

        // - addAll(Collection<? super T> c, T... elements) - Добавляет все указанные элементы в указанную коллекцию.
        // - binarySearch(List<? extends ComparableEx<? super T>> list, T key) -
        //   Поиск указанного объекта в указанном List с помощью алгоритма двоичного поиска.
        // - copy(List<? super T> dest, List<? extends T> src) - Копирует все элементы из одного List в другой.
        // - disjoint(Collection<?> c1, Collection<?> c2) -
        //   Возвращает true, если две указанные коллекции не имеют общих элементов.
        // - emptyList() - Возвращает пустой List.
        // - emptyMap() - Возвращает пустую Map.
        // - emptySet() - Возвращает пустой Set.
        // - fill(List<? super T> list, T obj) - Заменяет все элементы указанного списка указанным элементом.
        // - frequency(Collection<?> c, Object o) - Возвращает количество элементов в указанной коллекции,
        //   которые равны указанному объекту.
        // - max(Collection<? extends T> coll) - Возвращает максимальный элемент данной коллекции
        //   в соответствии с естественным упорядочением ее элементов.
        // - min(Collection<? extends T> coll) - Возвращает минимальный элемент данной коллекции
        //   в соответствии с естественным порядком ее элементов.
        // - nCopies(int n, T o) - Возвращает неизменяемый List, состоящий из n копий указанного объекта.
        // - newSetFromMap(Map<E,Boolean> map) - Возвращает Set из указанной Map.
        // - replaceAll(List<T> list, T oldVal, T newVal) - Заменяет все указанные значения в List другим значением.
        // - reverse(List<?> list) - Изменяет порядок элементов в указанном List в обратном порядке.
        // - reverseOrder() - Возвращает Компаратор, который накладывает обратный естественный порядок
        //   на коллекцию объектов, реализующих составляемый интерфейс.
        // - rotate(List<?> list, int distance) - Изменяет очередь элементов в указанном List на указанное расстояние.
        // - shuffle(List<?> list) - Случайным образом переставляет указанный List,
        //   используя источник случайности по умолчанию.
        // - singleton(T o) - Возвращает неизменяемый Set, содержащий только один указанный объект.
        // - singletonList(T o) - Возвращает неизменяемый List, содержащий только один указанный объект.
        // - singletonMap(K key, V value) - Возвращает неизменяемую Map,
        //   содержащую только одно соответствие ключ - значение.
        // - sort(List<T> list) - Сортирует указанный List по возрастанию
        //   в соответствии с естественным порядком его элементов.
        // - swap(List<?> list, int i, int j) - Замена местами двух элементов в указанных позициях в указанном List.
        // - synchronizedCollection(Collection<T> c) - Возвращает синхронизированную коллекцию,
        //   поддерживаемую указанной коллекцией.
        // - unmodifiableCollection(Collection<? extends T> c) - Возвращает неизменяемую указанную коллекцию.
    }
}