package java_work;

import java.util.*;
import java.io.*;

public class NumTransform1 {

    static Scanner in;
    
    static String N;
    static int P;

    public static void init() {

        String[] sp = (in.nextLine()).split(" ");
        N = sp[0];

        int index = Integer.parseInt(sp[1]);
        P = sp[0].length() - index;
    }

    public static String solve() {

        String num = "";
        int pdigit = Integer.parseInt(N.substring(P,P + 1));

        for(int i = 0; i < N.length(); i++){
            
            int c = Integer.parseInt(N.substring(i, i + 1));

            if(i < P){
                num += "" + (c + pdigit);
            }else if(i == P){
                num += primeFactor(N);
            }else{
                num += "" + Math.abs(c - pdigit);
            }
        }

        System.out.println(num);

        return "";
    }

    public static int primeFactor(String x){

        Set<Integer> set = new HashSet<Integer>();
        Long n = Long.parseLong(x);

        for(int i = 2; i <= n; i++){
            while(n % i == 0){
                set.add(i);
                n /= i;
            }
        }
        
        return set.size();
    }
    
    public static void main(String[] args) throws IOException {

        in = new Scanner(new File("test/numtransform1.in"));

        for(int i = 0; i < 5; i++) {
            try {
                init();
                System.out.print(i + 1 + ": ");
                solve();
            }catch(Exception e) {
                System.out.println("Error");
                e.printStackTrace();
            }
        }

        in.close();
    }
}