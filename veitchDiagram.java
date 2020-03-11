
import java.io.*;
import java.util.*;

public class veitchDiagram {

    static Scanner in;

    static int[][] ar;

    static ArrayList<String> not;
    static ArrayList<String> yes;

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

    static void init() {

        ar = new int[4][4];

        not = new ArrayList<String>();
        yes = new ArrayList<String>();

        String[] input = (in.nextLine()).split("\\+");

        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[i].length(); j++) {

                String word = input[i];

                if(word.charAt(j) == '~') {
                    not.add("" + word.charAt(j + 1));
                    j++;
                }else if(word.charAt(j) != '~') yes.add("" + word.charAt(j));
                
            }
        }

    }

    static void solve() {

        check();

        for(int i = 0; i < ar.length; i++) {
            for(int j = 0; j < ar[0].length; j++) {
                if(ar[i][j] < 2) ar[i][j] = 0;
                else ar[i][j] = 1;
            }
        }

        System.out.println(toHex());
    }

    static void check() {

        for(int i = 0; i < not.size(); i++) {
            if(not.get(i).equals("A")) {
                for(int a = 0; a < 4; a++) {
                    ar[a][2]++;
                    ar[a][3]++;
                }
            }
            if(not.get(i).equals("B")) {
                for(int b = 0; b < 4; b++) {
                    ar[2][b]++;
                    ar[3][b]++;
                }
            }
            if(not.get(i).equals("C")) {
                for(int c = 0; c < 4; c++) {
                    ar[c][0]++;
                    ar[c][3]++;
                }
            }
            if(not.get(i).equals("D")) {
                for(int d = 0; d < 4; d++) {
                    ar[0][d]++;
                    ar[3][d]++;
                }
            }
        }

        for(int j = 0; j < yes.size(); j++) {
            if(yes.get(j).equals("A")) {
                for(int a = 0; a < 4; a++) {
                    if(ar[a][0] == 2 || ar[a][1] == 2) continue;
                    ar[a][0]++;
                    ar[a][1]++;
                }
            }
            if(yes.get(j).equals("B")) {
                for(int b = 0; b < 4; b++) {
                    if(ar[0][b] == 2 || ar[1][b] == 2) continue;
                    ar[0][b]++;
                    ar[1][b]++;
                }
            }
            if(yes.get(j).equals("C")) {
                for(int c = 0; c < 4; c++) {
                    if(ar[c][1] == 2 || ar[c][2] == 2) continue;
                    ar[c][1]++;
                    ar[c][2]++;
                }
            }
            if(yes.get(j).equals("D")) {
                for(int d = 0; d < 4; d++) {
                    if(ar[1][d] == 2 || ar[2][d] == 2) continue;
                    ar[1][d]++;
                    ar[2][d]++;
                }
            }
        }

    }

    static String toHex() {

        String hex = "";

        String num = "";
        for(int i = 0; i < ar.length; i++) {
            for(int j = 0; j < ar[0].length; j++) {
                num += ar[i][j];
            }

            int binary = Integer.parseInt(num, 2);
            hex += Integer.toString(binary, 16);
            num = "";
        }

        return hex;
    }

}