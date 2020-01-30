/*
    Name: Ethan Byeon
    Grade: 11
    Team: Stempia
    Division: Intermediate
    Contest 2
*/

import java.util.*;
import java.io.*;

class samenessFactor {

    public static void main(String[] args) throws IOException{
        
        Scanner in = new Scanner(new File("1920C2JRIN.in"));
        
        while(in.hasNextLine()) {
            String[] split = (in.nextLine()).split(" ");
            align(split[0], split[1]);
        }

        in.close();
    }

    static void align(String x, String y) {

        String first = "";
        String sec = "";

        ArrayList f = new ArrayList<String>();
        ArrayList s = new ArrayList<String>();

        for(int i = 0; i < x.length(); i++) {
            f.add(x.charAt(i));
        }

        for(int i = 0; i < y.length(); i++) {
            s.add(y.charAt(i));
        }

        for(int i = 0; i < Math.min(f.size(), s.size()); i++) {
            if(f.get(i) == s.get(i)) {
                f.remove(i);
                s.remove(i);
                i = -1;
            }
        }

        for(int i = 0; i < Math.min(f.size(), s.size() - 1); i++) {
            if(f.get(i) == s.get(i)) {
                f.remove(i);
                s.remove(i);
                i = -1;
            }else if(f.get(i) == s.get(i + 1)){
                s.remove(i);
                i = -1;
            }
        }

        //System.out.println(f + " " + s);

        for(int i = 0; i < f.size(); i++) {
            first += f.get(i);
        }

        for(int i = 0; i < s.size(); i++) {
            sec += s.get(i);
        }

        System.out.println(calc(first, sec));
    }

    static int calc(String x, String y) {
        int total = 0;

        if(x.length() < y.length()) {
            for(int i = 0; i < x.length(); i++){
                char c = x.charAt(i);
                char n = y.charAt(i);
                //System.out.println(c - n);
                total += c - n;
            }
            
            int diff = y.length() - x.length();
            total += diff;
        }else if(x.length() > y.length()) {
            for(int i = 0; i < y.length(); i++){
                char c = x.charAt(i);
                char n = y.charAt(i);
                //System.out.println(c - n);
                total += c - n;
            }
            
            int diff = x.length() - y.length();
            total += diff;
        }

        return total; 
    }
    
}