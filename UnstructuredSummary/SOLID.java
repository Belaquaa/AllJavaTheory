package UnstructuredSummary;


/*
#Принципы СОЛИД
 */

/*
1. Принцип единственной ответственности.
Каждый класс должен иметь одну инкапсулированную обязанность.
 */


// Пример ДО (один класс)
//
//public class User {
//    public void addUser(String user) {
//        // Добавление пользователя
//    }
//
//    public void sendEmail(String message) {
//        // Отправка email
//    }
//}
//
// Пример ПОСЛЕ (разные классы)
//
//public class User {
//    public void addUser(String user) {
//      // Добавление пользователя
//    }
//}
//
//public class EmailSender {
//    public void sendEmail(String message) {
//      // Отправка email
//    }
//}


/*
2. Принцип открытости/закрытости.
Сущности (классы, модули, методы) открыты для расширения, но закрыты для изменения.
 */

// Пример ДО (связь напрямую)
//
//public class Rectangle {
//    public double length;
//    public double width;
//}
//
//public class AreaCalculator {
//    public double calculateRectangleArea(Rectangle rectangle) {
//        return rectangle.length * rectangle.width;
//    }
//}
//
// Пример ПОСЛЕ (связь через интерфейс)
//
//public interface Shape {
//    double calculateArea();
//}
//
//public class Rectangle implements Shape {
//    public double length;
//    public double width;
//
//    @Override
//    public double calculateArea() {
//        return length * width;
//    }
//}
//
//public class AreaCalculator {
//    public double calculateArea(Shape shape) {
//        return shape.calculateArea();
//    }
//}

/*
3. Принцип подстановки Лисков.
Возможность поменять базовый класс на производный без изменения поведения программы.
 */

// Пример ДО
//
//public class Bird {
//    public void fly() {
//      // Реализация полета
//    }
//}
//
//public class Penguin extends Bird {
//    @Override
//    public void fly() {
//        throw new UnsupportedOperationException();
//    }
//}
//
// Пример ПОСЛЕ
//
//public abstract class Bird {
//}
//
//public abstract class FlyingBird extends Bird {
//    public abstract void fly();
//}
//
//public class Sparrow extends FlyingBird {
//    @Override
//    public void fly() {
//        // Реализация полета
//    }
//}
//
//public class Penguin extends Bird {
//}

/*
4. Принцип разделения интерфейсов.
Клиенты не должны зависить от методов, которые они не используют. Несколько интерфейсов лучше одного универсального.
 */

// Пример ДО
//
//public interface Worker {
//    void work();
//    void eat();
//}
//
//public class HumanWorker implements Worker {
//    public void work() {
//        // Работа
//    }
//
//    public void eat() {
//        // Еда
//    }
//}
//
// Пример ПОСЛЕ
//
//public interface Workable {
//    void work();
//}
//
//public interface Eatable {
//    void eat();
//}
//
//public class HumanWorker implements Workable, Eatable {
//    public void work() {
//        // Работа
//    }
//
//    public void eat() {
//        // Еда
//    }
//}

/*
5. Принцип инверсии зависимостей.
Модули верхних уровней не должны зависеть от модулей нижних, а оба типа должны зависеть от абстракций.
Абстракции не должны зависеть от деталей, детали должны зависеть от абстракций (фигура и круг)
 */

// Пример ДО
//
//public class LightBulb {
//    public void turnOn() {
//        // Включение лампочки
//    }
//
//    public void turnOff() {
//        // Выключение лампочки
//    }
//}
//
//public class ElectricPowerSwitch {
//    public LightBulb lightBulb;
//
//    public ElectricPowerSwitch(LightBulb lightBulb) {
//        this.lightBulb = lightBulb;
//    }
//
//    public void press() {
//        // Включение или выключение света
//    }
//}
//
// Пример ПОСЛЕ
//
//public interface Switchable {
//    void turnOn();
//    void turnOff();
//}
//
//public class LightBulb implements Switchable {
//    @Override
//    public void turnOn() {
//        // Включение
//    }
//
//    @Override
//    public void turnOff() {
//        // Выключение
//    }
//}
//
//public class ElectricPowerSwitch {
//    public Switchable client;
//
//    public ElectricPowerSwitch(Switchable client) {
//        this.client = client;
//    }
//
//    public void press() {
//        // Включение или выключение
//    }
//}