import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int testcase = sc.nextInt();
        
        for (int i=0; i<testcase; i++) {
            int N = sc.nextInt();
            String str = sc.next();
            
            for (int j=0; j<str.length(); j++) {
                char ch = str.charAt(j);
                for (int k=0; k<N; k++) {
                    System.out.print(ch);
                }
            }
            System.out.print("\n");
        }
    }
}