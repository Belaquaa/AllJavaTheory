package CreditCalculator;

import java.util.Arrays;

public class LongDiv {

    private StringBuilder result = new StringBuilder();    // результат деления
    private StringBuilder quotient = new StringBuilder();  // чатсное
    private StringBuilder reminder = new StringBuilder();  // остаток


    public String makeDivision(long dividend, long divisor) {
        if (divisor == 0) throw new IllegalArgumentException("Divisor cannot be 0, division by zero");

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend < divisor) {
            return dividend + "/" + divisor + " = 0";
        }

        String dividendStr = String.valueOf(dividend);
        long reminderNumber;
        long multiplyResult;
        long mod;

        for (int i = 0; i < dividendStr.length(); i++) {
            reminder.append(dividendStr.charAt(i));
            reminderNumber = Integer.parseInt(reminder.toString());

            if (reminderNumber >= divisor) {
                mod = reminderNumber % divisor;
                multiplyResult = (reminderNumber / divisor) * divisor;

                appendDivisionStep(i, reminderNumber, multiplyResult);

                quotient.append(reminderNumber / divisor); // добавление к частному
                reminder.replace(0, reminder.length(), String.valueOf(mod)); // обновление остатка

            } else {
                if (i >= calculateDigit(divisor)) { // Если текущий остаток меньше и мы уже прошли количество цифр
                    quotient.append(0);             // в делителе, то добавляем 0 к частному
                }
            }

            if (i == dividendStr.length() - 1) { // добавляем остаток к результату после последней итерации
                result.append(String.format("%" + (i + 2) + "s", reminder.toString())).append("\n");
            }
        }
        modifyResultToView(dividend, divisor);
        return result.toString();
    }

    private void appendDivisionStep(int i, long reminderNumber, long multiplyResult) {
        String lastReminder = String.format("%" + (i + 2) + "s", "_" + reminderNumber); // это где _{число}
        result.append(lastReminder).append("\n");

        String multiply = String.format("%" + (i + 2) + "d", multiplyResult); // это хрень, которую мы отнимаем
        result.append(multiply).append("\n");

        int tab = lastReminder.length() - calculateDigit(multiplyResult); // это сколько минусов и пробелов
        result.append(assemblyString(tab, ' ') +
                assemblyString(calculateDigit(reminderNumber), '-')).append("\n");

    }

    private void modifyResultToView(long dividend, long divisor) { // отображение начальных данных
        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }
            if (j == 3) {
                break;
            }
        }

        int tab = (calculateDigit(dividend) + 1 - index[0]);
        result.insert(index[2], assemblyString(tab, ' ') + "│" + quotient); // это частное
        result.insert(index[1], assemblyString(tab, ' ') + "│" + assemblyString(quotient.length(), '-')); // это минусы
        result.insert(index[0], "│" + divisor); // это делитель
        result.replace(1, index[0], String.valueOf(dividend));
    }


    private int calculateDigit(long number) { // количество цифр в числе
        return (int) (Math.log10(number) + 1);
    }


    private String assemblyString(int numberOfSymbols, char symbol) { // строка из повторяющихся символов
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}

