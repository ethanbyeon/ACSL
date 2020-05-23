
import java.io.*;
import java.util.*;

class syllables  {

    static Scanner in;

    public static void init() {

    }

    public static boolean isVowel(char c) {
        if( c== 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }else {
            return false;
        }
    }

    public static String solve() {
        
        String result = "";
        String word = "choice";

        int count = 0;
        boolean prev = false;
        for(int i = 0; i < word.length(); i++) {
            if(word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u")) {
                if(isVowel(word.charAt(i)) && !((word.charAt(i) == 'e') && (i == word.length() - 1))) {
                    if(prev == false) {
                        count += i;
                        prev = true;
                    }else {
                        prev = false;
                    }
                }else {
                    count += i;
                    break;
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
