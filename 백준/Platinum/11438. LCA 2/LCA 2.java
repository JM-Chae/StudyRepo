import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main
  {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int[][] info;
    static int totalDepth = 0;
    static int[] depth;
    static int k;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        info = new int[21][n + 1];
        depth = new int[n + 1];

        for (int i = 1; i <= n; i++)
          {
            arr[i] = new ArrayList<>();
          }

        StringTokenizer st;

        for (int i = 0; i < n - 1; i++)
          {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
          }

        BFS(1);

        for (int k = 1; k < 21; k++)
          {
            for (int i = 1; i <= n; i++)
              {
                info[k][i] = info[k - 1][info[k - 1][i]];
              }
          }

        for (int i = 1; (int) Math.pow(2, i) <= totalDepth; i++)
          {
            k = i;
          }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++)
          {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            LCA(a, b);
          }
      }

    static void LCA(int a, int b)
      {
        if (depth[a] > depth[b])
          {
            int temp = a;
            a = b;
            b = temp;

          }

        for (int i = k; i >= 0; i--)
          {
            if (Math.pow(2, i) <= depth[b] - depth[a])
              {
                b = info[i][b];
              }
          }

        for (int i = k; i >= 0; i--)
          {
            if (info[i][a] != info[i][b])
              {
                a = info[i][a];
                b = info[i][b];
              }
          }

        if (a != b) a = info[0][a];

        System.out.println(a);
      }

    static void BFS(int s)
      {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 0, 1});

        while (!q.isEmpty())
          {
            int[] temp = q.poll();
            int cur = temp[0];
            int parent = temp[1];
            depth[cur] = temp[2];

            if (!visited[cur])
              {
                visited[cur] = true;
                info[0][cur] = parent;

                for (int i = 0; i < arr[cur].size(); i++)
                  {
                    int next = arr[cur].get(i);
                    if (visited[next]) continue;
                    q.add(new int[]{next, cur, depth[cur] + 1});
                  }
              }

            totalDepth = depth[cur];
          }
      }
  }