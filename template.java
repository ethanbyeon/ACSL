
import java.io.*;
import java.util.*;

class template  {

    static Scanner in;

    public static void init() {

    }

    public static String solve() {
        
        String result = "";
        
        
        return result;
    }
    public static void main(String[] args) throws IOException {

        in = new Scanner(new File("template.in"));

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
