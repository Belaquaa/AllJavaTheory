package CreditCalculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DoubleToLong {
    private static int maxNumberOfDigits = -1;

    public static long getLongNumber (double number) {
        if (maxNumberOfDigits == -1) {
            System.err.println("Должен быть вызван getMaxNumber! Результат вычислений может быть неверным.");
        }
        return (long) (number * Math.pow(10, maxNumberOfDigits));
    }

    public static void getMaxNumber(double dividend, double divisor) {
        maxNumberOfDigits = Math.max(countSignificantFiguresAfterDecimal(dividend),
                countSignificantFiguresAfterDecimal(divisor));
    }

    public static int countSignificantFiguresAfterDecimal(double number) { // кол-во значимых цифр после точки
        System.out.println("raw: " + number);

        String numberStr = String.format(Locale.ENGLISH, "%.6f", number);

        System.out.println("number str: " + numberStr);

        numberStr = numberStr.indexOf('.') < 0 ? numberStr :
                numberStr.replaceAll("0*$", "").replaceAll("\\.$", "");
        int decimalPointIndex = numberStr.indexOf('.');
        if (decimalPointIndex == -1) {
            System.out.println("Exit");
            return 0;
        }

//        System.out.println(numberStr.length());
//        System.out.println(decimalPointIndex);
        System.out.println("Итог:  " + (numberStr.length() - decimalPointIndex - 1));
        return numberStr.length() - decimalPointIndex - 1;
    }

}
