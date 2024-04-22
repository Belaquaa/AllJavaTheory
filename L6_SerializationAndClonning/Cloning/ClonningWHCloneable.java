package L6_SerializationAndClonning.Cloning;

// ========================================== Клонирование через Cloneable ========================================== \\

class MyClassClone implements Cloneable {
    int a;

    MyClassClone(int a) {
        this.a = a;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ClonningWHCloneable {
    public static void main(String[] args) {
        MyClassClone obj1 = new MyClassClone(10);
        MyClassClone obj2 = null;
        try {
            obj2 = (MyClassClone) obj1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(obj1.a);
        System.out.println(obj2.a);
    }
}