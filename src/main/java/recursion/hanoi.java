package recursion;

import java.util.*;
import java.io.*;


class Hanoi extends PrintWriter {
    BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    List<Pair<Integer, Integer>> moves = new ArrayList<>();

    static class Pair<K, V> implements Serializable {
        public K key;
        public V value;

        public Pair(K key, V val) {
            this.key = key;
            this.value = val;
        }

        public String toString() { return key + "=" + value; }

        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + (key != null ? key.hashCode() : 0);
            hash = 31 * hash + (value != null ? value.hashCode() : 0);
            return hash;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Pair) {
                var p = (Pair<K, V>) o;
                if (key != null ? !key.equals(p.key) : p.key == null) return false;
                if (value != null ? !value.equals(p.value) : p.value == null) return false;
                return true;
            }
            return false;
        }
    }

    Hanoi() {
        super(new BufferedOutputStream(System.out));
    }

    public String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(cin.readLine());
            }

            return st.nextToken();
        } catch (IOException ignored) {}
        return null;
    }

    int solve(int n, int start, int end) {
        if (n == 1) {
            moves.add(new Pair<>(start, end));
            return 1;
        }

        // there are 3 poles labelled, 1, 2, 3 => sum = 6
        int other = 6 - (start + end);
        int moveOff = solve(n-1, start, other);

        // move the longest disc
        moves.add(new Pair<>(start, end));

        int moveOn = solve(n-1, other, end);
        return 1 + moveOff + moveOn;
    }

    public static void main(String[] args) throws IOException {
        var h = new Hanoi();
        int n = Integer.parseInt(h.nextToken());

        h.println(h.solve(n, 1, 3));

        for (var p : h.moves) {
            h.printf("%d %d\n", p.key, p.value);
        }

        h.close();
    }
}