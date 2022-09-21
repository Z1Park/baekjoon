import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int function(int N) {
        if (N > 1) {
            N *= function(N-1);
        }
        return N;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.print(1);
        }
        else {
            System.out.print(function(N));
        }
    }
}