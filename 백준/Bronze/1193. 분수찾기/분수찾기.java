import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int Sum = 0;
        int i = 1;
        
        while (Sum+i < N) {
            Sum += i;
            i++;
        }
        
        Sum = N - Sum;
        if (i%2 == 0) {
            System.out.print(Sum+"/"+(i+1-Sum));
        } else {
            System.out.print((i+1-Sum)+"/"+Sum);
        }
    }
}