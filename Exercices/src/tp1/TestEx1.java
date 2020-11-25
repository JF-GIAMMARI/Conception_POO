package tp1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestEx1 {
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4};
        int[] b = new int[] {-1,2,-3,4,5};
        MonTableau m1=new MonTableau(a);
        MonTableau m2=new MonTableau(b);
        System.out.println(m1.compareA(m2));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now.compareTo(now));

    }
}
