package java_work;

import java.util.*;
import java.io.*;

public class Patolli {

    static Scanner in;
    
    static ArrayList<Integer> opp, p, dice, occ;
    
    public static void init() {

        opp = new ArrayList<Integer>();
        p = new ArrayList<Integer>();
        dice = new ArrayList<Integer>();
        occ = new ArrayList<Integer>();

        for(int i = 0; i < 3; i++) opp.add(in.nextInt());
        for(int i = 0; i < 3; i++) p.add(in.nextInt());

        int dnum = in.nextInt();
        for(int i = 0; i < dnum; i++) dice.add(in.nextInt());
    }
    
    public static void solve() {

        for(int die: dice) {
            Collections.sort(p);
            
            int current = p.get(0);
            int next = current + die;

            if(next == 52) {
                p.remove(0);
                continue;
            }

            if(isOccupied(next) || next > 52) continue;
            else if(isPrime(next)) next = movePrime(next);
            else if(isSquare(next)) next = moveSquare(next);
            else if(isRule9(current, next)) next = moveRule9(current, next, die);

            p.set(0, next);
        }

        Collections.sort(p);

        for(int i = 0; i < p.size(); i++) {
            if(i <= p.size()) System.out.print(p.get(i) + " ");
            else System.out.print(p.get(i));
        }

        System.out.println();
    }
    
    public static boolean isOccupied(int n) {
        reset();

        if(occ.contains(n)) return true;
        return false;
    }
    
    public static void reset() {
        occ = new ArrayList<Integer>();
        occ.addAll(0, opp);
        occ.addAll(0, p);
        Collections.sort(occ);
    }
    
    public static boolean isPrime(int n) {
        for(int i = 2; i <= n / 2; i++) if(n % i == 0) return false;
        return true;
    }
    
    public static boolean isSquare(int n) {
        
        int x = (int) Math.sqrt(n);

        if(Math.pow(x, 2) == n) return true;
        else return false;
    }
    
    public static boolean isRule9(int c, int n) {
        
        if(c <= 49 && n >= 51) return true;
        else if(c <= 44 && n >= 46) return true;
        else if(c <= 39 && n >= 41) return true;
        else if(c >= 31 && c <= 34 && n >= 36) return true;
        else if(c >= 22 && c <= 26 && n >= 28) return true;
        else if(c <= 21 && n >= 23) return true;
        else if(c <= 16 && n >= 18) return true;
        else if(c <= 11 && n >= 13) return true;
        else if(c <= 6 && n >= 8) return true;

        return false;
    }
    
    public static int movePrime(int n) {

        for(int i = 0; i < 6; i++) {
            if(isOccupied(n + 1)) return n;
            n++;
        }
         
        return n;
    }
    
    public static int moveSquare(int n) {
        
        for(int i = 0; i < 6; i++) {
            if(isOccupied(n - 1)) return n;
            n--;
        }

        return n;
    }
    
    public static int moveRule9(int c, int n, int d) {
        for(int i = 0; i <= n; i+=d) if(i > c && !isOccupied(i) && i % d == 0) return i;
        return c;
    }

    public static void main(String[] args) throws IOException {
        
        in = new Scanner(new File("test/patolli.in"));

        for(int i = 1; i < 6; i++) {
            try {

                init();
                System.out.print(i + ": ");
                solve();

            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        in.close();
    }
}