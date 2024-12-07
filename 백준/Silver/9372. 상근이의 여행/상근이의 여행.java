import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main
  {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++)
          {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            for (int j = 1; j <= n; j++)
              {
                arr[j] = new ArrayList<>();
              }

            for (int j = 0; j < m; j++)
              {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a].add(b);
                arr[b].add(a);
              }

            BFS();
          }
      }

    static void BFS()
      {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int count = 0;

        while (!q.isEmpty())
          {
            int cur = q.poll();

            if (!visited[cur])
              {
                visited[cur] = true;
                q.addAll(arr[cur]);
                count++;
              }
          }

        System.out.println(count - 1);
      }
  }