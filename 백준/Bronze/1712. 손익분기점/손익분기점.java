import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        if (B >= C) {
            System.out.print(-1);
        } else {
            int div = C-B;
            System.out.print(A/div + 1);
        }
    }
}