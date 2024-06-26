package L2_OOP.a_OOP;

public class a_Encapsulation {

    // ================================================ Инкапсуляция ================================================ \\

    // Инкапсуляция - скрытие внутреннего состояния объекта и предоставление публичных методов для доступа к нему
    //
    // Цель: уйти от зависимости внешнего интерфейса класса (то, что могут использовать другие классы) от реализации.
    // Чтобы малейшее изменение в классе не влекло за собой изменение внешнего поведения класса.
    //
    // Безопасность: защищает данные класса от неправильного доступа и модификации, позволяя устанавливать доступ
    // к полям класса только через методы (геттеры и сеттеры).
    //
    // Гибкость и Масштабируемость: изменения в реализации класса не влияют на код, который использует этот класс,
    // что упрощает обновление и модификацию программы.
    //
    // Упрощение: скрытие сложности реализации за простыми методами улучшает читаемость и управляемость кода.
    //
    // Контроль доступа: можно точно контролировать, какие данные и методы класса доступны для других классов,
    // а какие — нет.
}

class Person {
    // Приватное поле, недоступное напрямую извне класса
    private String name;

    // Конструктор класса
    public Person(String name) {
        this.name = name;
    }

    // Геттер для name
    public String getName() {
        return name;
    }

    // Сеттер для name
    public void setName(String name) {
        this.name = name;
    }
}

class Main_a_Encapsulation {
    public static void main(String[] args) {
        Person p = new Person("John");
        p.setName("Jack"); // Устанавливаем имя через set. John -> Jack
        System.out.println(p.getName()); // Получаем имя через get. Jack
    }
}

