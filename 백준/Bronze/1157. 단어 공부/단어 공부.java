import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine().toUpperCase();
        
        int[] alps = new int[26];
        for (int i=0; i<alps.length; i++) {
            alps[i] = 0;
        }
        
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            alps[ch-'A'] += 1;
        }
        
        int max_index = 0;
        int max_value = 0;
        int max_flag = 0;
        for (int i=0; i<alps.length; i++) {
            if (alps[i] > max_value) {
                max_value = alps[i];
                max_index = i;
                max_flag = 0;
            } else if (alps[i] == max_value) {
                max_flag = 1;
            }
        }
        
        if (max_flag == 1) {
            System.out.println("?");
        } else {
            System.out.println((char)('A'+max_index));
        }
    }
}