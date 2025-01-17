import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        int[][] ans = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (st.nextToken().equals("1")) {
                    arr[i].add(j);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            q.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();

                if (!arr[cur].isEmpty()) {
                    for (int j = 0; j < arr[cur].size(); j++) {
                        int next = arr[cur].get(j);
                        if (!visited[next]) {
                            visited[next] = true;
                            q.add(next);
                            ans[i][next] = 1;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}