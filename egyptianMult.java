
import java.io.*;
import java.util.*;

class egyptianMult {

    static Scanner in;

    static int large, small = 0;

    public static void main(String[] args) throws IOException {
        
        in = new Scanner(new File("test/egyptianMult.in"));
        
        for(int i = 0; i < 10; i++) {
            try {
                init();
                System.out.print(i + 1 + ": ");
                solve();

            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        in.close();
    }

    static void init() {
        String[] split = (in.nextLine()).split("\\s*,\\s*");
        large = Integer.parseInt(split[0]);
        small = Integer.parseInt(split[1]);
    }

    static String solve() {     
        
        String ans = "";
        
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();

        int sum = 0;
        for(int i = large; i - sum >= 0; i-=sum) {   
            for(int j = 1; j <= i - sum; j*=2) sum = j;

            first.add(sum);
        }
        Collections.sort(first);
        System.out.println(first);

        int count = 0;
        for(int i = 1; i <= large; i*=2) count++;

        int ssum = small;
        for(int i = 0; i < count; i++) second.add(ssum * 2);
        Collections.sort(second, Collections.reverseOrder());

        for(int num : second) ans += num + " ";

        return ans;
    }

}
