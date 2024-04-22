package CreditCalculator;

public class DivisionCalculator {

    public enum DivisionStyle {
        CLASSIC,
        GERMAN
    }

    public interface DivisionFormatter {
        String format(double dividend, double divisor, double quotient, double remainder);
    }

    public class ClassicFormatter implements DivisionFormatter {
        @Override
        public String format(double dividend, double divisor, double quotient, double remainder) {
            return "1";
        }
    }

    public class GermanFormatter implements DivisionFormatter {
        @Override
        public String format(double dividend, double divisor, double quotient, double remainder) {
            return "2";
        }
    }


    public String divide(double dividend, double divisor) {
        return divide(dividend, divisor, DivisionStyle.CLASSIC);
    }

    public String divide(double dividend, double divisor, DivisionStyle style) {
        if (divisor == 0) {
            throw new ArithmeticException("На ноль делить не буду!");
        }

        StringBuilder result = new StringBuilder();
        DivisionFormatter formatter = style == DivisionStyle.CLASSIC ?
                new ClassicFormatter() : new GermanFormatter();

        double quotient = dividend / divisor;
        double remainder = dividend % divisor;

        result.append(formatter.format(dividend, divisor, quotient, remainder));

        return result.toString();
    }
}


