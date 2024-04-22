package L11_FunctionalInterface;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Theory {
    public static void main(String[] args) {

        // ======================================== Функциональные интерфейсы ======================================= \\

        // Функциональный интерфейс в — это интерфейс, который содержит ровно один абстрактный метод.
        // Нужны, когда нужно передать в метод кусочек программной логики:
        // метод объявляется, как принимающий экземпляр какого-то класса или интерфейса

        //  Интерфейс может содержать любое количество методов по умолчанию (default) или статических методов,
        //  но должен быть только один абстрактный метод.

        // Снабжены аннотациями @FunctionalInterface
        // Если в интерфейсе с данной аннотацией более одного нереализованного (абстрактного) метода,
        // компилятор не пропустит данных интерфейс и будет считать его как ошибочный код

        // Могут быть представлены и использованием лямбда-выражений, ссылок на методы и ссылок на конструкторы
        // Если лямбда выражения вызывают только один существующий метод, лучше ссылаться на этот метод по его имени.
        // Ссылки на методы (Method References) – это компактные лямбда выражения для методов, у которых уже есть имя.

        // ============================================= Лямбда выражения =========================================== \\

        // Лямбда выражение в Java — это реализация единственного абстрактного метода функционального интерфейса.
        // Является сокращенной записью анонимного класса, который создается на основании функционального интерфейса.
        // Лямбда выражение состоит из списка параметров, стрелки (->) и {тела}. Например (int a, int b) -> a + b
        // this ссылается на внешний класс + могут быть созданы только на основании функциональных интерфейсов.
        //
        // Анонимный класс позволяет переопределять поведение уже существующих классов без создания новых подклассов.
        // Позволяет создавать экземпляры интерфейсов без явного создания классов, которые этот интерфейс реализуют.
        // this ссылается на сам класс + могут быть созданы на основании любых классов и интерфейсов +
        // нельзя создать новый метод

        // ============================================= Ссылки на метод ============================================ \\

        // Если лямбда выражения вызывают только один существующий метод, лучше ссылаться на этот метод по его имени.
        // Ссылки на методы (Method References) – это компактные лямбда выражения для методов, у которых уже есть имя

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.print(name));
        // или проще:
        names.forEach(System.out::print);
        // Метод forEach используется для итерации по элементам коллекции, но он требует функционального интерфейса
        // (например, Consumer) в качестве аргумента.

        // =========================================== Основные интерфейсы ========================================== \\

        //
        // 1. Consumer<T>
        // Принимает один входной параметр типа T и не возвращает значение (void). Метод: void accept(T t).
        Consumer<String> printConsumer = s -> System.out.println(s);
        printConsumer.accept("Hello, Consumer!");

        // 2. BiConsumer<T, U>
        // Принимает два параметра типа T и U и не возвращает значение. Метод: void accept(T t, U u).
        BiConsumer<String, Integer> printFormatConsumer = (s, n) -> System.out.println(s + n);
        printFormatConsumer.accept("Age: ", 30);

        // 3. Predicate<T>
        // Принимает один параметр типа T и возвращает значение типа boolean. Метод: boolean test(T t).
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(5)); // true

        // 4. BiPredicate<T, U>
        // Принимает два параметра типа T и U и возвращает boolean. Метод: boolean test(T t, U u).
        BiPredicate<Integer, String> validateInput = (i, s) -> i > 0 && s != null && !s.isEmpty();
        System.out.println(validateInput.test(10, "Hello")); // true

        // 5. Function<T, R>
        // Принимает параметр типа T и возвращает результат типа R. Метод: R apply(T t).
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println(stringLength.apply("Hello")); // 5

        // 6. BiFunction<T, U, R>
        // Принимает два параметра типа T и U и возвращает результат типа R. Метод: R apply(T t, U u).
        BiFunction<Integer, Integer, String> sumToString = (a, b) -> "Result: " + (a + b);
        System.out.println(sumToString.apply(5, 3)); // Result: 8

        // 7. UnaryOperator<T>
        // Разновидность Function, где входной и выходной типы совпадают. Метод: T apply(T t).
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // 25

        // 8. BinaryOperator<T>
        // Разновидность BiFunction, где все три типа совпадают. Метод: T apply(T t1, T t2).
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(5, 3)); // 15

        // 9. Supplier<T>
        // Не принимает параметров, но возвращает значение типа T. Метод: T get().
        Supplier<String> getString = () -> "Hello, Supplier!";
        System.out.println(getString.get());

        // Реализация своего функционального интерфейса

        @FunctionalInterface
        interface Converter<F, T> {
            T convert(F from);
        }

        Converter<String, Integer> stringToInteger = (String s) -> Integer.valueOf(s);
        Integer converted = stringToInteger.convert("123");
        System.out.println(converted); // Выводит 123, String -> Integer
    }
}