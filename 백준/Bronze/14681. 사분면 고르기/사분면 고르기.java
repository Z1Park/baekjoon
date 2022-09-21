import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int result;
        
        if (x>0) {
            if (y>0) {
                result = 1;
            } else {
                result = 4;
            }
        } else {
            if (y>0) {
                result = 2;
            } else {
                result = 3;
            }
        }
        
        System.out.println(result);
    }
}