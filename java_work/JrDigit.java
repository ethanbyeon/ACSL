package java_work;

import java.util.*;
import java.io.*;

public class JrDigit {

    static Scanner in;
    static String s;

    public static void init(){
        s = in.nextLine();
    }
    
    public static String solve(int i) {

        if(i == 0) System.out.println(s.length());
        
        if(i == 1) {
            int sum = 0;
            
            for(int j = 0; j < s.length(); j++){
                sum += Integer.parseInt(s.substring(j, j + 1));
            }

            System.out.println(sum);
        }
    
        if(i == 2) {

            int odd = 0;

            for(int j = 0; j < s.length(); j+=2){
                odd += Integer.parseInt(s.substring(j, j + 1));
            }

            System.out.println(odd);
        }

        if(i == 3) {

            int four = 0;

            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '4'){
                    four++;
                }
            }

            System.out.println(four); 
        }

        if(i == 4) {

            int mid = 0;
            int ind = s.length() / 2;

            if(s.length() % 2 == 0){
                mid = Integer.parseInt(s.substring(ind - 1, ind));
            }else {
                mid = Integer.parseInt(s.substring(ind, ind + 1));
            }

            System.out.print(mid);
        }

        return "";
    }
    
    public static void main(String[] args) throws IOException {

        in = new Scanner(new File("test/jrdigit.in"));
        
        for(int i = 0; i < 5; i++) {
            try {
               init();
               System.out.print(i + 1 + ": ");
               solve(i);
            }catch(Exception e) {
                System.out.println("Error");
                e.printStackTrace();
            }
        }

        in.close();
    }
}