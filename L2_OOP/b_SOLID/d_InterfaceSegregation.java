package L2_OOP.b_SOLID;

public class d_InterfaceSegregation {
    // ======================================= Принцип разделения интерфейсов ======================================= \\

    // Принцип разделения интерфейсов. Клиенты не должны зависить от методов, которые они не используют.
    // Несколько интерфейсов лучше одного универсального
}

// Вместо
interface MultifunctionalDevice {
    void print();

    void scan();

    void fax();
}

// Делаем так:
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class SimplePrinter implements Printer, Scanner {
    @Override
    public void print() {
        System.out.println("Печать документа");
    }

    @Override
    public void scan() {
        System.out.println("Печать документа");
    }
}

class MainIS {
    public static void main(String[] args) {
        SimplePrinter printer = new SimplePrinter();
        printer.scan();
        printer.print();

    }
}