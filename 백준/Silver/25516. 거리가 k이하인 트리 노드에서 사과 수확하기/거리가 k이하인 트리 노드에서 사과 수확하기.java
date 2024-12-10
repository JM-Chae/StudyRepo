import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main
  {
    static int k;
    static int ans = 0;
    static boolean[] apple;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        apple = new boolean[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++)
          {
            arr[i] = new ArrayList<>();
          }

        for (int i = 0; i < n - 1; i++)
          {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
          }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
          {
            apple[i] = st.nextToken().equals("1");
          }

        BFS();

        System.out.println(ans);
      }

    static void BFS()
      {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});

        while (!q.isEmpty())
          {
            int[] temp = q.poll();
            int cur = temp[0];
            int depth = temp[1];

            if (depth > k) return;

            if (!visited[cur])
              {
                visited[cur] = true;
                if (apple[cur]) ans++;
                for (int i = 0; i < arr[cur].size(); i++)
                  {
                    int next = arr[cur].get(i);
                    if (visited[next]) continue;
                    q.add(new int[]{next, depth + 1});
                  }
              }
          }
      }
  }