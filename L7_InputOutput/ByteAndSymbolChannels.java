package L7_InputOutput;

public class ByteAndSymbolChannels {
    // ======================================== Байтовые и символьные потоки ======================================== \\

    // Потоки ввода/вывода реализуют паттерн декоратор, что позволяет комбинировать их для добавления
    // функциональности, например, буферизации, чтения строк, сериализации объектов и т.д.

    //      Потоки:                      Поток Ввода (как сканнер)    Поток Вывода (как принтер)
    // Работает с байтами                InputStream                  OutputStream
    // Работает с символами (Unicode)    Reader (чтение)              Writer (запись)

    // Байтовые потоки предназначены для работы с данными в байтовом формате.
    // Подходят для чтения и записи двоичных данных, таких как изображения, аудио, видео файлы и т.д.
    //
    // InputStream - абстрактный класс, представляющий поток ввода байтов. Основные методы:
    //   - int read() - читает один байт из потока.
    //   - int read(byte[] b) - читает некоторое количество байтов и сохраняет их в массив b.
    //   - void close() - закрывает поток.
    // OutputStream - абстрактный класс, представляющий поток вывода байтов. Основные методы:
    //   - void write(int b) - записывает один байт в поток.
    //   - void write(byte[] b) - записывает массив байтов в поток.
    //   - void close() - закрывает поток
    //
    // Символьные потоки предназначены для работы с текстовыми данными, автоматически обрабатывая преобразование
    // символов в байты и обратно в соответствии с кодировкой. Подходят для чтения и записи текстовых файлов.
    //
    // Reader - абстрактный класс, представляющий поток ввода символов. Основные методы:
    //   - int read() - читает один символ.
    //   - int read(char[] cbuf) - читает символы и сохраняет их в массив cbuf.
    //   - void close() - закрывает поток.
    // Writer - абстрактный класс, представляющий поток вывода символов. Основные методы:
    //   - void write(int c) - записывает один символ.
    //   - void write(char[] cbuf) - записывает массив символов.
    //   - void close() - закрывает поток.


    // ============================================== Паттерн Декоратор ============================================= \\

    // Паттерн декоратор - это структурный шаблон проектирования, который позволяет динамически добавлять новые функции
    // объектам, оборачивая их в полезные "обёртки". Вместо того чтобы изменять код объекта, вы создаёте декораторы,
    // которые реализуют тот же интерфейс, что и ваш объект, и добавляют или расширяют его поведение,
    // передавая вызовы методов из декоратора в сам объект. Это помогает следовать принципу открытости/закрытости,
    // где классы открыты для расширения, но закрыты для изменений.

}
