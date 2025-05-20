import java.io.*;
import java.util.*;

// https://codeforces.com/contest/2094/problem/D
// initial attempt: 2 pointers, with pointer increments on comparing chars between positions, and decrementing a pointer
// on mismatch to account for potential double upping

// why was it hard to progress with: edge cases got overwhelming, needed to track a bunch of different things like:
//     - if i had already "consumed" a doubling effect in the `sound` string
//     - if i run out of characters in the first "actual" string

public class Sahur {
    // start >= 0, |s| >= 1
    static int runSize(String s, int start) {
        int i = 1 + start;
        while (i < s.length() && s.charAt(i-1) == s.charAt(i)) {
            i++;
        }

        // need to undo the offset to calculate the size of the run
        return i - start;
    }

    static String solve(String s, String p) {
        // key idea: compare runs of letters (if they're the same letter) between `s` and `p`

        int first = 0; int second = 0;

        while (first < s.length() && second < p.length()) {
            // the rule is that |s1| <= |s2| <= 2*|s1|

            var firstRun = runSize(s, first);
            var secondRun = runSize(p, second);

            if (s.charAt(first) != p.charAt(second) || firstRun > secondRun || secondRun > 2*firstRun)
                return "NO";

            first += firstRun;
            second += secondRun;
        }

        if (first == s.length() && second == p.length())
            return "YES";

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        var ss = new ArrayList<String>(n);
        var ps = new ArrayList<String>(n);

        for (int i = 0; i < n; ++i) {
            ss.add(br.readLine());
            ps.add(br.readLine());
        }

        for (int i = 0; i < n; ++i) {
            System.out.println(solve(ss.get(i), ps.get(i)));
        }
    }
}