import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
  {
    static int[][] a;
    static boolean[][] check;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++)
          {
            String line = br.readLine();
            for (int j = 1; j < m + 1; j++)
              {
                a[i][j] = Integer.parseInt(String.valueOf(line.charAt(j - 1)));
                check[i][j] = false;
              }
          }

        BFS(1, 1);

        System.out.println(a[n][m]);
        br.close();
      }

    static void BFS(int i, int j)
      {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        check[i][j] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty())
          {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++)
              {
                int count = a[cur[0]][cur[1]];
                i = cur[0] + dx[k];
                j = cur[1] + dy[k];

                if (i > n || j > m)
                  {
                    continue;
                  } else if (!check[i][j] && !(a[i][j] == 0))
                  {
                    a[i][j] = 1 + count;
                    q.add(new int[]{i, j});
                    check[i][j] = true;
                  }
              }
          }
      }
  }
