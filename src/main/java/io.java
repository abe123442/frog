import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;

class IO extends PrintWriter {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;

    IO() {
        super(System.out);
    }

    String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            return st.nextToken();
        } catch (IOException ignored) {}
        return null;
    }

    public static void main(String[] args) {
        var io = new IO();
        int n = Integer.parseInt(io.nextToken());

        var prods = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(io.nextToken());
            int b = Integer.parseInt(io.nextToken());
            prods.add(a*b);
        }

        for (var prod : prods) {
            io.println(prod);
        }

        io.close();
    }
}