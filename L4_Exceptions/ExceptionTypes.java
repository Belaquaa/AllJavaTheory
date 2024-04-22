package L4_Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTypes {
    // =============================================== Виды исключений ============================================== \\
    // Error указывает на серьезные ошибки, которые обрабатывать не нужно,
    // Exception делится на две категории: Checked и Unchecked
}

// ================================================ Checked Exceptions ============================================== \\

// Checked - должны обрабатываться блоком catch, проверяются при компиляции
//        * IOException - вввод-вывод, может возникать при работе с файлами (файла не существует)
//        * SQLException - исключения, связанные с доступом к базе данных
//        * ClassNotFoundException - приложение пытается загрузить класс через его строковое имя
//        * InterruptedException - поток в режиме ожидания перекрывается другим потоком (Thread.sleep())
//        * NoSuchMethodException - метод не найден
//        * MalformedURLException - неправильно сформированный URL

class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("non_existent_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}

// =============================================== Unchecked Exceptions ============================================= \\

// Unchecked - могут не обрабатываться, проверяются при выполнени, возникают из-за ошибок в логике программы
//        * наследуются от RuntimeException
//        * Ошибки (Error)
//        * NullPointerException - используется null вместо объекта (например, при вызове метода у null ссылки)
//        * ArrayIndexOutOfBoundsException - обращение по выходящему за пределы индексу массива
//        * ClassCastException - попытка приведения типа объекта к другому несовместима
//        * ArithmeticException - арифметические ошибки, деление на ноль
//        * IllegalArgumentException - недопустимый аргумент
//        * NumberFormatException - неудачное преобразование строки в числовой тип

class UncheckedExceptionExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        // Попытка доступа к элементу за пределами массива вызовет unchecked исключение ArrayIndexOutOfBoundsException
        System.out.println("Элемент не найден");
        System.out.println(numbers[3]);
    }
}

// ============================================== Подавленные исключения ============================================ \\

// Подавленные исключения - механизм, позволяющий сохранить исключения,
// возникшее в блоках try-with-resources или в блоках finally,
// не теряя при этом информацию об этих исключениях, даже если в блоке try или catch возникает другое исключение.
// При появлении подавленного исключения, первое исключение считается главным, остальные - подавленные.

class SuppressedExceptionsExample {
    public static void main(String[] args) {
        try (One one = new One(); Two two = new Two()) {
            throw new Exception("Exception in try");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }

    static class One implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("Exception in One.close()");
        }
    }

    static class Two implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("Exception in Two.close()");
        }
    }
}

