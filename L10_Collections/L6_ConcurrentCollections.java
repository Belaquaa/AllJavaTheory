package L10_Collections;

public class L6_ConcurrentCollections {
    public static void main(String[] args) {
        // ========================================== Concurrent коллекции ========================================== \\

        // Потокобезопасные Concurrent коллекции
        // Concurrent Collections – это набор коллекций, более эффективно работающих в многопоточной среде,
        // чем стандартные коллекции из пакета java.util

        // Вместо базового враппера (обертки) Collections.synchronizedCollection с блокированием доступа ко всей
        // коллекции используются блокировки по сегментам данных или же оптимизируется работа для параллельного
        // чтения данных по wait-free алгоритмам.

        // Пакет java.util.concurrent предоставляет реализации Конкурентных коллекций:
        //
        // ConcurrentHashMap – вместо HashMap
        // ConcurrentSkipListMap – вместо TreeMap
        // ConcurrentSkipListSet
        // CopyOnWriteArrayList – вместо ArrayList
        // CopyOnWriteArraySet

        // Блокирующие очереди пакета concurrent реализуют интерфейсы: BlockingQueue, BlockingDeque, TransferQueue
        //
        // - ArrayBlockingQueue — очередь, реализующая классический кольцевой буфер;
        // - LinkedBlockingQueue — односторонняя очередь на связанных узлах;
        // - LinkedBlockingDeque — двунаправленная очередь на связанных узлах;
        // - SynchronousQueue — блокирующую очередь без емкости (операция добавления одного потока находится
        //   в ожидании соответствующей операции удаления в другом потоке);
        // - LinkedTransferQueue — реализация очереди на основе интерфейса TransferQueue;
        // - DelayQueue — неограниченная блокирующая очередь, реализующая интерфейс Delayed;
        // - PriorityBlockingQueue — реализация очереди на основе интерфейса PriorityQueue.
    }
}
