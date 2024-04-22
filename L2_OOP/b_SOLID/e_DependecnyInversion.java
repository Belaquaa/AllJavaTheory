package L2_OOP.b_SOLID;

public class e_DependecnyInversion {
    // ======================================= Принцип инверсии зависимостей ======================================== \\

    // Принцип инверсии зависимостей. Модули верхних уровней не должны зависеть от модулей нижних,
    // а оба типа должны зависеть от абстракций.
    // Абстракции не должны зависеть от деталей, детали должны зависеть от абстракций (фигура и круг)
}

// Шаг 1: Создаем абстракцию (интерфейс) для записи сообщения
interface MessageLogger {
    void log(String message);
}

// Шаг 2: Реализуем этот интерфейс для записи сообщения в файл
class FileLogger implements MessageLogger {
    public void log(String message) {
        // Логика записи сообщения в файл
        System.out.println(STR."L5_Logging message to a file: \{message}");
    }
}

// Шаг 3: Реализуем этот интерфейс для отправки сообщения по электронной почте
class EmailLogger implements MessageLogger {
    public void log(String message) {
        // Логика отправки сообщения по электронной почте
        System.out.println(STR."Sending email with message: \{message}");
    }
}

// Шаг 4: Создаем класс, который использует абстракцию для записи сообщения
class MessageService {
    private MessageLogger logger;

    // В конструкторе передаем зависимость
    public MessageService(MessageLogger logger) {
        this.logger = logger;
    }

    public void logMessage(String message) {
        logger.log(message);
    }
}

// Шаг 5: Демонстрация использования
class Main {
    public static void main(String[] args) {
        // Используем запись в файл
        MessageService fileMessageService = new MessageService(new FileLogger());
        fileMessageService.logMessage("Hello, file!");

        // Используем отправку по электронной почте
        MessageService emailMessageService = new MessageService(new EmailLogger());
        emailMessageService.logMessage("Hello, email!");
    }
}
