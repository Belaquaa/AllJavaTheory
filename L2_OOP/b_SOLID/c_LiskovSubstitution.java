package L2_OOP.b_SOLID;

public class c_LiskovSubstitution {
    // ========================================= Принцип подстановки Лисков ========================================= \\

    // Принцип подстановки Лисков. Возможность поменять базовый класс на производный без изменения поведения программы
}

class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override // вот так делать нельзя, мы изменяем поведение
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override // вот так делать нельзя, мы изменяем поведение
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}

class LSPExample {
    private static void printArea(Rectangle r) {
        r.setWidth(5);
        r.setHeight(10);
        // Пользователь ожидает, что площадь будет 50
        System.out.println(STR."Expected area: 50, Actual area: \{r.getArea()}");
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        printArea(rectangle);

        Rectangle square = new Square();
        printArea(square); // Нарушение LSP, так как поведение изменено и не соответствует ожиданиям
    }
}