import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] arr;
    static int[] sold;
    static int n, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        sold = new int[n + 1];

        for (int i = n; i >= 2; i--) {
            arr[i] = i / 2;
        }

        for (int i = 1; i <= q; i++) {
            System.out.println(bfs(Integer.parseInt(br.readLine())));
        }
    }

    private static int bfs(int q) {
        int ans = 0;
        Queue<Integer> qq = new LinkedList<>();
        qq.add(q);
        while (!qq.isEmpty()) {
            int cur = qq.poll();
            if (sold[cur] == 1) {
                ans = cur;
            }

            if (arr[cur] == 1) {
                break;
            }

            qq.add(arr[cur]);
        }

        if (ans == 0) {
            sold[q] = 1;
        }

        return ans;
    }
}