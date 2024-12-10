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
    static ArrayList<Integer>[] arr2;
    static ArrayList<Integer>[] info;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int c = 0; c < t; c++)
          {
            int n = Integer.parseInt(br.readLine());
            arr = new ArrayList[n + 1];
            arr2 = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            info = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++)
              {
                arr[i] = new ArrayList<>();
                arr2[i] = new ArrayList<>();
                info[i] = new ArrayList<>();
              }

            StringTokenizer st;

            for (int i = 0; i < n - 1; i++)
              {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr2[b].add(a);
                arr[a].add(b);
                arr[b].add(a);
              }

            int s = 0;

            for (int i = 1; i <= n; i++)
              {
                if (arr2[i].isEmpty())
                  {
                    s = i;
                  }
              }

            BFS(s);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while (a != b)
              {
                if (info[a].get(1) > info[b].get(1))
                  {
                    a = info[a].get(0);
                  } else if (info[a].get(1) == info[b].get(1))
                  {
                    if (a == b) break;
                    a = info[a].get(0);
                    b = info[b].get(0);
                  } else
                  {
                    b = info[b].get(0);
                  }
              }
            
            System.out.println(a);
          }
      }

    static void BFS(int s)
      {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{s, 0, 0});

        while (!q.isEmpty())
          {
            int[] temp = q.poll();
            int cur = temp[0];
            int parent = temp[1];
            int depth = temp[2];

            if (!visited[cur])
              {
                visited[cur] = true;
                info[cur].add(parent);
                info[cur].add(depth);

                for (int i = 0; i < arr[cur].size(); i++)
                  {
                    int next = arr[cur].get(i);
                    if (visited[next]) continue;
                    q.add(new int[]{next, cur, depth + 1});
                  }
              }
          }
      }
  }