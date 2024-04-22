package L1_JavaCore1.b_Java;

public strictfp class NativeAndRomb {
    // =================================================== native =================================================== \\

    // native указывает, что метод реализован на нативном языке, например, на C или С++
    // такие методы позволяют выполнять операции на низком уровне, которые невозможны или неэффективны в Java
    // плюсы: производительность и доступ к системным ресурсам
    // минусы: уменьшение переносимости и увеличение сложности

    // ============================= Проблема ромбовидного (множественного) наследования ============================ \\

    // Проблема возникает при наследовании от двух классов (или интерфесов), что приводит к неоднозначности. Решение:
    // Переопределить конфликрующий метод и явно указать, какую реализацию использовать, или создать свою реализацию
    interface A {
        default void show() {
            System.out.println("A");
        }
    }

    interface B extends A {
        @Override
        default void show() {
            System.out.println("B");
        }
    }

    interface C extends A {
        @Override
        default void show() {
            System.out.println("C");
        }
    }

    // Пример реализации: [interfaceName].super.[methodName]
    class D implements B, C {
        @Override
        public void show() {
            B.super.show(); // Явно указываем, какую реализацию хотим использовать
        }
    }

    public class DiamondProblemSolution {
        public void main(String[] args) {
            D d = new D();
            d.show(); // Выведет "B", так как мы выбрали реализацию из интерфейса B
        }
    }


    // ================================================== strictfp ================================================== \\

    // strictfp указывает, что производятся вычисления с плавающей точкой в соответсвии со стандартом IEEE 754.
    // это нужно для точности и предсказуемости результата на разных платформах


    // Метод для сложения двух чисел с плавающей точкой
    public double add(double a, double b) { return a + b; }

    public static void main(String[] args) {
        NativeAndRomb calc = new NativeAndRomb();
        System.out.println(STR."100.0 + 200.0 = \{calc.add(100.0, 200.0)}");
    }
}


