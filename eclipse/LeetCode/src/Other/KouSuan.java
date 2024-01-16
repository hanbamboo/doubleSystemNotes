package Other;

//P1957 口算练习题
import java.util.Scanner;

public class KouSuan {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        char s = '0' ;
        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine(), result = "";
            String[] array = line.split("\\s+");
            int a, b;
            if (line.startsWith("a")) {
                s = 'a';
                a = Integer.parseInt(array[1]);
                b = Integer.parseInt(array[2]);
            } else if (line.startsWith("b")) {
                s = 'b';
                a = Integer.parseInt(array[1]);
                b = Integer.parseInt(array[2]);
            } else if (line.startsWith("c")) {
                s = 'c';
                a = Integer.parseInt(array[1]);
                b = Integer.parseInt(array[2]);
            } else {
                a = Integer.parseInt(array[0]);
                b = Integer.parseInt(array[1]);
            }
            switch (s) {
                case 'a':
                    result = a + "+" + b + "=" + (a+b);
                    break;
                case 'b':
                    result = a + "-" + b + "=" + (a-b);
                    break;
                case 'c' :
                    result = a + "*" + b + "=" + (a*b);
                    break;
            }
            System.out.println(result + "\n" + result.length());
        }
        scanner.close();

	}
}
