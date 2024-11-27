import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
  {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visit;
    static boolean isEven;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++)
          {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A = new ArrayList[v + 1];
            visit = new boolean[v + 1];
            check = new int[v + 1];
            isEven = true;

            for (int j = 1; j <= v; j++)
              {
                A[j] = new ArrayList<>();

              }

            for (int j = 1; j <= e; j++)
              {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                A[start].add(end);
                A[end].add(start);
              }

            for (int j = 1; j <= v; j++)
              {
                if (isEven)
                  {
                    dfs(j);
                  } else break;
              }

            if (isEven) System.out.println("YES");
            else System.out.println("NO");

          }
      }

    public static void dfs(int start)
      {
        visit[start] = true;
        for (int i = 0; i < A[start].size(); i++)
          {
            int j = A[start].get(i);
            if (!visit[j])
              {
                check[j] = (check[start] + 1) % 2;
                dfs(j);
              } else if (check[start] == check[j])
              {
                isEven = false;
              }
          }
      }
  }