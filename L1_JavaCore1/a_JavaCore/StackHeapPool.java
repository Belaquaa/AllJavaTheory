package L1_JavaCore1.a_JavaCore;

public class StackHeapPool {
    public static void main(String[] args) {
        // ============================================= Стек & Куча & Пулы ============================================= \\

        // Стек - хранятся примитивы и ссылки на объекты, LIFO. Потокобезопасен, для каждого создается отдельный стек
        //        При вызове метода создается фрейм (параметр метода, указатель на прошлый фрейм, локальные переменные).
        //        После выполнения он удаляется
        //
        // Куча - тут создаются и хранятся объекты и их поля, динамическое выделение памяти. Автоматически не освобождается
        //        Состоит из Young, Old, MetaSpace (метаданные классов) generation
        //
        // Пул (pool) данных, хранятся в куче - набор уникальных данных
        // 1. String: если строка в пуле, то не создасться новый объект, а будет ссылаться на существующий
        //            можно добавить в пул через intern(), либо создать вне пула через new
        String str_a = "Hello";
        String str_b = "Hello";
        String str_c = new String("Hello");
        String str_d = str_c.intern();

        System.out.println(str_a == str_b); // true
        System.out.println(str_a == str_c); // false
        System.out.println(str_a == str_d); // true

        // 2. Integer: создается при объявлении Integer, от -128 до 127.
        //             Объекты в этом диапазоне ссылаются на одно значение 100==100: true, 129==129: false
        Integer int_a = 100;
        Integer int_b = 100;
        Integer int_c = 200;
        Integer int_d = 200;

        System.out.println(int_a == int_b); // true
        System.out.println(int_c == int_d); // false

        // Но! Примитивы можно сравнивать через '=='
        System.out.println(1000 == 1000); // true
        System.out.println(int_d.equals(200)); // true

        // 3. Также для всех примитивов в классах-обертках существует пул (Boolean, Character)
    }
}