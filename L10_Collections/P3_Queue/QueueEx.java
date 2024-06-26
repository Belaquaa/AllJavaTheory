package L10_Collections.P3_Queue;

import java.util.ArrayDeque;

public class QueueEx {
    public static void main(String[] args) {
        // ================================================= Queue ================================================== \\

        // Queue в Java — это упорядоченная коллекция для хранения элементов в порядке их добавления.
        // Элементы извлекаются в порядке их добавления, следуя принципу FIFO (First-In-First-Out),
        // за исключением случаев использования структур данных с приоритетом.
        // Queue не поддерживает произвольный доступ к элементам, не может хранить null

        // Методы Queue:
        // - add(E e) - Добавляет указанный элемент в эту очередь, если это возможно сделать нарушая ограничения емкости,
        //   в случае успеха и возвращает true и в случае неудачи бросает исключение IllegalStateException,
        //   если в настоящее время нет свободного места.
        //
        // - element() - Получает, но не удаляет верхний элемент этой очереди.
        //   Если очередь пуста, бросает исключение NoSuchElementException
        //
        // - offer(E e) - Вставляет указанный элемент в очередь, если это возможно сделать не нарушая
        //   ограничения пропускной способности.
        //
        // - peek() -  Получает, но не удаляет верхний элемент очереди или возвращает null, если очередь пуста.
        //
        // - poll() - Получает и удаляет верхний элемент очереди или возвращает null, если очередь пуста.
        //
        // - remove() - Удаляет верхний элемент очереди. Если очередь пуста, бросает исключение NoSuchElementException

        // ============================================ Queue vs. Deque ============================================= \\

        // Queue - это очередь, которая обычно (но необязательно) строится по принципу FIFO (First-In-First-Out) -
        // соответственно извлечение элемента осуществляется с начала очереди, вставка элемента - в конец очереди.
        // Хотя этот принцип нарушает, к примеру PriorityQueue, использующая «natural ordering» или
        // переданный Comparator при вставке нового элемента.
        //
        // Deque (Double Ended Queue) расширяет Queue и согласно документации это линейная коллекция, поддерживающая
        // вставку/извлечение элементов с обоих концов. Помимо этого реализации интерфейса Deque могут строиться по
        // принципу FIFO, либо LIFO.
        //
        // Реализации и Deque, и Queue обычно не переопределяют методы equals() и hashCode(), вместо этого используются
        // унаследованные методы класса Object, основанные на сравнении ссылок.

        java.util.Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        System.out.println("Исходная очередь: " + queue);
        // Просмотр элемента в начале очереди без его удаления
        int head = queue.peek();
        System.out.println("Голова очереди: " + head);
        int removedElement = queue.poll();
        System.out.println("Удаленный элемент: " + removedElement);
        System.out.println("Очередь после удаления: " + queue);
    }
}
