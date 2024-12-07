import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main
  {
    static ArrayList<Integer>[] list;
    static int count = 0;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for (int i = 1; i < n; i++)
          {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
          }

        DFS(1, -1, 0);

        System.out.println((count % 2 == 1) ? "Yes" : "No");
      }

    static void DFS(int i, int j, int d)
      {
        if (list[i].size() == 1 && list[i].get(0) == j)
          {
            count = count + d;
            return;
          }

        for (int k = 0; k < list[i].size(); k++)
          {
            int c = list[i].get(k);
            if (c == j) continue;
            DFS(c, i, d + 1);
          }
      }
  }