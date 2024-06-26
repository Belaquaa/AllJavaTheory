package L12_Hibernate;

public class Entity {
    // =================================================== Entity =================================================== \\

    // Entity (сущность) - это класс, который представляет таблицу в базе данных.
    // Он используется для отображения ORM записей таблицы на объекты в приложении.
    //
    // Персистентное поле – это поле сущности, которое отражается в БД в виде столбца таблицы.
    //
    // 1. Entity класс должен быть отмечен аннотацией Entity или описан в XML файле конфигурации JPA.
    // 2. Entity класс должен содержать public или protected конструктор без аргументов
    //    (он также может иметь конструкторы с аргументами).
    // 3. Entity класс должен быть классом верхнего уровня (top-level class).
    // 4. Entity класс не может быть enum или интерфейсом,
    // 5. Entity класс не может быть финальным классом (final class).
    // 6. Entity класс не может содержать финальные поля или методы, если они участвуют в маппинге.
    // 7. Если объект Entity класса будет передаваться по значению как отдельный объект (detached object),
    //    например через удаленный интерфейс, он так же должен реализовывать Serializable интерфейс.
    // 8. Поля Entity класс должны быть напрямую доступны только методам самого Entity класса и не должны быть напрямую
    //    доступны другим классам, использующим этот Entity. Такие классы должны обращаться только к методам
    //    (getter/setter методам или другим методам бизнес-логики в Entity классе).
    // 9. Enity класс должен содержать первичный ключ, то есть атрибут или группу атрибутов которые уникально
    //    определяют запись этого Enity класса в базе данных.
    //
    // Или табличкой:
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | Требования к Entity | Описание                                                                                |
    // | классу в JPA        |                                                                                         |
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | V @Entity           | Entity класс должен быть помечен аннотацией @Entity                                     |
    // |                     | или описан в XML файле конфигурации JPA.                                                |
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | V Конструкторы      | Entity класс должен содержать public или protected конструктор без аргументов           |
    // |                     | (он также может иметь конструкторы с аргументами).                                      |
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | V top-level class   | Entity класс должен быть классом верхнего уровня (top-level class).                     |
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | V implements        | Если объект Entity класса будет передаваться по значению как отдельный от контекста     |
    // |   Serializable      | персистентности объект (detached object), например, через удаленный интерфейс,          |
    // |                     | то он должен реализовывать интерфейс Serializable (чтобы  могли сохраняться в кэше).    |
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | V extends           | Как обычный, так и абстрактный класс может быть Entity. Entities могут наследоваться    |
    // |                     | как от Entity классов, так  и от других классов.                                        |
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | V getter/setter     | Поля Entity класса должны быть объявлены private, protected или package-private,        |
    // |                     | быть доступными только через сам Entity класс, и не должны быть напрямую доступны       |
    // |                     | другим методам, кроме getter/setter-методов класса                                      |
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | V Primary key       | Entity класс должен содержать первичный ключ, то есть атрибут или группу атрибутов,     |
    // |                     | которые уникально определяют запись этого Entity класса в базе данных                   |
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | X Enum              | Перечисление [enum] или интерфейс НЕ могут быть определены как сущность [Entity].       |
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | X Final class       | Entity класс НЕ может быть финальным классом (final class).                             |
    // +---------------------+-----------------------------------------------------------------------------------------+
    // | X final methods     | Entity класс НЕ может содержать финальные поля или методы, если они участвуют в         |
    // |   final variables   | маппинге (persistent final methods or persistent final instance variables).             |
    // +---------------------+-----------------------------------------------------------------------------------------+



    // =============================================== Жизненный цикл =============================================== \\

    // 1. Transient (Неустойчивое состояние):
    //   - Объект создан, но еще не связан с сессией Hibernate.
    //   - У объекта нет представления в базе данных.
    //   - Hibernate не управляет этим объектом.
    //
    // 2. Persistent (Устойчивое состояние):
    //   - Объект связан с сессией Hibernate.
    //   - У объекта есть представление в базе данных.
    //   - Изменения объекта синхронизируются с базой данных при выполнении операций сохранения, обновления или удаления.
    //   - Hibernate управляет этим объектом и отслеживает его изменения.
    //
    // 3. Detached (Отсоединенное состояние):
    //   - Объект был связан с сессией Hibernate, но сессия была закрыта или объект был отсоединен от сессии.
    //   - У объекта есть представление в базе данных, но изменения объекта не синхронизируются автоматически с БД.
    //   - Hibernate больше не управляет этим объектом.
    //
    // 4. Removed (Удаленное состояние):
    //   - Объект был удален из базы данных с помощью операции удаления Hibernate.
    //   - Объект все еще связан с сессией Hibernate, но его представление в базе данных удалено.
    //   - Hibernate продолжает управлять этим объектом до закрытия сессии.
    //
    // Переходы между состояниями:
    // - Transient -> Persistent: при сохранении объекта с помощью метода save(), persist() или saveOrUpdate().
    // - Persistent -> Detached: при закрытии сессии или явном отсоединении объекта с помощью метода detach().
    // - Detached -> Persistent: при повторном присоединении объекта к сессии с помощью метода merge() или update().
    // - Persistent -> Removed: при удалении объекта с помощью метода delete() или remove().
    // - Removed -> Detached: при закрытии сессии.
    // https://habr.com/ru/articles/265061/


}
