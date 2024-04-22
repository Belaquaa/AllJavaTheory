package L1_JavaCore1.b_Java;
import java.util.function.Function;

public class ClassTypes {

    // ================================================ Типы классов ================================================ \\

    // Обычный класс: определяет объекты
    class Person {String name; int age;}

    // Абстрактный класс: определяет общее поведение и свойства
    abstract class Animal {abstract void makeSound();}

    // Интерфейсы: определяют контракт, который должен быть реализован классами
    interface Drawable {void draw();}

    // Финальный: нельзя наследоваться
    final class String { /*...*/ }

    // Перечисление enum: набор констант, не может наследовать
    enum Day {MON, TUE, WED, THU, FRI, SAT, SUN}

    // Вложенный: класс внутри класса
    class Outer { class Inner { void show() { /*...*/ } } }

    // Статический вложенный: не имеют доступа к нестатическим членам внешнего класса
    class OuterStatic { static class Nested { void show() { /*...*/ } } }

    // Анонимный класс: создаются без имени и используются только один раз.
    Runnable task = new Runnable() { @Override public void run() { } };
    Function<Integer, Integer> square = x -> x * x;
    // Позволяет переопределять поведение уже существующих классов без создания новых подклассов (новых файлов)
    // Позволяет создавать экземпляры интерфейсов без явного создания классов, которые этот интерфейс реализуют

    // Локальный класс: определяются внутри методов и имеют доступ к локальным переменным метода
    void method() { class LocalClass { /*...*/ } }
}
