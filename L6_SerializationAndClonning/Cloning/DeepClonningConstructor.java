package L6_SerializationAndClonning.Cloning;

public class DeepClonningConstructor {

    // =================================== Глубокое копирование через Конструктор =================================== \\

    // Реализация через конструктор копирования: Создайте новый конструктор в вашем классе, который принимает объект
    // того же класса в качестве параметра. Внутри конструктора, для каждого поля, создайте новый объект
    // на основе переданного объекта.

    private int field;
    private AnotherClass anotherField;

    // Конструктор копирования
    public DeepClonningConstructor(DeepClonningConstructor another) {
        this.field = another.field;
        // Предполагаем, что AnotherClass имеет конструктор копирования
        this.anotherField = new AnotherClass(another.anotherField);
    }
}

// Вложенный класс для копирования
class AnotherClass {
    // Пример поля класса
    private int someField;

    // Конструктор по умолчанию
    public AnotherClass() {
    }

    // Конструктор копирования
    public AnotherClass(AnotherClass another) {
        this.someField = another.someField;
    }

    // Геттеры и сеттеры
    public int getSomeField() {
        return someField;
    }

    public void setSomeField(int someField) {
        this.someField = someField;
    }
}

