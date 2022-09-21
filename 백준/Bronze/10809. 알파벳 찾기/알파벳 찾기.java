import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] alps = new int[26];
        for (int i=0; i<alps.length; i++) {
            alps[i] = -1;
        }
        
        String str = sc.nextLine();
        for (int i=0; i<str.length(); i++ ) {
            char c = str.charAt(i);
                
            if (alps[c-'a'] == -1) {
                alps[c-'a'] = i;
            }
        }
        
        for (int a : alps) {
            System.out.print(a+" ");
        }
    }
}