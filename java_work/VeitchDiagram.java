package java_work;

import java.io.*;
import java.util.*;

public class VeitchDiagram {

    static Scanner in;

    static int[][] veitch; // FINAL VEITCH DIAGRAM
    static int[][] grid; // TEMPORARY DIAGRAM

    static ArrayList<String> not; // 0s (LETTERS)
    static ArrayList<String> yes; // 1s (LETTERS)

    static int count; // LENGTH OF AND GATES

    public static void init() {

        veitch = new int[4][4];

        not = new ArrayList<String>();
        yes = new ArrayList<String>();
        
        count = 0;

        String[] input = (in.nextLine()).split("\\+");

        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[i].length(); j++) {
                
                String and = input[i];
                if(and.charAt(j) == '~') {
                    not.add("" + and.charAt(j + 1));
                    count++;
                    j++;
                }else if(and.charAt(j) != '~') {
                    yes.add("" + and.charAt(j));
                    count++;
                }
            }
            
            tally();
            not.clear();
            yes.clear();
            count = 0;
        }
    }

    public static void solve() {
        System.out.println(toHex().toUpperCase());
    }

    // CONVERTS EACH ROW IN VEITCH DIAGRAM TO BINARY THEN TO HEXADECIMAL
    public static String toHex() {

        String hex = "";
        String num = "";

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                num += veitch[i][j];
            }

            int binary = Integer.parseInt(num, 2);
            hex += Integer.toString(binary, 16);
            num = "";
        }

        return hex;
    }

    // TALLYS APPROPRIATE INDEXES
    public static void tally() {

        grid = new int[4][4];
        
        if(not.size() != 0) {
            for(int i = 0; i < not.size(); i++) {
                if(not.get(i).equals("A")) {
                    for(int a = 0; a < 4; a++) {
                        grid[a][2]++;
                        grid[a][3]++;
                    }
                }
                if(not.get(i).equals("B")) {
                    for(int b = 0; b < 4; b++) {
                        grid[2][b]++;
                        grid[3][b]++;
                    }
                }
                if(not.get(i).equals("C")) {
                    for(int c = 0; c < 4; c++) {
                        grid[c][0]++;
                        grid[c][3]++;
                    }
                }
                if(not.get(i).equals("D")) {
                    for(int d = 0; d < 4; d++) {
                        grid[0][d]++;
                        grid[3][d]++;
                    }
                }
            }
        }

        if(yes.size() != 0) {
            for(int j = 0; j < yes.size(); j++) {
                if(yes.get(j).equals("A")) {
                    for(int a = 0; a < 4; a++) {
                        grid[a][0]++;
                        grid[a][1]++;
                    }
                }
                if(yes.get(j).equals("B")) {
                    for(int b = 0; b < 4; b++) {
                        grid[0][b]++;
                        grid[1][b]++;
                    }
                }
                if(yes.get(j).equals("C")) {
                    for(int c = 0; c < 4; c++) {
                        grid[c][1]++;
                        grid[c][2]++;
                    }
                }
                if(yes.get(j).equals("D")) {
                    for(int d = 0; d < 4; d++) {
                        grid[1][d]++;
                        grid[2][d]++;
                    }
                }
            }
        }

        check();
    }

    // CHECKS IF INDEX OF GRID EQUALS TO THE LENGTH OF THE AND GATE
    public static void check() {

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(grid[i][j] == count) veitch[i][j] = 1;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        in = new Scanner(new File("test/veitch.in"));

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
}