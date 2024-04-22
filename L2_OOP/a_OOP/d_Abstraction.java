package L2_OOP.a_OOP;

public class d_Abstraction {

    // ================================================ Абстракция ================================================== \\

    // Абстракция - выделение наиболее важных характеристик объекта, создаем только важные переменные
    //
    // Понятность: абстракция помогает разработчикам сосредоточиться на том, как объекты взаимодействуют в системе,
    // а не на деталях реализации каждого объекта.
    //
    // Сокращение сложности: выделяя только важные характеристики, абстракция уменьшает сложность программы,
    // делая ее более управляемой.
    //
    // Повышение гибкости: абст..рактные конструкции облегчают модификацию и расширение программы,
    // поскольку изменения в абстрактном слое меньше затрагивают остальные части программы.
}

// Абстрактный класс Транспортное средство
abstract class Transport {
    // Абстрактный метод для получения максимальной скорости
    abstract int getMaxSpeed();

    // Конкретный метод, доступный всем подклассам
    public void start() {
        System.out.println("Транспортное средство начало движение.");
    }
}

// Класс Автомобиль, наследующий от Транспортного средства
class Car extends Transport {
    @Override
    int getMaxSpeed() {
        return 240; // Максимальная скорость автомобиля
    }
}

// Класс Велосипед, наследующий от Транспортного средства
class Bicycle extends Transport {
    @Override
    int getMaxSpeed() {
        return 40; // Максимальная скорость велосипеда
    }
}

class MainAbstraction {
    public static void main(String[] args) {
        Car car = new Car();
        Bicycle bicycle = new Bicycle();

        System.out.println(STR."Максимальная скорость автомобиля: \{car.getMaxSpeed()} км/ч");
        car.start();

        System.out.println(STR."Максимальная скорость велосипеда: \{bicycle.getMaxSpeed()} км/ч");
        bicycle.start();
    }
}
