package L7_InputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZIP {
    // ================================================ java.util.zip =============================================== \\

    // java.util.zip позволяет читать и записывать стандартныу форматы сжатия ZIP и GZIP.
    // Основное назначение — сжатие данных для экономии места на диске и ускорения передачи данных через сеть.

    // Основные классы и интерфейсы
    //   - ZipInputStream и ZipOutputStream: для чтения и записи файлов в формате ZIP.
    // ZipInputStream позволяет читать данные из ZIP-файла, а ZipOutputStream — записывать файлы в ZIP-архив.
    //
    //   - GZIPInputStream и GZIPOutputStream: аналогичны предыдущим, но работают с форматом GZIP (для одного файла),
    // который обычно используется для сжатия одного файла.
    //
    //   - ZipFile: используется для чтения содержимого ZIP-файла.
    // Позволяет получить доступ к отдельным элементам архива без необходимости извлекать весь архив.
    //
    //   - ZipEntry: представляет собой отдельный элемент в ZIP-файле, например, файл или директорию.
    // Содержит методы для получения информации об элементе, такой как имя, размер, время изменения.

    // Основные возможности
    //   - Сжатие и распаковка данных: позволяет сжимать данные для экономии пространства и распаковывать их
    //   - Чтение и запись ZIP- и GZIP-файлов: можно создавать и обрабатывать архивы в этих форматах.
    //   - Работа с отдельными элементами архива: возможность получения информации о содержимом архива, добавления,
    // удаления или извлечения отдельных файлов или директорий.


    // Пример использования (создание ZIP-файла):
    public void createZIP() {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("output.zip"))) {
            ZipEntry entry = new ZipEntry("example.txt");
            zos.putNextEntry(entry);
            byte[] data = "Hello, World!".getBytes();
            zos.write(data, 0, data.length);
            zos.closeEntry();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    // Пример использования (чтение ZIP-файла):
    public void readZIP() {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream("input.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Entry: " + entry.getName() + ", Size: " + entry.getSize());
                // Чтение данных из entry...
                zis.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
