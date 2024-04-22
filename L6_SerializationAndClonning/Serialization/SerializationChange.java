package L6_SerializationAndClonning.Serialization;

import java.io.*;

public class SerializationChange {
    // ====================================== Изменение стандартного поведения ====================================== \\

    // Изменение поведения может быть нужно для:
    //   - улучшения безопасности ()
    //   - совместимости версий (сериализованы в одной версии, десериализовали в другой)
    //   - улучшения производительности (убрать ненужные данные)
    //
    // Чтобы изменить стандартное поведение нужно:
    //   - Использовать интерфейс Externalizeable и переопределить методы
    //   - writeExternal(ObjectOutput out) throws IOException
    //   - readExternal(ObjectInput in) throws IOException, ClassNotFoundException

    // Определите методы `writeObject` и `readObject` в вашем классе:
    private void writeObject(ObjectOutputStream out) throws IOException {
        // Код для кастомной сериализации
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // Код для кастомной десериализации
    }

    // Реализуйте логику кастомной сериализации/десериализации в этих методах:
    // В writeObject, вы можете решить, какие поля или данные вашего объекта должны быть записаны в поток.
    // В readObject, вы указываете, как эти данные должны быть прочитаны из потока и как восстановить состояние объекта.

    public class MyClass implements Serializable {
        private transient String sensitiveData; // Не сериализуется автоматически из-за модификатора transient
        private String regularData;

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject(); // Сериализует все не-transient поля
            // Можно добавить шифрование или другую логику обработки для sensitiveData
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject(); // Десериализует все не-transient поля
            // Можно добавить дешифрование или другую логику обработки для sensitiveData
        }
    }
}
