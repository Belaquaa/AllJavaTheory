package L2_OOP.b_SOLID;

public class a_SingleResponsibility {
    // ======================================= Принцип единой ответственности ======================================= \\

    // Принцип единственной ответственности. Каждый класс должен иметь одну инкапсулированную обязанность (область отв)
}

// Класс Person() отвечает за данные пользователя
class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void changeEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getName() {
        return name;
    }
}

// Выделяем реализацию отправки email-а в другой класс. Класс EmailService отвечает за отправку сообщения
class EmailService {
    public void sendEmail(Person user, String message) {
        System.out.println(STR."Send email to \{user.getName()} with message: \{message}");
    }
}

class MainSRP {
    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        Person person = new Person("John", "john@gmail.com");
        emailService.sendEmail(person, "Hello World!");
    }
}