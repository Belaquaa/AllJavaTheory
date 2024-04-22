package L10_Collections.P3_Queue;

import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueEx {
    public static void main(String[] args) {
        // ============================================= PriorityQueue ============================================== \\

        // Класс PriorityQueue – очередь с приоритетами.
        // По умолчанию размещает элементы согласно естественному порядку сортировки используя Comparable:
        // элементу с наименьшим значением присваивается наибольший приоритет. Не поддерживает null

        // Если несколько элементов имеют одинаковый приоритет – связь определяется произвольно.
        // Можно указать порядок размещения, используя Comparator.

        // Создаем приоритетную очередь с кастомным компаратором
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // Сначала сравниваем по четности (нечетные имеют более высокий приоритет)
                if (o1 % 2 == o2 % 2) {
                    // Если четность одинакова, сравниваем числа
                    return Integer.compare(o1, o2);
                } else {
                    // Четные числа имеют более низкий приоритет (возвращаем -1, если первое число четное)
                    return (o1 % 2 == 0) ? -1 : 1;
                }
            }
        });

        queue.add(5);
        queue.add(2);
        queue.add(1);
        queue.add(4);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}


