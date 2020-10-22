package java_work;

import java.util.*;
import java.io.*;

public class SrDigit {
    
    static Scanner in;
    
    static String s;
    static int n;

    public static void init() {

        String[] a = (in.nextLine()).split(" ");

        s = a[0];
        n = Integer.parseInt(a[1]);
    }

    public static String solve() {

        int sum = 0;

        for(int i = 0; i < s.length(); i+=n){
            if(i + n > s.length()){
                int num = (i + n) - s.length();
                for(int j = 0; j < num; j++){
                    s += "0";
                } 
            }
        }

        for(int i = 0; i < s.length(); i+=n){
            sum += Integer.parseInt(s.substring(i, i + n));
        }

        System.out.println(sum);
        
        return "";
    }
    
    public static void main(String[] args) throws IOException {
        
        in = new Scanner(new File("test/srdigit.in"));
        
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