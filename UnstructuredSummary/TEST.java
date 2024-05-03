package UnstructuredSummary;

import java.util.ArrayList;
import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        boolean isEvenPosition = false;
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (!isEvenPosition) {
                list.add(num);
            }
            isEvenPosition = !isEvenPosition;
        }
        for (int i = list.size() - 1; i >= 0; i --) {
            System.out.print(list.get(i) + " ");
        }
    }
}

