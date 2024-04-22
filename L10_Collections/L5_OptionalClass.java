package L10_Collections;

import java.util.Optional;

public class L5_OptionalClass {
    public static void main(String[] args) {
        // ============================================= Класс Optional ============================================= \\

        // Опциональное значение Optional — это контейнер для объекта, который может содержать или не содержать
        // значение null. Такая обёртка является удобным средством предотвращения NullPointerException, т.к. имеет
        // некоторые функции высшего порядка, избавляющие от добавления повторяющихся if null/notNull проверок.

        Optional<String> optional = Optional.of("Hello, World!");

        // Проверяем, есть ли значение
        if (optional.isPresent()) {
            System.out.println(optional.get()); // Выводит: Hello, World!
        }

        // Использование метода ifPresent для вывода значения
        optional.ifPresent(System.out::println); // Выводит: Hello, World!

        // Использование orElse для предоставления альтернативного значения
        String nullSafeValue = optional.orElse("Default Value");
        System.out.println(nullSafeValue); // Выводит: Hello, World!

        // Пример с пустым Optional
        Optional<String> emptyOptional = Optional.empty();
        String result = emptyOptional.orElse("Default Value");
        System.out.println(result); // Выводит: Default Value

        // empty(): Возвращает пустой объект Optional.
        //
        // of(value): Возвращает объект Optional с указанным значением, которое не может быть null.
        // Если передать null, будет выброшено исключение NullPointerException.
        //
        // ofNullable(value): Возвращает объект Optional с указанным значением, если значение не null,
        // иначе возвращает пустой объект Optional.
        //
        // get(): Возвращает значение, если оно присутствует, иначе выбрасывает исключение NoSuchElementException.
        //
        // isPresent(): Возвращает true, если значение присутствует, иначе false.
        //
        // ifPresent(consumer): Если значение присутствует, выполняет заданное действие с этим значением.
        //
        // orElse(other): Возвращает значение, если оно присутствует, иначе возвращает другое значение,
        // указанное в качестве аргумента.
        //
        // orElseGet(supplier): Возвращает значение, если оно присутствует, иначе возвращает значение,
        // полученное от поставщика.
        //
        // orElseThrow(exceptionSupplier): Возвращает значение, если оно присутствует, иначе выбрасывает исключение,
        // созданное поставщиком исключений.
        //
        // map(function): Если значение присутствует, применяет функцию к значению и возвращает Optional
        // с результатом функции. Если значение отсутствует, возвращает пустой Optional.
        //
        // flatMap(function): Если значение присутствует, применяет функцию Optional к значению и возвращает результат.
        // Если значение отсутствует, возвращает пустой Optional.
        //
        // filter(predicate): Если значение присутствует и удовлетворяет предикату, возвращает Optional с этим значением,
        // иначе возвращает пустой Optional.

    }
}
