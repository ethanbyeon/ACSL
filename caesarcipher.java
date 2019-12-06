//Ethan Byeon Grade 11

import java.util.*;
import java.io.*;

public class caesarcipher {

    static Scanner in;
    static String decrypt, msg = "";
    static int key;
    static char c;
    public static void main(String[] args) throws IOException {
        
        in = new Scanner(System.in);

        System.out.print("Your message? ");
        decrypt = in.nextLine();

        System.out.print("Encoding key? ");
        key = in.nextInt();

        System.out.print(decipher());
    }

    static String decipher() {
        for(int i  = 0; i < decrypt.length(); i++){
            char c = (char)(decrypt.charAt(i) + key);
            if(c >= 'a' && c <= 'Z') {
                c = (char)(c - key);

                if(c < 'a') {
                    c = (char)(c - 'a' + 'z' + 1);
                }
                msg += c;
            }else if(c >= 'A' && c <= 'Z') {
                c = (char)(c - key);
                
                if(c <'A') {
                    c = (char)(c - 'A' + 'Z' + 1);
                }
                msg += c;
            }else {
                msg += c;
            }
        }
        return msg;
    }
}