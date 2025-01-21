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
        int m = Integer.parseInt(br.readLine());
        int[] position = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int callCount = 0;

        ArrayList<Integer>[] list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (position[cur] > 1) {
                continue;
            }

            if (!list[cur].isEmpty()) {
                for (int i = 0; i < list[cur].size(); i++) {
                    int next = list[cur].get(i);
                    if (!visited[next]) {
                        visited[next] = true;
                        position[next] = position[cur] + 1;
                        q.add(next);
                        callCount++;
                    }
                }
            }
        }

        System.out.println(callCount);
    }
}