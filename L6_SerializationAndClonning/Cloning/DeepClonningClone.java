package L6_SerializationAndClonning.Cloning;

public class DeepClonningClone implements Cloneable {
    // ==================================== Глубокое копирование через Cloneable ==================================== \\

    // Реализация через метод clone(): Класс должен реализовать интерфейс Cloneable и переопределить метод clone():
    //   - Пометьте ваш метод clone() как public
    //   - Вызовите super.clone() для создания копии объекта
    //   - Для каждого изменяемого поля создайте новый экземпляр, используя глубокое копирование

    private int[] myArray;

    @Override
    public DeepClonningClone clone() {
        try {
            DeepClonningClone copy = (DeepClonningClone) super.clone();
            copy.myArray = myArray.clone(); // Глубокое копирование массива
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Не должно произойти
        }
    }
}