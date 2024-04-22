package L2_OOP.b_SOLID;

public class b_OpenClose {
    // ======================================= Принцип открытости/закрытости ======================================== \\

    // Принцип открытости/закрытости. Сущности (классы, модули, методы) открыты для расширения, но закрыты для изменения
}

// Допустим, у нас есть приложение, которое выводит приветствие пользователям.
// Вместо того, чтобы модифицировать существующий класс при добавлении нового типа приветствия,
// мы можем создать интерфейс и реализовать его для каждого типа приветствия.


// Интерфейс, который представляет действие приветствия
interface Greeting {
    void greet();
}

// Реализация интерфейса для простого приветствия
class SimpleGreeting implements Greeting {
    public void greet() {
        System.out.println("Hello, User!");
    }
}

// Реализация интерфейса для более сложного приветствия
class FancyGreeting implements Greeting {
    public void greet() {
        System.out.println("Greetings, Esteemed User!");
    }
}

// Класс, который использует приветствия
class GreetingManager {
    private Greeting greeting;

    public GreetingManager(Greeting greeting) {
        this.greeting = greeting;
    }

    public void issueGreeting() {
        greeting.greet();
    }
}

// Демонстрация использования
class MainOC {
    public static void main(String[] args) {
        Greeting simpleGreeting = new SimpleGreeting();
        GreetingManager manager = new GreetingManager(simpleGreeting);
        manager.issueGreeting();

        Greeting fancyGreeting = new FancyGreeting();
        manager = new GreetingManager(fancyGreeting);
        manager.issueGreeting();
    }
}

// В этом примере, если мы захотим добавить новый способ приветствия, нам просто нужно будет создать новый класс,
// реализующий интерфейс Greeting, и передать его экземпляр в GreetingManager.
// Существующий код изменять не потребуется, что соответствует принципу открытости/закрытости.