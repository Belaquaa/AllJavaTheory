package L2_OOP.d_ClassLoader;

public class ClassLoader {
    // ================================================ ClassLoader ================================================= \\

    // ClassLoader - загружает классы в память при их первом использовании (ленивая загрузка),
    // преобразуя их из байт-кода в машинный код
    //
    // 1. Загрузка. Находит и загружает бинарные данные класса в память. Создается экземпляр класса Class в JVM
    //
    // 2. Связываение
    //    - Проверка корректности кода, проверка безопасности
    //    - Выделение памяти для статических полей, инициализация стандартными значениями
    //    - Преобразование символических ссылок на другие классы/методы/поля в прямые
    //
    // 3. Инициализация. Выполнение статических инициализаторов и инициализация статических полей (в порядке объявления)
    //    Инициализация происходит в момент первого обращения к классу,
    //    при создании первого экземпляра или обращению к его статическим членам

    // ====================================== Типы загрузчиков при запуске JVM ====================================== \\

    // BootStrap: Стандартные классы JDK. Написан на нативном коде
    // Extension: Классы расширений Java
    // System:    Классы приложения
    //
    // Каждый загрузчик классов, кроме Bootstrap, имеет родительский загрузчик, образуя иерархию загрузчиков.
    // Эта иерархия используется для обеспечения принципа делегирования при загрузке классов,
    // когда загрузчик классов сначала делегирует запрос на загрузку класса своему родительскому загрузчику,
    // прежде чем пытаться загрузить класс самостоятельно.
}
