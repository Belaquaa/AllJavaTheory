package L10_Collections.P4_Map;

public class A1_MapEx {
    public static void main(String[] args) {
        // =================================================== Map ================================================== \\

        // Интерфейс Map не имеет отношения к интерфейсу Collection, но тоже является частью Collections Framework.
        //
        // Это объект, который хранит элементы в виде пар "ключ-значение"
        // Каждый ключ уникален, и на каждый ключ приходится ровно одно значение.

        // Значения могут дублироваться
        // Доступ к значениям осуществляется по ключу. Ключ по значению получить нельзя

        // По умолчанию под капотом Map массив на 16 buckets (корзин)
        // Внутри каждого бакета данные хранятся в LinkedList
        // Массив автоматически расширяется: 16 – 32 – 64 при 75% заполненности (по умолчанию)

        // Худший результат работы Map – Коллизия:
        // Когда все элементы попадают в один bucket и их приходится перебирать итерацией по внутреннему LinkedList.
        //
        // В таком случае происходит оптимизация хранения данных в этом бакете:
        // Если размер внутреннего LinkedList бакета становится равен 8 элементам и размер внутреннего массива Map
        // равен 64 бакетам – происходит преобразование структуры данных внутри этого бакета в RB-дерево(red-black tree)

        // Для объектов-ключей важно переопределить методы equals() и hashCode()
        // Допускается добавление объектов без переопределения этих методов, но найти их в Map будет невозможно.

        // +----------------------+-------------------------+-------------------------+-------------------------+
        // |                      |       HashMap           |     LinkedHashMap       |        TreeMap          |
        // +----------------------+-------------------------+-------------------------+-------------------------+
        // | Порядок хранения     | Случайный. Нет гарантий,| В порядке добавления    | В порядке возрастания   |
        // | данных               | что порядок сохранится  |                         | или исходя из заданного |
        // |                      | на протяжении времени   |                         | компаратора             |
        // +----------------------+-------------------------+-------------------------+-------------------------+
        // | Время доступа к      | O(1)                    | O(1)                    | O(log(n))               |
        // | элементам            |                         |                         |                         |
        // +----------------------+-------------------------+-------------------------+-------------------------+
        // | Имплементированные   | Map                     | Map                     | NavigableMap            |
        // | интерфейсы           |                         |                         | SortedMap               |
        // |                      |                         |                         | Map                     |
        // +----------------------+-------------------------+-------------------------+-------------------------+
        // | Имплементация на     | Корзины (buckets)       | Корзины (buckets)       | Красно-чёрное дерево    |
        // | основе структуры     |                         |                         | (Red-Black Tree)        |
        // | данных               |                         |                         |                         |
        // +----------------------+-------------------------+-------------------------+-------------------------+
        // | Возможность работы   | Можно                   | Можно                   | Можно, если используется|
        // | с null-ключом        |                         |                         | компаратор,             |
        // |                      |                         |                         | разрешающий null        |
        // +----------------------+-------------------------+-------------------------+-------------------------+
        // | Потокобезопасна      | Нет                     | Нет                     | Нет                     |
        // +----------------------+-------------------------+-------------------------+-------------------------+

        // ========================================= Массив в качестве ключа ======================================== \\

        // Хеш-код массива не зависит от содержимого массива, а определяется при его создании. Метод вычисления хеш-кода
        // массива основан на стандартной функции Object.hashCode(), которая учитывает адрес массива в памяти.
        //
        // Массивы в Java не имеют переопределенных методов equals и hashCode, что приводит к сравнению по ссылкам.
        // Это означает, что даже если два массива содержат одинаковые элементы, они не будут равны при использовании
        // в качестве ключей в HashMap, так как сравнение происходит по адресам в памяти.
        //
        // Кроме того, при создании нового массива, даже с теми же самыми значениями, будет создан новый объект
        // с уникальным адресом, и, следовательно, с новым хеш-кодом, т.к. new byte[] {1} != new byte[] {1}.
        // Это приводит к тому, что при запросе значения по ключу, который является массивом, результат может быть
        // неожиданным, так как массивы с одинаковым содержимым будут иметь разные хеш-коды и считаться разными ключами.

        // Методы Map:
        // - clear() - Удаляет все пары ключ-значение из этой мапы.
        //
        // - containsKey(Object key) - Возвращает true, если эта мапа содержит значение для указанного ключа.
        //
        // - containsValue(Object value) - Возвращает true, если эта мапа содержит один или несколько
        //   ключей с указанным значением.
        //
        // - entrySet() - Возвращает Set сопоставлений (пар ключ-значение), содержащихся на этой карте.
        //
        // - get(Object key) - Возвращает значение, с которым сопоставлен указанный ключ, или null.
        //
        // - getOrDefault(Object key, V defaultValue) - Возвращает значение, с которым сопоставлен указанный ключ,
        //   или defaultValue, если эта мапа не содержит значения для ключа.
        //
        // - of() - Возвращает неизменяемую мар, содержащую ноль сопоставлений.
        //
        // - of(K k1, V v1) - Возвращает неизменяемую map, содержащую один элемент.
        //
        // - ofEntries(Map.Entry<? extends K, ? extends V>... entries) -
        //   Возвращает неизменяемую мар, содержащую ключи и значения, извлеченные из данной записей.
        //
        // - isEmpty() - Возвращает true, если эта мапа пуста (не содержит пар ключ-значение).
        //
        // - keySet() - Возвращает Set из ключей, содержащихся в этой мапе.
        //
        // - put(K key, V value) - Связывает указанное значение с указанным ключом и кладет это сопоставление в мапу.
        //
        // - putAll(Map<? extends K, ? extends V> m) - Копирует все сопоставления с указанной мапы на эту мапу.
        //
        // - putIfAbsent(K key, V value) - Если указанный ключ отсутствует в мапе (или сопоставлен с нулевым значением),
        //   связывает его с заданным значением, кладет пару в мапу и возвращает null,
        //   в противном случае возвращает текущее значение.
        //
        // - remove(Object key) - Удаляет значение по ключу из этой мапы, если оно присутствует.
        //
        // - remove(Object key, Object value) - Удаляет запись для указанного ключа только в том случае,
        //   если она в настоящее время сопоставлена с указанным значением.
        //
        // - replace(K key, V value) - Заменяет значение для указанного ключа только в том случае,
        //   если он в настоящее время уже сопоставлен с каким-либо значением.
        //
        // - size() - Возвращает количество сопоставлений ключ-значение в этой мапе.
        //
        // - values() - Возвращает Collection значений, содержащихся на этой карте.


    }
}
