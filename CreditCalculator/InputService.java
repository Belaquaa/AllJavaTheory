package CreditCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputService {

    static {
        getData();
    }

    static private String[] calculationData;

    public static double getDivident() {
        return parseToDouble(calculationData[0]);
    }

    public static double getDivisor() {
        return parseToDouble(calculationData[1]);
    }

    public static String getStyle() {
        return calculationData.length == 3 ? calculationData[2] : "CLASSIC";
    }

    private static void getData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите парамерты для деления (делимое, делитель, стиль (опционально):");
            calculationData = reader.readLine().trim().split(" ");
            if (calculationData.length != 2 && calculationData.length != 3) throw new IOException();
        } catch (IOException e) {
            System.err.println(STR."Ошибка в вводе данных: \{e}");
        }
    }

    private static double parseToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(STR."Ошибка в преобразовании данных: \{input}");
        }
    }
}