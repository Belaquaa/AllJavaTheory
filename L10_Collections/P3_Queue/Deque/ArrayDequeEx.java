package L10_Collections.P3_Queue.Deque;

import java.util.ArrayDeque;

public class ArrayDequeEx {
    public static void main(String[] args) {
        // =============================================== ArrayDeque =============================================== \\

        // Класс ArrayDeque представляет обобщенную двунаправленную очередь,
        // наследуя функционал от класса AbstractCollection и реализуя интерфейс Deque.
        // Более эффективная альтернатива LinkedList для реализации стеков и очередей

        // Не имеет ограничений по емкости, растет по мере необходимости для поддержки использования.

        ArrayDeque stack = new java.util.ArrayDeque<>();
        stack.push("Element 1");
        stack.push("Element 2");
        stack.push("Element 3");

        // Вывод верхнего элемента без удаления
        System.out.println("Top: " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        // Использование как очереди (FIFO)
        java.util.ArrayDeque queueEx = new java.util.ArrayDeque<>();
        queueEx.offer("Element 1");
        queueEx.offer("Element 2");
        queueEx.offer("Element 3");

        // Удаление элементов из очереди
        while (!queueEx.isEmpty()) {
            System.out.println("Polled: " + queueEx.poll());
        }
    }
}
