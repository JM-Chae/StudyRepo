import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int count = 0;
    static int[] parent;
    static int[] dep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        dep = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        BFS();

        System.out.println(count % 2 != 0 ? "Yes" : "No");
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        parent[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (!list[cur].isEmpty()) {
                if (list[cur].size() == 1 && list[cur].get(0) == parent[cur]) {
                    count += dep[cur];
                    continue;
                }
                for (int i = 0; i < list[cur].size(); i++) {
                    if (!visited[list[cur].get(i)]) {
                        visited[list[cur].get(i)] = true;
                        q.add(list[cur].get(i));

                        parent[list[cur].get(i)] = cur;
                        dep[list[cur].get(i)] = dep[cur] + 1;
                    }
                }
            }
        }
    }
}