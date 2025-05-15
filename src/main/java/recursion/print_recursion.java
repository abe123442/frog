package recursion;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class PrintRecursion {
    static String message = "I love Recursion";

    static void recurse(int n) {
        if (n <= 0) return;
        System.out.println(message);
        recurse(n-1);
    }

    public static void main(String[] args) {
        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            var st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            PrintRecursion.recurse(n);
        } catch (IOException ignored) {}
    }
}
