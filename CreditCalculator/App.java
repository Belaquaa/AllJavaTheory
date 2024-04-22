package CreditCalculator;

import java.util.Locale;

public class App {

    public static void main(String[] args) {

        double a1 = 10000000.001d;
        double a2 = 10.01d;

        DoubleToLong.getMaxNumber(a1, a2);

        long divident = DoubleToLong.getLongNumber(a1);
        long divisor = DoubleToLong.getLongNumber(a2);
//        String style = InputService.getStyle();

        //System.out.println(divident + "  " + divisor);

//        DivisionCalculator dc = new DivisionCalculator();
//        InputService is = new InputService();
//        System.out.println(dc.divide(is.getDivident(), is.getDivisor(), DivisionCalculator.DivisionStyle.CLASSIC));


//        LongDiv division = new LongDiv();
//        System.out.println(division.makeDivision(-78945, 4));
    }
}
