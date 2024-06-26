package L12_Hibernate;

public class ORM {
    // ===================================================== ORM ==================================================== \\

    // ORM (Object-Relational Mapping, объектно-реляционное отображение) - технология программирования,
    // суть которой заключается в создании «виртуальной объектной базы данных»
    // Java App -> Object -> ORM -> DataBase

    // В двух словах ORM — это отображение объектов какого-либо объектно-ориентированного языка в структуры реляционных
    // баз данных. Именно объектов, таких, какие они есть, со всеми полями, значениями, отношениями м/у друг с другом.
    // Позволяет работать с БД как с объектами

    // Состоит из:
    //  - API, который реализует базовые операции (создание, чтение, изменение, удаление) объектов-моделей.
    //  - Средства настройки метаданных связывания.
    //  - Техники взаимодействия с транзакциями, которая позволяет реализовать функции
    //    dirty checking, lazy association fetching и т.д.

    // Преимущества ORM в сравнении с JDBC:
    //  - Ускоряет бизнес методом обращения не к БД, а к Java-классам.
    //  - Основан на JDBC.
    //  - Отделяет SQL-запросы от ОО модели.
    //  - Позволяет думать о реализации бизнес-задач, а не о структуре БД.
    //  - Управление транзакциями.

    // ============================================== JPA, JDBC, JPQL =============================================== \\

    // JPA (Java Persistence API) - это стандартная спецификация, описывающая систему управления сохранением объектов в БД
    // Сам JPA не умеет ни сохранять, ни управлять объектами, JPA только определяет правила игры:
    // как должен действовать каждый провайдер (Hibernate, EclipseLink, OJB, Torque, Juke), реализующий стандарт JPA

    // JPQL (Java Persistence Query Language) - язык запросов для работы с сущностями в Java, используется в JPA
    // для выполнения запросов к базе данных на основе классов и их полей, а не таблиц SQL.

    // ======================================== Реляционная vs Объектная модель ===================================== \\
    // 1. Основа:
    //   - Реляционная: основана на таблицах.
    //   - Объектная (Java): основана на классах и объектах.
    //
    // 2. Структура данных:
    //   - Реляционная: данные организованы в строки и столбцы.
    //   - Объектная: данные организованы в объекты, имеющие поля и методы.
    //
    // 3. Связи:
    //   - Реляционная: связи между данными реализуются через внешние ключи.
    //   - Объектная: связи между объектами реализуются через ссылки.
    //
    // 4. Идентификация:
    //   - Реляционная: идентификация записей через первичные ключи.
    //   - Объектная: идентификация объектов через ссылки и уникальные идентификаторы.
    //
    // 5. Запросы:
    //   - Реляционная: использует SQL для запросов к данным.
    //   - Объектная: использует методы объектов для доступа и манипуляции данными.
    //
    // 6. Транзакции:
    //   - Реляционная: поддерживает сложные транзакции и согласованность данных.
    //   - Объектная: поддержка транзакций зависит от реализации.
    //
    // 7. Наследование:
    //   - Реляционная: не поддерживает напрямую, требует дополнительного моделирования.
    //   - Объектная: естественно поддерживает наследование и полиморфизм.
    //
    // 8. Масштабируемость:
    //   - Реляционная: хорошо масштабируется для больших объемов данных.
    //   - Объектная: масштабируемость зависит от реализации, может быть затруднена из-за сложности объектных связей.


}