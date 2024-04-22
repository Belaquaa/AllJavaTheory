package L6_SerializationAndClonning.Serialization;

import java.io.*;
import java.io.Serializable;


public class Serialization {

    // ======================================== Этапы и условия сериализации ======================================== \\

    // Этапы:
    //  1. Запись метаданных о классе, ассоциированном с объектом
    //  2. Рекурсивная запись описания суперклассов от родителя до наследника (пока не будет достигнут java.lang.object)
    //  3. Запись фактических данных (примитивов), начинается с верхнего класса
    //  4. Запись данных в поток
    //
    // Условия:
    //  1. Класс объекта должен реализовывать интерфейс Serializable
    //  2. Создать поток ObjectOutputStream (oos), который записывает объект в переданный OutputStream
    //  3. Записать в поток oos.writeObject(Object)
    //  4. Сделать oos.flush() и oos.close() - очистить буфер и закрыть

}

// ============================================ Как сериализовать объект ============================================ \\

// Для начала следует убедиться, что класс сериализуемого объекта реализует интерфейс java.io.Serializable:

class TestSerial implements Serializable {
    public byte version = 100;
    public byte count = 0;

    // Теперь у нас есть всё для сериализации объекта, следующим шагом будет фактическая сериализация объекта.
    // Она делается вызовом метода writeObject() класса java.io.ObjectOutputStream:

    public static void ser() throws IOException {
        FileOutputStream fos = new FileOutputStream("L6_SerializationAndClonning/Serialization/temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        TestSerial ts = new TestSerial();
        oos.writeObject(ts);
        oos.flush();
        oos.close();
    }

    // Для воссоздания объекта из файла, необходимо применить следующий код
    // Восстановление объекта происходит с помощью вызова метода oin.readObject().
    // В методе происходит чтение набора байт из файла и создаие точной копии графа оригинального объекта.
    // oin.readObject() может прочитать любой сериализованный объект,
    // поэтому необходимо полученный объект приводить к конкретному типу.

    public static void des() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("L6_SerializationAndClonning/Serialization/temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        TestSerial ts = (TestSerial) oin.readObject();
        System.out.println(STR."version=\{ts.version}");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ser();
        des();
    }
}

// ========================================= Формат сериализованного объекта ======================================== \\

// Содержимое файла temp.out, в шестнадцатеричном виде:
// AC ED 00 05 73 72 00 0A 53 65 72 69 61 6C 54 65
// 73 74 A0 0C 34 00 FE B1 DD F9 02 00 02 42 00 05
// 63 6F 75 6E 74 42 00 07 76 65 72 73 69 6F 6E 78
// 70 00 64
//
// Если вы снова посмотрите на TestSerial, то увидите, что у него всего 2 байтовых члена:
// public byte version = 100;
// public byte count = 0;
//
// Размер байтовой переменной один байт, и следовательно полный размер объекта (без заголовка) — два байта.
// Но размер сериализованного объекта 51 байт. Откуда взялись эти дополнительные байты и что они обозначают?
// Они добавлены сериализующим алгоритмом и необходимы для воссоздания объекта.

// Пример, охватывающий все возможные случаи сериализации
class parent implements Serializable {
    int parentVersion = 10;
}

class contain implements Serializable{
    int containVersion = 11;
}
class SerialTest extends parent implements Serializable {
    int version = 66;
    contain con = new contain();

    public int getVersion() {
        return version;
    }
    public static void main(String args[]) throws IOException {
        FileOutputStream fos = new FileOutputStream("L6_SerializationAndClonning/Serialization/temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        SerialTest st = new SerialTest();
        oos.writeObject(st);
        oos.flush();
        oos.close();
    }
}

// Подробнее: https://habr.com/ru/articles/60317/