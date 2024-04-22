package Amain;

import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        InputStreamReader as = new InputStreamReader(System.in);
    }
}

/*
Обозначения:
# - тема
 */


/*
#ООП
 */

/*
ИНКАПСУЛЯЦИЯ
 */

//class Person {
//    // Приватное поле, недоступное напрямую извне класса
//    private String name;
//
//    // Конструктор класса
//    public Person(String name) {
//        this.name = name;
//    }
//
//    // Геттер для name
//    public String getName() {
//        return name;
//    }
//
//    // Сеттер для name
//    public void setName(String name) {
//        this.name = name;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Person p = new Person("John");
//        p.setName("Jack"); // Устанавливаем имя через set. John -> Jack
//        System.out.println(p.getName()); // Получаем имя через get. Jack
//    }
//}

/*
НАСЛЕДОВАНИЕ
 */

//// Базовый класс
//class Animal {
//    // Поле базового класса
//    String name;
//
//    // Метод базового класса
//    public void eat() {
//        System.out.println(name + " ест");
//    }
//}
//
//// Подкласс, наследующий класс Animal
//class Dog extends Animal {
//    // Конструктор подкласса
//    Dog(String name) {
//        this.name = name; // Инициализация поля базового класса в подклассе
//    }
//
//    // Метод подкласса
//    public void bark() {
//        System.out.println(name + " лает");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        // Создание объекта подкласса
//        Dog myDog = new Dog("Рекс");
//        myDog.eat(); // Вызов метода базового класса. Рекс ест
//        myDog.bark(); // Вызов метода подкласса. Рекс лает
//    }
//}

/*
ПОЛИМОРФИЗМ и ПЕРЕОПРЕДЕЛЕНИЕ
 */

//class Animal {
//    void sound() {
//        System.out.println("Животное издает звук");
//    }
//}
//
//class Dog extends Animal {
//    @Override // Переопределение. Возвращаемый тип совпадает/является подклассом
                // Модификатор доступа совпадает/более открытый
                // Статичные методы нельзя переопределить, можно только перегрузить
//    void sound() {
//        System.out.println("Собака говорит Гав");
//    }
//}
//
//class Cat extends Animal {
//    @Override
//    void sound() {
//        System.out.println("Кот говорит Мяу");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Animal myAnimal = new Animal(); // Создаем объект класса Animal
//        Animal myDog = new Dog(); // Создаем объект класса Dog, но типа Animal
//        Animal myCat = new Cat(); // Создаем объект класса Cat, но типа Animal
//
//        myAnimal.sound(); // Вызывает метод sound() класса Animal
//        myDog.sound(); // Вызывает метод sound() класса Dog
//        myCat.sound(); // Вызывает метод sound() класса Cat
//    }
//}

/*
ПЕРЕГРУЗКА
 */

//public class Main {
//
//    // Метод для сложения двух целых чисел
//    public int add(int a, int b) {
//        return a + b;
//    }
//
//    // Перегруженный метод для сложения трех целых чисел
//    public int add(int a, int b, int c) {
//        return a + b + c;
//    }
//
//    // Перегруженный метод для сложения двух чисел с плавающей точкой
//    public double add(double a, double b) {
//        return a + b;
//    }
//
//    public static void main(String[] args) {
//        Main example = new Main();
//
//        // Вызов метода для сложения двух целых чисел
//        System.out.println("Сумма двух целых чисел: " + example.add(10, 20));
//
//        // Вызов перегруженного метода для сложения трех целых чисел
//        System.out.println("Сумма трех целых чисел: " + example.add(10, 20, 30));
//
//        // Вызов перегруженного метода для сложения двух чисел с плавающей точкой
//        System.out.println("Сумма двух чисел с плавающей точкой: " + example.add(10.5, 20.5));
//    }
//}


/*
Интерфейс - маркер
 */

//interface MyMarkerInterface {
//    // Пустой интерфейс
//}
//
//class MyClass implements MyMarkerInterface {
//    // Класс, реализующий интерфейс маркера
//}
//
//public class DivisionCalculator {
//    public static void main(String[] args) {
//        MyClass myObject = new MyClass();
//
//        if (myObject instanceof MyMarkerInterface) {
//            System.out.println("Объект myObject является экземпляром MyMarkerInterface");
//        } else {
//            System.out.println("Объект myObject не является экземпляром MyMarkerInterface");
//        }
//    }
//}


/*
Создание собственного исключения
 */

//public class MyException extends Exception {
//    public MyException(String message) {
//        super(message);
//    }
//}


/*
Логгирование
 */

//import java.util.logging.Logger;
//import java.util.logging.Level;
//
//public class Main {
//    private static final Logger LOGGER = Logger.getLogger(DemoLogging.class.getName());
//
//    public static void main(String[] args) {
//        LOGGER.info("Начало работы программы");
//
//        try {
//            // Код, который может вызвать ошибку
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "Произошла ошибка", e);
//        }
//    }
//}

/*
Сериализация
 */

//import java.io.Serializable;
////
//public class Cat implements Serializable {
//
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//}