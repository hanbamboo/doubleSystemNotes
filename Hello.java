
import java.util.Scanner;
import java.lang.Integer;
import java.lang.Math;
public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        double num = Double.parseDouble(a.split(" ")[0]);
        String c = a.split(" ")[1];
        
        int k = Integer.parseInt( Math.round(num/2) );
        for (int i = 0; i < k; i++) {
            for (int j = 0; j <num; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
        scanner.close();

    }
}