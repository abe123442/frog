package recursion;

import java.util.*;
import java.io.*;

class PrintToN {
    private int n;

    PrintToN(int n) {
        this.n = n;
    }

    void solve(int k) {
        if (k <= 0) return;
        System.out.println(n - k + 1);
        solve(k-1);
    }

    public static void main(String[] args) throws IOException {
        var br= new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        var s = new PrintToN(n);
        s.solve(n);
    }
}