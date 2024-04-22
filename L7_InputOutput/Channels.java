package L7_InputOutput;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Channels {
    // ================================================== Channels ================================================== \\

    // Channels позволяют работать с данными ввода-вывода, являются частью NIO
    //
    // Основные моменты:
    //   - Неблокирующий ввод-вывод: Channels поддерживают неблокирующий режим работы, что позволяет выполнять другие
    // задачи, пока данные читаются или записываются, улучшая тем самым производительность приложения.
    //
    //   - Буферизация: данные, с которыми работают Channels, обычно хранятся в буферах (java.nio.Buffer).
    // Это позволяет эффективно управлять данными, осуществляя батчевую обработку, что снижает кол-во системных вызовов.
    //
    //   - Селекторы: в сочетании с неблокирующими каналами, селекторы (java.nio.channels.Selector) позволяют одному
    // потоку управлять множеством каналов, определяя, какие из них готовы к чтению, записи или подключению.
    //
    //   - Прямой доступ к данным: FileChannel поддерживает операцию memory-mapped file I/O, что позволяет приложению
    // работать с файлами напрямую в памяти, минуя копирование данных из пользовательского пространства в пространство
    // ядра и обратно, что значительно увеличивает скорость работы с большими файлами.
    //
    //   - Передача данных между каналами: Channels поддерживают прямую передачу данных между собой
    // (например, между FileChannel'ами), что может быть эффективно использовано для быстрого копирования файлов.
    //
    //   - Типы каналов: в Java NIO существует несколько типов каналов, включая:
    //      - FileChannel для работы с файлами.
    //      - DatagramChannel для работы с UDP протоколом.
    //      - SocketChannel и ServerSocketChannel• для работы с TCP соединениями.

    // Пример использования
    // Этот пример демонстрирует базовый процесс чтения файла с использованием FileChannel и ByteBuffer в Java NIO.
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer) != -1) {
                buffer.flip(); // Подготовка буфера к чтению
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear(); // Очистка буфера для следующего чтения
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}