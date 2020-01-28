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

        ArrayList first = new ArrayList<String>();
        ArrayList sec = new ArrayList<String>();

        for(int i = 0; i < first.size(); i++) {
            for(int j = 0; j < sec.size(); j++) {
                
            }
        }

    }
}

//check left to right
//find same index w/ same chars and remove
//shift left
//delete char that would result in the same loco when shifted
//23, 27, 11, 68, -9