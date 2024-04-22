package L6_SerializationAndClonning.Cloning;

import java.io.*;

public class DeepClonningSerialization {
    // =================================== Глубокое копирование через Сериализацию ================================== \\

    // Использование сериализации: Если все классы, включая вложенные, реализуют интерфейс Serializable,
    // можно использовать сериализацию для глубокого копирования.
    //   - Сериализуйте объект в поток байтов.
    //   - Десериализуйте поток байтов обратно в объект.
    // Этот метод может быть более медленным и требует, чтобы все вложенные объекты были сериализуемыми.


    public static <T> T deepCopy(T object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new Error(e);
        }
    }
}