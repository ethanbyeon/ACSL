
import java.io.*;
import java.util.*;

public class duplicates {
    
    static Scanner in;

    static int position;
    static ArrayList<String> words;

    public static void main(String[] args) throws IOException {
        
        in = new Scanner(new File("test/duplicates.in"));

        for(int i = 0; i < 1; i++) {
            try {

                init();
                //System.out.print(i + 1 + ": ");
                solve();

            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        in.close();

    }

    static void init() {

        String[] split = ((in.nextLine()).toLowerCase()).split(" ");
        position = Integer.parseInt(split[0]);
        words = new ArrayList<String>();
        
        for(int word = 1; word < split.length; word++) {
            words.add(split[word]);
        }

    }

    static void solve() {

        String pos = "";

        for(String word: words) {
            // char[] letters = new char[word.length()];

            // letters[0] = word.charAt(0);
            // for(int i = 0; i < letters.length; i++) {
            //     for(int j = i + 1; j < letters.length; j++) {
            //         if(letters[j] < letters[i]) {
            //             char temp = letters[i];
            //             letters[i] = letters[j];
            //             letters[j] = temp;
            //         }
            //     }
            // }
            
            char[] chars = new char[word.length()];
            
            for(int i = 0; i < word.length(); i++) {
                chars[0] = word.charAt(0);
                for(int j = 0; j < i + 1; j++) {
                    System.out.println(chars[j]);
                    if(word.charAt(i) < chars[j]) {
                        char temp = chars[j];
                        chars[j] = word.charAt(i);
                        chars[j + 1] = temp;
                    }
                }
            }
        }

        //System.out.println(pos.length());
    }
}