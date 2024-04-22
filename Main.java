import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (sc.hasNextInt()){
            if (n % 2 != 0){
                arrayList.add(sc.nextInt());
            }
            else sc.next();
            n++;
        }

        for (int i = arrayList.size() - 1; i >= 0 ; i-- ) {
            System.out.print(arrayList.get(i) + " ");
        }
    }
}