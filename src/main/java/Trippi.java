import java.util.*;
import java.io.*;

public class Trippi {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        var ans = new ArrayList<String>(n);

        for (int i = 0; i < n; ++i) {
            var line = br.readLine();
            var words = line.split(" ");

            var res = new StringBuilder(words.length);

            for (var word : words) {
                var c = word.charAt(0);
                res.append(c);
            }

            ans.add(res.toString());
        }

        for (int i = 0; i < n; ++i) {
            System.out.println(ans.get(i));
        }
    }
}