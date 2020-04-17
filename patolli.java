
import java.util.*;
import java.io.*;

public class patolli {

    static Scanner in;
    
    static ArrayList<Integer> opp, p, dice, occ;

    public static void main(String[] args) throws IOException {
        
        in = new Scanner(new File("test/patolli.in"));

        for(int i = 1; i < 3; i++) {
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

    static void init() {

        opp = new ArrayList<Integer>();
        p = new ArrayList<Integer>();
        dice = new ArrayList<Integer>();
        occ = new ArrayList<Integer>();

        for(int i = 0; i < 3; i++) opp.add(in.nextInt());
        for(int i = 0; i < 3; i++) p.add(in.nextInt());

        int dnum = in.nextInt();
        for(int i = 0; i < dnum; i++) dice.add(in.nextInt());

    }
    
    static void solve() {

        for(int die: dice) {
            Collections.sort(p);
            
            int current = p.get(0);
            int next = current + die;

            if(next == 52) {
                p.remove(0);
                continue;
            }

            if(isOccupied(next) || next > 52) continue;
            if(isPrime(next)) next = movePrime(next);
            if(isSquare(next)) next = moveSquare(next);
            else if(isRule9(current, next)) next = moveRule9(current, next, die);

            System.out.println("turn: " + current + " " + die);
            System.out.println(p);
            p.set(0, next);
        }

        Collections.sort(p);
        System.out.println("FINAL: " + p);
    }
    
    static boolean isOccupied(int n) {
        reset();

        if(occ.contains(n)) return true;
        return false;
    }
    
    static void reset() {
        occ = new ArrayList<Integer>();
        occ.addAll(0, opp);
        occ.addAll(0, p);
        Collections.sort(occ);
    }
    
    static boolean isPrime(int n) {
        for(int i = 2; i <= n / 2; i++) if(n % i == 0) return false;
        return true;
    }
    
    static boolean isSquare(int n) {
        int x = (int) Math.sqrt(n);
        if(Math.pow(x, 2) == n) {
            System.out.println(x);
            return true;
        }
        else return false;
    }
    
    static boolean isRule9(int c, int n) {

        if(c <= 49 && n >= 51) return true;
        else if(c <= 44 && n >= 46) return true;
        else if(c <= 39 && n >= 41) return true;
        else if(c <= 34 && n >= 36) return true;
        else if(c <= 26 && n >= 28) return true;
        else if(c <= 21 && n >= 23) return true;
        else if(c <= 16 && n >= 18) return true;
        else if(c <= 11 && n >= 13) return true;
        else if(c <= 6 && n >= 8) return true;

        return false;
    }
    
    static int movePrime(int n) {

        for(int i = 0; i < 6; i++) {
            if(isOccupied(n + 1)) return n;
            n++;
        }
         
        return n;
    }
    
    static int moveSquare(int n) {
        
        for(int i = 0; i < 6; i++) {
            if(isOccupied(n - 1)) return n;
            n--;
        }

        return n;
    }
    
    static int moveRule9(int c, int n, int d) {
        if(n % d == 0 && !isOccupied(n)) return n;
        
        for(int i = n * 2; i < 52; i+=n) {
            if(!isOccupied(i)) return n;
        }

        return c;
    }
}
