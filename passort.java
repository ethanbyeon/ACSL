
import java.io.*;
import java.util.*;

class passort  {

    static Scanner in;

    public static void init() {}

    public static String solve() {
        
        String result = "";
        int count = 0;

        String list = "ASORTING";
        
        int temp;
        char[] ch = list.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            for(int j = i + 1; j < ch.length; j++) {
                if(ch[i] > ch[j]) {
                    temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = (char) temp;
                }
            }
        }

        System.out.println(count);
        return result + count;
    }

    public static void main(String[] args) throws IOException {

        in = new Scanner(new File("passort.in"));

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
