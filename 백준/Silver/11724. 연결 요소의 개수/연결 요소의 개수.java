import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
  {
    static ArrayList<Integer>[] a;
    static boolean[] check;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++)
          {
            a[i] = new ArrayList<>();
          }

        for (int i = 0; i < m; i++)
          {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            a[node].add(edge);
            a[edge].add(node);
            check[node] = false;
          }

        int count = 0;

        for (int i = 1; i < n + 1; i++)
          {
            if (!check[i])
              {
                DFS(i);
                count++;
              }
          }

        System.out.println(count);
      }

    static void DFS(int node)
      {
        if (check[node])
          {
            return;
          }

        check[node] = true;
        for (int i = 0; i < a[node].size(); i++)
          {
            int edge = a[node].get(i);
            if (!check[edge]) DFS(edge);
          }
      }
  }