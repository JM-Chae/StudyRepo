import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main
  {
    static ArrayList<Integer[]>[] arr;
    static long ans = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
          {
            arr[i] = new ArrayList<>();
          }

        for (int i = 1; i < n; i++)
          {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new Integer[]{b, c});
            arr[b].add(new Integer[]{a, c});
          }

        resolve(1, 0);

        System.out.println(ans);
      }

    static void resolve(int s, long c)
      {
        if (!visited[s])
          {
            visited[s] = true;
            for (int i = 0; i < arr[s].size(); i++)
              {
                int n = arr[s].get(i)[0];
                long temp = c;
                if (!visited[n])
                  {
                    c += arr[s].get(i)[1];
                  }
                resolve(n, c);
                c = temp;
              }
          }
        if (ans < c) ans = c;
      }
  }