import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        File text = new File("/home/leonardo/IdeaProjects/tan_network/solution/src/input.txt");
        Scanner in = null;
        try {
            in = new Scanner(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String startPoint = in.next();
        String endPoint = in.next();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String stopName = in.nextLine();
        }
        int M = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < M; i++) {
            String route = in.nextLine();
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("IMPOSSIBLE");
    }
}