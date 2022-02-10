import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args){
//1404 - номер залікової книжки
//C2 = Q1 = 0; операція +
//C3 = C = 0
//C5 = Q2 = 4; операція -
//C7 = 4; тип індексів i та j = char
        int a, b;
        final int n, m;
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
        if (a == 0){
            System.out.print("Division by zero is impossible!");
        }
        else if (a > n || b > m) {
            System.out.print("a should be less than n and b should be less than m");
        }
        else {
            for (char i = Character.forDigit(a,10); Character.getNumericValue(i) <= n; i++) {
                for (char j = Character.forDigit(b,10); Character.getNumericValue(j) <= m; j++) {
                    res += ((double)Integer.parseInt(String.valueOf(i)) - (double)Integer.parseInt(String.valueOf(j))) / (double)Integer.parseInt(String.valueOf(i));
                }
            }
        }
        float result = (float)res;
        System.out.println("Result: " + result);
    }
}
