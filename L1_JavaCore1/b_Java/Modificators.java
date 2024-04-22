package L1_JavaCore1.b_Java;

public class Modificators {
    // ============================================ Модификаторы доступа ============================================ \\

    // public: видимы и доступны везде
    // protected: видимы и доступны внутри пакета и в наследниках
    // default: видимы и доступны только внутри пакета
    // private: члены класса доступны только внутри класса


    // =================================================== Static =================================================== \\

    // Поля: принадлежат классу, а не объекту -> одна переменная на все экземпляры
    // Методы: могут быть вызваны без создания объекта класса: Class.method(). Обращаются только к static переменным.
    //         cтатические методы могут быть вызваны из нестатических, но не наоборот
    // Блоки инициализации: инициализация статических переменных. Выполняются один раз, пишутся перед конструктором
    // Вложенные классы: могут быть использованы без создания экземпляра внешнего класса,
    //                   имеют доступ только к статическим переменным внешнего класса

    // =================================================== Final ==================================================== \\

    // Класс: не может иметь наследников
    // Метод: не может быть переопределен в классах наследниках
    // Поле: не может изменить значение после инициализации
    // Параметры методов: не могут изменять свое значение внутри метода
    // Локальные переменные: не могут быть изменены после присвоения значения
}
