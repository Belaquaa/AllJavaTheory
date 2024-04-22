package L2_OOP.c_Theory;

public class Binding {
    // ================================================= Связывание ================================================= \\

    // Связывание - наличие связи между ссылкой и кодом
    // Раннее связывание - связывние на этапе компиялции.
    // Дженерики, перегруженные, private, final, static методы. Используется ссылка
    //
    // Позднее связывание - динамическое, происходит во время выполнения программы. Объекты создаются во время работы.
    // Абстрактные и переопределенные методы
    //

    // Раннее свзязывание
    // В этом примере вызов SuperClass.print() связывается во время компиляции, так как это статический метод.
    class EarlyBindingExample {
        static class SuperClass {
            static void print() {
                System.out.println("Метод из SuperClass");
            }
        }

        static class SubClass extends SuperClass {
            static void print() {
                System.out.println("Метод из SubClass");
            }
        }

        public static void main(String[] args) {
            SuperClass.print(); // Раннее связывание
        }
    }


    // Позднее связывание
    // Хотя тип переменной obj является SuperClass, фактический объект, на который она ссылается, является SubClass.
    // Следовательно, вызов obj.print() определяется во время выполнения, и вызывается переопределенный метод
    // из SubClass, что является примером позднего связывания.
    class LateBindingExample {
        static class SuperClass {
            void print() {
                System.out.println("Метод из SuperClass");
            }
        }

        static class SubClass extends SuperClass {
            @Override
            void print() {
                System.out.println("Метод из SubClass");
            }
        }

        public static void main(String[] args) {
            SuperClass obj = new SubClass();
            obj.print(); // Позднее связывание
        }
    }
}
