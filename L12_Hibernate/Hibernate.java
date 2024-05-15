package L12_Hibernate;

public class Hibernate {
    // ================================================== Hibernate ================================================= \\

    // Hibernate - спецификация JPA, ORM фреймворк. Главная цель - создание объектного слоя между кодом и БД,
    // чтобы работать с таблицами, как с объектами. Представляет язык HQL

    // Преимущества:
    //  - Hibernate — широко распространенный open source проект -> много гайдов
    //  - Легко интегрируется с другими Java EE фреймворками, например, со Spring Framework
    //  - Поддерживает ленивую инициализацию, используя PROXY объекты, —> запросы к БД только по необходимости.
    //  - Поддерживает разные уровни кэширования -> может повысить производительность.
    //  - Может использовать чистый SQL -> поддерживает работу с любым сторонним вендером БД и его фичами.
    //  - Неявно использует управление транзакциями (большинство запросов нельзя выполнять вне транзакций).
    //  - Использует HibernateException (unchecked) -> нет необходимости проверять их в коде каждый раз.
    //  - Поддерживает все основные СУБД: MySQL, Oracle, PostgreSQL, Microsoft SQL Server Database, HSQL, DB2.

    // ============================================= Ключевые интерфейсы ============================================ \\

    // 1. SessionFactory:
    //  - Отвечает за инициализацию Hibernate. Создает объекты Session.
    //  - Является тяжеловесным объектом, его создание занимает много ресурсов.
    //  - Неизменяем и является потокобезопасным
    //  - Пример:
    //
    //  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    // 2. Session:
    //  - Представляет собой однократный контекст для работы с базой данных.
    //  - Используется для создания, чтения и удаления объектов базы данных.
    //  - Простой жизненный цикл: открываем, выполняем операцию, закрываем
    //  - Пример:
    //
    //  Session session = sessionFactory.openSession();
    //  session.beginTransaction();
    //  // Ваш код для работы с базой данных
    //  session.getTransaction().commit();
    //  session.close();

    // 3. Transaction:
    //  - Представляет собой одну единицу работы с базой данных.
    //  - Используется для гарантии целостности данных при выполнении операций в базе данных.
    //  - Пример:
    //
    //  Transaction transaction = session.beginTransaction();
    //  // Ваш код для работы с базой данных
    //  transaction.commit();

    // 4. Query и Criteria:
    //  - Используются для создания и выполнения запросов к базе данных.
    //  - Query используется для HQL (Hibernate Query Language) и SQL запросов.
    //  - Criteria используется для программного создания запросов с помощью API, что позволяет избежать ошибок в
    //    строках запросов. Предоставляет методы для применения критериев (получение всех, ЗП которых 300к)
    //  - Примеры:
    //
    //  // Query
    //  Query query = session.createQuery("from User where id= :userId");
    //  query.setParameter("userId", 1);
    //  List result = query.list();
    //
    //  // Criteria
    //  Criteria crit = session.createCriteria(User.class);
    //  crit.add(Restrictions.eq("id", 1));
    //  List result = crit.list();

    // 5. Configuration:
    //  - Используется для конфигурации Hibernate и создания объекта SessionFactory.
    //  - Считывает конфигурационные параметры из файла hibernate.cfg.xml или других источников.
    //  - Используется для настройки и начальной загрузки спящего режима
    //  - Пример:
    //
    //  Configuration configuration = new Configuration().configure();
    //  SessionFactory sessionFactory = configuration.buildSessionFactory();
}