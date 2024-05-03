package L10_Collections.P4_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class A2_HashMapEx {
    public static void main(String[] args) {
        // ============================================== Класс HashMap ============================================= \\

        // HashMap использует хэш - таблицу, в которой ключи отсортированы относительно значений их хэш-кодов.
        // Хранит значения в произвольном порядке, ключ и значение могут быть null.
        // Объекты с null ключами всегда записываются в нулевую ячейку массива. Структура хранения данных: bucket 16 шт.
        //
        // Bucket – это элемент (ячейка) внутреннего массива HashMap. В нем хранятся узлы Nodes (ссылки на списки элем.)
        //
        // Хеш-таблица – структура данных, реализующая интерфейс ассоциативного массива
        // (сопоставления ключ–значение или entry), которая обеспечивает быструю вставку и поиск элементов.
        //
        // HashMap реализован с использованием метода цепочек, т.е. каждой ячейке массива (корзине) соответствует
        // свой связный список и при возникновении коллизии осуществляется добавление нового элемента в этот список.


        // ========================================== HashMap vs. HashTable ========================================= \\

        // Зачем нужен HashMap, если есть Hashtable?
        // - Методы класса Hashtable синхронизированы, что приводит к снижению производительности, а HashMap - нет;
        // - HashTable не может содержать элементы null, тогда как
        //   HashMap может содержать один ключ null и любое количество значений null;
        // - Iterator у HashMap, в отличие от Enumeration у HashTable, работает по принципу «fail-fast»
        //   (выдает исключение при любой несогласованности данных).
        // - Hashtable - это устаревший класс и его использование не рекомендовано


        // ========================================== Принцип работы HashMap ======================================== \\

        // Хеш-функция получает ключ, а на выходе возвращает целое число – хеш-код.
        // По полученному хэш-коду ключ помещается по определенному индексу хеш-таблицы.
        // За хеш-функцию отвечает метод hashCode()
        //
        // По этой причине важно, чтобы хеш-функция вела себя последовательно и выводила один и тот же хэш-код для
        // одинаковых входных данных. Поэтому в качестве ключей рекомендуется использовать только
        // неизменяемые immutable типы, например класс String или Integer.
        //
        // Хеш-отображение не гарантирует порядок расположения своих элементов.
        // Порядок, в котором элементы вводятся в хеш-отображение, не обязательно соответствует тому порядку,
        // в котором они извлекаются итератором.
        //
        // Node(int hash, K key, V value, Node<K,V> next) {
        //            this.hash = hash;
        //            this.key = key;
        //            this.value = value;
        //            this.next = next;
        //        }
        //
        // HashMap содержит следующие свойства:
        // - table – внутренний массив типа Entry
        // - size — размер, количество добавленных элементов
        // - capacity – емкость, количество бакетов в хэш-таблице
        // - loadFactor – коэффициент загрузки, по умолчанию равен 0.75
        //   Показатель насколько хэш-таблица может быть заполнена до того, как ее capacity будет автоматически увеличена
        // - threshold – количество элементов, при достижении которого, размер хэш-таблицы увеличится в два раза.
        //   Рассчитывается по формуле (capacity * loadFactor)
        //
        // Алгоритм добавления элемента в HashMap:
        // - Высчитывается hashCode() ключа
        // - Определяется бакет (ячейка массива) в которую будет добавлен новый элемент.
        //   Номер определяется по остатку от деления хэшкода на кол-во ячеек.
        //   В более новых версиях Java с помощью бинарного сдвига.
        // - Если бакет пустой - элемент просто добавляется.
        // - Если бакет не пустой – элемент добавляется в LinkedList внутри бакета:
        //   - Ключ добавляемого элемента сравнивается с ключами в LinkedList по хэшкодам.
        //   - Если хэшкоды неравны – переход к следующему элементу
        //   - Если хэшкоды равны – ключи дополнительно сравниваются по equals()
        //   - Если ключи равны по equals() – перезаписывается value найденного ключа
        //   - Если ключи не равны по equals() – переход к следующему элементу
        // - Если ключ не найден в LinkedList – элемент добавляется в конец списка

        // =========================== В каком случае может быть потерян элемент в HashMap? ========================= \\

        // Допустим, в качестве ключа используется не примитив, а объект с несколькими полями. После добавления элемента
        // в HashMap у объекта, который выступает в качестве ключа, изменяют одно поле, участвующее в вычислении хэш-кода.
        // В результате при попытке найти данный элемент по исходному ключу, будет происходить обращение к правильной
        // корзине, а вот equals уже не найдет указанный ключ в списке элементов. Тем не менее, даже если equals
        // реализован таким образом, что изменение данного поля объекта не влияет на результат, то после увеличения
        // размера корзин и пересчета хэш-кодов элементов, указанный элемент, с измененным значением поля, с большой
        // долей вероятности попадет в совершенно другую корзину и тогда уже потеряется совсем.

        // =============================== Какова роль equals() и hashCode() в HashMap? ============================= \\

        // hashCode позволяет определить корзину для поиска элемента,
        // а equals используется для сравнения ключей элементов в списке корзины и искомого ключа

        // ===== Сколько переходов происходит в момент вызова HashMap.get(key) по ключу, который есть в таблице ===== \\

        // - ключ равен null: 1 - выполняется единственный метод getForNullKey().
        // - любой ключ отличный от null: 4 -
        //   вычисление хэш-кода ключа; определение номера корзины; поиск значения; возврат значения

        // ========================================== Интерфейс Map.Entry ========================================= \\

        // Вложенный nested интерфейс Map.
        // Это структура внутри Map, которая хранит все пары ключ-значение.
        // Возвращает множество Set пар, которое можно перебрать Итератором.

        // Объекты Map.Entry действительны только во время итерации.
        Map<String, String> map = new HashMap<>();
        Set<Map.Entry<String, String>> set = map.entrySet(); //

        // ============================================ Получение в HashMap ========================================= \\

        // Использовать метод keySet(), который возвращает множество Set<K> ключей.
        // Использовать метод values(), который возвращает коллекцию Collection<V> значений.
        // Использовать метод entrySet(), который возвращает множество Set<Map.Entry<K, V> пар «ключ-значение».


        // ======================================= HashMap vs. IdentityHashMap ====================================== \\

        // IdentityHashMap - это структура данных, также реализующая интерфейс Map и использующая при сравнении ключей
        // (значений) сравнение ссылок, а не вызов метода equals(). Другими словами, в IdentityHashMap два ключа k1 и k2
        // будут считаться равными, если они указывают на один объект, т.е. выполняется условие k1 == k2

        // ========================================= HashMap vs. WeakHashMap ======================================== \\

        // Существует 4 типа ссылок: сильные (strong reference), мягкие (SoftReference) - есть в другой библиотеке,
        // слабые (WeakReference) и фантомные (PhantomReference) - при get() возвращает null.
        //
        // WeakHashMap - это структура данных, реализующая интерфейс Map и основанная на использовании WeakReference
        // для хранения ключей. Таким образом, пара «ключ-значение» будет удалена из WeakHashMap, если на объект-ключ
        // более не имеется сильных ссылок.
        //
        // В качестве примера использования такой структуры данных можно привести следующую ситуацию: допустим имеются
        // объекты, которые необходимо расширить дополнительной информацией, при этом изменение класса этих объектов
        // нежелательно либо невозможно. В этом случае добавляем каждый объект в WeakHashMap в качестве ключа,
        // а в качестве значения - нужную информацию. Таким образом, пока на объект имеется сильная ссылка
        // (либо мягкая), можно проверять хэш-таблицу и извлекать информацию. Как только объект будет удален,
        // то WeakReference для этого ключа будет помещен в ReferenceQueue и затем соответствующая запись
        // для этой слабой ссылки будет удалена из WeakHashMap.







    }
}