package L2_OOP.c_Theory;

public class Associations {
    // ================================================= Ассоциация ================================================= \\

    // Ассоциация - "has a" - наличие связи между объектами, они могут ссылаться друг на друга (наследование - "is a").
    // Агрегация - связь, часть может существовать отдельно от целого (книга и библиотека). Вложенный статический класс
    // Композиция - связь, часть существует только с целым (страница и книга). Вложенный класс

}

/*
Агрегация
*/
class Engine {
    private String type;

    void startEngine() {
        System.out.println("Двигатель запущен.");
    }
}

class Car1 {
    // Car "имеет-а" Engine. Это агрегация.
    Engine engine; // Агрегация

    Car1(Engine engine) {
        this.engine = engine;
    }

    void startCar() {
        engine.startEngine();
        System.out.println("Машина поехала.");
    }
}

/*
Композиция
*/
class Car2 {
    // Car "содержит" Engine. Это композиция.
    private Engine engine; // Композиция

    Car2() {
        this.engine = new Engine(); // Создание экземпляра Engine внутри конструктора Car
    }

    void startCar() {
        engine.startEngine();
        System.out.println("Машина поехала.");
    }
}

class MainAgregation {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car1 car1 = new Car1(engine);
        Car2 car2 = new Car2();
        car1.startCar();
        car1.startCar();
    }
}