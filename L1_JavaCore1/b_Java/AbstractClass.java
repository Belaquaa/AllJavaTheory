package L1_JavaCore1.b_Java;

public class AbstractClass {
    // =============================================== Abstract class =============================================== \\

    // Используется, когда классы имеют общую реализацию некоторых методов
    // Наследуется только один раз, класс "растворяет" собственную индивидуальность
    // Может содержать поля и конкретные методы, есть конструктор
    // Отношение "is a", extends

    abstract class Animal {
        abstract void makeSound();

        void eat() {
            System.out.println("This animal eats food.");
        }
    }

    // Конкретный класс, наследующий абстрактный класс
    class Dog extends Animal {
        void makeSound() {
            System.out.println("Woof Woof");
        }
    }

    public void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat();
        myDog.makeSound();
    }


    // ================================================== Interface ================================================= \\

    // Используется для определения контракта, который должны реализовать классы
    // Подходят для определения общего поведения, которое может быть разным для классов
    // Множественное наследование без иерархии, класс расширяет функциональность
    // Нет конструктора и состояния, все методы public abstract или default, поля public static final
    // Может наследоваться от других интерфейсов, нет геттеров и сеттеров

    public interface Vehicle {
        void cleanVehicle();

        default void startVehicle() {
            System.out.println("Vehicle is starting...");
        }
    }

    public class Car implements Vehicle {
        @Override
        public void cleanVehicle() {
            System.out.println("Cleaning the car...");
        }
        // Дефолтный метод startVehicle() наследуется и может быть использован напрямую
        // или переопределен, если необходимо изменить его поведение для Car
    }

    public class Bike implements Vehicle {
        @Override
        public void cleanVehicle() {
            System.out.println("Cleaning the bike...");
        }

        // Переопределяем дефолтный метод для Bike
        @Override
        public void startVehicle() {
            System.out.println("Bike is starting...");
        }
    }


    // ============================================ Default в интерфейсе ============================================ \\

    // default позволяет добавить методы с реализацией
    // Нужен для обратной совместимости: добавляем новые методы в интерфейс, но ничего не изменяем в реализующем классе,
    //                                   то есть необязательно переопределять defaultMethod()

    // ============================================== Interface-marker ============================================== \\

    // Интерфейс-маркер - это пустой интерфейс, не содержащий методов (например, Sizeable, Cloneable, Remote).
    // Это значит, класс обладает определенным свойством или поведением
}
