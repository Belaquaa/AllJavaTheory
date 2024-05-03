package L6_SerializationAndClonning.Serialization;


import java.io.Serializable;

public class a_Theory {

    // ================================================ Сериализация ================================================ \\

    // Сериализация - сохранение объекста в последовательность байт для компактного хранения или передачи,
    //                реализована через интерфейс-маркер (без методов) Serializable
    // Десериализация - восстановление объекта из байт
    //
    // Java Serialization API предоставляет стандартный механизм для создания сериализуемых объектов
    //


    // =========================================== Не будут сериализованы =========================================== \\

    // Static поля
    // Transient поля (@Transient) после восстановления его значение будет null (кэш и данные, которые легко вычислить)
    // Поля с модификатором final сериализуются как обычные, но их невозможно десериализовать через Externalize()


    // =========================================== Сериализация Singleton =========================================== \\

    // Singleton - класс имеет только один экземпляр во всем приложении и дает глобальную точку доступа
    //                (конфигурация приложения, логирования, кэширование, управление ресурсами)
    //
    // Проблема: после десериализации мы получим новый объект (создает Singleton еще раз)
    // Решение:  использовать метод readResolve(), который позволет заменить объект после дисериализации
    //           на уже существующий экземпляр Singleton


    // ============================================== serialVersionUID ============================================== \\

    // serialVersionUID - это уникальный идентификатор версии класса,
    // используемый в процессе сериализации и десериализации объектов в Java.
    //
    // Цель: serialVersionUID используется во время десериализации для проверки, что загруженный класс соответствует
    // сериализованному объекту. Если идентификаторы не совпадают, десериализация завершается с InvalidClassException.
    //
    // Значение по умолчанию: Если вы не определите serialVersionUID в своем классе, JVM автоматически сгенерирует его
    // на основе структуры класса, включая члены класса, методы и другие аспекты. Однако это может привести к проблемам
    // совместимости при изменении класса, так как любое изменение может изменить сгенерированный serialVersionUID.
    //
    // Явное определение: Рекомендуется явно объявлять serialVersionUID в классе, чтобы контролировать процесс
    // сериализации/десериализации и обеспечить совместимость версий. Это делается путем добавления
    // private static final long serialVersionUID = 1L; (где 1L — это версия). Начинают с 1L и после увелививают
    //
    public class MyClass implements Serializable {
        private static final long serialVersionUID = 1L;
        // поля, методы...
    }


    // ======================================= Serializable vs Externalizable ======================================= \\

    // Serializable:
    //   - Простота использования: реализация проста, достаточно объявить класс как реализующий интерфейс Serializable
    //
    //   - Автоматическая сериализация: JVM сама сериализует объекты, управляя процессом сериализации и десериализации.
    //     Все нестатические и не транзиентные поля класса будут автоматически сериализованы и десериализованы.
    //
    //   - Недостатки: нет контроля над процессом сериализации. Неэффективно для сложных объектов с большим количеством
    //     связей или для объектов, требующих специальной обработки при сериализации.
    //
    // Externalizable:
    //   - Контроль над сериализацией: реализация требует явной реализации двух методов:
    //     writeExternal(ObjectOutput out) и readExternal(ObjectInput in).
    //     Это дает полный контроль над процессом сериализации и десериализации.
    //
    //   - Эффективность: позволяет оптимизировать процесс сериализации, явно указывая, какие данные нужно сериализовать
    //     и как это делать. Это может существенно уменьшить размер сериализованных данных и ускорить процесс.
    //
    //   - Недостатки: требует больше работы при реализации, поскольку необходимо явно управлять
    //     сериализацией каждого поля класса.
    //
    // Serializabel - если нужен простой и быстрый способ сериализации без особых требований к эффективности и контролю
    // Externalizable - если требуется тонкий контроль над процессом сериализации, возможность оптимизации и управление
    //                  каждым аспектом сериализуемых данных

}