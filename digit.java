import java.util.*;
import java.io.*;

public class digit {
    
    static Scanner in;

    static String digit;
    static int n; 

    public static void main(String args[]) throws IOException {
        in = new Scanner(new File("test/digit.in"));
        for(int i = 0; i < 5; i++){
            try {
                init();
                System.out.print(i + 1 + ": ");
                solve();
            }catch(Exception e){
                System.out.println("Error");
                e.printStackTrace();
            }
        }
        in.close();
    }

    private static void init(){
        digit = in.next();
        n = in.nextInt();
    }

    private static void solve(){
        long sum = 0l;
        for(int i = 0; i < digit.length() - n + 1; i++){
                String d = digit.substring(i, i + n);
                long num = Long.parseLong(d);
                sum += num;
        }
        
        System.out.println(sum);
    }
}