package L2_OOP.a_OOP;

public class c_Polymorphism {

    // ================================================ Полиморфизм ================================================= \\

    // Полиморфизм - возможность использовать объект производного класса, вместо родительского,
    //               переопределение или перегрузка
    //
    //   Гибкость и расширяемость кода: можно использовать один и тот же код для работы с объектами разных классов,
    // если эти классы наследуются от одного родительского класса или реализуют один интерфейс.
    // Это упрощает добавление новых типов объектов без изменения существующего кода, который с ними работает.
    //
    //   Упрощение кода: полиморфизм помогает уменьшить количество кода, поскольку позволяет использовать общие методы
    // для работы с объектами различных классов.
    //
    //   Возможность замены объектов: полиморфизм позволяет заменять объекты одного класса объектами другого класса во
    // время выполнения программы, если они имеют общий родительский класс или интерфейс.
    // Это может быть полезно для изменения поведения программы на лету.
    //
}

/*
Переопределение (Override)
 */

class Animal_poly {
    void sound() {
        System.out.println("Животное издает звук");
    }
}

class Dog_poly extends Animal_poly {
    @Override
        // Переопределение. Возвращаемый тип совпадает/является подклассом
        // Модификатор доступа совпадает/более открытый
        // Статичные методы нельзя переопределить, можно только перегрузить
    void sound() {
        System.out.println("Собака говорит Гав");
    }
}

class Cat_poly extends Animal_poly {
    @Override
    void sound() {
        System.out.println("Кот говорит Мяу");
    }
}

class Main {
    public static void main(String[] args) {
        Animal_poly myAnimal = new Animal_poly(); // Создаем объект класса Animal
        Animal_poly myDog = new Dog_poly(); // Создаем объект класса Dog, но типа Animal
        Animal_poly myCat = new Cat_poly(); // Создаем объект класса Cat, но типа Animal

        myAnimal.sound(); // Вызывает метод sound() класса Animal
        myDog.sound(); // Вызывает метод sound() класса Dog
        myCat.sound(); // Вызывает метод sound() класса Cat
    }
}

// Практическая польза:
// Обобщение: если есть функция, которая может работать с любым животным, то вы можете передать в неё объект класса Cat,
// используя тип Animal. Это позволяет функции работать с любым типом животного, не заботясь о  деталях каждого класса
//
// Гибкость: если код ориентирован на работу с типом Animal, можно легко заменить объект класса Cat на объект
// другого класса, например, Dog, без необходимости изменения кода, который использует эти объекты
//
// Инкапсуляция: вы скрываете детали реализации класса Cat от остальной части программы, что является хорошей практикой
// инкапсуляции. Программа знает только о том, что она работает с Animal, и не зависит от специфики класса Cat.


/*
Перегрузка
 */
class MainSecondary {

    // Метод для сложения двух целых чисел
    public int add(int a, int b) {
        return a + b;
    }

    // Перегруженный метод для сложения трех целых чисел
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Перегруженный метод для сложения двух чисел с плавающей точкой
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        MainSecondary example = new MainSecondary();

        // Вызов метода для сложения двух целых чисел
        System.out.println(STR."Сумма двух целых чисел: \{example.add(10, 20)}");

        // Вызов перегруженного метода для сложения трех целых чисел
        System.out.println(STR."Сумма трех целых чисел: \{example.add(10, 20, 30)}");

        // Вызов перегруженного метода для сложения двух чисел с плавающей точкой
        System.out.println(STR."Сумма двух чисел с плавающей точкой: \{example.add(10.5, 20.5)}");
    }
}
