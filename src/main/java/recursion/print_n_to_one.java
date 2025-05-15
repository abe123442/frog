package recursion;

import java.util.*;
import java.io.*;

class PrintToOne {
    void solve(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.printf("%d ", n);
        solve(--n);
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        var s = new PrintToOne();
        s.solve(n);
    }
}