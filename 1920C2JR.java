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
            break;
        }

        in.close();
    }

    static void align(String x, String y) {

        String first = "";
        String sec = "";

        for(int i = 0; i < Math.min(x.length(), y.length()); i++) {
            // System.out.println(i);
            if(x.charAt(i) == y.charAt(i)) {
                x = x.replace("" + x.charAt(i), "");
                y = y.replace("" + y.charAt(i), "");
                i = -1;
            }
            System.out.println(x + " " + y);
        }
        
    }
}

//check left to right
//find same index w/ same chars and remove
//shift left
//delete char that would result in the same loco when shifted
//23, 27, 11, 68, -9