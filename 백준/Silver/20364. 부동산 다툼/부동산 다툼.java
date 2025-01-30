import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {


    static int[] sold;
    static int n, q;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        sold = new int[n + 1];

        for (int i = 1; i <= q; i++) {
            bfs(Integer.parseInt(br.readLine()));
        }

        System.out.println(sb);
    }

    private static void bfs(int q) {
        int ans = 0;
        int next = q;
        while (next != 1) {
            if (sold[next] == 1) {
                ans = next;
            }

            next /= 2;

            if (next == 1) {
                break;
            }
        }

        if (ans == 0) {
            sold[q] = 1;
        }

        sb.append(ans + "\n");
    }
}