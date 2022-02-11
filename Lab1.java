import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args){
//1404 - номер залікової книжки
//C2 = Q1 = 0; операція +
//C3 = C = 0
//C5 = Q2 = 4; операція -
//C7 = 4; тип індексів i та j = char
        final int a;
        final int b;
        final int n;
        final int m;
        float res = 0f;
        try {
            Scanner num = new Scanner(System.in);
            System.out.print("Enter a: ");
            a = num.nextInt();

            System.out.print("Enter b: ");
            b = num.nextInt();

            System.out.print("Enter n: ");
            n = num.nextInt();

            System.out.print("Enter m: ");
            m = num.nextInt();
        } catch (InputMismatchException exc) {
            System.out.print("Your values is not integer!");
            return;
        }
        if (a <= 0 || b < 0) {
            System.out.print("Division by zero is impossible! a and b should be greater than or equal to zero!");
        }
        else if (a > Character.MAX_VALUE || b > Character.MAX_VALUE || n > Character.MAX_VALUE || m > Character.MAX_VALUE){
            System.out.print("Error");
        }
        else if (a > n || b > m) {
            System.out.print("a should be less than n and b should be less than m");
        }
        else {
            for (char i = (char)a; i <= n; i++) {
                for (char j = (char)b; j <= m; j++) {
                    res += (i - j) / (float) i;
                }
            }
            System.out.print("Result: " + res);
        }
    }
}
