package L10_Collections.P3_Queue.Deque;


import java.util.ArrayDeque;
import java.util.Deque;

public class DequeEx {
    public static void main(String[] args) {
        // ================================================= Deque ================================================== \\

        // Интерфейс Deque расширяет интерфейс Queue и определяет поведение двунаправленной очереди.
        // Двунаправленная очередь может функционировать как стандартная очередь FIFO либо как стек LIFO.

        Deque<String> deque = new ArrayDeque<>();

        // Добавление элементов в конец deque
        deque.addLast("Элемент 1");
        deque.offerLast("Элемент 2");

        // Добавление элементов в начало deque
        deque.addFirst("Элемент 3");
        deque.offerFirst("Элемент 4");

        System.out.println("Deque после добавления элементов: " + deque);

        // Удаление элементов из начала deque
        String removedFirst = deque.removeFirst();
        System.out.println("Удаленный первый элемент: " + removedFirst);
        System.out.println("Deque после удаления первого элемента: " + deque);

        // Удаление элементов из конца deque
        String removedLast = deque.removeLast();
        System.out.println("Удаленный последний элемент: " + removedLast);
        System.out.println("Deque после удаления последнего элемента: " + deque);

        // Получение элементов без удаления
        String firstElement = deque.getFirst();
        String lastElement = deque.getLast();
        System.out.println("Первый элемент: " + firstElement);
        System.out.println("Последний элемент: " + lastElement);

        // Методы Deque:
        // - addFirst(E e) - Добавляет элемент в начало очереди. Бросит IllegalStateException,
        //   если в очереди ограниченной емкости нет места.
        //
        // - addLast(E e) - Добавляет элемент в конец очереди. Бросит IllegalStateException,
        //   если в очереди ограниченной емкости нет места.
        //
        // - getFirst() - Возвращает без удаления первый элемент очереди.
        //   Если очередь пуста, бросит NoSuchElementException.
        //
        // - getLast() - Возвращает без удаления последний элемент очереди.
        //   Если очередь пуста, бросит NoSuchElementException.
        //
        // - offerFirst(E e) - Добавляет элемент в начало очереди.
        //   Если элемент успешно добавлен, возвращает true, иначе - false.
        //
        // - offerLast(E e) - Добавляет элемент в конец очереди.
        //   Если элемент успешно добавлен, возвращает true, иначе - false.
        //
        // - peekFirst() - Возвращает без удаления элемент из начала очереди.
        //   Если очередь пуста, возвращает значение null.
        //
        // - peekLast() - Возвращает без удаления элемент из конца очереди.
        //   Если очередь пуста, возвращает значение null.
        //
        // - pollFirst() - Возвращает с удалением элемент из начала очереди.
        //   Если очередь пуста, возвращает значение null.
        //
        // - pollLast() - Возвращает с удалением элемент из конца очереди.
        //   Если очередь пуста, возвращает значение null.
        //
        // - pop() - Возвращает с удалением элемент из начала очереди.
        //   Если очередь пуста, генерирует исключение NoSuchElementException.
        //
        // - push(E e) - Добавляет элемент в начало очереди.
        //   Если в очереди фиксированного объема нет места, бросит исключение IllegalStateException.
        //
        // - removeFirst() - Удаляет элемент из начала очереди.
        //   Если очередь пуста, генерирует исключение NoSuchElementException.
        //
        // - removeFirstOccurrence(Object o) - Удаляет первый встреченный элемент из очереди.
        //   Если удаление произошло, то возвращает true, иначе возвращает false.
        //
        // - removeLast() - Удаляет элемент из конца очереди.
        // Если очередь пуста, генерирует исключение NoSuchElementException.
        //
        // - removeLastOccurrence(Object o) - Удаляет последний встреченный элемент из очереди.
        // Если удаление произошло, то возвращает true, иначе возвращает false.


    }
}
