package L9_Streams;

import java.util.Arrays;
import java.util.List;

public class Theory {
    // =================================================== Стримы =================================================== \\

    // Стрим - это абстракция, которая позволяет обрабатывать последовательности элементов (например, коллекции)
    // в функциональном стиле (производить различные операции)
    //
    // Основные особенности стримов в Java:
    // 1. Не хранят данные. Стримы не изменяют исходную коллекцию или массив, на основе которого они созданы.
    // Они просто предоставляют пайплайн (конвейер) для операций с данными.
    //
    // 2. Ленивые вычисления. Операции с данными в стримах выполняются лениво, то есть фактическая обработка данных
    // начинается только тогда, когда это становится необходимым — например, при вызове терминальной операции.
    //
    // 3. Поддержка параллельной обработки. Стримы могут обрабатываться как в однопоточном, так и в многопоточном режиме
    // (параллельные стримы), что позволяет эффективно использовать многоядерные процессоры.
    //
    // Основные операции со стримами делятся на два типа:
    // - Промежуточные (intermediate): преобразуют стрим и возвращают новый стрим. Примеры: filter, map, sorted.
    // Эти операции не выполняются сразу после вызова и служат для построения пайплайна обработки данных.
    //
    // - Конечные (terminal): выполняют финальную операцию и завершают работу стрима, возвращая результат (или void)
    // Примеры: forEach, collect, reduce, sum. Вызов терминальной операции запускает обработку данных.
    //
    // Ассоциативные массивы (maps, ключ-значение), например HashMap, не поддерживаются!

    // ============================================= Стримы vs Коллекции ============================================ \\

    // Коллекция - это структура данных, набор каких-либо объектов. Данными (объектами в наборе) могут быть
    // числа, строки, объекты пользовательских классов и т.п. List, Set, Queue
    //
    // Коллекции позволяют работать с элементами по-отдельности, тогда как стримы так делать не позволяют,
    // но вместо этого предоставляют возможность выполнять функции над данными как над одним целым

    // Также стоит отметить важность самой концепции сущностей: Collection - это прежде всего воплощение структуры
    // данных. Например, Set не просто хранит в себе элементы, он реализует идею множества с уникальными элементами,
    // тогда как Stream - это прежде всего абстракция необходимая для реализации конвеера вычислений, собственно поэтому
    // результатом работы конвеера являются те или иные структуры данных или же результаты проверок/поиска и т.п.

    // ============================================= Параллельные стримы ============================================ \\

    // Параллельные стримы позволяют обрабатывать свои элементы одновременно в нескольких потоках
    // Элементы разделяются на группы, их обработка проходит в каждом потоке по отдельности. Затем они объединяются
    // С помощью parallel и sequential можно явно указать, что нужно сделать параллельным, а что последовательным

    // Не рекомендуется использовать параллельность для выполнения долгих операций, потому что все стримы работают с
    // общим пулом. Долгие операции могут остановить работу всех параллельных стримов JVM (недостаток свободных стримов)

    // ========================================== IntStream и DoubleStream ========================================== \\

    // Есть специальные стримы: IntStream, LongStream, DoubleStream
    // У них есть все методы обычных стримов + count, average, sum, min, max, range и др.
    //
    // Созданы специально для примитивных типов, т.к. обычный стрим работает с объектами - в нем будут дополнительные
    // расходы на упаковку и распаковку.

}

// Пример использования стрима для фильтрации, преобразования и вывода списка чисел:
class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream() // создаем стрим из списка
                .filter(n -> n % 2 == 0) // фильтруем четные числа
                .map(n -> n * n) // возводим отфильтрованные числа в квадрат
                .sorted()
                .forEach(System.out::println); // выводим результат

        // Метод .reduce() в Java Stream API используется для выполнения операции сокращения на элементах стрима,
        // то есть процесса комбинирования элементов стрима для создания одного суммарного результата
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
        int sum = number.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum); // Вывод: 15



    }
}
