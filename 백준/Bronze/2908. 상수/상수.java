import java.util.Scanner;

public class Main {
    public static int swap(String num) {
        char[] cs = new char[3];
        
        for (int i=0; i<3; i++) {
            cs[3 - i - 1] = num.charAt(i);
        }
        
        String str = new String(cs);
        return Integer.parseInt(str);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int A = swap(nums[0]);
        int B = swap(nums[1]);
        if (A > B) {
            System.out.print(A);
        } else {
            System.out.print(B);
        }
    }
}