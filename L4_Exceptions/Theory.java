package L4_Exceptions;

import java.io.FileInputStream;
import java.io.IOException;

public class Theory {
    // ================================================= Исключения ================================================= \\

    // Исключение - объект, который описывает исключительное состояние, возникшее в каком-либо участке кода,
    // Исключения представленны классом Throwable и его подклассами (Error и Exception).
    //
    // Отлавливание исключений:
    // 1. try - блок, в котором может появится исключение
    // 2. catch - указываем исключение и его обработку
    //    * можно отлавливать сразу несколько исключений-братьев (catch E1 | E2 | e),
    //      должны быть на одном уровне иерархии - не наследниками
    //    * обращаемся от наследника к предку
    // 3. finally - отработает всегда, кроме ситуаций:
    //    * в try или catch используется System.exit()
    //    * происходит сбой JVM
    //    * уничтожается выполняющий поток

    // Пример вызова исключения
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // Попытка доступа к несуществующему индексу массива
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Доступ за пределы массива!");
        } finally {
            System.out.println("Блок finally выполнен.");
        }
    }

    // =============================================== Throw и throws =============================================== \\

    // Throw - используется для явного выброса исключения
    //    * может быть использован в любом месте кода
    //    * после throw следует экземпляр класса (throw new SomeException("Сообщение об ошибке"))
    //    * одно исключение за раз
    //
    // Throws - используется в сигнатуре (описании) метода для указания, что метод может выбрасить исключение, это важно для checked исключений
    //    * не выбрасывает исключение, лишь показывает, что метод может выбросить исключение
    //    * позволяет обработать исключение в вызывающем коде или передать его дальше по стеку вызовов
    //    * исключения должны быть обработаны в вызывающем коде (через try)

    public void myMethod() throws IOException { // throws
        // Код, который может выбросить IOException
        throw new IOException("Что-то пошло не так!"); // throw
    }

    // ============================================= Try with resources ============================================= \\

    // Try with resources позволяет объявить ресурсы в блоке try, которые будут автоматически закрыты без finally
    // Закрываются в обратном порядке через .close()

    public void myMethod2() {
        try (FileInputStream fis = new FileInputStream("file.txt")) {
            // Чтение данных из файла
        } catch (IOException e) {
            // Обработка исключения IOException
            System.out.println("File not found");
        }
    }

    // ====================================== Создание собственного исключения ====================================== \\

    // Наследоваться от класса Exception (для проверяемых исключений) или от RuntimeException (для непроверяемых)
    // Определить конструкторы, как в любом другом классе


    // Создание проверяемого исключения
    public class MyCustomException extends Exception {
        public MyCustomException(String message) {
            super(message);
        }
        // Дополнительные конструкторы или методы, если необходимо
    }

    // Создание непроверяемого исключения
    public class MyCustomRuntimeException extends RuntimeException {
        public MyCustomRuntimeException(String message) {
            super(message);
        }
        // Дополнительные конструкторы или методы, если необходимо
    }
}