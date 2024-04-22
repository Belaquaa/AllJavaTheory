package L10_Collections.P2_Set;

import java.util.EnumSet;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class P4_EnumSet {
    public static void main(String[] args) {
        // =============================================== EnumSet ================================================== \\

        // EnumSet - это реализация интерфейса Set для использования с перечислениями (Enum).
        // В структуре данных хранятся объекты только одного типа Enum, указываемого при создании. Для хранения значений
        // EnumSet использует массив битов (bit vector), — это позволяет получить высокую компактность и эффективность.
        // Проход по EnumSet осуществляется согласно порядку объявления элементов перечисления.
        //
        // Все основные операции выполняются за O(1) и обычно (но негарантированно) быстрей аналогов из HashSet,
        // а пакетные операции (bulk operations), такие как containsAll() и retainAll() выполняются дажего раздо быстрей
        //
        // Помимо всего EnumSet предоставляет множество статических методов инициализации
        // для упрощенного и удобного создания экземпляров.
        //
        // Использование EnumSet рекомендуется, когда нужно работать с наборами элементов перечисления, т.к. это
        // обеспечивает лучшую производительность по сравнению с использованием общих коллекций, таких как HashSet.

        // Создание EnumSet с использованием всех элементов перечисления Day
        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: " + weekend);
        EnumSet<Day> workdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        boolean isWeekend = weekend.contains(Day.SATURDAY);
        weekend.remove(Day.SUNDAY);
        System.out.println("Weekend contains Saturday: " + isWeekend);
        System.out.println("Workdays: " + workdays);

    }
}
