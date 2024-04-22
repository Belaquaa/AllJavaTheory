package L6_SerializationAndClonning.Cloning;

// ========================================= Клонирование через Конструктор ========================================= \\

class MyClass {
    int a;
    MyClass(int a) {
        this.a = a;
    }

    // Конструктор копирования
    MyClass(MyClass obj) {
        this.a = obj.a;
    }
}

public class ClonningWHConstructor {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass(10);
        MyClass obj2 = new MyClass(obj1);
        System.out.println(obj1.a);
        System.out.println(obj2.a);
    }
}
