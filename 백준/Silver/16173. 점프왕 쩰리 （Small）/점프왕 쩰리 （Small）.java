import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
  {
    static int[][] a;
    static boolean[][] check;
    static boolean win = false;
    static int n;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n + 1][n + 1];

        check = new boolean[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i < n + 1; i++)
          {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++)
              {
                a[i][j] = Integer.parseInt(st.nextToken());
                check[i][j] = false;
              }
          }

        DFS(1, 1);

        String result = win ? "HaruHaru" : "Hing";
        System.out.println(result);
      }

    static void DFS(int i, int j)
      {
        if (a[i][j] == -1)
          {
            win = true;
          } else
          {
            for (int k = 0; k < 2; k++)
              {
                int[] dx = {0, 1};
                int[] dy = {1, 0};
                int x = i + dx[k] * a[i][j];
                int y = j + dy[k] * a[i][j];
                if (x > n || y > n || check[x][y]) continue;

                check[x][y] = true;
                DFS(x, y);
              }
          }
      }
  }